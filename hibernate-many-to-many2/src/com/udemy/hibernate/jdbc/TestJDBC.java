package com.udemy.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String JDBCUrl="jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		try {
			Connection conn=DriverManager.getConnection(JDBCUrl, user, pass);
			System.out.println("connection successfull::::");
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}

		
	}

}
