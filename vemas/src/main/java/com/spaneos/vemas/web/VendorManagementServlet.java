package com.spaneos.vemas.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.ws.spi.http.HttpContext;

import com.spaneos.vemas.dao.VendorDAOImp;
import com.spaneos.vemas.pojo.Bank;
import com.spaneos.vemas.pojo.Billes;
import com.spaneos.vemas.pojo.Contact;
import com.spaneos.vemas.pojo.User;
import com.spaneos.vemas.pojo.Vendor;
import com.spaneos.vemas.pojo.VendorType;
import com.spaneos.vemas.service.VendorServiceImp;
import com.spaneos.vemas.service.VendorServiceInf;

/**
 * Servlet implementation class VendorManagementServlet
 */
@WebServlet("*.user")
public class VendorManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VendorServiceImp vendorServiceImp = VendorServiceImp.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Request......");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();


 if(uri.endsWith("landingpageOfEmplyee.user")){
			request.getRequestDispatcher("landingpageOfEmplyee.jsp").forward(request, response);
		}
  else if (uri.endsWith("forgotpwd.vms")) {
			String email = request.getParameter("email");
			String seq_question = request.getParameter("seq_question");
			String answer = request.getParameter("answer");

			if (vendorServiceImp.checkCredentials(email, seq_question, answer)) {
				User user = vendorServiceImp.getUserByEmail(email);

				request.setAttribute("email", email);

				request.setAttribute("password", user.getPassword());
				request.setAttribute("incorrectAnswer", false);
				request.getRequestDispatcher("forgotpwdform.jsp").forward(
						request, response);
				;
			} else {
				request.setAttribute("incorrectAnswer", true);
				request.getRequestDispatcher("forgotpwdform.jsp").forward(
						request, response);
				;
			}
		} else if (uri.endsWith("logout.vms")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				session.invalidate();

				response.sendRedirect("loginpage.jsp");
			}
 
 
		
		}  
		

	}

}
