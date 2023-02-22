package com.coding.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.entity.Course;
import com.coding.hibernate.entity.Instructor;
import com.coding.hibernate.entity.InstructorDetail;
import com.coding.hibernate.entity.Review;

public class GetCourseAndReviewDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = new Configuration().configure()
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class)
					.buildSessionFactory();
			// create the session
			session = sessionFactory.getCurrentSession();

			// start the transaction
			session.beginTransaction();

			// get the course
			int theId = 13;
			Course tempCourse = session.get(Course.class, theId);
			
			// print the course
			System.out.println("Printing the Courses...");
			System.out.println(tempCourse.toString());
			
			// print the course reviews
			System.out.println(tempCourse.getReviews().toString());
			
			// commit the transaction
			session.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (session != null) {
			session.close();
			sessionFactory.close();
		}
	}
}
