package com.coding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestEmployeeJDBC {

	public static void main(String[] args) {
		// setup the jdbc url
		String jdbcUrl = null;
		String userName = null;
		String password = null;
		Connection conn = null;
		boolean isSuccess = false;
		try 
		{
			jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
			userName = "hbstudent";
			password = "hbstudent";
			//connect to the database
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			
			isSuccess = (conn != null) ? true : false;
			
			if(isSuccess) {
				System.out.println("Connection Successfull!!!");
				conn.close();
			}
			else {
				System.out.println("Connection Error");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
