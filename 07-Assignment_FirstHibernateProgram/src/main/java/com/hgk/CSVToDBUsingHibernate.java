package com.hgk;

import java.io.BufferedReader;
import java.io.FileReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hgk.entities.Student;

public class CSVToDBUsingHibernate {

	public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction = null;
        
        FileReader fileReader = null;
		BufferedReader br = null;
        try
        {
        	fileReader =  new FileReader("src/main/resources/student.csv");
			br = new BufferedReader(fileReader);
			String line = null;

			
        	while((line = br.readLine()) != null)
			{
        		
				String token[] = line.split(",");
			
				if(token.length < 3)
				{
					continue;
				}

				Student student = new Student();
	        	student.setRollNumber(Integer.parseInt(token[0]));
	        	student.setName(token[1]);
	        	student.setPercentage(Float.parseFloat(token[2]));
	        	System.out.println(student);
	        	try
	        	{
	        		transaction = session.beginTransaction();
	        		session.save(student);
	        		transaction.commit();
	        	}
	        	catch(Exception e)
	        	{
	        		transaction.rollback();
	        		e.printStackTrace();
	        	}
	        	
	        	
	        	
			}

        	
        }
        catch(Exception e)
        {
        	 e.printStackTrace();
        }
        finally
        {
        	session.close();
            sessionFactory.close();
            
        }
                       
    }

}
