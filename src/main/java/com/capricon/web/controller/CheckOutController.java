package com.capricon.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.capricon.web.dao.ProductDao;
import com.capricon.web.dao.UserDao;
import com.capricon.web.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckOutController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserDao user = new UserDao();
		ProductDao product = new ProductDao();
		
		
		@SuppressWarnings("unchecked")
		List<Product> cart = (List<Product>) session.getAttribute("cart");
		
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String creditCard = request.getParameter("creditCard");
		
		double random = Math.random() * 1000;
		
		try {
			int result = user.payDetails(email, address, city, creditCard);
			if(result == 1) {
				
				/*for(Product p : cart) {
					product.saveOrder(random, p.getProductId(), 1);
				}*/
				
				EmailUtility.sendEmail(email, "Order Confirmation", "Your order has been placed successfully.");
				System.out.println("Order successful");
				session.invalidate();
				response.sendRedirect("home.jsp");
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}


















