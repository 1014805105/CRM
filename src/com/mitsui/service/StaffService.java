package com.mitsui.service;

import java.util.List;

import com.mitsui.dao.StaffDao;
import com.mitsui.domain.Staff;

public class StaffService {
	
static	private StaffDao staffDao = new StaffDao();
	
	public static boolean addStaff(Staff staff){
		try{
			staffDao.addStaff(staff);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	static public Staff queryStaff(Staff staff){
		try{
			Staff u = staffDao.queryStaff(staff);
			return u;
		}catch (Exception e) {
			return null;
		}
	}
	public  List<Staff> queryAllStaff(){
		try{
			List<Staff> Staffs = staffDao.queryAllStaff();
			return Staffs;
		}catch (Exception e) {
			return null;
		}
	}
	public boolean deleteStaff(Integer p_id){
		try{
			staffDao.deleteStaff(p_id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public Staff queryStaff(Integer id){
		try{
			Staff u = staffDao.queryStaff(id);
			return u;
		}catch (Exception e) {
			return null;
		}
	}
	public boolean updateStaff(Staff Staff){
		try{
			return staffDao.updateStaff(Staff);
		}catch (Exception e) {
			return false;
		}
	}
	public List<Staff> queryOneStaff(String name) {
		try{
			List<Staff> Staffs = staffDao.queryOneStaff(name);
			return Staffs;
		}catch (Exception e) {
			return null;
		}
	}
}
