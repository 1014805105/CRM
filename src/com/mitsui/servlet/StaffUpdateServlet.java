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


public class StaffUpdateServlet extends HttpServlet {
	
	private StaffService staffService = new StaffService();
	/**
	 * Constructor of the object.
	 */
	public StaffUpdateServlet() {
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

		String p_id = request.getParameter("p_id");
		Staff staff  = staffService.queryStaff(Integer.parseInt(p_id));
		request.setAttribute("staff", staff);
		request.getRequestDispatcher("/view/files/staffupdate.jsp").forward(request, response);
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
		String p_id = request.getParameter("p_id");
		String p_name = request.getParameter("p_name");
		String sex = request.getParameter("sex");
		String degree = request.getParameter("degree");
		String department = request.getParameter("department");
		String position = request.getParameter("position");
		String state = request.getParameter("state");
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		Staff staff = new Staff(Integer.parseInt(p_id), p_name, sex, degree, department, position, state, user_name,user_password);
		boolean flag = staffService.updateStaff(staff);
		if(flag){
			request.getRequestDispatcher("/servlet/StaffQueryAllServlet").forward(request, response);
			
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
