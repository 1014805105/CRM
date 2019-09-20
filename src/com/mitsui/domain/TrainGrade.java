package com.mitsui.domain;

public class TrainGrade {

	private Integer grade_id;
	private Integer train_id;
	private Integer p_id;
	private Integer grade;
	private String subject;
	private String get_cer;
	public Integer getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(Integer gradeId) {
		grade_id = gradeId;
	}
	public Integer getTrain_id() {
		return train_id;
	}
	public void setTrain_id(Integer trainId) {
		train_id = trainId;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer pId) {
		p_id = pId;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGet_cer() {
		return get_cer;
	}
	public void setGet_cer(String getCer) {
		get_cer = getCer;
	}
	public TrainGrade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrainGrade(Integer gradeId, Integer trainId, Integer pId, Integer grade,
			String subject, String getCer) {
		super();
		grade_id = gradeId;
		train_id = trainId;
		p_id = pId;
		this.grade = grade;
		this.subject = subject;
		get_cer = getCer;
	}
	@Override
	public String toString() {
		return "TrainGrade [get_cer=" + get_cer + ", grade=" + grade
				+ ", grade_id=" + grade_id + ", p_id=" + p_id + ", subject="
				+ subject + ", train_id=" + train_id + "]";
	}
	
	
	
}
