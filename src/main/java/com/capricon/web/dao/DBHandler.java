package com.capricon.web.dao;

import java.sql.*;

public class DBHandler {
	
	 public Connection connection() throws ClassNotFoundException, SQLException {
		 Connection conn = null;
		 
		 
		 String dbUser = "root";
		 String dbPass = "";
		 String dbName = "commercesite";
		 String dbPath = "jdbc:mysql://localhost:3306/" + dbName;
		 
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 conn = DriverManager.getConnection(dbPath, dbUser, dbPass);
		 
		 return conn;
	 }

}
