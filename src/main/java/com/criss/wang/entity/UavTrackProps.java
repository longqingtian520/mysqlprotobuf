package com.criss.wang.entity;


/**
 *
 * @author lihaosu
 *
 * @date 2018-09-27 20:43:54
 *
 * @description 无人机航迹的自定义属性
 */
public class UavTrackProps extends BaseEntity {
	/**
	*
	*/
	private static final long serialVersionUID = 5213911122213714349L;

	/**
	 * 上云时间
	 */
	private long[] time;

	/**
	 * 高度
	 */
	private double[] alt;

	/**
	 * 高度
	 */
	private double[] height;

	/**
	 * 速度
	 */
	private double[] speed;

	/**
	 * 方向
	 */
	private double[] direction;

	/**
	 * yaw
	 */
	private double[] yaw;

	/**
	 * pitch
	 */
	private double[] pitch;

	/**
	 * roll
	 */
	private double[] roll;

	/**
	 * ext2
	 */
	private String[] ext2;

	/**
	 * 数据帧时间
	 */
	private long[] uploadingTime;

	/**
	 * 原始纬度
	 */
	private double[] oLat;

	/**
	 * 原始经度
	 */
	private double[] oLon;

	public UavTrackProps() {
		super();
	}

	public UavTrackProps(long[] time, double[] alt, double[] height, double[] speed, double[] direction, double[] yaw,
			double[] pitch, double[] roll, String[] ext2, long[] uploadingTime, double[] oLat, double[] oLon) {
		super();
		this.time = time;
		this.alt = alt;
		this.height = height;
		this.speed = speed;
		this.direction = direction;
		this.yaw = yaw;
		this.pitch = pitch;
		this.roll = roll;
		this.ext2 = ext2;
		this.uploadingTime = uploadingTime;
		this.oLat = oLat;
		this.oLon = oLon;
	}

	public long[] getTime() {
		return time;
	}

	public void setTime(long[] time) {
		this.time = time;
	}

	public double[] getAlt() {
		return alt;
	}

	public void setAlt(double[] alt) {
		this.alt = alt;
	}

	public double[] getHeight() {
		return height;
	}

	public void setHeight(double[] height) {
		this.height = height;
	}

	public double[] getSpeed() {
		return speed;
	}

	public void setSpeed(double[] speed) {
		this.speed = speed;
	}

	public double[] getDirection() {
		return direction;
	}

	public void setDirection(double[] direction) {
		this.direction = direction;
	}

	public double[] getYaw() {
		return yaw;
	}

	public void setYaw(double[] yaw) {
		this.yaw = yaw;
	}

	public double[] getPitch() {
		return pitch;
	}

	public void setPitch(double[] pitch) {
		this.pitch = pitch;
	}

	public double[] getRoll() {
		return roll;
	}

	public void setRoll(double[] roll) {
		this.roll = roll;
	}

	public String[] getExt2() {
		return ext2;
	}

	public void setExt2(String[] ext2) {
		this.ext2 = ext2;
	}

	public long[] getUploadingTime() {
		return uploadingTime;
	}

	public void setUploadingTime(long[] uploadingTime) {
		this.uploadingTime = uploadingTime;
	}

	public double[] getOLat() {
		return oLat;
	}

	public void setOLat(double[] oLat) {
		this.oLat = oLat;
	}

	public double[] getOLon() {
		return oLon;
	}

	public void setOLon(double[] oLon) {
		this.oLon = oLon;
	}
}
