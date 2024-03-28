package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;
import com.tca.entities.StudentCompositeKey;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.configure();  // load & parse cfg.xml file
       
       SessionFactory sessionFactory = configuration.buildSessionFactory();
       
       Session session = sessionFactory.openSession();
       Transaction txn = session.beginTransaction();
   
       /* Code to add record */
   
       
//       Student sob = new Student();
//       sob.setFname("AAAAA");
//       sob.setLname("BBBB");
//       sob.setCity("Delhi");
     
//        session.save(sob);
       
          
       /* Code to display record */
       
       StudentCompositeKey ck =  new StudentCompositeKey(); // ck="Sachin-Tendulkar"
       ck.setFname("AAAAA");
       ck.setLname("BBBB");
       
       
       Student sob =(Student) session.get(Student.class, ck);  // id, city
       
       System.out.println("CITY : " + sob.getCity());
          
        
        System.out.println("Record Saved Successfully !!");
       	txn.commit();
             
       session.close();
       sessionFactory.close();
    }
}
