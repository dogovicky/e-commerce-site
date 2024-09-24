package com.capricon.web.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capricon.web.model.Product;

public class ProductDao {
	
	DBHandler handler = new DBHandler();
	
	//save products to database
	/*public void saveProducts(Product product) throws ClassNotFoundException, SQLException {
		
		String saveSql = "insert into products values(?, ?, ?, ?, ?, ?)";
		
		//prepare statement
		PreparedStatement saveStatement = handler.connection().prepareStatement(saveSql);
		saveStatement.setInt(1, product.getProductId());
		saveStatement.setString(2, product.getTitle());
		saveStatement.setString(3, product.getDescription());
		saveStatement.setString(4, product.getImageUrl());
		saveStatement.setString(5, product.getCategory());
		saveStatement.setDouble(6, product.getPrice());
		
		
		saveStatement.executeUpdate();
	}*/
	
	
	//fetch products
	public ResultSet fetchProducts() throws ClassNotFoundException, SQLException {
		ResultSet set = null;
		
		String fetchSql = "select * from products";
		
		PreparedStatement fetchStatement = handler.connection().prepareStatement(fetchSql);
		set = fetchStatement.executeQuery();
		
		return set;
		
	}
	
	//get product by id
	public ResultSet getProduct(int productId) throws ClassNotFoundException, SQLException {
		ResultSet result = null;
		
		//sql string
		String getSql = "select * from products where ProductId = ?";
		
		//prepare statement
		PreparedStatement getStatement = handler.connection().prepareStatement(getSql);
		getStatement.setInt(1, productId);
		
		result = getStatement.executeQuery();
		
		
		return result;
	}
	
	
	//save order details
	public int[] saveOrder( double orderId, int productId, int quantity) throws ClassNotFoundException, SQLException {
		int[] result = {};
		
		String saveSql = "insert into orderedItems values(?, ?, ?)";
		
		PreparedStatement saveState = handler.connection().prepareStatement(saveSql);
		saveState.setDouble(1, orderId);
		saveState.setInt(2, productId);
		saveState.setInt(3, quantity);
		saveState.addBatch();
		
		result = saveState.executeBatch();
		
		return result;
	}
	

}











































