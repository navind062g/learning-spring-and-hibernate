package com.coding.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.entity.Course;
import com.coding.hibernate.entity.Instructor;
import com.coding.hibernate.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			Instructor theInstructor = session.get(Instructor.class, instructorId);
			
			System.out.println("Instructor: "+theInstructor);
			
			List<Course> courses = theInstructor.getCourses();
			
			System.out.println("Courses: "+courses);
			
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
