package com.hgk;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.hgk.entities.Student;

public class Deserialization {

	public static void main(String[] args) 
	{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
			
		try
		{
			fis = new FileInputStream("resources/student.ser");
			ois = new ObjectInputStream(fis);
			
			Student s = (Student) ois.readObject();
			
			System.out.println("Deserialized Object : ");
			System.out.println("Roll Number : " + s.getRno());
			System.out.println("Name        : " + s.getName());
			System.out.println("Percentage  : " + s.getPer());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
