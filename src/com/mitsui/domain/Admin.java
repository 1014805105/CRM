package com.mitsui.domain;

public class Admin {
private Integer admin_id;
private String admin_username;
private String admin_password;


public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(Integer adminId, String adminUsername, String adminPassword) {
	super();
	admin_id = adminId;
	admin_username = adminUsername;
	admin_password = adminPassword;
}

public String toString() {
	return "Admin [admin_id=" + admin_id + ", admin_password=" + admin_password
			+ ", admin_username=" + admin_username + "]";
}
public Integer getAdmin_id() {
	return admin_id;
}

public void setAdmin_id(Integer adminId) {
	admin_id = adminId;
	
}

public String getAdmin_username() {
	return admin_username;
}
public void setAdmin_username(String adminUsername) {
	admin_username = adminUsername;
	
}
public String getAdmin_password() {
	return admin_password;
}
public void setAdmin_password(String adminPassword) {
	admin_password = adminPassword;
}

}
