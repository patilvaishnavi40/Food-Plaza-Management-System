package com.foodplaza.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility 
{
	public static Connection establishConnection() throws ClassNotFoundException, SQLException
	{
		String hostname,user,password;
		hostname = "jdbc:mysql://localhost:3306/foodplaza_anushka";
		user = "root";
		password = "root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(hostname,user,password);
		
		return conn;
	}
}
