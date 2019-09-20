package com.mitsui.domain;

public class Agreement {

	private Integer agreement_id;
	 private Integer p_id;
	 private String  agreement_btime;
	 private String agreement_etime;
	 private String position;
	 private String agreement_content;
	public Integer getAgreement_id() {
		return agreement_id;
	}
	public void setAgreement_id(Integer agreementId) {
		this.agreement_id = agreementId;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer pId) {
		this.p_id = pId;
	}
	public String getAgreement_btime() {
		return agreement_btime;
	}
	public void setAgreement_btime(String agreementBtime) {
		this.agreement_btime = agreementBtime;
	}
	public String getAgreement_etime() {
		return agreement_etime;
	}
	public void setAgreement_etime(String agreementEtime) {
		agreement_etime = agreementEtime;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAgreement_content() {
		return agreement_content;
	}
	public void setAgreement_content(String agreementContent) {
		this.agreement_content = agreementContent;
	}
	
	@Override

	public String toString() {
		return "Agreement [agreement_id=" + agreement_id + ", p_id=" + p_id + ", agreement_btime="
				+ agreement_btime + ", agreement_etime=" + agreement_etime + ", position=" + position + ", agreement_content="
				+ agreement_content + "]";
	}
	public Agreement(Integer agreementId, Integer pId, String agreementBtime, String agreementEtime,
			String position, String agreementContent) {
		super();
		this.agreement_id = agreementId;
		this.p_id = pId;
		this.agreement_btime = agreementBtime;
		this.agreement_etime = agreementEtime;
		this.position = position;
		this.agreement_content = agreementContent;
	}
}
