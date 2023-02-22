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

public class AddCoursesForMaryDemo {

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
			session = sessionFactory.getCurrentSession();
			
			// start the transaction
			Transaction transaction = session.beginTransaction();

			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("\nLoaded the Student: "+tempStudent);
			System.out.println("\nCourses: "+tempStudent.getCourses());
			
			
			// create some more courses
			Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
			Course tempCourse2 = new Course("Atari 2600 - Game Development");
			
			//add student to the courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
