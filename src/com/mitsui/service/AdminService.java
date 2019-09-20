package com.mitsui.service;

import com.mitsui.dao.AdminDao;
import com.mitsui.domain.Admin;


public class AdminService {
	static	private AdminDao adminDao = new AdminDao();
	static public Admin queryAdmin(Admin admin){
		try{
			Admin u = adminDao.queryAdmin(admin);
			return u;
		}catch (Exception e) {
			return null;
		}
	}
}
