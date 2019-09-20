package com.mitsui.domain;

public class Alter {
 private Integer alter_id;
 private Integer p_id;
 private String  p_name;
 private String alter_time;
 private String alter_bstate;
 private String alter_estate;
 private String alter_type;
 private String alter_content;
 

public Integer getAlter_id() {
	return alter_id;
}


public void setAlter_id(Integer alterId) {
	alter_id = alterId;
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


public String getAlter_time() {
	return alter_time;
}


public void setAlter_time(String alterTime) {
	alter_time = alterTime;
}




public String getAlter_bstate() {
	return alter_bstate;
}


public void setAlter_bstate(String alterBstate) {
	alter_bstate = alterBstate;
}


public String getAlter_estate() {
	return alter_estate;
}


public void setAlter_estate(String alterEstate) {
	alter_estate = alterEstate;
}


public String getAlter_type() {
	return alter_type;
}


public void setAlter_type(String alterType) {
	alter_type = alterType;
}


public String getAlter_content() {
	return alter_content;
}


public void setAlter_content(String alterContent) {
	alter_content = alterContent;
}


public Alter(Integer alterId, Integer pId, String pName, String alterTime,
		 String alterBstate, String alterEstate, String alterType,
		String alterContent) {
	super();
	alter_id = alterId;
	p_id = pId;
	p_name = pName;
	alter_time = alterTime;
	alter_bstate = alterBstate;
	alter_estate = alterEstate;
	alter_type = alterType;
	alter_content = alterContent;
}


@Override
public String toString() {
	return "Alter [alter_id=" + alter_id + ", p_id=" + p_id + ", p_name="
			+ p_name + ", alter_time=" + alter_time + ", alter_bstate=" 
			+ alter_bstate + ", alter_estate=" + alter_estate + ", alter_type=" + alter_type
			+ ", alter_content=" + alter_content + "]";
	}
}