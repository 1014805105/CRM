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
import com.mitsui.domain.StaffCert;
import com.mitsui.domain.TrainRecord;
import com.mitsui.service.StaffCertService;

public class StaffCertUpdateServlet extends HttpServlet {
	private StaffCertService staffcertService=new StaffCertService();
	/**
	 * Constructor of the object.
	 */
	public StaffCertUpdateServlet() {
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
		String cerid = request.getParameter("cerid");
		System.out.println(cerid);
		StaffCert cer=staffcertService.queryStaffCert(Integer.parseInt(cerid));
		System.out.println(cer.toString());
		request.setAttribute("cer", cer);
		request.getRequestDispatcher("/view/files/editcert.jsp").forward(request, response);

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
		String cerid = request.getParameter("cerid");
		String cername = request.getParameter("cername");
		String gradeid = request.getParameter("gradeid");
		String cerdate = request.getParameter("cerdate");
        
		StaffCert cert=new StaffCert(Integer.parseInt(cerid), Integer.parseInt(gradeid), cername, cerdate);
		System.out.println(cert);
		System.out.println("This is Update");
		boolean flag=staffcertService.updateStaffCert(cert);
		
		
		
		
		
		List<CertSelect> certs = CertSelectDao.queryAllCertSelect();
		request.setAttribute("certs", certs);
		System.out.println("This is QueryAllTrainRecordServlet");
		System.out.println(certs);
		request.getRequestDispatcher("/view/files/listcert.jsp").forward(request,response);
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
