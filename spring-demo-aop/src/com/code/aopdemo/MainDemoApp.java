package com.code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aopdemo.dao.AccountDAO;
import com.code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read the spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);		
		
		// call the business method
		Account account = new Account();
		theAccountDAO.addAccount(account, true);
		theAccountDAO.getDetails();
		
		System.out.println("\n Testing it again!!! \n");
		
		// get the bean from the spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		theMembershipDAO.addSillyMember();
		theMembershipDAO.getMembershipNumber(account);

		// close the context
		context.close();

	}

}
