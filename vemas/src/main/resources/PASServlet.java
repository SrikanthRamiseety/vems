package com.spaneos.pas.web;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("*.do")
public class PASServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "C:/Desktop/upload";

	private String filePath;
	private static final int BUFSIZE = 4096;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();

		if (uri.endsWith("login.do")) {
			request.getRequestDispatcher("homepage.jsp").forward(request,
					response);
		} else if (uri.endsWith("homepage.do")) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else if (uri.endsWith("sdetails.do")) {
			request.getRequestDispatcher("studentenrollment.jsp").forward(
					request, response);
		} else if (uri.endsWith("sresume.do")) {
			request.getRequestDispatcher("StudentResume.jsp").forward(request,
					response);
		} else if (uri.endsWith("cresume.do")) {
			request.getRequestDispatcher("CounsolorDetail.jsp").forward(
					request, response);
		} else if (uri.endsWith("report.do")) {
			request.getRequestDispatcher("report.jsp").forward(request,
					response);
		} else if (uri.endsWith("cdetails.do")) {
			request.getRequestDispatcher("cdetails.jsp").forward(request,
					response);
		} else if (uri.endsWith("studentassessment.do")) {
			request.getRequestDispatcher("studentassessment.jsp").forward(
					request, response);
		} else if (uri.endsWith("screening.do")) {
			request.getRequestDispatcher("screening.jsp").forward(request,
					response);
		} else if (uri.endsWith("upload.do")) {

			String u = request.getParameter("upload");
			//System.out.println(u);
			if (ServletFileUpload.isMultipartContent(request)) {
				//System.out.println("some");
				try {
					List<FileItem> multiparts = new ServletFileUpload(
							new DiskFileItemFactory()).parseRequest(request);

					for (FileItem item : multiparts) {
						if (!item.isFormField()) {
							String name = new File(item.getName()).getName();
							item.write(new File(UPLOAD_DIRECTORY
									+ File.separator + name));
						}
					}

					// File uploaded successfully
					request.setAttribute("message",
							"File Uploaded Successfully");
				} catch (Exception ex) {
					request.setAttribute("message",
							"File Upload Failed due to " + ex);
				}

			} else {
				request.setAttribute("message",
						"Sorry this Servlet only handles file upload request");
			}
			request.getRequestDispatcher("result.jsp").forward(request,
					response);
		}  else if (uri.endsWith("filelist.do")){
			try {
				 response.setContentType("application/json");
			        response.setCharacterEncoding("UTF-8");
			        
			        File pdfFolder = new File("C:\Users\Srikanth.Lakshman\upload");
			        
			        List<String> list=new ArrayList<String>();
			        for (File pdf : pdfFolder.listFiles()) { // Line 27
			            list.add(pdf.getName());
			        }
			        request.setAttribute("list", list);
			        request.getRequestDispatcher("filelist.jsp").forward(request, response);
			    } catch (Exception e) {
			      e.printStackTrace();
			    }
		}else if (uri.endsWith("download.do")) {
			
			String file1=request.getParameter("filename");
			filePath = "C:/Users/sony/Desktop/upload/"+file1.trim();
			File file = new File(filePath);
			int length = 0;
			ServletOutputStream outStream = response.getOutputStream();
			ServletContext context = getServletConfig().getServletContext();
			String mimetype = context.getMimeType(filePath);

			// sets response content type
			if (mimetype == null) {
				mimetype = "application/octet-stream";
			}
			response.setContentType(mimetype);
			response.setContentLength((int) file.length());
			String fileName = file.getName();

			// sets HTTP header
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ fileName + "\"");

			byte[] byteBuffer = new byte[BUFSIZE];
			DataInputStream in = new DataInputStream(new FileInputStream(file));

			// reads the file's bytes and writes them to the response stream
			while ((in != null) && ((length = in.read(byteBuffer)) != -1)) {
				outStream.write(byteBuffer, 0, length);
			}

			in.close();
			outStream.close();
		} else if (uri.endsWith("filedelete.do")){
			try {
				 response.setContentType("application/json");
			        response.setCharacterEncoding("UTF-8");
			        
			        File pdfFolder = new File("C:/Users/sony/Desktop/upload");
			        
			        List<String> list=new ArrayList<String>();
			        for (File pdf : pdfFolder.listFiles()) { // Line 27
			            list.add(pdf.getName());
			        }
			        request.setAttribute("list", list);
			        request.getRequestDispatcher("filedelete.jsp").forward(request, response);
			    } catch (Exception e) {
			      e.printStackTrace();
			    }
		}else if (uri.endsWith("delete.do")) {
			String file1=request.getParameter("filename");
			File deleteFile = new File("C:/Users/sony/Desktop/upload"+file1.trim());
			// check if the file present or not
			try {
				if (deleteFile.exists())
				{
					deleteFile.delete();
				request.setAttribute("message", "File Deleted Successfully");
				}
				else {
					request.setAttribute("message",
							"Sorry there is no file to delete");
				}
			} catch (Exception ex) {
				request.setAttribute("message", "File deletion Failed due to "
						+ ex);
			}
			
			request.getRequestDispatcher("deletemessage.jsp").forward(request,
					response);

		}

	}

}
