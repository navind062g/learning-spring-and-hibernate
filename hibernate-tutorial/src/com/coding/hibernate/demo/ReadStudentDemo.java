package com.coding.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create the session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try 
		{
			// create the session
			Session session = sessionFactory.getCurrentSession();
			
			// use the session object to save Java Object
			System.out.println("Creating new student object...");
			// create a student object
			Student tempStudent = new Student("Code", "Ninja", "codeninja@youtube.com");
			
			//start the transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
		}
		catch(Exception ex) {
			sessionFactory.close();
		}
		
	}



}
