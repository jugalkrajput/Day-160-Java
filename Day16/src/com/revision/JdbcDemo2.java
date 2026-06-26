package com.revision;

import java.sql.*;

import java.util.Scanner;

public class JdbcDemo2 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/JdbcRevision","root","Mysql");
			
			PreparedStatement ps=cn.prepareStatement("insert into students values(?,?,?)");
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter Student ID:");
			String sid=sc.nextLine();
			ps.setString(1, sid);
			
			System.out.print("Enter Student Name:");
			String name=sc.nextLine();
			ps.setString(2, name);
			
			System.out.print("Enter Student Course:");
			String course=sc.nextLine();
			ps.setString(3, course);
			
			ps.executeUpdate();
			System.out.println("Record has been inserted!");
			
			ps.close();
			cn.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
