package com.code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.dao.AccountDAO;
import com.code.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// read the spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);		
		
		// call the method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		// print the results and display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp.");
		System.out.println("============");
		System.out.println(theAccounts);

		// close the context
		context.close();

	}

}
