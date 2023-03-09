package com.code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Component
public class MembershipDAO {

	public boolean addSillyMember() {
		System.out.println(getClass()+" : Doing subscription: Adding a membership Account");
		return true;
	}
	
	public void getMembershipNumber(Account account) {
		System.out.println(getClass()+" : Here is Membership Number"+Math.random());
	}
}
