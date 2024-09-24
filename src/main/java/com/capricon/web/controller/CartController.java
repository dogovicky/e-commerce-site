package com.capricon.web.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capricon.web.dao.ProductDao;
import com.capricon.web.model.CartItem;
import com.capricon.web.model.Product;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		HttpSession session = request.getSession();
		List<Product> cart = (List<Product>) session.getAttribute("cart");
		
		if(cart == null) {
			cart = new ArrayList<Product>();
		}
		
		String action = request.getParameter("action");
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		//boolean found = false;
		/*for(CartItem item : cart) {
			if (item.getProduct().getProductId() == productId) {
                item.setQuantity(item.getQuantity() + 1);
                found = true;
                break;
            }
		}*/
		
			
			if("add".equals(action)) {
				 
				try {
					
					Product product = findProductById(productId);
					cart.add(product);
					
				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				}
				
			} 
				
				
				
			

		session.setAttribute("cart", cart);
		response.sendRedirect("cart.jsp");
	}
	
	public Product findProductById(int productId) throws ClassNotFoundException, SQLException {
		Product product = null;
		
		ProductDao productDao = new ProductDao();
		ResultSet result = productDao.getProduct(productId);
		if(result.next()) {
			String title = result.getString("Title");
			String description = result.getString("Description");
			String imageUrl = result.getString("ImageUrl");
			String category= result.getString("Category");
			double price = result.getDouble("Price");
			
			product = new Product(productId, title, description, category, price, imageUrl);
		}
		
		return product;
		
	}

}
