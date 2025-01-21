package com.hgk.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hgk.config.HibernateConfig;

public class HibernateUtil 
{
	private static SessionFactory sessionFactory = null;
	
	private HibernateUtil() {}
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory == null)
		{
			try
			{
//				
//				 Method 1:
				 
				 Configuration configuration = new Configuration();
				 configuration.configure(HibernateConfig.FILE_NAME);
				 sessionFactory = configuration.buildSessionFactory();
				 /* 
				 * Method 2:
				 * 
				 * sessionFactory = new Configuration()
				 * 					.configure(HibernateConfig.FILE_NAME)
				 * 					.buildSessionFactory();
				 * 
				 * Method 3:
				 * 
					sessionFactory = new Configuration().configure(HibernateConfig.FILE_NAME).buildSessionFactory();
				*/
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
		}
		return sessionFactory;		
	}
	
	public static void closeSessionFactory()
	{
		if(sessionFactory != null)
		{
			sessionFactory.close();
		}
	}
}
