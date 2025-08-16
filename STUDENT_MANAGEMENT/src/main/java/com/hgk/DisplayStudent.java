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

public class DisplayStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		StudentService studentService = StudentServiceFactory.getInstanceStudentService();
		List<Student> listOfStudents = studentService.fetchAllStudents();
		
		request.getRequestDispatcher("./mainNav.html").include(request, response);
		
		if(listOfStudents.isEmpty())
		{
			out.println(studentTableEmptyHtml(HTMLConsts.ALERT_MSG_STUDENT_NOT_FOUND));
		}
		else
		{
			out.println(displayStudentHtml(listOfStudents));
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

	public static String displayStudentHtml(List<Student> listOfStudents)
	{
		String msg = "<!doctype html>\r\n"
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
				+ "<div style =\"margin-top:75px; width:90%; margin-left:5%;\">\r\n"
				+ "  <h2 class=\"center-container\">STUDENTS</h2><br>\r\n"
				+ "	  	<div class=\"center-container fs-5\"><div>"
				+ "<table class=\"table table-hover table-dark \" style=\"text-align: center;\">\r\n"
				+ "  <thead>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope=\"col\">ROLL NO</th>\r\n"
				+ "      <th scope=\"col\">NAME</th>\r\n"
				+ "      <th scope=\"col\">PERCENTAGE</th>\r\n"
				+ "      <th scope=\"col\">CITY</th>\r\n"
				+ "      <th scope=\"col\">CREATE DATE</th>\r\n"
				+ "      <th scope=\"col\">UPDATE DATE</th>\r\n"
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
				+ "      <td>"+student.getDateCreated()+"</td>\r\n"
				+ "      <td>"+student.getLastUpdated()+"</td>\r\n"
				+ "</tr>";
		}
		
		msg = msg + "  </tbody>\r\n"
				+ "</table></div>"
				+ "	</div></div>"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\r\n"
				+ "  </body>\r\n"
				+ "</html>";
		return msg;
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
}

