package com.mitsui.domain;

public class CertSelect {

	 private Integer cer_id;
	 private Integer grade_id;
	 private String cer_name;
	 private String cer_date;
	 private Integer p_id;
	 private String p_name;
	public Integer getCer_id() {
		return cer_id;
	}
	public void setCer_id(Integer cerId) {
		cer_id = cerId;
	}
	public Integer getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(Integer gradeId) {
		grade_id = gradeId;
	}
	public String getCer_name() {
		return cer_name;
	}
	public void setCer_name(String cerName) {
		cer_name = cerName;
	}
	public String getCer_date() {
		return cer_date;
	}
	public void setCer_date(String cerDate) {
		cer_date = cerDate;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer pId) {
		p_id = pId;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String pName) {
		p_name = pName;
	}
	public CertSelect(Integer cerId, Integer gradeId, String cerName,
			String cerDate, Integer pId, String pName) {
		super();
		cer_id = cerId;
		grade_id = gradeId;
		cer_name = cerName;
		cer_date = cerDate;
		p_id = pId;
		p_name = pName;
	}
	public CertSelect() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CertSelect [cer_date=" + cer_date + ", cer_id=" + cer_id
				+ ", cer_name=" + cer_name + ", grade_id=" + grade_id
				+ ", p_id=" + p_id + ", p_name=" + p_name + "]";
	}
	
	 
}
