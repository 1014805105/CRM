package com.mitsui.domain;

public class StaffCert {
	 private Integer cer_id;
	 private Integer grade_id;
	 private String cer_name;
	 private String cer_date;
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
	@Override
	public String toString() {
		return "StaffCert [cer_date=" + cer_date + ", cer_id=" + cer_id
				+ ", cer_name=" + cer_name + ", grade_id=" + grade_id + "]";
	}
	public StaffCert(Integer cerId, Integer gradeId, String cerName,
			String cerDate) {
		super();
		cer_id = cerId;
		grade_id = gradeId;
		cer_name = cerName;
		cer_date = cerDate;
	}
	public StaffCert() {
		super();
		// TODO Auto-generated constructor stub
	}

}
