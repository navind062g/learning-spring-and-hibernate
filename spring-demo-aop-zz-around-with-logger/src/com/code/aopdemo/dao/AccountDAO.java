package com.code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	// add a new method: findAccounts()
	
	public List<Account> findAccounts(boolean tripWire) {
		
		// simulating an exception
		if(tripWire) {
			throw new RuntimeException("No Accounts found!"); 
		}
		List<Account> myAccounts = new ArrayList<Account>();
		
		// create sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	public void addAccount(Account theAccount, boolean isVIP) {
		System.out.println(getClass()+" : Doing my db work - Adding an Account");
	}
	
	public boolean printDetails() {
		System.out.println(getClass()+" : Doing my db work - Getting the details.");
		return true;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName() ");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName() ");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode() ");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode() ");
		this.serviceCode = serviceCode;
	}

}
