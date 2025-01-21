package com.hgk;

import java.io.IOException;
import java.io.PrintWriter;

import com.hgk.constants.HTMLConsts;
import com.hgk.constants.Status;
import com.hgk.entities.Student;
import com.hgk.factory.StudentServiceFactory;
import com.hgk.service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = null;
		Double per = null;
		String city = null;
		try
		{
			name = request.getParameter("name");
			per = Double.parseDouble(request.getParameter("per"));
			city = request.getParameter("city");
			
			String tokens[] = name.split(" ");
			
			if(tokens.length <= 2 || tokens.length > 3)
			{
				request.getRequestDispatcher("./mainNav.html").include(request, response);
				
				out.println(addStudentHtml(HTMLConsts.ALERT_MSG_FOR_NAME, HTMLConsts.ALERT_WARNING));
				
				return;
			}
			
			if(per > 100 || per < 0)
			{
				request.getRequestDispatcher("./mainNav.html").include(request, response);
				
				out.println(addStudentHtml(HTMLConsts.ALERT_MSG_FOR_PERCENTAGE, HTMLConsts.ALERT_WARNING));
				
				return;
			}
		}
		catch (Exception e) 
		{
			request.getRequestDispatcher("./mainNav.html").include(request, response);
			out.println(addStudentHtml(HTMLConsts.ALERT_MSG_FOR_CORRECT_INPUT, HTMLConsts.ALERT_WARNING));
			
			return;
		}
		String status = addStudent(name, per, city);

		if(status == Status.STUDENT_SAVE_SUCCESS)
		{	
			request.getRequestDispatcher("./mainNav.html").include(request, response);

			out.println(addStudentHtml(HTMLConsts.ALERT_MSG_FOR_DATA_ADDED_SUCCESS, HTMLConsts.ALERT_SUCCESS));
		}
		else if(status == Status.STUDENT_SAVE_FAILURE)
		{
			
			request.getRequestDispatcher("./mainNav.html").include(request, response);
			
			out.println(addStudentHtml(HTMLConsts.ALERT_MSG_FOR_DATA_ADDED_FAILURE, HTMLConsts.ALERT_DANGER));
			
		}
		else if(status == Status.STUDENT_EXISTS)
		{
			request.getRequestDispatcher("./mainNav.html").include(request, response);
			
			out.println(addStudentHtml(HTMLConsts.ALERT_MSG_FOR_DATA_EXISTS, HTMLConsts.ALERT_WARNING));
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("./mainNav.html").include(request, response);
		out.println(addStudentHtml("", ""));
	}
	
	public static String addStudent(String name,Double per,String city)
	{
		StudentService studentService = null;
		
		try
		{			
			Student student = new Student();
			
			student.setName(name);
			student.setCity(city);
			student.setPer(per);
			studentService = StudentServiceFactory.getInstanceStudentService();
					
			return studentService.addStudent(student);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public static String addStudentHtml(String msg,String htmlAlert)
	{
		
		return("<html lang=\"en\">\r\n"
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
				+ "  <jsp:include page=\"./mainNav.html\" /> \r\n"
				+ "  \r\n"
				+ "  <div class=\"container border border-success w-75 p-3 align-items-center\" style =\"margin-top:75px;\">\r\n"
				+ "  <h2 class=\"center-container\">ADD STUDENT</h2><br>\r\n"
				+ "	  	<div class=\"col-md-12 center-container fs-5\">\r\n"
				+ "	  		\r\n"
				+ "			<form method=\"post\" action=\"./AddStudent\" class=\"w-50\">\r\n"
				+ "<div class=\""+ htmlAlert +"\" role=\"alert\">\r\n"
				+ msg
				+ "</div>"
				+ "		  		<div class=\"mb-3\">\r\n"
				+ "				  <label for=\"name\" class=\"form-label\">Enter Your Name</label>\r\n"
				+ "				  <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" required>\r\n"
				+ "				</div>\r\n"
				+ "				\r\n"
				+ "				<div class=\"mb-3\">\r\n"
				+ "				  <label for=\"per\" class=\"form-label\">Enter Your Percentage</label>\r\n"
				+ "				  <input type=\"text\" class=\"form-control\" id=\"per\" name=\"per\" required>\r\n"
				+ "				</div>\r\n"
				+ "				\r\n"
				+ "				<div class=\"mb-3\">\r\n"
				+ "				  <label for=\"city\" class=\"form-label\">Enter Your City</label>\r\n"
				+ "				  <input type=\"text\" class=\"form-control\" id=\"city\" name=\"city\" required>\r\n"
				+ "				</div>\r\n"
				+ "				<input class=\"btn btn-outline-success w-100\" type=\"submit\" value=\"ADD STUDENT\">\r\n"
				+ "		  	</form>\r\n"
				+ "	  	</div>\r\n"
				+ "	</div>\r\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\r\n"
				+ "  </body>\r\n"
				+ "</html>");
		
	}

}
