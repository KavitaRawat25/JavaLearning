package com.crud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/college";
	private static final String USER = "root";
	private static final String PASSWORD= "root";
	
	public static Connection getDBConnect() {
		Connection con = null;
		
		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 		
		return con;
	}
}
