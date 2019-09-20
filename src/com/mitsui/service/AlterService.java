package com.mitsui.service;

import java.util.List;

import com.mitsui.dao.AgreementDao;
import com.mitsui.dao.AlterDao;
import com.mitsui.domain.Agreement;
import com.mitsui.domain.Alter;

public class AlterService {
	
	private AlterDao alterDao = new AlterDao();
	
	public boolean addUser(Alter user){
		try{
			alterDao.addAlter(user);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public Alter queryAlter(Alter user){
		try{
			Alter u = alterDao.queryAlter(user);
			return u;
		}catch (Exception e) {
			return null;
		}
	}
	public List<Alter> queryAllAlter(){
		try{
			List<Alter> users = alterDao.queryAllAlter();
			return users;
		}catch (Exception e) {
			return null;
		}
	}
	public boolean deleteAlter(Integer id){
		try{
			alterDao.deleteAlter(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public Alter queryAlter(Integer id){
		try{
			Alter u = alterDao.queryAlter(id);
			return u;
		}catch (Exception e) {
			return null;
		}
	}
	public boolean updateAlter(Alter user){
		try{
			return alterDao.updateAlter(user);
		}catch (Exception e) {
			return false;
		}
	}
	public List<Alter> queryOneAlter(int id) {
		try{
			List<Alter> users =alterDao.queryOneAlter(id);
			return users;
		}catch (Exception e) {
			return null;
		}
	}
	}

