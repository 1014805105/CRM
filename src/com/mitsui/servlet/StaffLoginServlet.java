package com.mitsui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.Admin;
import com.mitsui.domain.Staff;
import com.mitsui.service.AdminService;
import com.mitsui.service.StaffService;

public class StaffLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public StaffLoginServlet() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"  "+password);
		if("".equals(username))
		{
			System.out.println("usernameweishuru");
		}
		String role = request.getParameter("role");
		if (role.equals("administrator")) {
			Admin admin = new Admin();
			admin.setAdmin_username(username);
			admin.setAdmin_password(password);
			Admin u = AdminService.queryAdmin(admin);
			if (u != null) {
				request.getRequestDispatcher("./view/index.html").forward(request, response);
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} else {
			Staff staff = new Staff();
			staff.setUser_name(username);
			staff.setUser_password(password);
			Staff u = StaffService.queryStaff(staff);
			if (u != null) {
				request.getRequestDispatcher("./view/index1.html").forward(request, response);
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
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
