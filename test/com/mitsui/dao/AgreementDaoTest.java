package com.mitsui.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mitsui.domain.Agreement;
import com.mitsui.util.ConnectionUtil;

public class AgreementDaoTest {
	
	@Test
	
	public void testaddAgreement() {
		Agreement a =new Agreement(133,5,"56","56","45","45");
		boolean result = new AgreementDao().addAgreement(a);
		assertEquals(true, result);

	}
	public void testqueryAllAgreement() {
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
				assertEquals(agreements,new AgreementDao().queryAllAgreement());
				assertEquals(false ,new Agreement(null, null, null, null, null, null).equals(new AgreementDao().queryAllAgreement()));
			//判定覆盖率100%
			}
		

			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
}
	
	public void testdeleteAgreement() {
		boolean rs = new AgreementDao().deleteAgreement(4);
		assertEquals(true,rs);
		
	}
	
	public void testqueryAgreement() {
		Agreement srs =new AgreementDao().queryAgreement(5);
		String sql = "select * from staffagreement where agreement_id = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ResultSet rs = ps.executeQuery();
			Agreement u = null;
			if(rs.next()){
				int p_id = rs.getInt("p_id");
				String agreement_btime = rs.getString("agreement_btime");
				String agreement_etime = rs.getString("agreement_etime");
				String position = rs.getString("position");
				String agreement_content = rs.getString("agreement_content");
				u = new Agreement(1, p_id, agreement_btime, agreement_etime, position, agreement_content);
			}
			assertEquals(u,srs);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public void testupdateAgreement() {
		Agreement a =new Agreement(11,5,"56","56","45","45");
		boolean rs=new AgreementDao().updateAgreement(a);
		assertEquals(true,rs);
		
	}
	public void testqueryOneAgreement() {
			String sql = "select * from staffagreement where P_id = "+ 4 +"";
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
					new AgreementDao();
					assertEquals(agreements,AgreementDao.queryOneAgreement(4));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
	}


