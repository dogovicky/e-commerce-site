package com.capricon.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capricon.web.dao.ProductDao;
import com.capricon.web.model.Product;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@WebServlet("/getproducts")
public class ProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductsController() {
        // TODO Auto-generated constructor stub
    }


	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		HttpSession session = request.getSession();
		ProductDao productDao = new ProductDao();
		
		//fetch products from API
		String apiUrl = "https://fakestoreapi.com/products";
		HttpURLConnection connection = null;
		List<Product> products = new ArrayList<>();
		
		
		try {
			
			URL url = new URL(apiUrl);
	        connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");
	        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
	        JsonArray productArray = JsonParser.parseReader(reader).getAsJsonArray();
			
	        //parse the product Json and store in array list
	        for(JsonElement productElement : productArray) {
	        	
	        	JsonObject productJson = productElement.getAsJsonObject();
	        	int id = productJson.get("id").getAsInt();
	        	String title = productJson.get("title").getAsString();
                String description = productJson.get("description").getAsString();
                double price = productJson.get("price").getAsDouble();
                String imageUrl = productJson.get("image").getAsString();
                String category = productJson.get("category").getAsString();
                
                Product product = new Product(id, title, description, category, price, imageUrl);
                products.add(product);
                
                
	        	
	        }
	        
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/*for(Product p : products) {
        	try {
				productDao.saveProducts(p);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
        }*/
		
		request.setAttribute("products", products);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}























