package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.File;
import com.mitsui.service.FileService;

public class FileQueryAllServlet1 extends HttpServlet {
	private FileService fileService = new FileService();
	/**
	 * Constructor of the object.
	 */
	public FileQueryAllServlet1() {
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

		request.setCharacterEncoding("UTF-8");
		String lang = request.getParameter("lang");
		Integer a = null;
	     try {
	    	     a = Integer.parseInt(lang);
	    	      } catch (NumberFormatException e) {
	    	          e.printStackTrace();
	    	       }
		List<File> Files = new ArrayList<File>() ;
		if(lang!=null&&lang!="") {
			Files = fileService.queryOneFile(a);
		}else {
			 Files = fileService.queryAllFile();
			}
		request.setAttribute("files", Files);
		request.getRequestDispatcher("/view/files/filequery1.jsp").forward(request,response);
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
