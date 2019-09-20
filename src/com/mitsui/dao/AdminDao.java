package com.mitsui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mitsui.domain.Admin;
import com.mitsui.util.ConnectionUtil;

public class AdminDao {
	public Admin queryAdmin(Admin Admin){
		String sql = "select * from administrator where admin_username = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, Admin.getAdmin_username());
			ResultSet rs = ps.executeQuery();
			Admin u = null;
			
			if(rs.next()){
				
				Integer admin_id = rs.getInt("admin_id");
				String admin_username = rs.getString("admin_username");
				String admin_password = rs.getString("admin_password");
				
				u=new Admin(admin_id,admin_username,admin_password);
				
			}
			if(u.getAdmin_password().equals(Admin.getAdmin_password())){
				System.out.println("用户密码校验通过");
				return u;
				
			}else{
				
				System.out.println("用户密码校验未通过");
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return null;
			
		}
	}
}
