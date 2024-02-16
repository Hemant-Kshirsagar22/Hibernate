package com.hgk;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;

import com.hgk.entities.Student;

public class CSVToSER 
{
	public static void main(String[] args) 
	{
		FileReader fr = null;
		BufferedReader br = null;
		FileOutputStream fob = null;
		ObjectOutputStream oos = null;
		
		try
		{
			fr = new FileReader("resources/student.csv");
			br = new BufferedReader(fr);	
			
			String line = null;
			
			fob = new FileOutputStream("resources/student.ser");
			oos = new ObjectOutputStream(fob);
			
			while((line = br.readLine()) != null)
			{
				String tokens[] = line.split(",");
				
				if(tokens.length < 3)
				{	
					continue;
				}
				
				Student s = new Student();
				
				s.setRno(Integer.parseInt(tokens[0]));
				s.setName(tokens[1]);
				s.setPer(Float.parseFloat(tokens[2]));
				
				oos.writeObject(s);
				
				System.out.println("Serialize Successfully !!!");
				
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
				oos.close();
				br.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
