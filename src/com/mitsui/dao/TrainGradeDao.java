package com.mitsui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mitsui.domain.StaffCert;
import com.mitsui.domain.TrainGrade;
import com.mitsui.util.ConnectionUtil;

public class TrainGradeDao {
	public boolean addTrainGrade(TrainGrade traingrade){
		String sql = "insert into TrainGrade(grade_id,train_id,p_id,grade,subject,get_cer) values(?,?,?,?,?,?)";
		Object[] params = {
				traingrade.getGrade_id(),
				traingrade.getTrain_id(),
				traingrade.getP_id(),
				traingrade.getGrade(),
				traingrade.getSubject(),
				traingrade.getGet_cer()
				

				
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

	public TrainGrade queryTrainGrade(Integer grade_id){
		String sql = "select * from TrainGrade where grade_id = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, grade_id);
			ResultSet rs = ps.executeQuery();
			TrainGrade grade = null;
			if(rs.next()){
				int gradeid = rs.getInt("grade_id");
				int trainid = rs.getInt("train_id");
				int pid = rs.getInt("p_id");
				int gradei = rs.getInt("grade");
				String subject = rs.getString("subject");
				String getcer = rs.getString("get_cer");

				grade = new TrainGrade(gradeid,trainid,pid,gradei,subject,getcer);
			}
			return grade;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteTrainGrade(Integer grade_id){
		String sql = "delete from TrainGrade where grade_id = ?";
		Object[] params = {
				grade_id
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}

	public List<TrainGrade> queryAllTrainGrade(){
		String sql = "select * from TrainGrade";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			TrainGrade grade = null;
			List<TrainGrade> grades = new ArrayList<TrainGrade>();
			while(rs.next()){
				int gradeid = rs.getInt("grade_id");
				int trainid = rs.getInt("train_id");
				int pid = rs.getInt("p_id");
				int gradei = rs.getInt("grade");
				String subject = rs.getString("subject");
				String getcer = rs.getString("get_cer");

				grade = new TrainGrade(gradeid,trainid,pid,gradei,subject,getcer);
				grades.add(grade);
			}
			return grades;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean updateTrainGrade(TrainGrade traingrade){
		String sql = "update traingrade set grade_id=?,train_id=?,p_id=?,grade=?,subject=?,get_cer=? where grade_id=?";
		Object[] params = {
                traingrade.getGrade_id(),
				traingrade.getTrain_id(),
				traingrade.getP_id(),
				traingrade.getGrade(),
				traingrade.getSubject(),
				traingrade.getGet_cer(),
				traingrade.getGrade_id()
		
		
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
}
