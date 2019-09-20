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

public class TrainRecordUpdateServlet extends HttpServlet {
	private TrainRecordService trainrecordService =new TrainRecordService();
	/**
	 * Constructor of the object.
	 */
	public TrainRecordUpdateServlet() {
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
		String trainid = request.getParameter("trainid");
		System.out.println(trainid);
		TrainRecord record=trainrecordService.queryTrainRecord(Integer.parseInt(trainid));
		System.out.println(record.toString());
		request.setAttribute("record", record);
		
		
		request.getRequestDispatcher("/view/files/edittrainrecord.jsp").forward(request, response);
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
		String train_id = request.getParameter("train_id");
		String train_name = request.getParameter("train_name");
		String type_code = request.getParameter("type_code");
		String train_btime = request.getParameter("train_btime");
		String train_etime = request.getParameter("train_etime");
		String train_location = request.getParameter("train_location");
		String train_expense = request.getParameter("train_expense");
		String train_host = request.getParameter("train_host");
		String train_master = request.getParameter("train_master");
		TrainRecord record=new TrainRecord(Integer.parseInt(train_id), train_name, type_code, train_btime, train_etime,
				train_expense, train_location, train_host, train_master);
		System.out.println(record);
		boolean flag=trainrecordService.updateTrainRecord(record);
//		System.out.println("databasedone");		
		List<TrainRecord> records = trainrecordService.queryAllTrainRecord();
		request.setAttribute("records", records);
		if(flag){
			System.out.println(records);
			request.getRequestDispatcher("/view/files/listtrainrecord.jsp").forward(request, response);
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
