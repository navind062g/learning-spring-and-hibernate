package com.coding.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.demo.entity.Student;

public class PrimaryStudentDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
		// configure hibernate to get session factory
		sessionFactory = new Configuration()
							.configure()
							.addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session object from session factory
		session = sessionFactory.getCurrentSession();
		
		// create a student object
		Student student1 = new Student("John", "Doe", "john.doe@youtube.com");
		Student student2 = new Student("Mary", "Public", "marypublic@youtube.com");
		Student student3 = new Student("Bonita", "Applebum", "bonita.apple@youtube.com");
		
		// begin the transaction using session
		session.beginTransaction();
		
		// save the student object
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		// commit the transaction to the database
		session.getTransaction().commit();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			// finally close the session factory object
			if(sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}
}
