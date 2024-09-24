package com.capricon.web.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capricon.web.model.User;

public class UserDao {
	
	DBHandler handler = new DBHandler();
	
	//check if user exists in the system
	public ResultSet checkUser(User user) throws ClassNotFoundException, SQLException {
		ResultSet result = null;
		
		String checkUser = "select * from users where Email = ?";
		
		PreparedStatement checkStatement = handler.connection().prepareStatement(checkUser);
		checkStatement.setString(1, user.getEmail());
		
		result = checkStatement.executeQuery();
		
		return result;
	}
	
	
	//create user
	public int createUser(User user) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		
		String userSql = "insert into users values (?, ?, ?, ?, ?)";
		
		//prepare statement
		PreparedStatement userStatement = handler.connection().prepareStatement(userSql);
		userStatement.setString(1, user.getFirstname());
		userStatement.setString(2, user.getLastname());
		userStatement.setString(3, user.getEmail());
		userStatement.setString(4, user.getPassword());
		userStatement.setInt(5, user.getPhone());
		
		result = userStatement.executeUpdate();
		
		
		return result;
	}
	
	
	//log in user
	public ResultSet loginUser(User user) throws ClassNotFoundException, SQLException {
		ResultSet result = null;
		
		
		String loginSql = "select Password from users where Email = ?";
		
		PreparedStatement loginStatement = handler.connection().prepareStatement(loginSql);
		loginStatement.setString(1, user.getEmail());
		
		result = loginStatement.executeQuery();
		
		
		return result;
	}
	
	//save payment details
	public int payDetails(String email,  String address, String city, String creditCard) throws ClassNotFoundException, SQLException {
		int result = 0;
		
		//insert statement
		String paySql = "insert into paydetails values(?, ?, ?, ?)";
		
		//prepare statement
		PreparedStatement payStatement = handler.connection().prepareStatement(paySql);
		payStatement.setString(1, email);
		payStatement.setString(2, city);
		payStatement.setString(3, address);
		payStatement.setString(4, creditCard);
		
		result = payStatement.executeUpdate();
		
		return result;
	}

}

























