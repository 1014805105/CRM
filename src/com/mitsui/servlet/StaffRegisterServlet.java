package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.Staff;
import com.mitsui.service.StaffService;

public class StaffRegisterServlet extends HttpServlet {
	private StaffService staffService = new StaffService();
	/**
	 * Constructor of the object.
	 */
	public StaffRegisterServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkpassword = request.getParameter("checkpassword");
		// String sex=null;
		Staff s = new Staff(null, null, null, null, null, null, null, username,
				password);
		if (username.equals("") || password.equals("")||checkpassword.equals("")) {
		String message = "不能有空";
		request.setAttribute("mes", message);
		request.getRequestDispatcher("../view/files/prompt.jsp").forward(
				request, response);
		} 
		else{			
		if (!(password.equals(checkpassword))) {
			String mes = "两次输入的密码不同，请重新输入!";
			request.setAttribute("mes", mes);
			request.getRequestDispatcher("../view/files/prompt.jsp").forward(
					request, response);
		}
		 else {
				boolean t = StaffService.addStaff(s);
				if (t == true) {
					System.out.println("注册成功");
					request.getRequestDispatcher("../index.jsp").forward(request,
							response);
		}
		 }
//		if (username.equals(null) || password.equals(null)
//				|| checkpassword.equals(null)) {
//			String message = "不能有空";
//			request.setAttribute("mes", message);
//			request.getRequestDispatcher("../view/files/prompt.html").forward(
//					request, response);
//		} else {
//			boolean t = StaffService.addStaff(s);
//			if (t == true) {
//				System.out.println("注册成功");
//				request.getRequestDispatcher("../index.jsp").forward(request,
//						response);
//			} else {
//				request.getRequestDispatcher("../view/files/register.html")
//						.forward(request, response);
//			}
//		}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
