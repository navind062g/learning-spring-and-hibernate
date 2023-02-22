package com.coding.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.entity.Course;
import com.coding.hibernate.entity.Instructor;
import com.coding.hibernate.entity.InstructorDetail;

public class DeleteCourseDemo {

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
			
			// get the course
			int courseId = 10;
			
			Course courseToDelete = session.get(Course.class, courseId);
			
			// delete the course
			session.delete(courseToDelete);
			
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
