package com.coding.hibernate.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.coding.hibernate.entity.Employee;

public class CreateEmployeeOperation {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try 
		{
		// configure the hibernate config file
		sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		// create session factory object from the configuration
		// get the session object from factory
		session = sessionFactory.getCurrentSession();
		
		// begin the transaction
		session.beginTransaction();
		
		// create Employee object
		Employee newEmp1 = new Employee("Sumit", "Chandwani", "Twitter", "2022-02-23 09:00:00.000");
		Employee newEmp2 = new Employee("Ravi", "Chandwani", "LinkdenIn", "2022-02-13 09:00:00.000");		
		
		// create an entry into the database
		session.save(newEmp1);
		session.save(newEmp2);		
		
		// commit the transaction
		session.getTransaction().commit();
		
		// clean up the session and factory
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
}
