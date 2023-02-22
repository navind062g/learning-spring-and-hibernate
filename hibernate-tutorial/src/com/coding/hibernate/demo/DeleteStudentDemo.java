package com.coding.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create the session factory
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

			// create the session
			session = sessionFactory.getCurrentSession();
			/*
			// create a student object
			int studentId = 1;

			// start the transaction
			session.beginTransaction();
			
			// retrieve the student using student id which is primary key
			Student tempStudent = session.get(Student.class, studentId);
			
			// Delete the student
			System.out.println("\n Deleting the student: "+tempStudent);
			session.delete(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// deleting the objects using query approach
			session = sessionFactory.getCurrentSession();*/
			session.beginTransaction();
			
			// update email for all students
			session.createQuery("delete from Student where id=2").executeUpdate();			
			
			// commit the transaction
			session.getTransaction().commit();

		} catch (Exception ex) {
			session.close();
			sessionFactory.close();
		}

	}

}
