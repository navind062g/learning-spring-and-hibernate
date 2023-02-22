package com.coding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String userName = "hbstudent";
		String password = "hbstudent";
		Connection myConn = null;
		try {
			System.out.println("Connection to the database: "+jdbcUrl);
			
			myConn = DriverManager.getConnection(jdbcUrl, userName, password);
			
			System.out.println("Connection Successfull!");
			
			myConn.close();			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
