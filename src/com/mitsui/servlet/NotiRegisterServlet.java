package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.File;
import com.mitsui.domain.Notification;
import com.mitsui.service.NotiService;

public class NotiRegisterServlet extends HttpServlet {
	public static int error_type=0;
	private NotiService notificationService = new NotiService();
	/**
	 * Constructor of the object.
	 */
	public NotiRegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		try{					
		String notification_content = request.getParameter("notification_content");
		Notification notification = new Notification(null, notification_content);
		boolean flag = notificationService.addNotification(notification);
		
		if(
				
				notification_content.equals("")
			)
		{
			//1表示字符串为空
			error_type=1;
		}
		
		
		if(flag&&error_type!=1){
			request.getRequestDispatcher("/servlet/NotificationQueryAllServlet").forward(request, response);
		}else{
			if
			(error_type==1){
			request.setAttribute("error","输入的内容不能为空！" );
			error_type=0;
			request.getRequestDispatcher("/exception.jsp").forward(request, response);
			
			}
		}
		}catch(Exception e){
			request.setAttribute("error","您输入的数据存在为空的现象或者输入的员工编号在数据库中不存在！" );
			request.getRequestDispatcher("/exception.jsp").forward(request, response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

 


