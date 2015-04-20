package com.spaneos.vemas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spaneos.vemas.pojo.Billes;
import com.spaneos.vemas.pojo.User;
import com.spaneos.vemas.pojo.VendorType;
import com.spaneos.vemas.service.VendorServiceImp;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VendorServiceImp vendorServiceImp = VendorServiceImp.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.endsWith("a_type_a")) {
			List<VendorType> list3 = vendorServiceImp.getAllVendorTypes();
			System.out.println(list3);
			req.setAttribute("tlist", list3);
			req.getRequestDispatcher("../../addvendor.jsp").forward(req, resp);

		} else if (uri.endsWith("typevendor")) {
			req.getRequestDispatcher("../../addvendortype.jsp").forward(req,
					resp);

		} else if (uri.endsWith("v_search")) {
			req.getRequestDispatcher("../../search.jsp").forward(req, resp);
		} else if (uri.endsWith("signup")) {
			req.getRequestDispatcher("signup.jsp").forward(req, resp);

		} else if (uri.endsWith("reporting")) {

		} else if (uri.endsWith("viewuser")) {
			List<User> users = vendorServiceImp.getAllUsers();
			ServletContext context = req.getServletContext();

			context.setAttribute("userslist", users);
			resp.sendRedirect("../../viewUser.jsp");

		} else if (uri.endsWith("billesview")) {
			List<Billes> billes = vendorServiceImp.getAllBilles();

			ServletContext context = req.getServletContext();

			context.setAttribute("billeslist", billes);
			resp.sendRedirect("../../viewbilles.jsp");
		} 
		else if (uri.endsWith("landingpage_vendor")) {
			req.getRequestDispatcher("../landingpage.jsp").forward(req, resp);
		}
		else if(uri.endsWith("addBank")){
			req.getRequestDispatcher("../addBank.jsp").forward(req, resp);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
