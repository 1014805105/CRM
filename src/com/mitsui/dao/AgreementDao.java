package com.mitsui.dao;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mitsui.domain.Agreement;
import com.mitsui.util.ConnectionUtil;

public class AgreementDao {
	public boolean addAgreement(Agreement agreement){
		try {
			
		
		String sql = "insert into staffagreement(agreement_id,p_id,agreement_btime,agreement_etime,position,agreement_content) values(?,?,?,?,?,?)";
		Object[] params = {
				agreement.getAgreement_id(),
				agreement.getP_id(),
				agreement.getAgreement_btime(),
				agreement.getAgreement_etime(),
				agreement.getPosition(),
				agreement.getAgreement_content(),
				
		};
	
		
		return ConnectionUtil.executeUpdate(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("性别过长");
			return false;
		}
	}
	public List<Agreement> queryAllAgreement(){
		String sql = "select * from staffagreement";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			 Agreement u = null;
			List<Agreement> agreements = new ArrayList<Agreement>();
			while(rs.next()){
				int agreement_id = rs.getInt("agreement_id");
				int p_id = rs.getInt("p_id");
				String agreement_btime = rs.getString("agreement_btime");
				String agreement_etime= rs.getString("agreement_etime");
				String position = rs.getString("position");
				String agreement_content = rs.getString("agreement_content");
				u = new Agreement(agreement_id, p_id, agreement_btime, agreement_etime, position, agreement_content);
				agreements.add(u);
			}
			return agreements;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean deleteAgreement(Integer agreement_id){
		String sql = "delete from staffagreement where agreement_id = ?";
		Object[] params = {
				agreement_id
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
	public Agreement queryAgreement(Integer agreement_id){
		String sql = "select * from staffagreement where agreement_id = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, agreement_id);
			ResultSet rs = ps.executeQuery();
			Agreement u = null;
			if(rs.next()){
				int p_id = rs.getInt("p_id");
				String agreement_btime = rs.getString("agreement_btime");
				String agreement_etime = rs.getString("agreement_etime");
				String position = rs.getString("position");
				String agreement_content = rs.getString("agreement_content");
				u = new Agreement(agreement_id, p_id, agreement_btime, agreement_etime, position, agreement_content);
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean updateAgreement(Agreement agreement){
		String sql = "update staffagreement set p_id = ?,agreement_btime = ?,agreement_etime = ?,position = ?,agreement_content = ?where agreement_id = ?";
		Object[] params = {		
				agreement.getP_id(),
				agreement.getAgreement_btime(),
				agreement.getAgreement_etime(),
				agreement.getPosition(),
				agreement.getAgreement_content(),
				agreement.getAgreement_id(),
				
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
	public static List<Agreement> queryOneAgreement(int id) {
		String sql = "select * from staffagreement where P_id = "+ id +"";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			 Agreement u = null;
			List<Agreement> agreements = new ArrayList<Agreement>();
			while(rs.next()){
				int agreement_id = rs.getInt("agreement_id");
				int p_id = rs.getInt("p_id");
				String agreement_btime = rs.getString("agreement_btime");
				String agreement_etime= rs.getString("agreement_etime");
				String position = rs.getString("position");
				String agreement_content = rs.getString("agreement_content");
				u = new Agreement(agreement_id, p_id, agreement_btime, agreement_etime, position, agreement_content);
				agreements.add(u);
			}
			return agreements;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
