package com.mitsui.service;

import java.util.List;

import com.mitsui.dao.FileDao;
import com.mitsui.domain.File;
import com.mitsui.domain.Staff;

public class FileService {
	
static	private FileDao fileDao = new FileDao();
	
	public boolean addFile(File file){
		try{
			fileDao.addFile(file);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public  List<File> queryAllFile(){
		try{
			List<File> Files = fileDao.queryAllFile();
			return Files;
		}catch (Exception e) {
			return null;
		}
	}
	public boolean deleteFile(Integer p_id){
		try{
			fileDao.deleteFile(p_id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public File queryFile(Integer id){
		try{
			File u = fileDao.queryFile(id);
			return u;
		}catch (Exception e) {
			return null;
		}
	}
	public boolean updateFile(File File){
		try{
			return fileDao.updateFile(File);
		}catch (Exception e) {
			return false;
		}
	}
	public List<File> queryOneFile(int id) {
		try{
			List<File> Files = FileDao.queryOneFile(id);
			return Files;
		}catch (Exception e) {
			return null;
		}
	}

}
