package com.mitsui.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mitsui.domain.Notification;
import com.mitsui.util.ConnectionUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class NotificationDaoTest {
/**
	@Test
	public void testAddNotification() {
		Notification n =new Notification(15,"sd");
		boolean a = new NotificationDao().addNotification(n);
		assertEquals(true, a);
	}
**/
	@Test
	public void testQueryAllNotification() {
		String sql = "select * from notification";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Notification u = null;
			List<Notification> notifications = new ArrayList<Notification>();
			while(rs.next()){
				int notification_id = rs.getInt("notification_id");
				
				String notification_content = rs.getString("notification_content");
				u = new Notification(notification_id, notification_content);
				notifications.add(u);
				
			}
			assertEquals(true, notifications.toString().equals(new NotificationDao().queryAllNotification().toString()));
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	
	}
/**
	@Test
	public void testDeleteNotification() {
		Notification n =new Notification(12,"sd");
		boolean a = new NotificationDao().deleteNotification(12);
		assertEquals(true, a);
	}
*/
	@Test
	public void testQueryNotification() {
		
		String sql = "select * from notification where notification_id = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 12);
			ResultSet rs = ps.executeQuery();
			Notification u = null;
			if(rs.next()){
				
				String notification_content = rs.getString("notification_content");
				u = new Notification(12, notification_content);
			
				assertEquals(true, u.toString().equals(new NotificationDao().queryNotification(12).toString()));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}

	@Test
	public void testUpdateNotification() {
		
	}

}
