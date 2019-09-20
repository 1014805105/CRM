package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.TrainRecord;
import com.mitsui.domain.TrainType;
import com.mitsui.service.TrainRecordService;
import com.mitsui.service.TrainTypeService;

public class TrainTypeDeleteServlet extends HttpServlet {
	private TrainTypeService traintypeService=new TrainTypeService();

	/**
	 * Constructor of the object.
	 */
	public TrainTypeDeleteServlet() {
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
		String typecode = request.getParameter("typecode");
		System.out.println(typecode);
		boolean flag = traintypeService.deleteTrainType(typecode);
		System.out.println("Delete done");
		List<TrainType> types = traintypeService.queryAllTrainType();
		request.setAttribute("types", types);
		if(flag){
			request.getRequestDispatcher("/view/files/listtraintype.jsp").forward(request, response);
		}

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
