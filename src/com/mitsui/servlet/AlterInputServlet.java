package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.Alter;
import com.mitsui.service.AlterService;

public class AlterInputServlet extends HttpServlet {

	public static int error_type=0;
	private AlterService userService = new AlterService();
	/**
	 * Constructor of the object.
	 */
	public AlterInputServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		String t=request.getParameter("p_id");
		try{
		Integer p_id = Integer.valueOf(t);


		
		String p_name = request.getParameter("p_name");
		String alter_time = request.getParameter("alter_time");
		String alter_bstate = request.getParameter("alter_bstate");
		String alter_estate = request.getParameter("alter_estate");
		String alter_type = request.getParameter("alter_type");
		String alter_content = request.getParameter("alter_content");
		Alter user = new Alter(null, p_id, p_name, alter_time, alter_bstate, alter_estate, alter_type, alter_content);
		boolean flag = userService.addUser(user);
		

		
		if(
			p_name.equals("")||
			alter_time.equals("")||
			alter_bstate.equals("")||
			alter_estate.equals("")||
			alter_type.equals("")||
			alter_content.equals("")
			
		){
			//1表示字符串为空
			error_type=1;
		}
		
		if(flag&&error_type!=1){
			//System.out.println("flag"+flag);
			
			//System.out.println("error_type"+error_type);
			request.getRequestDispatcher("view/files/mainfra.html").forward(request, response);
			
		}else{
			
			if
			(error_type==1){
			request.setAttribute("error","输入的内容不能为空！" );
			error_type=0;
			request.getRequestDispatcher("view/files/exception.jsp").forward(request, response);
			
			}
			
			//request.getRequestDispatcher("/HR/view/files/exception.jsp").forward(request, response);
		}
		}catch(Exception e){
			request.setAttribute("error","输入的内容不能为空！" );
			request.getRequestDispatcher("view/files/exception.jsp").forward(request, response);
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
