package com.spaneos.vemas.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spaneos.vemas.pojo.Bank;
import com.spaneos.vemas.pojo.Billes;
import com.spaneos.vemas.pojo.Contact;
import com.spaneos.vemas.pojo.User;
import com.spaneos.vemas.pojo.Vendor;
import com.spaneos.vemas.pojo.VendorType;
import com.spaneos.vemas.service.VendorServiceImp;

/**
 * Servlet implementation class VMS
 */
@WebServlet("*.opt")
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
	 * @see HttpServlet#doGet(HttpServletreq req, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req,
			HttpServletResponse response) throws ServletException, IOException {
		String uri=req.getRequestURI();
		if(uri.endsWith("addvendor.opt")){
			HttpSession session = req.getSession(false);
			System.out.println("coming..");

			if (session != null) {
				Vendor vendor = vendorServiceImp.createVendor(
						req.getParameter("vendorType"),
						req.getParameter("vendorCategory"),
						req.getParameter("vendorName"),
						req.getParameter("landlineCode") + "-"
								+ req.getParameter("vendorLandlineNumber"),
						req.getParameter("mobileCode") + "-"
								+ req.getParameter("vendorMobileNumber"),
						req.getParameter("vendorWebsite"),
						req.getParameter("vendorAddress"));

				if (vendor == null) {
			
				}
				session.setAttribute("vendorMobileCode",
						req.getParameter("mobileCode"));
				session.setAttribute("vendorMobileNumber",
						req.getParameter("vendorMobileNumber"));
				session.setAttribute("vendorLandlineCode",
						req.getParameter("landlineCode"));
				session.setAttribute("vendorLandlineNumber",
						req.getParameter("vendorLandlineNumber"));
				session.setAttribute("vendor", vendor);
			}

 req.getRequestDispatcher("contactmanager.jsp").forward(req, response);
		}else if(uri.endsWith("searchview")){
			System.out.println("coming");
			int pageNumber = Integer.parseInt(req
					.getParameter("pagenumber"));
			String page = req.getParameter("page");
			String search = req.getParameter("search");
			List<Vendor> vendorList = null;

			if (page.equals("first")) {
				HttpSession session = req.getSession();
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

			req.getRequestDispatcher(
					"../searchview.jsp?pagenumber=" + pageNumber).forward(req,
					response);
				}
		else if (uri.endsWith("addtype")) {
			String category = req.getParameter("vendorcategory");
			String vtype = req.getParameter("vendortype");
			System.out.println(vtype);
			System.out.println(category);
			VendorType type2 = new VendorType();
			type2.setVendorCategory(category);
			type2.setVendorType(vtype);
			if (vendorServiceImp.addVendortype(type2)) {
				response.sendRedirect("../landingpage.jsp");

			} else {
				response.sendRedirect("error.jsp");
			}

		}else if (uri.endsWith("billes.vms")) {
			Billes billes = new Billes();
			billes.setBillNo(req.getParameter("billno"));
			billes.setShopName(req.getParameter("shopname"));
			System.out.println(req.getParameter("filename"));
			billes.setAmount(req.getParameter("amount"));
			billes.setName(req.getParameter("name"));
			billes.setMobile(req.getParameter("mobile"));
		           System.out.println((req.getParameter("date")));
		        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		       	String date=req.getParameter("date");
		        	

		         try{
		        	 
		        	 Date date1 = formatter.parse(date);
		        	 System.out.println(date1);
		        	System.out.println( formatter.format(date1));
		         }catch(ParseException e){
		        	 e.printStackTrace();
		         }
		            
		            
		            
		            			File file = new File(req.getParameter("filename"));
			String path = file.getAbsolutePath();

			billes.setImagepath(file);

			if (vendorServiceImp.addBills(billes)) {
				response.sendRedirect("landingpageOfEmplyee.jsp");

			} else {
				response.sendRedirect("error.jsp");
			}
		}
		else if (uri.endsWith("bankadd")) {
			Bank bank = new Bank();
			bank.setAcno(req.getParameter("acn"));
			bank.setAcName(req.getParameter("acname"));
			bank.setVendorName(req.getParameter("vendorname"));
			bank.setBankName(req.getParameter("bankname"));
			bank.setIcfcode(req.getParameter("iscfcode"));
			bank.setA_cno(req.getParameter("ac_n"));
			bank.setA_cName(req.getParameter("ac_name"));
			bank.setOtherbankname(req.getParameter("bank_name"));
			bank.setIcf_code(req.getParameter("iscf_code"));
			if (vendorServiceImp.addBank(bank)) {
				response.sendRedirect("landingpage.jsp");
			} else {
				response.sendRedirect("error.jsp");
			}
		}
		else if (uri.endsWith("editcontact.vms")) {
			HttpSession session = req.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");
				List<Contact> vendorContacts = vendor.getVendorContacts();

				for (Contact contact : vendorContacts) {
					if (contact.getEmail().equalsIgnoreCase(
							req.getParameter("email"))) {
						req.setAttribute("editContact", contact);
					}
				}
			}
			req.getRequestDispatcher("addcontact.jsp").forward(req,
					response);
		}
		 else if (uri.endsWith("updatecontact.vms")) {
				HttpSession session = req.getSession(false);

				if (session != null) {
					Vendor vendor = (Vendor) session.getAttribute("vendor");
					List<Contact> vendorContacts = vendorServiceImp.updateContact(
							req.getParameter("contactName"),
							req.getParameter("designation"),
							req.getParameter("mobile"),
							req.getParameter("email"),
							req.getParameter("employmentStatus"),
							req.getParameter("manager"),
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
				HttpSession session = req.getSession(false);

				if (session != null) {
					Vendor vendor = (Vendor) session.getAttribute("vendor");

					List<Contact> vendorContacts = vendorServiceImp
							.deleteContacts(req.getParameter("ids"),
									vendor.getVendorContacts());

					if (vendorContacts == null) {
						response.sendRedirect("error.jsp");
					}
					session.setAttribute("vendor", vendor);
					session.setAttribute("editContact", null);
					session.setAttribute("contactList", vendor.getVendorContacts());
				}
				req.getRequestDispatcher("viewcontacts.jsp").forward(req,
						response);
			} else if (uri.endsWith("saveall.vms")) {
				HttpSession session = req.getSession(false);

				if (session != null) {
					Vendor vendor = (Vendor) session.getAttribute("vendor");

					if (((VendorServiceImp) vendorServiceImp).saveAllData(vendor)) {
						req.setAttribute("addedsuccessfully", true);
						req.getRequestDispatcher("addvendor.jsp").forward(
								req, response);
					} else {
						response.sendRedirect("error.jsp");
					}
				}
			} else if (uri.endsWith("savevendor.vms")) {
				HttpSession session = req.getSession(false);

				if (session != null) {
					Vendor vendor = (Vendor) session.getAttribute("vendor");

					if (vendorServiceImp.addVendor(vendor)) {
						req.setAttribute("addedsuccessfully", true);
						req.getRequestDispatcher("addvendor.jsp").forward(
								req, response);
					} else {
						response.sendRedirect("error.jsp");
					}
				}
	 		}


 	}

	/**
	 * @see HttpServlet#doPost(HttpServletreq req, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
