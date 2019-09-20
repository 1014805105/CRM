package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.File;
import com.mitsui.service.FileService;


public class FileUpdateServlet extends HttpServlet {
	
	private FileService fileService = new FileService();
	/**
	 * Constructor of the object.
	 */
	public FileUpdateServlet() {
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

		String file_id = request.getParameter("file_id");
		File file  = fileService.queryFile(Integer.parseInt(file_id));
		request.setAttribute("file", file);
		request.getRequestDispatcher("/view/files/fileupdate.jsp").forward(request, response);
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
		String file_id = request.getParameter("file_id");
		String p_id = request.getParameter("p_id");
		String file_name = request.getParameter("file_name");
		String file_abstract = request.getParameter("file_abstract");
		String reward_note = request.getParameter("reward_note");
		String experience = request.getParameter("experience");
		File file = new File(Integer.parseInt(file_id),Integer.parseInt(p_id), file_name, file_abstract, reward_note, experience);
		boolean flag = fileService.updateFile(file);
		if(flag){
			request.getRequestDispatcher("/servlet/FileQueryAllServlet").forward(request, response);
			
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
