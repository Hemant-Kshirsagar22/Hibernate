package com.hgk;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.hgk.entities.Student;

public class Serialization 
{

	public static void main(String[] args) 
	{
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try
		{
			fos = new FileOutputStream("resources/student.ser");
			oos = new ObjectOutputStream(fos);
			
			Student s = new Student();
			
			s.setRno(101);
			s.setName("Hemant");
			s.setPer(89.76f);
			
			oos.writeObject(s);
			
			System.out.println("Student Object Serialization Successfully !!!");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				oos.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
