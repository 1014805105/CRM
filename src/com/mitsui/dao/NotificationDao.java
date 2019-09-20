package com.mitsui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mitsui.domain.Notification;
import com.mitsui.util.ConnectionUtil;

public class NotificationDao {
	public boolean addNotification(Notification notification){
		String sql = "insert into notification(notification_id,notification_content) values(?,?)";
		Object[] params = {
				notification.getNotification_id(),				
				notification.getNotification_content(),
				
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
	public List<Notification> queryAllNotification(){
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
			return notifications;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean deleteNotification(Integer notification_id){
		String sql = "delete from notification where notification_id = ?";
		Object[] params = {
				notification_id
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}
	public Notification queryNotification(Integer notification_id){
		String sql = "select * from notification where notification_id = ?";
		Connection conn = ConnectionUtil.getConection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, notification_id);
			ResultSet rs = ps.executeQuery();
			Notification u = null;
			if(rs.next()){
				
				String notification_content = rs.getString("notification_content");
				u = new Notification(notification_id, notification_content);
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean updateNotification(Notification notification){
		String sql = "update notification set notification_content = ?where notification_id = ?";
		Object[] params = {		
				
				notification.getNotification_content(),
				notification.getNotification_id(),
				
		};
		return ConnectionUtil.executeUpdate(sql, params);
	}

}

