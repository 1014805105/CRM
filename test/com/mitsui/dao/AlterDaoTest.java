package com.mitsui.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mitsui.domain.Alter;
import com.mitsui.util.ConnectionUtil;

public class AlterDaoTest {

	@Test
	public void testAddAlter() {
		Alter a=new Alter(102, 4, "4", "4", "4", "4", "4", "4");
		boolean rs=new AlterDao().addAlter(a);
		assertEquals(true, rs);
				
	}


	@Test
	public void testQueryAlterAlter() {
		Alter a=new Alter(4, 4, "4", "4", "4", "4", "4", "4");
		String sql = "select * from staffalter where alter_id = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 4);
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
			//System.out.println(u);
			//System.out.println(new AlterDao().queryAlter(a));
				if(u.equals(new AlterDao().queryAlter(a)))
					System.out.println("1");
				//assertEquals(u, new AlterDao().queryAlter(a));
			
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		}
	}

	@Test
	public void testQueryAllAlter() {
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
			assertEquals(true,Alters.toString().equals( new AlterDao().queryAllAlter().toString()));
		
			
		} catch (SQLException e) {
			

			
			e.printStackTrace();
			
		}
	}

	@Test
	public void testDeleteAlter() {
		boolean rs =new AlterDao().deleteAlter(9);
		assertEquals(true, rs);
	
	}

//	@Test
//	public void testQueryAlterInteger() {
		
//	}

	//@Test
//	public void testUpdateAlter() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testQueryOneAlter() {
//		fail("Not yet implemented");
//	}
//
}
