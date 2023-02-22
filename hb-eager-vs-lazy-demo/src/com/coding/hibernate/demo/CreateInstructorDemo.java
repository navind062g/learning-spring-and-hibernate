package com.coding.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.entity.Course;
import com.coding.hibernate.entity.Instructor;
import com.coding.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

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
					.addAnnotatedClass(Course.class)
					.buildSessionFactory();
			// create the session
			session = sessionFactory.getCurrentSession();
			
			// use the session object to save Java Object
			System.out.println("Creating new Instructor and Detail object...");
			
			// use the session object to save Java Object
			Instructor tempInstructor = new Instructor("Maxmillan", "Acamind",
			  "max@udemy.com");
			
			InstructorDetail tempInsDetail = new InstructorDetail("https://www.youtube.com/@academind",
			  "React JS"); tempInstructor.setInstructorDetail(tempInsDetail);
			 
			//start the transaction
			session.beginTransaction();
			
			// save the instructor
			System.out.println("Saving the Instructor...");
			session.save(tempInstructor);
			
			//commit the transaction
			session.getTransaction().commit();
			
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
