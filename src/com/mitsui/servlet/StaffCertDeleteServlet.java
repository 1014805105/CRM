package com.mitsui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitsui.dao.CertSelectDao;
import com.mitsui.domain.CertSelect;
import com.mitsui.service.StaffCertService;

public class StaffCertDeleteServlet extends HttpServlet {
	private StaffCertService staffcertService=new StaffCertService();

	/**
	 * Constructor of the object.
	 */
	public StaffCertDeleteServlet() {
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

		String cerids = request.getParameter("cerid");
		int cerid =Integer.parseInt(cerids);
		System.out.println(cerid);
		boolean flag = staffcertService.deleteStaffCert(cerid);
		System.out.println("Delete done");
		List<CertSelect> certs = CertSelectDao.queryAllCertSelect();
		request.setAttribute("certs", certs);
		System.out.println("This is QueryAllTrainRecordServlet");
		System.out.println(certs);
		request.getRequestDispatcher("/view/files/listcert.jsp").forward(request,response);
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
