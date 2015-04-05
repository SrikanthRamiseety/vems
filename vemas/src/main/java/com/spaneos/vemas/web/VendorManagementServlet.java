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

import com.spaneos.vemas.pojo.Contact;
import com.spaneos.vemas.pojo.User;
import com.spaneos.vemas.pojo.Vendor;
import com.spaneos.vemas.service.VendorServiceImp;

/**
 * Servlet implementation class VendorManagementServlet
 */
@WebServlet("*.vms")
public class VendorManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VendorServiceImp vendorServiceImp = VendorServiceImp.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.endsWith("login.vms")) {
			if (vendorServiceImp.authenticateUser(
					request.getParameter("email"),
					request.getParameter("password"))) {
				HttpSession session = request.getSession();
				User user = vendorServiceImp.getUserByEmail(request
						.getParameter("email"));

				session.setAttribute("user", user);
				session.setAttribute("loggedIn", true);
				session.setAttribute("incorrectCredentials", false);

				response.sendRedirect("landingpage.jsp");
			} else {
				request.setAttribute("incorrectCredentials", true);
				request.getRequestDispatcher("loginpage.jsp").forward(request,
						response);
				;
			}
		} else if (uri.endsWith("signup.vms")) {
			User user = vendorServiceImp.createUser(
					request.getParameter("firstname"),
					request.getParameter("middlename"),
					request.getParameter("lastname"),
					request.getParameter("email"),
					request.getParameter("password"),
					request.getParameter("selectquestion"),
					request.getParameter("answer"),
					request.getParameter("mobile"));

			if (user == null) {
				response.sendRedirect("error.jsp");
			} else {
				if (vendorServiceImp.addUser(user)) {
					response.sendRedirect("loginpage.jsp");
				} else {
					response.sendRedirect("error.jsp");
				}
			}
		} else if (uri.endsWith("addvendor.vms")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				Vendor vendor = vendorServiceImp.createVendor(
						request.getParameter("vendorType"),
						request.getParameter("vendorCategory"),
						request.getParameter("vendorName"),
						request.getParameter("landlineCode") + "-"
								+ request.getParameter("vendorLandlineNumber"),
						request.getParameter("mobileCode") + "-"
								+ request.getParameter("vendorMobileNumber"),
						request.getParameter("vendorWebsite"),
						request.getParameter("vendorAddress"));

				if (vendor == null) {
					response.sendRedirect("error.jsp");
				}
				session.setAttribute("vendorMobileCode", request.getParameter("mobileCode"));
				session.setAttribute("vendorMobileNumber", request.getParameter("vendorMobileNumber"));
				session.setAttribute("vendorLandlineCode", request.getParameter("landlineCode"));
				session.setAttribute("vendorLandlineNumber", request.getParameter("vendorLandlineNumber"));
				session.setAttribute("vendor", vendor);
			}

			response.sendRedirect("contactmanager.jsp");
		} else if (uri.endsWith("addcontact.vms")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");
				Contact contact = vendorServiceImp.createContact(
						request.getParameter("contactName"),
						request.getParameter("designation"),
						request.getParameter("mobile"),
						request.getParameter("email"),
						request.getParameter("employmentStatus"),
						request.getParameter("manager"));

				if (contact == null) {
					response.sendRedirect("error.jsp");
				}
				if (vendor.getVendorContacts() == null) {
					vendor.setVendorContacts(new ArrayList<Contact>());
					vendor.getVendorContacts().add(contact);
				}

				if (!vendorServiceImp.addContactToVendor(contact,
						vendor.getVendorContacts())) {
					session.setAttribute("duplicateEntry",
							"This Contact already exists");
				}

				/* vendor.getVendorContacts().add(contact); */

				session.setAttribute("vendor", vendor);
				session.setAttribute("editContact", null);
				session.setAttribute("contactList", vendor.getVendorContacts());
			}

			response.sendRedirect("contactmanager.jsp");
		} else if (uri.endsWith("editcontact.vms")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");
				List<Contact> vendorContacts = vendor.getVendorContacts();

				for (Contact contact : vendorContacts) {
					if (contact.getEmail().equalsIgnoreCase(
							request.getParameter("email"))) {
						request.setAttribute("editContact", contact);
					}
				}
			}
			request.getRequestDispatcher("addcontact.jsp").forward(request,
					response);
		} else if (uri.endsWith("updatecontact.vms")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");
				List<Contact> vendorContacts = vendorServiceImp.updateContact(
						request.getParameter("contactName"),
						request.getParameter("designation"),
						request.getParameter("mobile"),
						request.getParameter("email"),
						request.getParameter("employmentStatus"),
						request.getParameter("manager"),
						vendor.getVendorContacts());

				if (vendorContacts == null) {
					response.sendRedirect("error.jsp");
				}
				session.setAttribute("vendor", vendor);
				session.setAttribute("editContact", null);
				session.setAttribute("contactList", vendor.getVendorContacts());
			}
			response.sendRedirect("contactmanager.jsp");
		} else if (uri.endsWith("deletecontacts.vms")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");

				List<Contact> vendorContacts = vendorServiceImp
						.deleteContacts(request.getParameter("ids"),
								vendor.getVendorContacts());

				if (vendorContacts == null) {
					response.sendRedirect("error.jsp");
				}
				session.setAttribute("vendor", vendor);
				session.setAttribute("editContact", null);
				session.setAttribute("contactList", vendor.getVendorContacts());
			}
			request.getRequestDispatcher("viewcontacts.jsp").forward(request,
					response);
		} else if (uri.endsWith("saveall.vms")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");
				
				if (vendorServiceImp.saveAllData(vendor)) {
					request.setAttribute("addedsuccessfully", true);
					request.getRequestDispatcher("addvendor.jsp").forward(
							request, response);
				} else {
					response.sendRedirect("error.jsp");
				}
			}
		} else if (uri.endsWith("savevendor.vms")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");

				if (vendorServiceImp.addVendor(vendor)) {
					request.setAttribute("addedsuccessfully", true);
					request.getRequestDispatcher("addvendor.jsp").forward(
							request, response);
				} else {
					response.sendRedirect("error.jsp");
				}
			}
		} else if (uri.endsWith("search.vms")) {
			int pageNumber = Integer.parseInt(request
					.getParameter("pagenumber"));
			String page = request.getParameter("page");
			String search = request.getParameter("search");
			List<Vendor> vendorList = null;

			if (page.equals("first")) {
				HttpSession session = request.getSession();
				if (search == null || search == "")
					session.setAttribute("vender", null);
				else {
					vendorList = vendorServiceImp
							.getVendorsByVendorname(search);
					/*
					 * if (vendorlist1 == null) vendorlist1 = new
					 * ArrayList<Vendor>();
					 */
					
				}

				session.setAttribute("vender", vendorList);
			}

			request.getRequestDispatcher(
					"searchview.jsp?pagenumber=" + pageNumber).forward(request,
					response);
		} else if (uri.endsWith("forgotpwd.vms")) {
			String email = request.getParameter("email");
			String seq_question = request.getParameter("seq_question");
			String answer = request.getParameter("answer");
			
			if (vendorServiceImp.checkCredentials(email, seq_question, answer)) {
				User user = vendorServiceImp.getUserByEmail(email);
				
				request.setAttribute("email", email);
				
				request.setAttribute("password", user.getPassword());
				request.setAttribute("incorrectAnswer", false);
				request.getRequestDispatcher("forgotpwdform.jsp").forward(request, response);;
			} else {
				request.setAttribute("incorrectAnswer", true);
				request.getRequestDispatcher("forgotpwdform.jsp").forward(request, response);;
			}
		} else if(uri.endsWith("logout.vms")) {
			HttpSession session = request.getSession(false);
			
			if(session != null) {
				session.invalidate();
				
				response.sendRedirect("loginpage.jsp");
			}
		}

	}
}
