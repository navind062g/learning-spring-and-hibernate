package com.coding.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.entity.Instructor;
import com.coding.hibernate.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
			
			// get the instructor detail object
			int theId = 3;
			InstructorDetail tempInsDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("Printing the Instructor Detail: "+tempInsDetail);
			
			// print the associated instructor
			System.out.println("Printing the Instructor: "+tempInsDetail.getInstructor());
			
			//remove the associated object reference
			//break bidirectional link
			tempInsDetail.getInstructor().setInstructorDetail(null);
			session.delete(tempInsDetail);
			
			//commit the transaction
			session.getTransaction().commit();
			
			// print the instructor detail
			System.out.println("Printing after Deleting the Instructor Detail: "+tempInsDetail);
			
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
