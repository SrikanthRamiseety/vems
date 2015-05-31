package com.spaneos.vemas.web;

import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itextpdf.text.FontFactory;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.spaneos.vemas.pojo.Bank;
import com.spaneos.vemas.pojo.Billes;
import com.spaneos.vemas.pojo.Contact;
import com.spaneos.vemas.pojo.User;
import com.spaneos.vemas.pojo.Vendor;
import com.spaneos.vemas.pojo.VendorType;
import com.spaneos.vemas.service.VendorServiceImp;

/**
 * Servlet implementation class VendorManagementServlet
 */
@WebServlet("/user/*")
public class VendorManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VendorServiceImp vendorServiceImp = VendorServiceImp.getInstance();
	public String PATH = "/WEB-INF/view_u/";

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

		if (uri.endsWith("landingpageOfEmplyee")) {
			
			request.getRequestDispatcher(PATH + "landingpageOfEmplyee.jsp")
					.forward(request, response);
		} else if (uri.endsWith("forgotpwd.vms")) {
			String email = request.getParameter("email");
			String seq_question = request.getParameter("seq_question");
			String answer = request.getParameter("answer");

			request.setAttribute("email", email);

			request.setAttribute("incorrectAnswer", false);
			request.getRequestDispatcher("forgotpwdform.jsp").forward(request,
					response);
			;

			;

		} else if (uri.endsWith("logout.vms")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				session.invalidate();

				response.sendRedirect("loginpage.jsp");
			}

		} else if (uri.endsWith("type.vms")) {
			List<VendorType> list3 = vendorServiceImp.getAllVendorTypes();
			request.setAttribute("tlist", list3);
			request.getRequestDispatcher(PATH + "addvendor.jsp").forward(
					request, response);
		} else if (uri.endsWith("search_v")) {
			request.getRequestDispatcher(PATH + "search.jsp").forward(request,
					response);
		} else if (uri.endsWith("typevendor.vms")) {
			request.getRequestDispatcher(PATH + "addvendortype.jsp").forward(
					request, response);
		} else if (uri.endsWith("billes.vms")) {
			request.getRequestDispatcher(PATH + "billes.jsp").forward(request,
					response);

		} else if (uri.endsWith("billadd.vms")) {
			Billes billes = new Billes();
			billes.setBillNo(request.getParameter("billno"));
			billes.setShopName(request.getParameter("shopname"));
			System.out.println(request.getParameter("filename"));
			billes.setAmount(request.getParameter("amount"));
			billes.setName(request.getParameter("name"));
			billes.setMobile(request.getParameter("mobile"));
			System.out.println((request.getParameter("date")));

			String date = request.getParameter("date");
			System.out.println(date);

			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

				Date parsed = format.parse(date);

				java.sql.Date date11 = new java.sql.Date(0000 - 00 - 00);
				System.out.println();
				billes.setDate(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			File file = new File(request.getParameter("filename"));
			String path = file.getAbsolutePath();

			billes.setImagepath(file);

			if (vendorServiceImp.addBills(billes)) {
				request.getRequestDispatcher(PATH + "landingpageOfEmplyee.jsp")
						.forward(request, response);

			} else {
				response.sendRedirect("error.jsp");
			}
		} else if (uri.endsWith("addvendor.opt")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				Vendor vendor = vendorServiceImp.createVendor(
						request.getParameter("vendorcode"),
						request.getParameter("vendorType"),
						request.getParameter("vendorCategory"),
						request.getParameter("vendorName"),
						request.getParameter("landlineCode") + "-"
								+ request.getParameter("vendorLandlineNumber"),
						request.getParameter("mobileCode") + "-"
								+ request.getParameter("vendorMobileNumber"),
						request.getParameter("vendorMobileNumber1"),
						request.getParameter("vendorMobileNumber2"),
						request.getParameter("vendorWebsite"),
						request.getParameter("vendorAddress"));

				if (vendor == null) {

				}
				session.setAttribute("vendorMobileCode",
						request.getParameter("mobileCode"));
				session.setAttribute("vendorMobileNumber",
						request.getParameter("vendorMobileNumber"));
				session.setAttribute("vendorLandlineCode",
						request.getParameter("landlineCode"));
				session.setAttribute("vendorLandlineNumber",
						request.getParameter("vendorLandlineNumber"));
				session.setAttribute("vendor", vendor);

				request.getRequestDispatcher(PATH + "contactmanager.jsp")
						.forward(request, response);
			}
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
			request.getRequestDispatcher(PATH + "contactmanager.jsp").forward(
					request, response);
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
			request.getRequestDispatcher(PATH + "viewcontacts.jsp").forward(
					request, response);
		} else if (uri.endsWith("saveall.vms")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");

				if (((VendorServiceImp) vendorServiceImp).saveAllData(vendor)) {
					request.setAttribute("addedsuccessfully", true);
					System.out.println("vendor" + vendor);
					session.invalidate();
					request.getRequestDispatcher(PATH + "addvendor.jsp")
							.forward(request, response);
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
					request.getRequestDispatcher(PATH + "addvendor.jsp")
							.forward(request, response);
				} else {
					response.sendRedirect("error.jsp");
				}
			}
		} else if (uri.endsWith("add_contact.vms")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");
				Contact contact = vendorServiceImp.createContact(
						request.getParameter("contactName"),
						request.getParameter("designation"),
						request.getParameter("mobile"),
						request.getParameter("mobile1"),
						request.getParameter("mobile2"),
						request.getParameter("email"),
						request.getParameter("email1"),
						request.getParameter("email2"),
						request.getParameter("employmentStatus"),
						request.getParameter("manager"));

				if (contact == null) {
					response.sendRedirect("/WEB-INF/views/error.jsp");
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
			request.getRequestDispatcher("/WEB-INF/views/contactmanager.jsp")
					.forward(request, response);
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
			request.getRequestDispatcher(PATH + "addcontact.jsp").forward(
					request, response);
		} else if (uri.endsWith("addvendor.vms")) {
			List<VendorType> list3 = vendorServiceImp.getAllVendorTypes();
			System.out.println(list3);
			request.setAttribute("tlist", list3);
			request.getRequestDispatcher(PATH + "addvendor.jsp").forward(
					request, response);
		} else if (uri.endsWith("addtype_v.vms")) {
			String category = request.getParameter("vendorcategory");
			String vtype = request.getParameter("vendortype");
			System.out.println(vtype);
			System.out.println(category);
			VendorType type2 = new VendorType();
			type2.setVendorCategory(category);
			type2.setVendorType(vtype);
			if (vendorServiceImp.addVendortype(type2)) {
				request.getRequestDispatcher(PATH + "landingpageOfEmplyee.jsp")
						.forward(request, response);

			} else {
				response.sendRedirect("error.jsp");
			}

		} else if (uri.endsWith("searchview.vms")) {

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
					PATH + "searchview.jsp?pagenumber=" + pageNumber).forward(
					request, response);
		} else if (uri.endsWith("viewUser.vms")) {
			request.getRequestDispatcher(PATH + "viewUser.jsp").forward(
					request, response);
		} else if (uri.endsWith("vendor_view")) {
			String vendor = request.getParameter("vendor");
			System.out.println(vendor);
			List<Vendor> vlist = vendorServiceImp
					.getVendorsByVendorname(vendor);
			List<Bank> blist = vendorServiceImp.getBankdetiles(vendor);
			request.setAttribute("vlist", vlist);
			request.setAttribute("blist", blist);
			System.out.println(blist);
			request.setAttribute("vendor", vendor);
			System.out.println(vlist);
			request.getRequestDispatcher(PATH + "searchview_b.jsp").forward(
					request, response);

		} else if (uri.endsWith("addbank_v")) {
			String vendor = request.getParameter("vendorName");
			System.out.println(vendor);
			request.setAttribute("vendorname", vendor);
			request.getRequestDispatcher(PATH + "addBank_v.jsp").forward(
					request, response);
		} else if (uri.endsWith("bankadd_n.vms")) {
			Bank bank = new Bank();
			bank.setAcno(request.getParameter("acn"));
			bank.setAcName(request.getParameter("acname"));
			bank.setVendorName(request.getParameter("vendorname"));
			bank.setBankName(request.getParameter("bankname"));
			bank.setIcfcode(request.getParameter("iscfcode"));
			bank.setA_cno(request.getParameter("ac_n"));
			bank.setA_cName(request.getParameter("ac_name"));
			bank.setOtherbankname(request.getParameter("bank_name"));
			bank.setIcf_code(request.getParameter("iscf_code"));
			if (vendorServiceImp.addBank(bank)) {
				List<VendorType> list3 = vendorServiceImp.getAllVendorTypes();
				System.out.println(list3);
				request.setAttribute("tlist", list3);
				request.getRequestDispatcher(PATH + "addvendor.jsp").forward(
						request, response);
			} else {
				response.sendRedirect("error.jsp");
			}
		} else if (uri.endsWith("contactmanager.vms")) {
			HttpSession session = request.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");

				List<Contact> vendorContacts = vendorServiceImp
						.deleteContacts(request.getParameter("ids"),
								vendor.getVendorContacts());

				session.setAttribute("vendor", vendor);
				session.setAttribute("editContact", null);
				session.setAttribute("contactList", vendor.getVendorContacts());
			}
			request.getRequestDispatcher(PATH + "contactmanager.jsp").forward(
					request, response);
		} else if (uri.endsWith("allvendors")) {
			List<Vendor> list = vendorServiceImp.getAllVendors();
			System.out.println("coming...");

			request.setAttribute("vlist", list);
			int pageNumber = Integer.parseInt(request
					.getParameter("pagenumber"));
			String page = request.getParameter("page");
			request.getRequestDispatcher(
					PATH + "view_vendor.jsp?pagenumber=" + pageNumber).forward(
					request, response);
		} else if (uri.endsWith("landingpage")) {
			String user = request.getParameter("name");
			User role = vendorServiceImp.getUser(user);
			String user_role = role.getRole();
			request.setAttribute("role", user_role);
			request.setAttribute("name",user);
			System.out.println("role="+user_role);
			 
			 
			 
				request.getRequestDispatcher(PATH+"landing.jsp").forward(
						request, response);
			 
		}else if(uri.endsWith("doc")){
			String type=request.getParameter("type");
			System.out.println(type);
			if(type.equalsIgnoreCase("execlsheet")){
				
			
			 
			List<Vendor> list = vendorServiceImp.getAllVendors();
			try{ 
				
				String filename="C:/data/vendor_user.xls" ; 
				HSSFWorkbook hwb=new HSSFWorkbook(); 
				HSSFSheet sheet = hwb.createSheet("sheet"); 
				HSSFCellStyle style = hwb.createCellStyle();
				HSSFFont font = hwb.createFont();// Create font
				 
				font.setBoldweight((short) Font.ROMAN_BASELINE);
				style.setFont(font);
				
				HSSFRow rowhead= sheet.createRow((short)0);
				 
				rowhead.createCell((short) 0).setCellValue("VENDOR NAME"); 
				rowhead.createCell((short) 1).setCellValue("VENDOR TYPE"); 
				rowhead.createCell((short) 2).setCellValue("VENDOR CATEGORY"); 
				rowhead.createCell((short) 3).setCellValue("VENDOR ADDRESS"); 
				rowhead.createCell((short) 4).setCellValue("VENDOR CONTACTS#"); 
				rowhead.createCell((short) 5).setCellValue(" VENDOR WEB_SITE"); 
				int j=0;
			for(Vendor i:list){
				  j++;
				 
				  
				 
				 
				 
				HSSFRow row= sheet.createRow(j); 
				row.createCell((short) 0).setCellValue(i.getVendorName()); 
			 
				row.createCell((short) 1).setCellValue(i.getVendorType()); 
				row.createCell((short) 2).setCellValue(i.getVendorCategory()); 
				row.createCell((short) 3).setCellValue(i.getVendorAddress()); 
				row.createCell((short) 4).setCellValue(i.getVendorMobileNumber());
				row.createCell((short) 5).setCellValue(i.getVendorWebsite());
				} 
				FileOutputStream fileOut = new FileOutputStream(filename); 
				hwb.write(fileOut); 
				fileOut.close(); 
			 
				} catch( Exception ex ) { 
				System.out.println(ex); 
				}
			}else if(type.equalsIgnoreCase("csv")){
				final String COMMA_DELIMITER = ",";
				String filename="C:/data_v/vendor_user.csv" ; 
				  final String NEW_LINE_SEPARATOR = "\n";
				 final String FILE_HEADER = "VENDOR NAME,VENDOR TYPE,VENDOR CATEGORY,VENDOR ADDRESS,VENDOR CONTACTS#,VENDOR WEB_SITE";
				 List<Vendor> list = vendorServiceImp.getAllVendors();
				 FileWriter fileWriter = null;

				try {
					  
					             fileWriter = new FileWriter(filename);
					 
					  
					 
					             //Write the CSV file header
					  
					             fileWriter.append(FILE_HEADER.toString());
					  
					              
					  
					             //Add a new line separator after the header
					  
					             fileWriter.append(NEW_LINE_SEPARATOR);
					  
					              
					 
					             //Write a new student object list to the CSV file
					 
					            for(Vendor i:list){
					            	fileWriter.append(i.getVendorName());
					            	 fileWriter.append(COMMA_DELIMITER);

					            	fileWriter.append(i.getVendorType());
					            	 fileWriter.append(COMMA_DELIMITER);

					            	fileWriter.append(i.getVendorCategory());
					            	 fileWriter.append(COMMA_DELIMITER);

					            	fileWriter.append(i.getVendorAddress());
					            	 fileWriter.append(COMMA_DELIMITER);

					            	fileWriter.append(i.getVendorMobileNumber());
					            	 fileWriter.append(COMMA_DELIMITER);

					            	fileWriter.append(i.getVendorWebsite());
					            	fileWriter.append(NEW_LINE_SEPARATOR);

					            }
					  
					  
					  
					              
					  
					  
					             System.out.println("CSV file was created successfully !!!");
					  
					              
					  
					         } catch (Exception e) {
					  
					             System.out.println("Error in CsvFileWriter !!!");
					  
					             e.printStackTrace();
					  
					         } finally {
					 
					              
					  
					             try {
					  
					                 fileWriter.flush();
					 
					                 fileWriter.close();
					  
					             } catch (IOException e) {
					 
					                 System.out.println("Error while flushing/closing fileWriter !!!");
					 
					                 e.printStackTrace();
					  
					             }

			}
			}else if(type.equalsIgnoreCase("pdf")){
				 com.itextpdf.text.Document document = new com.itextpdf.text.Document();
				    try
				    {
				    	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/data_p/Vendor_user.pdf"));
				         document.open();
				         
				         com.itextpdf.text.Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
				         //Add ordered list
				         Paragraph paragraphOne = new Paragraph("VENDOR LIST", redFont);
				         document.add(paragraphOne);
				         //Add ordered list
				         List<Vendor> list = vendorServiceImp.getAllVendors();
				         com.itextpdf.text.List orderedList = new com.itextpdf.text.List(com.itextpdf.text.List.ALIGN_MIDDLE);
				         for(Vendor i:list){
				        	 
				         
				         orderedList.add(new ListItem(i.getVendorName()));
				         orderedList.add(new ListItem(i.getVendorType()));
				         orderedList.add(new ListItem(i.getVendorCategory()));
				         orderedList.add(new ListItem(i.getVendorMobileNumber()));
				         orderedList.add(new ListItem(i.getVendorAddress()));
				         orderedList.add(new ListItem(i.getVendorWebsite()));
				         orderedList.add(new ListItem("..........................."));
				         
				         document.add(orderedList);
				    }
				         document.close();
				         writer.close();
				         document.close();
				         writer.close();
				    }catch (Exception e)
				    {
				        e.printStackTrace();
				    }
			}else if(type.equalsIgnoreCase("")){
				
			}
				
			
			request.getRequestDispatcher("landingpageOfEmplyee")
			.forward(request, response);
			
		}

	}
}
