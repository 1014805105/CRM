package com.mitsui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mitsui.domain.Alter;
import com.mitsui.servlet.AlterInputServlet;
import com.mitsui.util.ConnectionUtil;

public class AlterDao {
	public boolean addAlter(Alter alter){
		String sql = "insert into staffalter(alter_id,p_id,p_name,alter_time,alter_bstate,alter_estate,alter_type,alter_content) values(?,?,?,?,?,?,?,?)";
		Object[] params = {
				alter.getAlter_id(),
				alter.getP_id(),
				alter.getP_name(),
				alter.getAlter_time(),
				alter.getAlter_bstate(),
				alter.getAlter_estate(),
				alter.getAlter_type(),
				alter.getAlter_content()
				
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
	public Alter queryAlter(Alter alter){
		String sql = "select * from staffalter where alter_id = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, alter.getAlter_id());
			ResultSet rs = ps.executeQuery();
			Alter u = null;
			if(rs.next()){
				
				Integer alter_id = rs.getInt("alter_id");
				Integer p_id = rs.getInt("p_id");
				String p_name = rs.getString("p_name");
				String alter_time = rs.getString("alter_time");
				String alter_bstate = rs.getString("alter_bstate");
				String alter_estate = rs.getString("alter_estate");
				String alter_type = rs.getString("alter_type");
				String alter_content = rs.getString("alter_content");
				
				u = new Alter(alter_id, p_id, p_name, alter_time, alter_bstate, alter_estate, alter_type,alter_content);
			}
			if(u.getAlter_id().equals(alter.getAlter_id())){
				return u;
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}
	}
	public List<Alter> queryAllAlter(){
		String sql = "select * from staffalter";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Alter u = null;
			List<Alter> Alters = new ArrayList<Alter>();
			while(rs.next()){
				Integer alter_id = rs.getInt("alter_id");
				Integer p_id = rs.getInt("p_id");
				String p_name = rs.getString("p_name");
				String alter_time = rs.getString("alter_time");
				String alter_bstate = rs.getString("alter_bstate");
				String alter_estate = rs.getString("alter_estate");
				String alter_type = rs.getString("alter_type");
				String alter_content = rs.getString("alter_content");
				u = new Alter(alter_id, p_id, p_name, alter_time, alter_bstate, alter_estate, alter_type, alter_content);
				Alters.add(u);
			}
			return Alters;
		} catch (SQLException e) {
			

			
			e.printStackTrace();
			return null;
		}
	}
	public boolean deleteAlter(Integer alter_id){
		String sql = "delete from staffalter where alter_id = ?";
		Object[] params = {
				alter_id
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
	public Alter queryAlter(Integer alter_id){
		
		String sql = "select * from staffalter where alter_id = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, alter_id);
			ResultSet rs = ps.executeQuery();
			Alter u = null;
			if(rs.next()){
				Integer alter_id1 = rs.getInt("alter_id");
				Integer p_id = rs.getInt("p_id");
				String p_name = rs.getString("p_name");
				String alter_time = rs.getString("alter_time");
				String alter_bstate = rs.getString("alter_bstate");
				String alter_estate = rs.getString("alter_estate");
				String alter_type = rs.getString("alter_type");
				String alter_content = rs.getString("alter_content");
				u = new Alter(alter_id1, p_id, p_name, alter_time, alter_bstate, alter_estate, alter_type, alter_content);;
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean updateAlter(Alter alter){
		try{
		String sql = "update staffalter set p_id = ?,p_name = ?,alter_time = ?,alter_bstate = ?,alter_estate = ? ,alter_type = ?,alter_content = ?where  alter_id = ?";
		Object[] params = {
				
				alter.getP_id(),
				alter.getP_name(),
				alter.getAlter_time(),
				alter.getAlter_bstate(),
				alter.getAlter_estate(),
				alter.getAlter_type(),
				alter.getAlter_content(),
				alter.getAlter_id()
		};
		return ConnectionUtil.executeUpdate(sql, params);
		}catch(Exception e){

			
			
			e.printStackTrace();
			
		}
		return false;
	}
	public List<Alter> queryOneAlter(int id) {
		String sql = "select * from staffalter where p_id = "+ id +"";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Alter u = null;
			List<Alter> Alters = new ArrayList<Alter>();
			while(rs.next()){
				Integer alter_id = rs.getInt("alter_id");
				Integer p_id = rs.getInt("p_id");
				String p_name = rs.getString("p_name");
				String alter_time = rs.getString("alter_time");
				String alter_bstate = rs.getString("alter_bstate");
				String alter_estate = rs.getString("alter_estate");
				String alter_type = rs.getString("alter_type");
				String alter_content = rs.getString("alter_content");
				u = new Alter(alter_id, p_id, p_name, alter_time, alter_bstate, alter_estate, alter_type, alter_content);
				Alters.add(u);
			}
			return Alters;
		} catch (SQLException e) {
			

			
			e.printStackTrace();
			return null;
		}
	}
	
}
