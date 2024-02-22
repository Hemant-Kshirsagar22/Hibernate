package com.hgk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hgk.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction = null;
        
        try
        {
        	transaction = session.beginTransaction();
        	Student student = new Student();
        	student.setRollNumber(101);
        	student.setName("Hemant");
        	student.setPercentage(89.77f);
        	
        	session.save(student);

        	transaction.commit();
        }
        catch(Exception e)
        {
        	transaction.rollback();     
        }
        finally
        {
        	session.close();
            sessionFactory.close();
        }
                
        System.out.println("First Hibernate Program !!!");
        
                
    }
}
