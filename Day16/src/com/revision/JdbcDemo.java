package com.revision;

import java.sql.*;

public class JdbcDemo {
	public static void main(String[] args) {
		
		try {
			//1. Load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded!");
			
			//2. Create connection object
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/JdbcRevision","root","Mysql");
			System.out.println("Connection object is created");
			
			//3. Create statement object
			Statement st=cn.createStatement();
			System.out.println("Statement object is created!");
			
			//4. Execute sql query
			st.execute("create table students(sid int primary key,name varchar(30),course varchar(30))");
			System.out.println("SQL query is executed!");
			
			//5. Close resources
			st.close();
			cn.close();
			System.out.println("Resources are closed!");
			
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
