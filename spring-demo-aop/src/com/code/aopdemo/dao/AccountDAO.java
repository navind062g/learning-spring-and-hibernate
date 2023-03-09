package com.code.aopdemo.dao;

import org.springframework.stereotype.Component;
import com.code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount, boolean isVIP) {
		System.out.println(getClass()+" : Doing my db work - Adding an Account");
	}
	
	public boolean getDetails() {
		System.out.println(getClass()+" : Doing my db work - Getting the details.");
		return true;
	}
}
