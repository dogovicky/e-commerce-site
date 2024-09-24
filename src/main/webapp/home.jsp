<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Best Buy</title>
<link rel="stylesheet" href="styles/home.css"/>

</head>
<body>

	<nav>
	
		<div class="logo">
			<h4>BestBuy</h4>
		</div>
		
		<div class="nav-links">
		
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">Payment Options</a></li>
				<li><a href="#">Contact</a></li>
				<li><a href="cart.jsp">Cart</a></li>
				<li><a href="#">Profile</a></li>
			</ul>
		
		</div>
	
	</nav>
	
	<div class="container">
		
		<div class="filter-container">
		
			<div class="filter-category">
				<form action="getProducts" method="get">
					<span class="category">Category: </span>
					<select name="category">
						<option value="all">All</option>
						<option value="fashion">Fashion</option>
						<option value="electronics">Electronics</option>
						<option value="utensils">Utensils</option>
						<option value="books">Books</option>
					</select>
				</form>
			</div>
			
			<div class="filter">
				<form action="searchproduct">
			
					<input type="text" name="search" value="" placeholder="Search product.." />
					<button type="submit">Search</button>
					
				</form>
			</div>
		
		</div>
		
		<div class="products-container">
		
			<h4 class="title">Our Products</h4>

			<div class="products">
				<c:forEach var="product" items="${products}">
					
					<div class="product-item">
						<div class="img-container">
							<img src= "${product.imageUrl}" alt="${product.title}" />
						</div>
						<h4 class="product-title">${product.title}</h4>
						<!-- <p class="product-desc">${product.description}</p>  -->
						<div class="cart-container">
							<h4 class="price">Price: $${product.price}</h4>
							<a class="cartBtn" href="CartController?action=add&productId=${product.productId}">Add to Cart</a>
						</div>
						
					</div>
					
				</c:forEach>
			</div>
			
		</div>
	
	</div>
	
	<script>
	
		function fetchProducts() {
			
			return "/getproducts";
		}
	
		window.onload(fetchProducts);
	
	</script>

</body>
</html>