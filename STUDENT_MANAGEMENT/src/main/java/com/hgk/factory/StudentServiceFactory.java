package com.hgk.factory;

import com.hgk.service.StudentService;
import com.hgk.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService studentService = null;
	
	private StudentServiceFactory() {}
	
	public static StudentService getInstanceStudentService()
	{
		if(studentService == null)
		{
			studentService = new StudentServiceImpl();
		}
		
		return studentService;
	}
}
