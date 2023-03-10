package com.code.aopdemo.dao;

import org.springframework.stereotype.Component;
import com.code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
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
