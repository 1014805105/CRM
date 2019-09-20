package com.mitsui.domain;

public class Notification {

	 private Integer notification_id;
	 private String notification_content;
	 
	 public Integer getNotification_id() {
			return notification_id;
		}
		public void setNotification_id(Integer notificationId) {
			this.notification_id = notificationId;
		}
								
	public String getNotification_content() {
		return notification_content;
	}
	public void setNotification_content(String notificationContent) {
		this.notification_content = notificationContent;
	}
	
	@Override

	public String toString() {
		return "Notification [notification_content="+ notification_content + "]";
	}
	public Notification( Integer notificationId,String notificationContent) {
		super();
		this.notification_id = notificationId;
		this.notification_content = notificationContent;
	}
}


