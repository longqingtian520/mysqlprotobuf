package com.criss.wang.entity;

/**
 *
 * @author lihaosu
 *
 * @date 2018-09-27 20:42:45
 *
 * @description GeoJSON的Geometry
 */
public class Geometry extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 6871736842028054803L;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 每个点的坐标
	 */
	private double[][] coordinates;

	public Geometry() {
		super();
	}

	public Geometry(String type, double[][] coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double[][] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(double[][] coordinates) {
		this.coordinates = coordinates;
	}
}
