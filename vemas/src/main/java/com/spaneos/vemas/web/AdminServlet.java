package com.spaneos.vemas.web;

import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
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

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itextpdf.text.FontFactory;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
	private Logger log = Logger.getLogger(AdminServlet.class.getName());

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
			log.info("to go to addvendor form.....");
			req.setAttribute("tlist", list3);
			req.getRequestDispatcher("/WEB-INF/views/addvendor.jsp").forward(
					req, resp);
			LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME)
					.setLevel(Level.FINE);
		} else if (uri.endsWith("typevendor")) {
			req.getRequestDispatcher("/WEB-INF/views/addvendor_v.jsp").forward(
					req, resp);

		} else if (uri.endsWith("v_search")) {
			req.getRequestDispatcher("/WEB-INF/views/search.jsp").forward(req,
					resp);
		} else if (uri.endsWith("signup")) {
			req.getRequestDispatcher("signup.jsp").forward(req, resp);

		} else if (uri.endsWith("reporting")) {

		}    else if (uri.endsWith("billesview")) {
			int pageNumber = Integer.parseInt(req.getParameter("pagenumber"));
			String page = req.getParameter("page");
			List<Billes> billes = vendorServiceImp.getAllBilles();

			ServletContext context = req.getServletContext();

			context.setAttribute("billeslist", billes);
			req.getRequestDispatcher("/WEB-INF/views/viewTables.jsp?pagenumber=" + pageNumber).forward(
					req, resp);
		} else if (uri.endsWith("landingpage_vendor")) {
			log.info("After Login Succesfuly......");
			req.getRequestDispatcher("/WEB-INF/views/landingpage.jsp").forward(
					req, resp);
		} else if (uri.endsWith("addBank.vms")) {
			req.getRequestDispatcher("/WEB-INF/views/addBank.jsp").forward(req,
					resp);
		} else if (uri.endsWith("date")) {
			System.out.println("date");
			req.getRequestDispatcher("/WEB-INF/views/date.jsp").forward(req,
					resp);

		} else if (uri.endsWith("date_s")) {
			 
			int pageNumber = Integer.parseInt(req.getParameter("pagenumber"));
			String page = req.getParameter("page");
			String date = req.getParameter("date");

			// System.out.println("" + blist);

			List<Billes> blist = vendorServiceImp.getBillByDate(date);
			 
             log.info(blist.toString());
			req.setAttribute("bill", blist);

			req.getRequestDispatcher(
					"/WEB-INF/views/viewdate.jsp?pagenumber=" + pageNumber)
					.forward(req, resp);

		} else if (uri.endsWith("vendor_s")) {
			req.getRequestDispatcher("/WEB-INF/views/search_a.jsp").forward(
					req, resp);
		} else if (uri.endsWith("searchview_a.vms")) {
			String search = req.getParameter("search");
			int pageNumber = Integer.parseInt(req.getParameter("pagenumber"));
			String page = req.getParameter("page");
			System.out.println(search);
			List<Billes> blist = vendorServiceImp.getBillByVendorName(search);

			req.setAttribute("bl", blist);
			req.getRequestDispatcher(
					"/WEB-INF/views/view_s.jsp?pagenumber=" + pageNumber)
					.forward(req, resp);
		}   else if (uri.endsWith("typevendor_t.vms")) {
			resp.sendRedirect("addvendortype_l.jsp");

		} else if (uri.endsWith("addvendor.opt")) {
			HttpSession session = req.getSession(false);

			if (session != null) {
				Vendor vendor = vendorServiceImp.createVendor(
						req.getParameter("vendorcode"),
						req.getParameter("vendorType"),
						req.getParameter("vendorCategory"),
						req.getParameter("vendorName"),
						req.getParameter("landlineCode") + "-"
								+ req.getParameter("vendorLandlineNumber"),
						req.getParameter("mobileCode") + "-"
								+ req.getParameter("vendorMobileNumber"),
						req.getParameter("vendorMobileNumber1"),
						req.getParameter("vendorMobileNumber2"),
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

				req.getRequestDispatcher("/WEB-INF/views/contactmanager.jsp")
						.forward(req, resp);
			}
		} else if (uri.endsWith("updatecontact.vms")) {
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
			req.getRequestDispatcher("/WEB-INF/views/contactmanager.jsp")
					.forward(req, resp);
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
			req.getRequestDispatcher("/WEB-INF/views/viewcontacts.jsp")
					.forward(req, resp);
		} else if (uri.endsWith("saveall.vms")) {
			HttpSession session = req.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");

				if (((VendorServiceImp) vendorServiceImp).saveAllData(vendor)) {
					req.setAttribute("addedsuccessfully", true);
					session.invalidate();
					req.getRequestDispatcher("/WEB-INF/views/addvendor.jsp")
							.forward(req, resp);
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
					req.getRequestDispatcher("/WEB-INF/views/addvendor.jsp")
							.forward(req, resp);
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
						req.getParameter("mobile"),
						req.getParameter("mobile1"),
						req.getParameter("mobile2"), req.getParameter("email"),
						req.getParameter("email1"), req.getParameter("email2"),
						req.getParameter("employmentStatus"),
						req.getParameter("manager"));

				if (contact == null) {
					resp.sendRedirect("/WEB-INF/views/error.jsp");
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
			req.getRequestDispatcher("/WEB-INF/views/contactmanager.jsp")
					.forward(req, resp);
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
			req.getRequestDispatcher("/WEB-INF/views/addcontact.jsp").forward(
					req, resp);
		} else if (uri.endsWith("addvendor.vms")) {
			List<VendorType> list3 = vendorServiceImp.getAllVendorTypes();
			System.out.println(list3);
			req.setAttribute("tlist", list3);
			req.getRequestDispatcher("/WEB-INF/views/addvendor.jsp").forward(
					req, resp);
		} else if (uri.endsWith("addtype.vms")) {
			String category = req.getParameter("vendorcategory");
			String vtype = req.getParameter("vendortype");
			System.out.println(vtype);
			System.out.println(category);
			VendorType type2 = new VendorType();
			type2.setVendorCategory(category);
			type2.setVendorType(vtype);
			if (vendorServiceImp.addVendortype(type2)) {
				req.getRequestDispatcher("/WEB-INF/views/landingpage.jsp")
						.forward(req, resp);

			} else {
				resp.sendRedirect("/WEB-INF/views/error.jsp");
			}

		} else if (uri.endsWith("searchview.vms")) {

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
					"/WEB-INF/views/searchview.jsp?pagenumber=" + pageNumber)
					.forward(req, resp);
		} else if (uri.endsWith("reporting.vms")) {
			req.getRequestDispatcher("/WEB-INF/views/reporting.jsp").forward(
					req, resp);
		} else if (uri.endsWith("bank.vms")) {
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
				req.getRequestDispatcher("/WEB-INF/views/landingpage.jsp")
						.forward(req, resp);
			} else {
				resp.sendRedirect("/WEB-INF/views/error.jsp");
			}
		} else if (uri.endsWith("billes.vms")) {
			req.getRequestDispatcher("/WEB-INF/views/billes.jsp").forward(req,
					resp);

		} else if (uri.endsWith("billadd.vms")) {
			Billes billes = new Billes();
			billes.setBillNo(req.getParameter("billno"));
			billes.setShopName(req.getParameter("shopname"));
			System.out.println(req.getParameter("filename"));
			billes.setAmount(req.getParameter("amount"));
			billes.setName(req.getParameter("name"));
			billes.setMobile(req.getParameter("mobile"));
			System.out.println((req.getParameter("date")));

			String date = req.getParameter("date");
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

			File file = new File(req.getParameter("filename"));
			String path = file.getAbsolutePath();

			billes.setImagepath(file);

			if (vendorServiceImp.addBills(billes)) {
				req.getRequestDispatcher("/WEB-INF/views/landingpage.jsp")
						.forward(req, resp);

			} else {
				resp.sendRedirect("/WEB-INF/views/error.jsp");
			}
		} else if (uri.endsWith("month.vms")) {
			req.getRequestDispatcher("/WEB-INF/views/month_a.jsp").forward(req,
					resp);
		} else if (uri.endsWith("month_v")) {

			String month = req.getParameter("month");
			int month_int = Integer.parseInt(month);
			 
			List<Billes> bii_list = new ArrayList<Billes>();
			List<Billes> blist = vendorServiceImp.getAllBilles();
			for (Billes b : blist) {
				int month1 = b.getDate1().getMonth();
				Calendar cal = Calendar.getInstance();
				cal.setTime(b.getDate1());
				int year = cal.get(Calendar.YEAR);

				if (year == 2015 && month_int == month1 + 1) {
					bii_list.add(b);

				}

			}

			ServletContext context = req.getServletContext();

			context.setAttribute("bl", bii_list);
			req.getRequestDispatcher("/WEB-INF/views/view_m.jsp").forward(req,
					resp);
		} else if (uri.endsWith("allvendors")) {
			List<Vendor> list = vendorServiceImp.getAllVendors();
			 
            System.out.println(list.size());
			req.setAttribute("vlist", list);
			int pageNumber = Integer.parseInt(req.getParameter("pagenumber"));
			String page = req.getParameter("page");
			req.getRequestDispatcher(
					"/WEB-INF/views/view_vendor.jsp?pagenumber=" + pageNumber)
					.forward(req, resp);
		} else if (uri.endsWith("contactmanager.vms")) {
			HttpSession session = req.getSession(false);

			if (session != null) {
				Vendor vendor = (Vendor) session.getAttribute("vendor");

				List<Contact> vendorContacts = vendorServiceImp.deleteContacts(
						req.getParameter("ids"), vendor.getVendorContacts());

				session.setAttribute("vendor", vendor);
				session.setAttribute("editContact", null);
				session.setAttribute("contactList", vendor.getVendorContacts());
			}
			req.getRequestDispatcher("/WEB-INF/views/contactmanager.jsp")
					.forward(req, resp);
		} else if(uri.endsWith("doc")){
			String type=req.getParameter("type");
			System.out.println(type);
			if(type.equalsIgnoreCase("execlsheet")){
				
			
			 
			List<Vendor> list = vendorServiceImp.getAllVendors();
			try{ 
				
				String filename="C:/data/vendor_admin.xls" ; 
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
				String filename="C:/data_v/vendor_admin.csv" ; 
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
				    	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/data_p/Vendor_admin_1.pdf"));
				         document.open();
				         
				         com.itextpdf.text.Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
				         //Add ordered list
				         Paragraph paragraphOne = new Paragraph("VENDOR LIST", redFont);
				         document.add(paragraphOne);
				         //Add ordered list
				         List<Vendor> list = vendorServiceImp.getAllVendors();
				         /*com.itextpdf.text.List orderedList = new com.itextpdf.text.List(com.itextpdf.text.List.LIST);*/
				         PdfPTable orderedList = new PdfPTable(6);
				         for(Vendor i:list){
				        	 
				         
				         orderedList.addCell(i.getVendorName());
				         orderedList.addCell(i.getVendorType());
				         orderedList.addCell(i.getVendorCategory());
				         orderedList.addCell(i.getVendorMobileNumber());
				         orderedList.addCell(i.getVendorAddress());
				         orderedList.addCell(i.getVendorWebsite());
				         
				         
				         document.add(orderedList);
				    } 
				          



				          // Step 5
				          
				         document.close();
				         writer.close();
				         document.close();
				         writer.close();
				    }catch (Exception e)
				    {
				        e.printStackTrace();
				    }
				/* Document doc = new Document();
				 
				 
				  DecimalFormat df = new DecimalFormat("0.00");
				 
				  try {
				    
				   //special font sizes
				   com.itextpdf.text.Font bfBold12 = new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0)); 
				   com.itextpdf.text.Font bf12 = new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 12); 
				 
				   //file path
				    
				     PdfWriter docWriter = PdfWriter.getInstance(doc, new FileOutputStream("C:/data_p/Vendor.pdf"));;
				    
				     doc.open();
				   //document header attributes
				   doc.addAuthor("betterThanZero");
				   doc.addCreationDate();
				   doc.addProducer();
				   doc.addCreator("MySampleCode.com");
				   doc.addTitle("Report with Column Headings");
				   doc.setPageSize(PageSize.LETTER);
				   
				   //open document
				 
				   //create a paragraph
				   Paragraph paragraph = new Paragraph("iText ® is a library that allows you to create and " +
				     "manipulate PDF documents. It enables developers looking to enhance web and other " +
				     "applications with dynamic PDF document generation and/or manipulation.");
				    
				    
				   //specify column widths
				   float[] columnWidths = {1.5f, 2f, 5f, 2f};
				   //create PDF table with the given widths
				   PdfPTable table = new PdfPTable(columnWidths);
				   // set table width a percentage of the page width
				   table.setWidthPercentage(90f);
				 
				   //insert column headings
				   insertCell(table, "Order No", Element.ALIGN_RIGHT, 1, bfBold12);
				   insertCell(table, "Account No", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table, "Account Name", Element.ALIGN_LEFT, 1, bfBold12);
				   insertCell(table, "Order Total", Element.ALIGN_RIGHT, 1, bfBold12);
				   table.setHeaderRows(1);
				 
				   //insert an empty row
				   insertCell(table, "", Element.ALIGN_LEFT, 4, bfBold12);
				   //create section heading by cell merging
				   insertCell(table, "New York Orders ...", Element.ALIGN_LEFT, 4, bfBold12);
				   double orderTotal, total = 0;
				    
				   //just some random data to fill 
				   for(int x=1; x<5; x++){
				     
				    insertCell(table, "10010" + x, Element.ALIGN_RIGHT, 1, bf12);
				    insertCell(table, "ABC00" + x, Element.ALIGN_LEFT, 1, bf12);
				    insertCell(table, "This is Customer Number ABC00" + x, Element.ALIGN_LEFT, 1, bf12);
				     
				    orderTotal = Double.valueOf(df.format(Math.random() * 1000));
				    total = total + orderTotal;
				    insertCell(table, df.format(orderTotal), Element.ALIGN_RIGHT, 1, bf12);
				     
				   }
				   //merge the cells to create a footer for that section
				   insertCell(table, "New York Total...", Element.ALIGN_RIGHT, 3, bfBold12);
				   insertCell(table, df.format(total), Element.ALIGN_RIGHT, 1, bfBold12);
				    
				   //repeat the same as above to display another location
				   insertCell(table, "", Element.ALIGN_LEFT, 4, bfBold12);
				   insertCell(table, "California Orders ...", Element.ALIGN_LEFT, 4, bfBold12);
				   orderTotal = 0;
				    
				   for(int x=1; x<7; x++){
				     
				    insertCell(table, "20020" + x, Element.ALIGN_RIGHT, 1, bf12);
				    insertCell(table, "XYZ00" + x, Element.ALIGN_LEFT, 1, bf12);
				    insertCell(table, "This is Customer Number XYZ00" + x, Element.ALIGN_LEFT, 1, bf12);
				     
				    orderTotal = Double.valueOf(df.format(Math.random() * 1000));
				    total = total + orderTotal;
				    insertCell(table, df.format(orderTotal), Element.ALIGN_RIGHT, 1, bf12);
				     
				   }
				   insertCell(table, "California Total...", Element.ALIGN_RIGHT, 3, bfBold12);
				   insertCell(table, df.format(total), Element.ALIGN_RIGHT, 1, bfBold12);
				    
				   //add the PDF table to the paragraph 
				   paragraph.add(table);
				   // add the paragraph to the document
				   doc.add(paragraph);
				   doc.close();
				 
				  }
				  catch (DocumentException dex)
				  {
				   dex.printStackTrace();
				  }
				  catch (Exception ex)
				  {
				   ex.printStackTrace();
				  }
				 
				  
			
				  */
		
			}else if(type.equalsIgnoreCase("")){
				
			}
				
			
			req.getRequestDispatcher("landingpage_vendor")
			.forward(req, resp);
			
		} else if (uri.endsWith("year_a")) {
			String str = req.getParameter("year");
			int year_int = Integer.parseInt(str);
			System.out.println(year_int);
			if (year_int == 2015) {
				req.getRequestDispatcher("/WEB-INF/views/month_f.jsp").forward(
						req, resp);
			} else if (year_int == 2014) {
				req.getRequestDispatcher("/WEB-INF/views/month_2014.jsp")
						.forward(req, resp);
			} else if (year_int == 2013) {
				req.getRequestDispatcher("/WEB-INF/views/month_2013.jsp")
						.forward(req, resp);
			} else if (year_int == 2012) {
				req.getRequestDispatcher("/WEB-INF/views/month_2012.jsp")
						.forward(req, resp);
			}
		} else if (uri.endsWith("month_2014")) {

			String month = req.getParameter("month");
			int month_int = Integer.parseInt(month);
			System.out.println("monthvalue=" + month_int);
			List<Billes> bii_list = new ArrayList<Billes>();
			List<Billes> blist = vendorServiceImp.getAllBilles();
			for (Billes b : blist) {
				int month1 = b.getDate1().getMonth();
				Calendar cal = Calendar.getInstance();
				cal.setTime(b.getDate1());
				int year = cal.get(Calendar.YEAR);

				if (year == 2014 && month_int == month1 + 1) {
					bii_list.add(b);

				}

			}

			ServletContext context = req.getServletContext();

			req.setAttribute("bl", bii_list);
			req.getRequestDispatcher("/WEB-INF/views/view_m.jsp").forward(req,
					resp);
		} else if (uri.endsWith("month_2013")) {
			 
			String page = req.getParameter("page");
			String month = req.getParameter("month");
			int month_int = Integer.parseInt(month);
			System.out.println("monthvalue=" + month_int);
			List<Billes> bii_list = new ArrayList<Billes>();
			List<Billes> blist = vendorServiceImp.getAllBilles();
			for (Billes b : blist) {
				int month1 = b.getDate1().getMonth();
				Calendar cal = Calendar.getInstance();
				cal.setTime(b.getDate1());
				int year = cal.get(Calendar.YEAR);
				if (year == 2013 && month_int == month1 + 1) {
					bii_list.add(b);

				}
			}

			ServletContext context = req.getServletContext();

			req.setAttribute("bl", bii_list);
			req.getRequestDispatcher("/WEB-INF/views/view_m.jsp").forward(req,
					resp);
		} else if (uri.endsWith("month_2012")) {

			String month = req.getParameter("month");
			int month_int = Integer.parseInt(month);
			System.out.println("monthvalue=" + month_int);
			List<Billes> bii_list = new ArrayList<Billes>();
			List<Billes> blist = vendorServiceImp.getAllBilles();
			for (Billes b : blist) {
				int month1 = b.getDate1().getMonth();
				Calendar cal = Calendar.getInstance();
				cal.setTime(b.getDate1());
				int year = cal.get(Calendar.YEAR);

				if (year == 2012 && month_int == month1 + 1) {
					bii_list.add(b);

				}

			}

			ServletContext context = req.getServletContext();

			req.setAttribute("bl", bii_list);
			req.getRequestDispatcher("/WEB-INF/views/view_m.jsp").forward(req,
					resp);
		} else if (uri.endsWith("addbank_v")) {
			String vendor = req.getParameter("vendorName");
			System.out.println(vendor);
			req.setAttribute("vendorname", vendor);
			req.getRequestDispatcher("/WEB-INF/views/addBank_v.jsp").forward(
					req, resp);
		} else if (uri.endsWith("bankadd_n.vms")) {
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
				List<VendorType> list3 = vendorServiceImp.getAllVendorTypes();
				System.out.println(list3);
				req.setAttribute("tlist", list3);
				req.getRequestDispatcher("/WEB-INF/views/addvendor.jsp")
						.forward(req, resp);
			} else {
				resp.sendRedirect("/WEB-INF/views/error.jsp");
			}
		} else if (uri.endsWith("vendor_view")) {
			String vendor = req.getParameter("vendor");
			System.out.println(vendor);
			List<Vendor> vlist = vendorServiceImp.getVendorsByVendorname(vendor);
			List<Bank> blist=vendorServiceImp.getBankdetiles(vendor);
			req.setAttribute("vlist",vlist );
			req.setAttribute("blist", blist);
			System.out.println(blist);
			req.setAttribute("vendor", vendor);
			System.out.println(vlist);
			req.getRequestDispatcher("/WEB-INF/views/searchview_b.jsp").forward(req, resp);

		}else if(uri.endsWith("adduser.vms")){
			req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
		}else if(uri.endsWith("adding.vms")){
			User user =new User();
			user.setName(req.getParameter("name"));
			user.setRole(req.getParameter("role"));
			if(vendorServiceImp.addUser(user)){
				req.getRequestDispatcher("landingpage_vendor").forward(req, resp);
			}else{
				resp.sendRedirect("/WEB-INF/views/error.jsp");
			}
		}

	}
	private void insertCell(PdfPTable table, String text, int align, int colspan, com.itextpdf.text.Font bfBold12){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(text.trim()));
		  //set the cell alignment
		  cell.setHorizontalAlignment(align);
		  //set the cell column span in case you want to merge two or more cells
		  cell.setColspan(colspan);
		  //in case there is no text and you wan to create an empty row
		  if(text.trim().equalsIgnoreCase("")){
		   cell.setMinimumHeight(10f);
		  }
		  //add the call to the table
		  table.addCell(cell);
		   
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
