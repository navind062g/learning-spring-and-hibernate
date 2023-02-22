package com.coding.hibernate.demo;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.entity.Course;
import com.coding.hibernate.entity.Instructor;
import com.coding.hibernate.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			//start the transaction
			session.beginTransaction();
			
			// get the instructor from the database
			int instructorId = 1;
			
			//option 2: Hibernate Query with HQL
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:theInstructorId"
					, Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", instructorId);
			
			// execute query and get instructor
			Instructor theInstructor = query.getSingleResult();
			
			System.out.println("Printing Instructor: "+theInstructor);

			//commit the transaction
			session.getTransaction().commit();
			session.close();
			
			System.out.println("Printing Courses: "+theInstructor.getCourses());
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		if(session!=null) {
			
			sessionFactory.close();
		}	
	}
}
