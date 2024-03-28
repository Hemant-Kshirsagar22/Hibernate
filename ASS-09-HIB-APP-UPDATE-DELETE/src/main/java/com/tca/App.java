package com.tca;

import org.hibernate.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.tca.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
       Configuration configuration = new Configuration();
       configuration.configure();
       
       SessionFactory sessionFactory = configuration.buildSessionFactory();
       Session session = sessionFactory.openSession();
       
       Transaction transaction = session.beginTransaction();
       
       /* Testing of delete() */
       
       Student student = new Student();
       student.setRno(102);
       
       session.delete(student);
            
       
       /* Testing of update() and saveOrUpdate() */
       
       /*
       Student student = new Student();
       student.setRno(102);
       student.setName("YYY");
       student.setPer(85.00);
       
       // session.update(student);
       
       session.saveOrUpdate(student);
       
       */
       transaction.commit();
       session.close();
       sessionFactory.close();
    }
}
