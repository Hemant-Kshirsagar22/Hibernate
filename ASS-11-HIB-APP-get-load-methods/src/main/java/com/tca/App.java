package com.tca;


import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

public class App 
{
    public static void main( String[] args ) 
    {
    	
    	Configuration configuration = new Configuration();
    	configuration.configure();  // load & parse cfg.xml file
       
       SessionFactory sessionFactory = configuration.buildSessionFactory();
       
       Session session = sessionFactory.openSession();
      
       int rid = 101;
        
       
       try
       {
       	Student ob = (Student) session.load(Student.class, rid);
       	
       	
       	
       	System.out.println("Roll Num : " + ob.getRno());
       	System.out.println("Name     : " + ob.getName());
       	System.out.println("Per      : " + ob.getPer());
       }
       catch(ObjectNotFoundException oe)
       {
    	   System.out.println("No Record Found for Roll Nume : " + rid);
       }
       
       
 /*
   		// Story of get() 
  
       Student ob = (Student) session.get(Student.class, rid); 
       
       System.out.println(ob);
      
       if(ob==null)
       {
    	   System.out.println("No Record Found for Roll Nume : " + rid);
       }
       else
       {
    	   System.out.println("Roll Num : " + ob.getRno());
    	   System.out.println("Name     : " + ob.getName());
    	   System.out.println("Per      : " + ob.getPer());
       }
*/
       
       
       session.close();
       sessionFactory.close();
       
       
    }
}





