package com.coding.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.entity.Instructor;
import com.coding.hibernate.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		
		// create the session factory
		SessionFactory sessionFactory = null;
		Session session = null;
		try 
		{
			sessionFactory = new Configuration()
					.configure()
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Instructor.class)
					.buildSessionFactory();
			// create the session
			session = sessionFactory.getCurrentSession();
			//start the transaction
			session.beginTransaction();
			// use the session object to save Java Object
			System.out.println("Delete Instructor and Detail object...");
			
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found Instructor: "+tempInstructor);
			// delete the instructor
			if(tempInstructor != null) {
				session.delete(tempInstructor);
			}
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		if(session!=null) {
			session.close();
			sessionFactory.close();
		}	
	}
}
