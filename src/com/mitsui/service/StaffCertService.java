package com.mitsui.service;

import java.util.List;

import com.mitsui.dao.StaffCertDao;
import com.mitsui.dao.TrainRecordDao;
import com.mitsui.domain.StaffCert;
import com.mitsui.domain.TrainRecord;

public class StaffCertService {
	 private StaffCertDao staffcertDao=new StaffCertDao();
		
	 public boolean addStaffCert(StaffCert staffcert){
		try {
			staffcertDao.addStaffCert(staffcert);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteStaffCert(Integer train_id){
		try {
			staffcertDao.deleteStaffCert(train_id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateStaffCert(StaffCert staffcert){
		try {
			staffcertDao.updateStaffCert(staffcert);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public StaffCert queryStaffCert(Integer train_id){
		try {
			StaffCert staffcert=staffcertDao.queryStaffCert(train_id);
			return staffcert;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<StaffCert> queryAllStaffCert(){
		try {
			List<StaffCert> trains=staffcertDao.queryAllStaffCert();
			return trains;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
