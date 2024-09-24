package com.capricon.web.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capricon.web.dao.UserDao;
import com.capricon.web.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SignUpController() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = new UserDao();
		
		//get parameters
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int phone = Integer.parseInt(request.getParameter("phone"));
		
		User user = new User();
		user.setEmail(email);
		
		
		try {
			
			ResultSet set = userDao.checkUser(user);
			
			if(set.next()) {
				
				System.out.println("User already registered in the system! Try logging in");
				
			} else {
				
				user = new User(firstname, lastname, email, password, phone);
				int result = userDao.createUser(user);
				if(result == 1) {
					response.sendRedirect("home.jsp");
				} else {
					System.out.println("Failed to sign up user");
				}
				
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
