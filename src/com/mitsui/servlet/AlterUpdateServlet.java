package com.mitsui.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.Alter;
import com.mitsui.service.AlterService;

public class AlterUpdateServlet extends HttpServlet {

	
	private AlterService userService = new AlterService();
	/**
	 * Constructor of the object.
	 */
	public AlterUpdateServlet() {
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

		String alter_id = request.getParameter("alter_id");
		Alter user  = userService.queryAlter(Integer.valueOf(alter_id));
		request.setAttribute("user", user);
		request.getRequestDispatcher("/view/files/alterupdate.jsp").forward(request, response);
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
		Integer alter_id=Integer.valueOf(request.getParameter("alter_id"));
		Integer p_id = Integer.valueOf(request.getParameter("p_id"));
		String p_name = request.getParameter("p_name");
		String alter_time = request.getParameter("alter_time");
		String alter_bstate = request.getParameter("alter_bstate");
		String alter_estate = request.getParameter("alter_estate");
		String alter_type = request.getParameter("alter_type");
		String alter_content = request.getParameter("alter_content");
		Alter user = new Alter(alter_id, p_id, p_name, alter_time, alter_bstate, alter_estate, alter_type, alter_content);

		boolean flag = userService.updateAlter(user);
		if(flag){
			
			request.getRequestDispatcher("/AlterQueryAllServlet").forward(request, response);
		}else{
			System.out.println("跳转AlterQueryAllServlet失败");
		}
	}

	public void init() throws ServletException {
		
	}

}
