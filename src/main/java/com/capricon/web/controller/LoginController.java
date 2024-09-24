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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LoginController() {
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = new UserDao();
		HttpSession session = request.getSession();
		
		
		 try {
			 
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			User user = new User();
			user.setEmail(email);
			 
			//check if user really exists in the system
			ResultSet result = userDao.checkUser(user);
			
			if(result.next()) {
				
				ResultSet loginSet = userDao.loginUser(user);
				
				if(loginSet.next()) {
					
					String dbPassword = loginSet.getString("Password");
					
					
					if(dbPassword.equals(password)) {
						
						session.setAttribute("email", email);
						response.sendRedirect("home.jsp");
						
					} else {
						
						System.out.println("Wrong Password! Try again");
					}
				} else {
					
					System.out.println("User not registered, please Sign up");
					
				}
				
				
			} 
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
