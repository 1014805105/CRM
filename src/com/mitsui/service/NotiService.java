package com.mitsui.service;

import java.util.List;

import com.mitsui.dao.NotificationDao;
import com.mitsui.domain.Notification;

public class NotiService {
static	private NotificationDao notificationDao = new NotificationDao();
	
	public boolean addNotification(Notification notification){
		try{
			notificationDao.addNotification(notification);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public  List<Notification> queryAllNotification(){
		try{
			List<Notification> Notifications = notificationDao.queryAllNotification();
			return Notifications;
		}catch (Exception e) {
			return null;
		}
	}
	public boolean deleteNotification(Integer notification_id){
		try{
			notificationDao.deleteNotification(notification_id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	public Notification queryNotification(Integer id){
		try{
			Notification u = notificationDao.queryNotification(id);
			return u;
		}catch (Exception e) {
			return null;
		}
	}
	public boolean updateNotification(Notification Notification){
		try{
			return notificationDao.updateNotification(Notification);
		}catch (Exception e) {
			return false;
		}
	}


}
