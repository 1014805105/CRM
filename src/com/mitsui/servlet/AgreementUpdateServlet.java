package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.domain.Agreement;
import com.mitsui.service.AgreementService;


public class AgreementUpdateServlet extends HttpServlet {
	
	private AgreementService agreementService = new AgreementService();
	/**
	 * Constructor of the object.
	 */
	public AgreementUpdateServlet() {
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

		String agreement_id = request.getParameter("agreement_id");
		Agreement agreement  = agreementService.queryAgreement(Integer.parseInt(agreement_id));
		request.setAttribute("agreement", agreement);
		request.getRequestDispatcher("/view/files/agreementupdate.jsp").forward(request, response);
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
		String agreement_id = request.getParameter("agreement_id");
		String p_id = request.getParameter("p_id");
		String agreement_btime = request.getParameter("agreement_btime");
		String agreement_etime = request.getParameter("agreement_etime");
		String position = request.getParameter("position");
		String agreement_content = request.getParameter("agreement_content");
		Agreement agreement = new Agreement(Integer.parseInt(agreement_id),Integer.parseInt(p_id), agreement_btime, agreement_etime, position, agreement_content);
		boolean flag = agreementService.updateAgreement(agreement);
		if(flag){
			request.getRequestDispatcher("/servlet/AgreementQueryAllServlet").forward(request, response);
			
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
