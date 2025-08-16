package com.hgk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.hgk.constants.HTMLConsts;
import com.hgk.entities.Student;
import com.hgk.factory.StudentServiceFactory;
import com.hgk.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String selectOption = request.getParameter("selectOption");
		
		List<Student> listOfStudents = null;
		if(selectOption.equals("name"))
		{
		
			String name = request.getParameter("name");
			listOfStudents = searchByName(name);

			if(listOfStudents.isEmpty())
			{
				request.getRequestDispatcher("./mainNav.html").include(request, response);
				
				out.println(studentNotFoundHtml(HTMLConsts.ALERT_MSG_STUDENT_NOT_FOUND));
			}
			else
			{
				request.getRequestDispatcher("./mainNav.html").include(request, response);
				out.println(studentFoundHtml(listOfStudents));
			}
		}
		else if(selectOption.equals("city"))
		{
			String city = request.getParameter("city");
			listOfStudents = searchByCity(city);
			
			if(listOfStudents.isEmpty())
			{
				request.getRequestDispatcher("./mainNav.html").include(request, response);
				
				out.println(studentNotFoundHtml(HTMLConsts.ALERT_MSG_STUDENT_NOT_FOUND));
			}
			else
			{
				request.getRequestDispatcher("./mainNav.html").include(request, response);
				out.println(studentFoundHtml(listOfStudents));
			}
			
		}
		else if(selectOption.equals("per"))
		{
			Double per = Double.parseDouble(request.getParameter("per"));
			listOfStudents = searchByPer(per);
			
			if(listOfStudents.isEmpty())
			{
				request.getRequestDispatcher("./mainNav.html").include(request, response);
				
				out.println(studentNotFoundHtml(HTMLConsts.ALERT_MSG_STUDENT_NOT_FOUND));
			}
			else
			{
				request.getRequestDispatcher("./mainNav.html").include(request, response);
				out.println(studentFoundHtml(listOfStudents));
			}
		}	
		
		
	}
	
	public static List<Student> searchByName(String name)
	{
		StudentService studentService = StudentServiceFactory.getInstanceStudentService();
		return studentService.fetchStudentByName(name);
	}

	public static List<Student> searchByCity(String city)
	{
		StudentService studentService = StudentServiceFactory.getInstanceStudentService();
		return studentService.fetchStudentByCity(city);
	}

	public static List<Student> searchByPer(Double per)
	{
		StudentService studentService = StudentServiceFactory.getInstanceStudentService();
		return studentService.fetchStudentByPer(per);
	}
	
	public static String studentNotFoundHtml(String msg)
	{
		return("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "    <title>SEARCH STUDENT</title>\r\n"
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
				+ "\r\n"
				+ "  \r\n"
				+ "  <div class=\"container border border-success w-75 p-3 align-items-center\" style =\"margin-top:75px;\">\r\n"
				+ "  <h2 class=\"center-container\">SEARCH STUDENT</h2><br>\r\n"
				+ "	  	<div class=\"col-md-12 center-container fs-5\">\r\n"
				+ "	  		\r\n"
				+ "			<form method=\"post\" action=\"./SearchStudent\" class=\"w-50\" >\r\n"
				+ "                <div id=\"msg\">\r\n"
				+ 						"<div class=\"alert alert-danger\" role=\"alert\">\r\n"
				+	msg
				+ 					"</div>"
				+ "                </div>\r\n"
				+ "			 	<div class=\"mb-3\">\r\n"
				+ "				  <label for=\"selectOption\" class=\"form-label\">Select Search Option</label>\r\n"
				+ "                    <select class=\"form-control custom-select\" id=\"selectOption\" onchange=\"select()\" name=\"selectOption\">\r\n"
				+ "                    <option value=\"\" selected>Choose...</option>\r\n"
				+ "                    <option value=\"name\">By Name</option>\r\n"
				+ "                    <option value=\"city\">By City</option>\r\n"
				+ "                    <option value=\"per\">By per</option>\r\n"
				+ "                    </select>\r\n"
				+ "                    \r\n"
				+ "				</div>\r\n"
				+ "\r\n"
				+ "				<div id=\"inputField\"></div>\r\n"
				+ "				<input class=\"btn btn-outline-success w-100\" type=\"submit\" id=\"btn\" value=\"SEARCH\" disabled>\r\n"
				+ "		  	</form>\r\n"
				+ "	  	</div>\r\n"
				+ "	</div>\r\n"
				+ "	<script type=\"text/javascript\" src=\"./src/js/searchStudent.js\"></script>\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\r\n"
				+ "  </body>\r\n"
				+ "</html>");
	}

	public static String studentFoundHtml(List<Student> listOfStudents)
	{
		String msg ="<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "    <title>SEARCH STUDENT</title>\r\n"
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
				+ "\r\n"
				+ "<jsp:include page=\"./mainNav.html\"></jsp:include>\r\n"
				+ "  \r\n"
				+ "  <div class=\"container border border-success w-75 p-3 align-items-center\" style =\"margin-top:75px;\">\r\n"
				+ "  <h2 class=\"center-container\">SEARCH STUDENT</h2><br>\r\n"
				+ "	  	<div class=\"col-md-12 center-container fs-5\">\r\n"
				+ "	  		\r\n"
				+ "			<form method=\"post\" action=\"./SearchStudent\" class=\"w-50\" >\r\n"
				+ "                <div id=\"msg\">\r\n"
				+ "                </div>\r\n"
				+ "			 	<div class=\"mb-3\">\r\n"
				+ "				  <label for=\"selectOption\" class=\"form-label\">Select Search Option</label>\r\n"
				+ "                    <select class=\"form-control custom-select\" id=\"selectOption\" onchange=\"select()\" name=\"selectOption\">\r\n"
				+ "                    <option value=\"\" selected>Choose...</option>\r\n"
				+ "                    <option value=\"name\">By Name</option>\r\n"
				+ "                    <option value=\"city\">By City</option>\r\n"
				+ "                    <option value=\"per\">By per</option>\r\n"
				+ "                    </select>\r\n"
				+ "                    \r\n"
				+ "				</div>\r\n"
				+ "\r\n"
				+ "				<div id=\"inputField\"></div>\r\n"
				+ "				<input class=\"btn btn-outline-success w-100\" type=\"submit\" id=\"btn\" value=\"SEARCH\" disabled>\r\n"
				+ "		  	</form>\r\n</div>"
				+ "<table class=\"table table-hover table-dark \" style=\"text-align: center;\">\r\n"
				+ "  <thead>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope=\"col\">ROLL NO</th>\r\n"
				+ "      <th scope=\"col\">NAME</th>\r\n"
				+ "      <th scope=\"col\">PERCENTAGE</th>\r\n"
				+ "      <th scope=\"col\">CITY</th>\r\n"
				+ "    </tr>\r\n"
				+ "  </thead>\r\n"
				+ "  <tbody>\r\n";
		
		for(Student student : listOfStudents)
		{
			msg = msg + "    <tr>\r\n"
				+ "		 <th scope=\"row\">"+student.getRno()+"</th>\r\n"
				+ "      <td>"+student.getName()+"</td>\r\n"
				+ "      <td>"+student.getPer()+"</td>\r\n"
				+ "      <td>"+student.getCity()+"</td>\r\n"
				+ "</tr>";
		}
		
				msg = msg + "  </tbody>\r\n"
						+ "</table>" 
				+ "	</div>\r\n"
				+ "	<script type=\"text/javascript\" src=\"./src/js/searchStudent.js\"></script>\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\r\n"
				+ "  </body>\r\n"
				+ "</html>";
		
		return msg;
	}
}
