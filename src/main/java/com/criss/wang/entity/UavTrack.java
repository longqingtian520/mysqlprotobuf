package com.criss.wang.entity;

/**
 *
 * @author lihaosu
 *
 * @date 2018-10-18 20:32:48
 *
 * @description 无人机航迹的GeoJSON
 */
public class UavTrack extends BaseEntity {
	/**
	*
	*/
	private static final long serialVersionUID = 5594451669088662805L;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * geo数据
	 */
	private Geometry geometry;

	/**
	 * 自定义数据
	 */
	private UavTrackProps properties;

	public UavTrack() {
		super();
	}

	public UavTrack(String type, Geometry geometry, UavTrackProps properties) {
		super();
		this.type = type;
		this.geometry = geometry;
		this.properties = properties;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public UavTrackProps getProperties() {
		return properties;
	}

	public void setProperties(UavTrackProps properties) {
		this.properties = properties;
	}
}
