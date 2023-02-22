package com.coding.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

			// create the session
			session = sessionFactory.getCurrentSession();

			System.out.println("Updating the student object...");
			// create a student object
			int studentId = 1;

			// start the transaction
			session.beginTransaction();
			
			// retrieve the student using student id which is primary key
			Student tempStudent = session.get(Student.class, studentId);
			
			// update the field using the methods available from Entity
			tempStudent.setFirstName("Bruce");

			// commit the transaction
			session.getTransaction().commit();
			System.out.println(tempStudent);
			
			// bulk update
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all students
			session.createQuery("update Student set emailAddress='foo@youtube.com'").executeUpdate();			
			
			// commit the transaction
			session.getTransaction().commit();

		} catch (Exception ex) {
			session.close();
			sessionFactory.close();
		}

	}

}
