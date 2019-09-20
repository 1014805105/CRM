package com.mitsui.service;

import java.util.List;

import com.mitsui.dao.TrainRecordDao;
import com.mitsui.domain.TrainRecord;

public class TrainRecordService {
	

		 private TrainRecordDao trainrecordDao=new TrainRecordDao();
		
		 public boolean addTrainRecord(TrainRecord trainrecord){
			try {
				trainrecordDao.addTrainRecord(trainrecord);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		public boolean deleteTrainRecord(Integer train_id){
			try {
				trainrecordDao.deleteTrainRecord(train_id);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		public boolean updateTrainRecord(TrainRecord trainrecord){
			try {
				trainrecordDao.updateTrainRecord(trainrecord);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		public TrainRecord queryTrainRecord(Integer train_id){
			try {
				TrainRecord trainrecord=trainrecordDao.queryTrainRecord(train_id);
				return trainrecord;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		public List<TrainRecord> queryAllTrainRecord(){
			try {
				List<TrainRecord> trains=trainrecordDao.queryAllTrainRecord();
				return trains;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

}
