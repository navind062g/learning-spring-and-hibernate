package com.code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		// read the spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);		
		List<Account> theAccounts = null;
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		// print the results and display the accounts
		System.out.println("\n\nMain Program: AfterFinallyDemoApp.");
		System.out.println("============");
		System.out.println(theAccounts);
		
		System.out.println("\n");

		// close the context
		context.close();

	}

}
