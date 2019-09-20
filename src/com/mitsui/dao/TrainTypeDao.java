package com.mitsui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mitsui.domain.TrainType;
import com.mitsui.util.ConnectionUtil;
public class TrainTypeDao {
/**
 * @author ssz
 * 2013年9月5日8:58:59
 */
	public boolean addTrainType(TrainType TrainType){
		String sql = "insert into TrainType(Type_code,Type_name,Type_info) values(?,?,?)";
		Object[] params = {
				TrainType.getType_code(),
				TrainType.getType_name(),
				TrainType.getType_info(),

				
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

	public TrainType queryTrainType(String type_code){
		String sql = "select * from TrainType where type_code = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, type_code);
			ResultSet rs = ps.executeQuery();
			TrainType type = null;
			if(rs.next()){
				String type_name = rs.getString("type_name");
				String type_info = rs.getString("type_info");

				type = new TrainType(type_code,type_name,type_info);
			}
			return type;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteTrainType(String type_code){
		String sql = "delete from traintype where type_code = ?";
		Object[] params = {
				type_code
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}

	public List<TrainType> queryAllTrainType(){
		String sql = "select * from TrainType";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			TrainType type = null;
			List<TrainType> types = new ArrayList<TrainType>();
			while(rs.next()){
				String type_code = rs.getString("type_code");
				String type_name = rs.getString("type_name");
				String type_info = rs.getString("type_info");

				type = new TrainType(type_code,type_name,type_info);
				types.add(type);
			}
			return types;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean updateTrainType(TrainType traintype){
		String sql = "update traintype set type_code=?,type_name=?,type_info=? where type_code=?";
		Object[] params = {
        traintype.getType_code(),
        traintype.getType_name(),
        traintype.getType_info(),
        traintype.getType_code()
		
		
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
	
}
