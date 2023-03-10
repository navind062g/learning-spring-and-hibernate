package com.coding.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coding.springdemo.entity.Customer;

/* Repository annotation is always applied to DAO implementations */
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// need to inject the session factory
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();		
		
		// create a query 
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
				
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

}
