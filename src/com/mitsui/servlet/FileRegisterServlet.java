package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.File;
import com.mitsui.service.AlterService;
import com.mitsui.service.FileService;

public class FileRegisterServlet extends HttpServlet {
	private FileService fileService = new FileService();
	public static int error_type=0;

	/**
	 * Constructor of the object.
	 */
	public FileRegisterServlet() {
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
		Integer p_id = Integer.valueOf(request.getParameter("p_id"));
		String file_name = request.getParameter("file_name");
		String file_abstract = request.getParameter("file_abstract");
		String reward_note = request.getParameter("reward_note");
		String experience = request.getParameter("experience");
		File file = new File(null, p_id, file_name, file_abstract, reward_note, experience);
		boolean flag = fileService.addFile(file);
		
		if(file_name.equals("")||
				file_abstract.equals("")||
				reward_note.equals("")||
				experience.equals(""))
		{
			//1表示字符串为空
			error_type=1;
		}
		
		
		if(flag&&error_type!=1){
			request.getRequestDispatcher("/servlet/FileQueryAllServlet").forward(request, response);
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
