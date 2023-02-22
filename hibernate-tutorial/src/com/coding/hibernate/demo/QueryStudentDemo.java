package com.coding.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		
		// create the session factory
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = null;
		
		try 
		{
			// create the session
			session = sessionFactory.getCurrentSession();
			
			//start the transaction
			session.beginTransaction();
			
			// query students
			List<Student> studentsList = session.createQuery("from Student").getResultList();
			System.out.println("\nPrinting All the Students");
			displayStudents(studentsList);
			
			// query students: lastName is Doe
			studentsList = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
			
			System.out.println("\nPrinting Students whose lastName is Doe");
			displayStudents(studentsList);
			
			// query students whose lastName is Doe or firstName is Daffy
			studentsList = session.createQuery("from Student s "
					+ "where s.lastName = 'Doe' OR s.firstName='Daffy'")
					.getResultList();
			
			displayStudents(studentsList);
			
			// query students with email like youtube.com
			studentsList = session.createQuery("from Student s where"
					+ " s.email like 'youtube.com'").getResultList();
			
			displayStudents(studentsList);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		catch(Exception ex) {
			session.close();
			sessionFactory.close();
		}
	}
	
	private static void displayStudents(List<Student> studentsList) {
		for(Student tempStudent : studentsList) {
			System.out.println(tempStudent);
		}
	}

}
