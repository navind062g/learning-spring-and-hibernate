package com.coding.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.entity.Course;
import com.coding.hibernate.entity.Instructor;
import com.coding.hibernate.entity.InstructorDetail;

public class GetCourseReviewDemo {

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
			
			// create some courses
			Course tempCourse1 = new Course("Supernatural - The VR Gym");
			Course tempCourse2 = new Course("The Pinball Masterclass");
			
			// add courses to instructor
			theInstructor.addCourse(tempCourse1);
			theInstructor.addCourse(tempCourse2);
			
			// save the instructor
			System.out.println("Saving the Courses...");
			
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
