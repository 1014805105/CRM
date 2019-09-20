package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.StaffCert;
import com.mitsui.domain.TrainGrade;
import com.mitsui.service.TrainGradeService;

public class TrainGradeUpdateServlet extends HttpServlet {
	private TrainGradeService traingradeService=new TrainGradeService();
	/**
	 * Constructor of the object.
	 */
	public TrainGradeUpdateServlet() {
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
		String gradeid = request.getParameter("gradeid");
		System.out.println(gradeid);
		TrainGrade grade=traingradeService.queryTrainGrade(Integer.parseInt(gradeid));
		System.out.println(grade.toString());
		request.setAttribute("grade", grade);
		request.getRequestDispatcher("/view/files/edittraingrade.jsp").forward(request, response);
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
		
		String gradeid = request.getParameter("gradeid");
		String gradess = request.getParameter("grade");
		String getcer = request.getParameter("getcer");
		String subject = request.getParameter("subject");
		String trainid = request.getParameter("trainid");
		String pid = request.getParameter("pid");
		System.out.println("This is Update1");

		TrainGrade grade=new TrainGrade(Integer.parseInt(gradeid), Integer.parseInt(trainid), Integer.parseInt(pid),Integer.parseInt(gradess), subject, getcer);
		System.out.println(grade);
		System.out.println("This is Update2");
		boolean flag=traingradeService.updateTrainGrade(grade);
		List<TrainGrade> grades = traingradeService.queryAllTrainGrade();
		request.setAttribute("grades", grades);
		System.out.println("This is QueryAllTrainRecordServlet");
		System.out.println(grades);
		request.getRequestDispatcher("/view/files/listtraingrade.jsp").forward(request,response);
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
