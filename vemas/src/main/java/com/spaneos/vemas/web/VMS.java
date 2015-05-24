package com.spaneos.vemas.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spaneos.vemas.pojo.Bank;
import com.spaneos.vemas.pojo.Contact;
import com.spaneos.vemas.pojo.Vendor;
import com.spaneos.vemas.pojo.VendorType;
import com.spaneos.vemas.service.VendorServiceImp;

/**
 * Servlet implementation class VMS
 */
@WebServlet("/j_spring_security_check")
public class VMS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VendorServiceImp vendorServiceImp = VendorServiceImp.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VMS() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletreq req, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		String user=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println(user+","+password);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletreq req, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Request is received");
		doGet(req, resp);
	}

}
