package com.mitsui.service;

import java.util.List;

import com.mitsui.dao.TrainTypeDao;
import com.mitsui.domain.TrainType;


/**
 * @author ssz
 * 2013年9月5日10:46:39
 */
public class TrainTypeService {

	 private TrainTypeDao traintypeDao=new TrainTypeDao();
	
	 public boolean addTrainType(TrainType traintype){
		try {
			traintypeDao.addTrainType(traintype);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteTrainType(String type_code){
		try {
			traintypeDao.deleteTrainType(type_code);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateTrainType(TrainType traintype){
		try {
			traintypeDao.updateTrainType(traintype);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public TrainType queryTrainType(String type_code){
		try {
			TrainType type=traintypeDao.queryTrainType(type_code);
			return type;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<TrainType> queryAllTrainType(){
		try {
			List<TrainType> types=traintypeDao.queryAllTrainType();
			return types;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
