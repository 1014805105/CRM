package com.mitsui.domain;

public class Staff {
 private Integer p_id;
 private String p_name;
 private String  sex;
 private String degree;
 private String department;
 private String position;
 private String state;
 private String user_name;
 private String user_password;
 
public Staff() {
	super();
}

public Integer getP_id() {
	return p_id;
}

public void setP_id(Integer pId) {
	this.p_id = pId;
}
public String getP_name() {
	return p_name;
}
public void setP_name(String pName) {
	this.p_name = pName;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String userName) {
	this.user_name = userName;
}
public String getUser_password() {
	return user_password;
}
public void setUser_password(String userPassword) {
	this.user_password = userPassword;
}
@Override

public String toString() {
	return "Staff [degree=" + degree + ", department=" + department + ", p_id="
			+ p_id + ", p_name=" + p_name + ", position=" + position + ", sex="
			+ sex + ", state=" + state + ", user_name=" + user_name
			+ ", user_password=" + user_password + "]";
}
public Staff(Integer pId, String pName, String sex, String degree,
		String department, String position, String state, String userName,
		String userPassword) {
	super();
	this.p_id = pId;
	this.p_name = pName;
	this.sex = sex;
	this.degree = degree;
	this.department = department;
	this.position = position;
	this.state = state;
	this.user_name = userName;
	this.user_password = userPassword;
}
 
}
