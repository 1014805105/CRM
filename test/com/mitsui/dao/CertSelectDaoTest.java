package com.mitsui.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mitsui.domain.CertSelect;
import com.mitsui.util.ConnectionUtil;

public class CertSelectDaoTest {

	@Test
	public void testQueryAllCertSelect() {
		String sql = "select cer_id,traingrade.grade_id,cer_name,staff.p_id,p_name,cer_date from staffcert, traingrade,staff where staffcert.grade_id=traingrade.grade_id and traingrade.p_id=Staff.p_id";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			CertSelect select = null;
			List<CertSelect> certSelects = new ArrayList<CertSelect>();
			while(rs.next()){
				int cer_id = rs.getInt("cer_id");
				int grade_id = rs.getInt("grade_id");
				String cer_name = rs.getString("cer_name");
				String cer_date = rs.getString("cer_date");
				int p_id =rs.getInt("p_id");
				String p_name =rs.getString("p_name");

				select = new CertSelect(cer_id, grade_id, cer_name, cer_date, p_id, p_name);
				certSelects.add(select);
				new CertSelectDao();
				assertEquals(true,certSelects.toString().equals( CertSelectDao.queryAllCertSelect().toString()));
			
			}
			
		
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	}


