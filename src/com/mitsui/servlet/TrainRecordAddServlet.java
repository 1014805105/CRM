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


public class TrainRecordAddServlet extends HttpServlet {
	private TrainRecordService trainrecordService=new TrainRecordService();

	/**
	 * Constructor of the object.
	 */
	public TrainRecordAddServlet() {
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

//		System.out.println("XD");
		request.setCharacterEncoding("utf-8");
		String train_name = request.getParameter("train_name");
		String type_code = request.getParameter("type_code");
		String train_btime = request.getParameter("train_btime");
		String train_etime = request.getParameter("train_etime");
		String train_location = request.getParameter("train_location");
		String train_expense = request.getParameter("train_expense");
		String train_host = request.getParameter("train_host");
		String train_master = request.getParameter("train_master");
		TrainRecord record=new TrainRecord(null, train_name, type_code, train_btime, train_etime,
				train_expense, train_location, train_host, train_master);
		System.out.println(record);
		boolean flag = trainrecordService.addTrainRecord(record);
		System.out.println("0.0");
		List<TrainRecord> records = trainrecordService.queryAllTrainRecord();
		request.setAttribute("records", records);
		System.out.println("This is QueryAllTrainRecordServlet");
		request.getRequestDispatcher("/view/files/listtrainrecord.jsp").forward(request,response);
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
