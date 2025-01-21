package com.hgk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.hgk.constants.HTMLConsts;
import com.hgk.constants.Status;
import com.hgk.entities.Student;
import com.hgk.factory.StudentServiceFactory;
import com.hgk.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		StudentService studentService = StudentServiceFactory.getInstanceStudentService();
		
		List<Student> listOfStudents = studentService.fetchAllStudents();
		
		
		if(listOfStudents.isEmpty())
		{
			request.getRequestDispatcher("./mainNav.html").include(request, response);
			out.println(studentTableEmptyHtml(HTMLConsts.ALERT_MSG_STUDENT_NOT_FOUND));
			return;
		}
		request.getRequestDispatcher("./mainNav.html").include(request, response);
		out.println(removeStudentForHtml(listOfStudents));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		StudentService studentService = StudentServiceFactory.getInstanceStudentService();
		
		List<Student> listOfStudents = null;
		
		listOfStudents = studentService.fetchAllStudents();
		request.getRequestDispatcher("./mainNav.html").include(request, response);
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		
		request.getRequestDispatcher("./mainNav.html").include(request, response);
		
		if(rno == -1)
		{
			out.println(removeStudentForHtml(HTMLConsts.ALERT_MSG_SELECT_STUDENT_TO_REMOVE, HTMLConsts.ALERT_WARNING,listOfStudents));
		}
		else
		{
			String status = studentService.removeStudent(rno);
			
			if(status == Status.STUDENT_REMOVE_SUCCESS)
			{
				listOfStudents = studentService.fetchAllStudents();
				
				if(listOfStudents.isEmpty())
				{
					out.println(studentTableEmptyHtml(HTMLConsts.ALERT_MSG_STUDENT_NOT_FOUND));
					return;
				}
				
				out.println(removeStudentForHtml(HTMLConsts.ALERT_MSG_REMOVE_SUCCESS,HTMLConsts.ALERT_SUCCESS ,listOfStudents));
			}
			else if(status == Status.STUDENT_REMOVE_FAILURE)
			{
				listOfStudents = studentService.fetchAllStudents();
				
				if(listOfStudents.isEmpty())
				{
					out.println(studentTableEmptyHtml(HTMLConsts.ALERT_MSG_STUDENT_NOT_FOUND));
					return;
				}
				out.println(removeStudentForHtml(HTMLConsts.ALERT_MSG_REMOVE_FAILED, HTMLConsts.ALERT_DANGER,listOfStudents));
			}
			
		}
	}
	
	public static String studentTableEmptyHtml(String msg)
	{
		return("<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "    <title>DISPLAY STUDENT</title>\r\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n"
				+ "    <link rel=\"stylesheet\" type=\"text/css\" href=\"./src/css/home.css\">\r\n"
				+ "<style type=\"text/css\">\r\n"
				+ "	    .center-container \r\n"
				+ "	    {\r\n"
				+ "	      display: flex;\r\n"
				+ "	      justify-content: center;\r\n"
				+ "	      align-items: center;\r\n"
				+ "	    }\r\n"
				+ "	    \r\n"
				+ "    </style>"
				+ "  </head>"				
				+ "  <body>"
				+ "<div class=\"container align-items-center\" style =\"margin-top:75px; width:80%;\">  	\r\n"
				+ "<h1>"+msg+"</h1>"
				+ "	</div>"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\r\n"
				+ "  </body>\r\n"
				+ "</html>");
	}

	public static String removeStudentForHtml(List<Student> listOfStudents)
	{
		String msg ="<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "    <title>ADD STUDENT</title>\r\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n"
				+ "    \r\n"
				+ "    <style type=\"text/css\">\r\n"
				+ "	    .center-container \r\n"
				+ "	    {\r\n"
				+ "	      display: flex;\r\n"
				+ "	      justify-content: center;\r\n"
				+ "	      align-items: center;\r\n"
				+ "	    }\r\n"
				+ "	    \r\n"
				+ "    </style>\r\n"
				+ "  </head>\r\n"
				+ "  <body>\r\n"
				+ "  \r\n"
				+ "  <div class=\"container border border-danger w-75 p-3 align-items-center\" style =\"margin-top:75px;\">\r\n"
				+ "  <h2 class=\"center-container\">REMOVE STUDENT</h2><br>\r\n"
				+ "	  	<div class=\"col-md-12 center-container fs-5\">"
				+ "    <form action=\"./RemoveStudent\" method=\"post\" class=\"w-75\">\r\n"
				+ "      <div class=\"input-group\">\r\n"
				+ "  <select class=\"form-select\" name=\"rno\">\r\n"
				+ "    <option selected value=\"-1\">Choose...</option>\r\n";
		for(Student student : listOfStudents)
		{
			msg = msg + "<option value=\""+student.getRno()+"\">"+student.getName()+"</option>";
		}
		
		msg = msg + "  </select>\r\n"
				+ "  <button class=\"btn btn-outline-danger\" type=\"submit\">REMOVE</button>\r\n"
				+ "</div>\r\n"
				+ "    </form>\r\n</div></div>"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\r\n"
				+ "  </body>\r\n"
				+ "</html>";
		
		return msg;
	}

	public static String removeStudentForHtml(String removeMsg,String alert,List<Student> listOfStudents)
	{
		String msg = "<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "    <title>REMOVE STUDENT</title>\r\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\r\n"
				+ "  </head>\r\n"
				+ "<style type=\"text/css\">\r\n"
				+ "	    .center-container \r\n"
				+ "	    {\r\n"
				+ "	      display: flex;\r\n"
				+ "	      justify-content: center;\r\n"
				+ "	      align-items: center;\r\n"
				+ "	    }\r\n"
				+ "	    \r\n"
				+ "    </style>"
				+ "  <body>\r\n"
				+ "<div class=\"container border border-danger w-75 p-3 align-items-center\" style =\"margin-top:75px;\">\r\n"
				+ "  <h2 class=\"center-container\">REMOVE STUDENT</h2><br>\r\n"
				+ "	  	<div class=\"col-md-12 center-container fs-5\">"
				+ "    <form action=\"./RemoveStudent\" method=\"post\" class=\"w-75\">\r\n"
				+ "<div class=\""+alert+"\" role=\"alert\">\r\n"
				+ removeMsg
				+ "</div>"
				+ "      <div class=\"input-group\">\r\n"
				+ "  <select class=\"form-select\" name=\"rno\">\r\n"
				+ "    <option selected value=\"-1\">Choose...</option>\r\n";
		
		
		for(Student student : listOfStudents)
		{
			msg = msg + "<option value=\""+student.getRno()+"\">"+student.getName()+"</option>";
		}
		
		msg = msg + "  </select>\r\n"
				+ "  <button class=\"btn btn-outline-danger\" type=\"submit\">REMOVE</button>\r\n"
				+ "</div>\r\n"
				+ "    </form>\r\n</div></div>"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\r\n"
				+ "  </body>\r\n"
				+ "</html>";
		return msg;
	}
}
