package com.hgk;

import java.io.BufferedReader;
import java.io.FileReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hgk.entities.Student;

public class CSVToDBUsingHibernate 
{
	public static void main(String args[])
	{
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try
		{
			fileReader = new FileReader("src/main/resources/student.csv");
			bufferedReader = new BufferedReader(fileReader);
			
			configuration = new Configuration();
			configuration.configure();
			
			sessionFactory = configuration.buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			transaction = session.beginTransaction();
			
			String line = null;
			
			Student student = null;
			
			while((line = bufferedReader.readLine()) != null)
			{
				String tokens[] = line.split(",");
							
				try
				{
					student = new Student();
					
					student.setRollNumber(Integer.parseInt(tokens[0]));
					student.setName(tokens[1]);
					student.setPercentage(Float.parseFloat(tokens[2]));
					
				}
				catch(Exception e)
				{
					continue;
				}
				
				if((student.getRollNumber() == null)|| (student.getName() == null) || (student.getPercentage() == null))
				{
					continue;
				}
				else
				{
					session.save(student);
				}
			}
			
			transaction.commit();
		}
		catch(Exception e)
		{
			transaction.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
			sessionFactory.close();
		}
		
	}

}