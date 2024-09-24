package com.capricon.web.model;

public class Product {
	
	private int productId;
	private String title;
	private String description;
	private String imageUrl;
	private String category;
	private double price;
	
	
	
	
	public Product() {
		super();
		
	}


	public Product(int productId,  String title, String description, String category, double price,  String imageUrl) {
		super();
		this.productId = productId;
		this.category = category;
		this.price = price;
		this.title = title;
		this.description = description;
		this.imageUrl = imageUrl;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	

}
