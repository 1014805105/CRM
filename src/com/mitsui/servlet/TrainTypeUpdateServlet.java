package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.TrainType;
import com.mitsui.service.TrainTypeService;

public class TrainTypeUpdateServlet extends HttpServlet {

	private TrainTypeService traintypeService=new TrainTypeService();
	/**
	 * Constructor of the object.
	 */
	public TrainTypeUpdateServlet() {
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
		System.err.println("XD");
		String typecode = request.getParameter("typecode");
		System.out.println(typecode);
		TrainType type=traintypeService.queryTrainType(typecode.toString());
		System.out.println(type.toString());
		request.setAttribute("type", type);
		
		
		request.getRequestDispatcher("/view/files/edittraintype.jsp").forward(request, response);
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
//		System.out.println("yes?");
		request.setCharacterEncoding("utf-8");
		String typecode = request.getParameter("typecode");
		String typename = request.getParameter("typename");
		String typeinfo = request.getParameter("typeinfo");
		System.out.println("yes?");
		TrainType type=new TrainType(typecode, typename, typeinfo);
		System.out.println(type);
		boolean flag=traintypeService.updateTrainType(type);
		System.out.println("databasedone");		
		List<TrainType> types = traintypeService.queryAllTrainType();
		request.setAttribute("types", types);
		if(flag){
			request.getRequestDispatcher("/view/files/listtraintype.jsp").forward(request, response);
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
