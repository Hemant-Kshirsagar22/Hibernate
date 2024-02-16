package com.hgk;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;

import com.hgk.entities.Student;

public class SERToCSV 
{

	public static void main(String[] args) 
	{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		RandomAccessFile fw = null;
		try
		{
			fis = new FileInputStream("resources/student.ser");
			ois = new ObjectInputStream(fis);
			
			fw = new RandomAccessFile("resources/studentOne.csv","rw");
			
			Student s = null;
			
			while((s = (Student)ois.readObject()) != null)
			{				
				String line = s.getRno() + "," + s.getName() + "," + s.getPer()	+ "\n";
				
				fw.writeBytes(line);
			}
		}
		catch(Exception e)
		{
			if(e instanceof EOFException)
			{
				System.out.println("Data Decentralized Successfully !!!");
			}
			else
			{
				e.printStackTrace();
			}
		}
		finally
		{
			try
			{
				fw.close();
				ois.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
		}
	}

}