package com.prowings.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BikeHibernateApi 
{

	private static SessionFactory factory = null;
	public static SessionFactory getFactory()
	{
		if(factory == null)
			factory = new Configuration().configure().buildSessionFactory();
			return factory;
	}
	
	public static void main(String[] args) 
	{
		
		System.out.println("-----------Hibernate Singlton Project Started----------");
		
		SessionFactory factory1 = null;
		Session session = null;
		
		Bike b1 = new Bike("RoyalEnfield", 1.75f);
		Bike b2 = new Bike("Hornate", 2.32f);
		
		try {
			
			factory1 = getFactory();
			
			session = factory1.openSession();
			
			System.out.println("In try block...");
			
			Transaction tx = session.beginTransaction();
			
			session.save(b1);
			session.save(b2);
			
			tx.commit();
		
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Some Exception occured....");
		}
		finally {
			session.close();
			System.out.println("session closed");
			factory1.close();
			System.out.println("factory1 closed");
		}
		
		System.out.println("--------Table created in database successfully-------");
		
	}
}
