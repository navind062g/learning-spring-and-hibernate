package com.coding.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.entity.Course;
import com.coding.hibernate.entity.Instructor;
import com.coding.hibernate.entity.InstructorDetail;
import com.coding.hibernate.entity.Review;
import com.coding.hibernate.entity.Student;

public class DeletePacmanCourseDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class)
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
			// create the session
			/*
			 * session = sessionFactory.getCurrentSession();
			 * 
			 * // start the transaction Transaction transaction =
			 * session.beginTransaction();
			 * 
			 * // get the pacman course from the database int courseId = 10; Course
			 * tempCourse = session.get(Course.class, courseId);
			 * 
			 * // delete the course System.out.println("Deleting the course: "+tempCourse);
			 * 
			 * session.delete(tempCourse);
			 * 
			 * // commit the transaction transaction.commit();
			 */
			
			// create the session
			session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();

			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("\nLoaded the Student: "+tempStudent);
			System.out.println("\nCourses: "+tempStudent.getCourses());
			
			
			// commit the transaction
			transaction.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (session != null) {
			session.close();
			sessionFactory.close();
		}
	}
}
