package com.coding.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.entity.Course;
import com.coding.hibernate.entity.Instructor;
import com.coding.hibernate.entity.InstructorDetail;
import com.coding.hibernate.entity.Review;
import com.coding.hibernate.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			session.beginTransaction();

			Course theCourse = new Course("Pacman - How to Score One Million Points!!!");
			
			// save the instructor
			System.out.println("Saving the Course...");
			session.save(theCourse);
			System.out.println("Courses saved Successfully!!!");
			
			// create the Students
			Student tempStudent1 = new Student("John", "Doe", "john.doe@internet.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary.public@internet.com");
			
			// add students to the course
			theCourse.addStudent(tempStudent1);
			theCourse.addStudent(tempStudent2);
			
			//saving the students
			System.out.println("Saving the Students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Students saved Successfully!!!");
			
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
