package com.criss.wang;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.criss.wang.entity.Geometry;
import com.criss.wang.entity.UavTrack;
import com.criss.wang.entity.UavTrackProps;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.cc.commons.MathUtils;
import net.cc.commons.StringUtils;
import net.cc.luffy.entity.proto.UavFlyDataBatchProto;
import net.cc.luffy.entity.proto.UavFlyDataProto;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class FlydatainitApplication {

	private static String dbURL;
	private static String dbName;
	private static String userName;
	private static String userPwd;
	private static String hbaseUrl;
	private static int count = 0;

	public static void main(String[] args) {
		SpringApplication.run(FlydatainitApplication.class, args);

		if (args.length < 5) {
			System.out.println(args[0]);
			System.out.println("参数不完整, 程序退出");
			System.exit(-1);
		}

		// office-server:3306
		dbURL = args[1];
		// 数据库名称 UCareDB_Test
		dbName = args[2];
		// 用户名
		userName = args[3];
		// 密码
		userPwd = args[4];
		// 192.168.3.37:8100
		hbaseUrl = args[5];

		Connection dbConn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://" + dbURL + "/" + dbName + "?useSSL=false", userName,
					userPwd);
			System.out.println("链接成功");

			// 飞参数据入Hbase
			flyDataToHbase(dbConn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void flyDataToHbase(Connection dbConn) throws SQLException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PreparedStatement flyDataPs = null;
		ResultSet flyDataRs = null;
		// buerId:iso
		Map<String, Integer> isoMark = null;
		try {
			// 查询fly_data_info总数据量
			flyDataPs = dbConn.prepareStatement("SELECT COUNT(*) FROM FLY_DATA_INFO");
			flyDataRs = flyDataPs.executeQuery();
			flyDataRs.next();
			// 总记录数量
			String rowCount = flyDataRs.getString(1);
			// 起始行
			int row = 0;
			while (row <= Integer.valueOf(rowCount)) {
				String sql = "SELECT DEVICE_START_END_ID, DEVICE_ID, FLY_DATA FROM FLY_DATA_INFO " + "limit " + row
						+ ", 10";
				flyDataPs = dbConn.prepareStatement(sql);
				flyDataRs = flyDataPs.executeQuery();
				while (flyDataRs.next()) {
					UavTrack jsonTrack = objectMapper.readValue(flyDataRs.getString(3), UavTrack.class);
					// 获取buyerId
					String buyerId = getBuyerIdByDeviceId(flyDataRs.getString(2), dbConn);
					if (buyerId != null) {
						// 获取buyerId对应的隔离级别 buyerId:iso
						isoMark = getIsoMarkByBuyerId(buyerId, dbConn);
					}
					// 拆点入Hbase
					convertTrack2ProtoBytes(isoMark, flyDataRs.getString(2), jsonTrack);
				}
				row += 10;
				if (row < Integer.valueOf(rowCount))
					System.out.println("当前row: " + row + ", rowCount: " + rowCount + ",当前已完成进度： "
							+ (MathUtils.div(Double.valueOf(row), Double.valueOf(rowCount), 4, RoundingMode.HALF_UP)
									* 100)
							+ "%");
			}
			System.out.println("当前已完成进度：100%");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!dbConn.isClosed()) {
				dbConn.close();
			}
			if (flyDataPs != null) {
				flyDataPs = null;
			}

		}
	}

	private static Map<String, Integer> getIsoMarkByBuyerId(String buyerId, Connection dbConn) {
		Map<String, Integer> isoMark = new HashMap<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = dbConn.prepareStatement("SELECT BUYER_NAME FROM UCARE_AGENTS_BUYER_INFO WHERE BUYER_ID = ?");
			ps.setString(1, buyerId);
			rs = ps.executeQuery();
			if (!rs.next()) {
				return null;
			}
			String buyerName = rs.getString(1);
			if (buyerName.contains("翼比特") || buyerName.contains("中科院")) {
				isoMark.put(buyerId, 2);
			} else if (buyerName.contains("中船")) {
				isoMark.put(buyerId, 1);
			} else {
				isoMark = null;
			}
			return isoMark;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String getBuyerIdByDeviceId(String deviceId, Connection dbConn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String flyId = null;
		flyId = deviceId;
		if (!deviceId.startsWith("A")) {
			try {
				ps = dbConn.prepareStatement(
						"SELECT FLY_ID FROM DEVICE_MAPPING_INFO WHERE DEVICE_ID = ? AND FLY_DATA_TYPE = 'Bind'");
				ps.setString(1, deviceId);
				rs = ps.executeQuery();
				if (!rs.next()) {
					return null;
				}
				// 获取FlyId
				flyId = rs.getString(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			// 如果FlyId有效则根据其查询buyerId
			if (!StringUtils.isEmpty(flyId)) {
				ps = dbConn.prepareStatement("SELECT BUYER_ID FROM UCARE_AGENTS_BUYER_CONFIG_INFO WHERE AGENT_ID = ?");
				ps.setString(1, flyId);
				rs = ps.executeQuery();
				if (!rs.next())
					return null;
				// 获取buyerId
				String buyerId = rs.getString(1);
				if (!StringUtils.isEmpty(buyerId)) {
					return buyerId;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void convertTrack2ProtoBytes(Map<String, Integer> isoMark, String flyId, UavTrack jsonTrack) {
		UavFlyDataBatchProto.UavFlyDataBatch.Builder uavFlyDataBatch = UavFlyDataBatchProto.UavFlyDataBatch
				.newBuilder();
		Geometry geo = jsonTrack.getGeometry();
		UavTrackProps props = jsonTrack.getProperties();

		// 计数
		int sendCount = 1;

		for (int i = 0; i < geo.getCoordinates().length; i++) {
			UavFlyDataProto.UavFlyData.Builder uavFlyData = UavFlyDataProto.UavFlyData.newBuilder();
			// 设备Id
			uavFlyData.setFlyId(flyId)
					// jc102
					.setLat(geo.getCoordinates()[i][1]) // 纬度
					.setLon(geo.getCoordinates()[i][0]) // 经度

					.setSpeed((float) props.getSpeed()[i]) // speed
					.setDirection((float) props.getDirection()[i]) // direction
					.setHeight(props.getHeight()[i]) // height
					.setAlt(props.getAlt()[i]) // alt
					.setYaw(props.getYaw()[i]) // yaw
					.setPitch(props.getPitch()[i]) // pitch
					.setRoll(props.getRoll()[i]) // roll
					.setTime(props.getTime()[i] * 1000); // time

			// uploadTime
			if (jsonTrack.getProperties().getUploadingTime() != null
					&& jsonTrack.getProperties().getUploadingTime().length > 0
					&& jsonTrack.getProperties().getUploadingTime()[i] > 0) {
				uavFlyData.setUploadTime(jsonTrack.getProperties().getUploadingTime()[i] * 1000);
			} else {
				count++;
				uavFlyData.setUploadTime(props.getTime()[i] * 1000);
			}

			// Ext2
			if (jsonTrack.getProperties().getExt2() != null && jsonTrack.getProperties().getExt2().length > 0
					&& !StringUtils.isEmpty(jsonTrack.getProperties().getExt2()[i])) {
				uavFlyData.setExt2(props.getExt2()[i]);
			}

			// oLat
			if (jsonTrack.getProperties().getOLat() != null && jsonTrack.getProperties().getOLat().length > 0
					&& jsonTrack.getProperties().getOLat()[i] > 0) {
				uavFlyData.setOLat(jsonTrack.getProperties().getOLat()[i]);
			}
			// oLon
			if (jsonTrack.getProperties().getOLon() != null && jsonTrack.getProperties().getOLon().length > 0
					&& jsonTrack.getProperties().getOLon()[i] > 0) {
				uavFlyData.setOLon(jsonTrack.getProperties().getOLon()[i]);
			}

			// 如果batch中包含了2000个点，则将这2000个点发出去
			if (sendCount % 2000 == 0) {
				sendFlyData(isoMark, uavFlyDataBatch);
				uavFlyDataBatch.clear();
			} else {
				uavFlyDataBatch.addFlyData(uavFlyData.build());
			}

			sendCount++;
		}

		// 如果有剩余数据也需要发出去
		if (uavFlyDataBatch.build().getFlyDataCount() > 0) {
			sendFlyData(isoMark, uavFlyDataBatch);
		}
	}

	public static void sendFlyData(Map<String, Integer> isoMark,
			UavFlyDataBatchProto.UavFlyDataBatch.Builder uavFlyDataBatch) {
		String iso2 = null;
		if (isoMark != null) {
			Optional<String> buyerId = isoMark.keySet().stream().findFirst();
			if (buyerId.isPresent()) {
				iso2 = "&isoMark=2&buyerId=" + buyerId.get();
			}
		}

		try {
			System.out.println("uploadTime为空数量：" + count);
			count = 0; // count清零

			Thread.sleep(50);
			// 调用批量发送接口发送数据
			// String s = "http://192.168.3.37:8100/flydata/uav/batch?toRealtime=true";
			String s = "http://" + hbaseUrl + "/flydata/uav/batch?toRealtime=true";
			if (iso2 != null) {
				s += iso2;
			}
			URL url = new URL(s);
			HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
			urlc.setDoInput(true);
			urlc.setDoOutput(true);
			urlc.setRequestMethod("POST");
			urlc.setRequestProperty("Accept", "application/x-protobuf");
			urlc.setRequestProperty("Content-Type", "application/x-protobuf");

			urlc.connect();

			// 获取一次batch的数据量
			// System.out.println("batch size:" +
			// uavFlyDataBatch.build().toByteArray().length);

			try (OutputStream os = urlc.getOutputStream();) {
				IOUtils.copy(new ByteArrayInputStream(uavFlyDataBatch.build().toByteArray()), os);
			}

			try (BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream(), "utf-8"));) {
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			}

			// 关闭连接
			urlc.disconnect();
			urlc = null;
			url = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}
