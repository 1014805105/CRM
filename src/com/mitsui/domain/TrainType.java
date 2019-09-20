package com.mitsui.domain;

public class TrainType {
	/**培训类型类
	 * @author ssz
	 * 2013年9月5日8:52:15
	 */
	private String type_code;
    private String type_name;
	private String type_info;
	public String getType_code() {
		return type_code;
	}
	public void setType_code(String typeCode) {
		type_code = typeCode;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String typeName) {
		type_name = typeName;
	}
	public String getType_info() {
		return type_info;
	}
	public void setType_info(String typeInfo) {
		type_info = typeInfo;
	}
	@Override
	public String toString() {
		return "TrainType [type_code=" + type_code + ", type_info=" + type_info
				+ ", type_name=" + type_name + "]";
	}
	public TrainType(String typeCode, String typeName, String typeInfo) {
		super();
		type_code = typeCode;
		type_name = typeName;
		type_info = typeInfo;
	}
	public TrainType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
