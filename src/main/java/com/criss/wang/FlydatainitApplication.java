package com.criss.wang;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.druid.util.StringUtils;
import com.criss.wang.entity.Geometry;
import net.cc.luffy.entity.proto.UavFlyDataBatchProto;
import net.cc.luffy.entity.proto.UavFlyDataProto;
import com.criss.wang.entity.UavTrack;
import com.criss.wang.entity.UavTrackProps;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class FlydatainitApplication {

	private static String dbURL;
	private static String userName;
	private static String userPwd;
	private static String hbaseUrl;
	private static int count = 0;

	public static void main(String[] args) {
		SpringApplication.run(FlydatainitApplication.class, args);

		if (args.length < 5) {
			System.out.println(args[0]);
			System.out.println("参数不完整");
			System.exit(-1);
		}

		// office-server:3306
		dbURL = args[1];
		// 用户名
		userName = args[2];
		// 密码
		userPwd = args[3];
		// 192.168.3.37:8100
		hbaseUrl = args[4];

		Connection dbConn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://" + dbURL + "/UCareDB_Test?useSSL=false", userName,
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
		try {
			// 查询fly_data_info总数据量
			flyDataPs = dbConn.prepareStatement("SELECT COUNT(*) FROM FLY_DATA_INFO");
			flyDataRs = flyDataPs.executeQuery();
			flyDataRs.next();
			// 总记录数量
			String count = flyDataRs.getString(1);
			// 起始行
			int row = 0;
			while (row <= Integer.valueOf(count)) {
				String sql = "SELECT DEVICE_START_END_ID, DEVICE_ID, FLY_DATA FROM FLY_DATA_INFO " + "limit " + row
						+ ", 10";
				flyDataPs = dbConn.prepareStatement(sql);
				flyDataRs = flyDataPs.executeQuery();
				while (flyDataRs.next()) {
					UavTrack jsonTrack = objectMapper.readValue(flyDataRs.getString(3), UavTrack.class);
					// 拆点入Hbase
					convertTrack2ProtoBytes(flyDataRs.getString(2), jsonTrack);
				}
				row += 10;
			}
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

	public static void convertTrack2ProtoBytes(String flyId, UavTrack jsonTrack) {
		try {
			UavFlyDataBatchProto.UavFlyDataBatch.Builder uavFlyDataBatch = UavFlyDataBatchProto.UavFlyDataBatch
					.newBuilder();
			Geometry geo = jsonTrack.getGeometry();
			UavTrackProps props = jsonTrack.getProperties();

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
						.setTime(props.getTime()[i]); // time

				// uploadTime
				if (jsonTrack.getProperties().getUploadingTime() != null
						&& jsonTrack.getProperties().getUploadingTime().length > 0
						&& jsonTrack.getProperties().getUploadingTime()[i] > 0) {
					uavFlyData.setUploadTime(jsonTrack.getProperties().getUploadingTime()[i]);
				} else {
					count++;
					uavFlyData.setUploadTime(props.getTime()[i]);
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
				uavFlyDataBatch.addFlyData(uavFlyData.build());
			}

			System.out.println("uploadTime为空数量：" + count);
			count = 0; // count清零

			Thread.sleep(50);
			// 调用批量发送接口发送数据
			// String s = "http://192.168.3.37:8100/flydata/uav/batch?toRealtime=true";
			String s = "http://" + hbaseUrl + "/flydata/uav/batch?toRealtime=true";
			URL url = new URL(s);
			HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
			urlc.setDoInput(true);
			urlc.setDoOutput(true);
			urlc.setRequestMethod("POST");
			urlc.setRequestProperty("Accept", "application/x-protobuf");
			urlc.setRequestProperty("Content-Type", "application/x-protobuf");

			urlc.connect();

			// 获取一次batch的数据量
			System.out.println("batch size:" + uavFlyDataBatch.build().toByteArray().length);

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
			// 退出脚本
			System.exit(-1);
		}
	}
}
