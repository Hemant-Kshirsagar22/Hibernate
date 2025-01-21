package com.hgk.factory;

import com.hgk.dao.StudentDao;
import com.hgk.dao.StudentDaoImpl;

public class StudentDaoFactory 
{
	private static StudentDao studentDao = null;
	
	public static StudentDao getInstanceStudentDao()
	{
		if(studentDao == null)
		{
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
		
}
