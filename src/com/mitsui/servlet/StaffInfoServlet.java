package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.Staff;
import com.mitsui.service.StaffService;

public class StaffInfoServlet extends HttpServlet {

	public static int error_type=0;
	
	private StaffService staffService = new StaffService();
	/**
	 * Constructor of the object.
	 */
	public StaffInfoServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String p_name = request.getParameter("p_name");
		String sex = request.getParameter("sex");
		String degree = request.getParameter("degree");
		String department = request.getParameter("department");
		String position = request.getParameter("position");
		String state = request.getParameter("state");
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		Staff staff = new Staff(null, p_name, sex, degree, department, position, state, user_name,user_password);
		boolean flag = staffService.addStaff(staff);
		
		
		if(p_name.equals("")||
			sex.equals("")||
			degree.equals("")||
			department.equals("")||
			position.equals("")||
			state.equals("")||
			user_name.equals("")||
			user_password.equals("")
			
		){
			//1表示字符串为空
			error_type=1;
		}
		
		if(flag&&error_type!=1){
			request.getRequestDispatcher("/servlet/StaffQueryAllServlet").forward(request, response);
			
		}else{
			if
			(error_type==1){
			request.setAttribute("error","输入的内容不能为空！" );
			error_type=0;
			request.getRequestDispatcher("/exception.jsp").forward(request, response);
			
			}
			
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
