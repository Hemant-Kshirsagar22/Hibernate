package com.hgk;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.hgk.entities.Student;

public class SERToCSV 
{

	public static void main(String[] args) 
	{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
			
		try
		{
			fis = new FileInputStream("resources/student.ser");
			ois = new ObjectInputStream(fis);
			
			Student s = null;
			
			while((s = (Student)ois.readObject()) != null)
			{				
				
				System.out.println(s);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ois.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
		}
	}

}
