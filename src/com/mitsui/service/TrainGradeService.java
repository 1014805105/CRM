package com.mitsui.service;

import java.util.List;

import com.mitsui.dao.TrainGradeDao;
import com.mitsui.domain.TrainGrade;

public class TrainGradeService {
	 private TrainGradeDao traingradeDao=new TrainGradeDao();
		
	 public boolean addTrainGrade(TrainGrade traingrade){
		try {
			traingradeDao.addTrainGrade(traingrade);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteTrainGrade(Integer train_id){
		try {
			traingradeDao.deleteTrainGrade(train_id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateTrainGrade(TrainGrade traingrade){
		try {
			traingradeDao.updateTrainGrade(traingrade);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public TrainGrade queryTrainGrade(Integer train_id){
		try {
			TrainGrade traingrade=traingradeDao.queryTrainGrade(train_id);
			return traingrade;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<TrainGrade> queryAllTrainGrade(){
		try {
			List<TrainGrade> grades=traingradeDao.queryAllTrainGrade();
			return grades;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
