package com.mitsui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mitsui.domain.TrainRecord;
import com.mitsui.domain.TrainType;
import com.mitsui.util.ConnectionUtil;

public class TrainRecordDao {
	public boolean addTrainRecord(TrainRecord trainrecord){
		String sql = "insert into Train( train_id,train_name,type_code,train_btime,train_etime,train_expense,train_location,train_host,train_master) values(?,?,?,?,?,?,?,?,?)";
		Object[] params = {
				trainrecord.getTrain_id(),
				trainrecord.getTrain_name(),
				trainrecord.getType_code(),
				trainrecord.getTrain_btime(),
				trainrecord.getTrain_etime(),
				trainrecord.getTrain_expense(),
				trainrecord.getTrain_location(),
				trainrecord.getTrain_host(),
				trainrecord.getTrain_master()
				
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
	/*public TrainType queryTrainType(TrainType trainType){

		String sql = "select * from trainType where type_code = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, trainType.getType_code());
			ResultSet rs = ps.executeQuery();
			TrainType type = null;
			if(rs.next()){
				String type_code = rs.getString("type_code");
				String type_name = rs.getString("type_name");
				String type_info = rs.getString("type_info");

				type = new TrainType(type_code,type_name,type_info);
			}
			if(u.getPassword().equals(trainType.getPassword())){
				return u;
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}*/

	public TrainRecord queryTrainRecord(Integer train_id){
		String sql = "select * from Train where train_id = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, train_id);
			ResultSet rs = ps.executeQuery();
			TrainRecord train = null;
			if(rs.next()){
				String train_name=rs.getString("train_name");
				String type_code = rs.getString("type_code");
				String train_btime = rs.getString("train_btime");
				String train_etime = rs.getString("train_etime");
				String train_expense = rs.getString("train_expense");
				String train_location = rs.getString("train_location");
				String train_host = rs.getString("train_host");
				String train_master = rs.getString("train_master");

				train = new TrainRecord(train_id,train_name,type_code,train_btime,train_etime,train_expense,train_location,train_host,train_master);
			}
			return train;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteTrainRecord(Integer train_id){
		String sql = "delete from train where train_id = ?";
		Object[] params = {
				train_id
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}

	public List<TrainRecord> queryAllTrainRecord(){
		String sql = "select * from Train";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			TrainRecord train = null;
			List<TrainRecord> trains = new ArrayList<TrainRecord>();
			while(rs.next()){
				Integer train_id= rs.getInt("train_id");
				String train_name=rs.getString("train_name");
				String type_code = rs.getString("type_code");
				String train_btime = rs.getString("train_btime");
				String train_etime = rs.getString("train_etime");
				String train_expense = rs.getString("train_expense");
				String train_location = rs.getString("train_location");
				String train_host = rs.getString("train_host");
				String train_master = rs.getString("train_master");

				train = new TrainRecord(train_id,train_name,type_code,train_btime,train_etime,train_expense,train_location,train_host,train_master);
				trains.add(train);
			}
			return trains;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean updateTrainRecord(TrainRecord trainrecord){
		String sql = "update train set train_id=?,train_name=?,type_code = ? ,train_btime=?,train_etime=?,train_expense=?,train_location=?,train_host = ?,train_master=? where train_id=?";
		Object[] params = {
				trainrecord.getTrain_id(),
				trainrecord.getTrain_name(),
				trainrecord.getType_code(),
				trainrecord.getTrain_btime(),
				trainrecord.getTrain_etime(),
				trainrecord.getTrain_expense(),
				trainrecord.getTrain_location(),
				trainrecord.getTrain_host(),
				trainrecord.getTrain_master(),
                trainrecord.getTrain_id()
		
		
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
	
}
