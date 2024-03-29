package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.Agreement;
import com.mitsui.domain.File;
import com.mitsui.service.AgreementService;

public class AgreementRegisterServlet extends HttpServlet {
	public static int error_type=0;
	private AgreementService agreementService = new AgreementService();
	/**
	 * Constructor of the object.
	 */
	public AgreementRegisterServlet() {
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
		String agreement_btime = request.getParameter("agreement_btime");
		String agreement_etime = request.getParameter("agreement_etime");
		String position = request.getParameter("position");
		String agreement_content = request.getParameter("agreement_content");
		Agreement agreement = new Agreement(null, p_id, agreement_btime, agreement_etime, position, agreement_content);
		boolean flag = agreementService.addAgreement(agreement);
		
		if(
				agreement_btime.equals("")||
				agreement_etime.equals("")||
				position.equals("")||
				agreement_content.equals("")
			)
		{
			//1表示字符串为空
			error_type=1;
		}
		
		
		if(flag&&error_type!=1){
			request.getRequestDispatcher("/servlet/AgreementQueryAllServlet").forward(request, response);
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
