package com.hgk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hgk.constants.Status;
import com.hgk.entities.Student;
import com.hgk.factory.StudentDaoFactory;
import com.hgk.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student student) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction transaction = null;
		
		try
		{
			
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			StudentDao studentDao = StudentDaoFactory.getInstanceStudentDao();
			
			List<Student> listOfStudents = studentDao.fetchAll();
			
			for(Student stud : listOfStudents)
			{
				if(stud.getName().equals(student.getName()))
				{
					return Status.STUDENT_EXISTS;
				}
			}

			session.save(student);
			transaction.commit();
			return(Status.STUDENT_SAVE_SUCCESS);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
			return Status.STUDENT_SAVE_FAILURE;
		}
		
	}

	@Override
	public List<Student> fetchAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		try(Session session = sessionFactory.openSession())
		{
			@SuppressWarnings("unchecked")
			Query<Student> query = session.createQuery("FROM Student");
			
			
			List<Student> list = query.list();
			
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public String remove(Integer id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		Transaction transaction = null;
		try
		{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery("DELETE FROM Student WHERE rno = "+id);
			
			int status = query.executeUpdate();
			transaction.commit();
			if( status >= 1)
			{
				return Status.STUDENT_REMOVE_SUCCESS;
			}
			else
			{
				return Status.STUDENT_REMOVE_FAILURE;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
			return Status.STUDENT_REMOVE_FAILURE;
		}
	}
	
	@Override
	public List<Student> fetchByName(String name) 
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		try(Session session = sessionFactory.openSession())
		{
		
			@SuppressWarnings("unchecked")
			Query<Student> query = session.createQuery("FROM Student where name LIKE '%"+name+"%'");
			
			
			List<Student> list = query.list();
			
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public List<Student> fetchByCity(String city) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		try(Session session = sessionFactory.openSession())
		{
			@SuppressWarnings("unchecked")
			Query<Student> query = session.createQuery("FROM Student where city LIKE '%"+city+"%'");
					
			List<Student> list = query.list();
			
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Student> fetchByPer(Double per) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		try(Session session = sessionFactory.openSession())
		{
			@SuppressWarnings("unchecked")
			Query<Student> query = session.createQuery("FROM Student where per LIKE '%"+per+"%'");
					
			List<Student> list = query.list();
			
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	

}
