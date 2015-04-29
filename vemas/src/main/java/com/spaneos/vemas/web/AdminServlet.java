package com.spaneos.vemas.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spaneos.vemas.pojo.Admin;
import com.spaneos.vemas.pojo.Bank;
import com.spaneos.vemas.pojo.Billes;
import com.spaneos.vemas.pojo.Contact;
import com.spaneos.vemas.pojo.User;
import com.spaneos.vemas.pojo.Vendor;
import com.spaneos.vemas.pojo.VendorType;
import com.spaneos.vemas.service.VendorServiceImp;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin/*")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VendorServiceImp vendorServiceImp = VendorServiceImp.getInstance();
	private final static Logger LOGGER = Logger.getLogger(AdminServlet.class.getName()); 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		 
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
			req.getRequestDispatcher("/WEB-INF/views/addvendor.jsp").forward(req, resp);
			LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.FINE); 
		} else if (uri.endsWith("typevendor")) {
			req.getRequestDispatcher("/WEB-INF/views/addvendortype.jsp").forward(req,
					resp);

		} else if (uri.endsWith("v_search")) {
			req.getRequestDispatcher("/WEB-INF/views/search.jsp").forward(req, resp);
		} else if (uri.endsWith("signup")) {
			req.getRequestDispatcher("signup.jsp").forward(req, resp);

		} else if (uri.endsWith("reporting")) {

		} else if (uri.endsWith("viewuser")) {
			List<User> users = vendorServiceImp.getAllUsers();
			ServletContext context = req.getServletContext();

			context.setAttribute("userslist", users);
			req.getRequestDispatcher("/WEB-INF/views/viewUser.jsp").forward(req, resp);

		} else if (uri.endsWith("billesview")) {
			List<Billes> billes = vendorServiceImp.getAllBilles();

			ServletContext context = req.getServletContext();

			context.setAttribute("billeslist", billes);
			req.getRequestDispatcher("/WEB-INF/views/viewbilles.jsp").forward(req, resp);
		} else if (uri.endsWith("landingpage_vendor")) {
			  req.getRequestDispatcher("/WEB-INF/views/landingpage.jsp").forward(req, resp);
		} else if (uri.endsWith("addBank.vms")) {
			req.getRequestDispatcher("/WEB-INF/views/addBank.jsp").forward(req, resp);
		} else if (uri.endsWith("date")) {
			System.out.println("date");
			req.getRequestDispatcher("/WEB-INF/views/date.jsp").forward(req, resp);

		} else if (uri.endsWith("date_s")) {
			String date = req.getParameter("date");
			System.out.println("date===" + date);
			Billes billes=new Billes();

			//System.out.println("" + blist);
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

			try {
				java.sql.Date date4 = (java.sql.Date) formatter.parse(date);
				billes.setDate1(date4);
			System.out.println(date);
			System.out.println(formatter.format(date));
				 
				Calendar cal = Calendar.getInstance();
				String date11 = formatter.format(cal.getTime());
				System.out.println("....." + date11);
				
				List<Billes> blist = vendorServiceImp.getBillByDate(date4);
				System.out.println("servlet"+blist);
				
				req.setAttribute("bill", blist);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			 
			req.getRequestDispatcher("/WEB-INF/views/viewdate.jsp").forward(req, resp);

		} else if (uri.endsWith("vendor_s")) {
			req.getRequestDispatcher("/WEB-INF/views/search_a.jsp").forward(req, resp);
		} else if (uri.endsWith("searchview_a.vms")) {
			String search = req.getParameter("search");
			System.out.println(search);
			List<Billes> blist = vendorServiceImp.getBillByVendorName(search);
			 
			req.setAttribute("bl", blist);
			req.getRequestDispatcher("/WEB-INF/views/view_s.jsp").forward(req, resp);
		} else if (uri.endsWith("bankview.vms")) {
			List<Bank> blist = vendorServiceImp.getAllBAnkDetalies();
			req.setAttribute("banklist", blist);
			req.getRequestDispatcher("/WEB-INF/views/searchview_b.jsp").forward(req, resp);
		} else if (uri.endsWith("typevendor_t.vms")) {
		 resp.sendRedirect("addvendortype_l.jsp");

		}else if (uri.endsWith("addvendor.opt")) {
			HttpSession session = req.getSession(false);

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

				req.getRequestDispatcher("/WEB-INF/views/contactmanager.jsp").forward(req,
						resp);
			}
		}else if (uri.endsWith("updatecontact.vms")) {
			HttpSession session = req.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");
				List<Contact> vendorContacts = vendorServiceImp
						.updateContact(req.getParameter("contactName"),
								req.getParameter("designation"),
								req.getParameter("mobile"),
								req.getParameter("email"),
								req.getParameter("employmentStatus"),
								req.getParameter("manager"),
								vendor.getVendorContacts());

				if (vendorContacts == null) {
					resp.sendRedirect("error.jsp");
				}
				session.setAttribute("vendor", vendor);
				session.setAttribute("editContact", null);
				session.setAttribute("contactList", vendor.getVendorContacts());
			}
			req.getRequestDispatcher("/WEB-INF/views/contactmanager.jsp").forward(req,
					resp);
		} else if (uri.endsWith("deletecontacts.vms")) {
			HttpSession session = req.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");

				List<Contact> vendorContacts = vendorServiceImp.deleteContacts(
						req.getParameter("ids"), vendor.getVendorContacts());

				if (vendorContacts == null) {
					resp.sendRedirect("error.jsp");
				}
				session.setAttribute("vendor", vendor);
				session.setAttribute("editContact", null);
				session.setAttribute("contactList", vendor.getVendorContacts());
			}
			req.getRequestDispatcher("/WEB-INF/views/viewcontacts.jsp").forward(req,
					resp);
		} else if (uri.endsWith("saveall.vms")) {
			HttpSession session = req.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");

				if (((VendorServiceImp) vendorServiceImp).saveAllData(vendor)) {
					req.setAttribute("addedsuccessfully", true);
					System.out.println("vendor" + vendor);
					req.getRequestDispatcher("/WEB-INF/views/addvendor.jsp").forward(req,
							resp);
				} else {
					resp.sendRedirect("error.jsp");
				}
			}
		} else if (uri.endsWith("savevendor.vms")) {
			HttpSession session = req.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");

				if (vendorServiceImp.addVendor(vendor)) {
					req.setAttribute("addedsuccessfully", true);
					req.getRequestDispatcher("/WEB-INF/views/addvendor.jsp").forward(req,
							resp);
				} else {
					resp.sendRedirect("error.jsp");
				}
			}
		} else if (uri.endsWith("add_contact.vms")) {
			HttpSession session = req.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");
				Contact contact = vendorServiceImp.createContact(
						req.getParameter("contactName"),
						req.getParameter("designation"),
						req.getParameter("mobile"), req.getParameter("email"),
						req.getParameter("employmentStatus"),
						req.getParameter("manager"));

				if (contact == null) {
					resp.sendRedirect("error.jsp");
				}
				vendor.setVendorContacts(new ArrayList<Contact>());
				vendor.getVendorContacts().add(contact);
 
				/* vendor.getVendorContacts().add(contact); */

				session.setAttribute("vendor", vendor);
				session.setAttribute("editContact", null);
				session.setAttribute("contactList", vendor.getVendorContacts());
			}
			req.getRequestDispatcher("/WEB-INF/views/contactmanager.jsp").forward(req,
					resp);
		} else if (uri.endsWith("editcontact.vms")) {
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
			req.getRequestDispatcher("/WEB-INF/views/addcontact.jsp").forward(req,
					resp);
		} else if(uri.endsWith("addvendor.vms")){
			List<VendorType> list3 = vendorServiceImp.getAllVendorTypes();
			System.out.println(list3);
			req.setAttribute("tlist", list3);
			req.getRequestDispatcher("/WEB-INF/views/addvendor.jsp").forward(req,
					resp);
		}else if (uri.endsWith("addtype.vms")) {
			String category = req.getParameter("vendorcategory");
			String vtype = req.getParameter("vendortype");
			System.out.println(vtype);
			System.out.println(category);
			VendorType type2 = new VendorType();
			type2.setVendorCategory(category);
			type2.setVendorType(vtype);
			if (vendorServiceImp.addVendortype(type2)) {
				req.getRequestDispatcher("/WEB-INF/views/landingpage.jsp").forward(req,
						resp); 

			} else {
				resp.sendRedirect("error.jsp");
			}

		}else if (uri.endsWith("searchview.vms")) {
		 
			int pageNumber = Integer.parseInt(req.getParameter("pagenumber"));
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
					"/WEB-INF/views/searchview.jsp?pagenumber=" + pageNumber).forward(req,
					resp);
		}else if(uri.endsWith("reporting.vms")){
			req.getRequestDispatcher(
					"/WEB-INF/views/reporting.jsp").forward(req,
					resp);
		}else if (uri.endsWith("bank.vms")) {
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
				req.getRequestDispatcher("/WEB-INF/views/landingpage.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("error.jsp");
			}
		}else if(uri.endsWith("billes.vms")){
			req.getRequestDispatcher("/WEB-INF/views/billes.jsp").forward(req, resp);
			
		}else if (uri.endsWith("billadd.vms")) {
			Billes billes = new Billes();
			billes.setBillNo(req.getParameter("billno"));
			billes.setShopName(req.getParameter("shopname"));
			System.out.println(req.getParameter("filename"));
			billes.setAmount(req.getParameter("amount"));
			billes.setName(req. getParameter("name"));
			billes.setMobile(req.getParameter("mobile"));
			System.out.println((req.getParameter("date")));
			 
			String date = req.getParameter("date");
			System.out.println(date);

			try {
				SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
				SimpleDateFormat parseDate = new java.text.SimpleDateFormat("MM/dd/yyyy");
				SimpleDateFormat formatDdate = new java.text.SimpleDateFormat("yyyy-MM-dd");
		        Date parsed = format.parse(date);
		       Date date11 = (Date) parseDate.parse(date);
		        String DisplayDate= formatDdate.format(parsed);
		        java.sql.Date sql = new java.sql.Date(date11.getTime());
		        System.out.println("sql"+sql);
				  billes.setDate1(sql);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			File file = new File(req.getParameter("filename"));
			String path = file.getAbsolutePath();

			billes.setImagepath(file);

			if (vendorServiceImp.addBills(billes)) {
				req.getRequestDispatcher("/WEB-INF/views/landingpage.jsp").forward(req,
						resp);

			} else {
				resp.sendRedirect("error.jsp");
			}
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
