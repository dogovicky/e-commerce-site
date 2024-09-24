<%@page import="java.util.ArrayList"%>
<%@page import="com.capricon.web.model.Product"%>
<%@page import="com.capricon.web.model.CartItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	
	List<Product> cart = (List<Product>) session.getAttribute("cart");
	double totalAmount = 0;

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Best Buy: Cart</title>
<link rel="stylesheet" href="styles/cart.css" />
</head>
<body>

	<div class="container">
		<h4 class="title">Your Cart Items</h4>
		
		<div class="cart-container">
		
			<c:if test="${cart != null && !cart.isEmpty() }">
			
				<ul class="cart-products">
				
					<c:forEach var="product" items="${cart}">
					
						<li>
							<div class="img-container">
								<img src="${product.imageUrl}" alt="${product.title}" />
							</div>
							<div class="details">
								<h4>${product.title}</h4>
								<span>${product.category}</span>
								<h4>$${product.price}</h4>
								<a href="CartController?action=remove&productId=${product.productId}">Delete</a>
							</div>
							
						</li>
					</c:forEach>
					
				</ul>
				
				<div>Total: $${totalAMount} USD</div>
			</c:if>
			<a href="checkout.jsp">Place Order</a>
		
		</div>
	
	</div>

</body>
</html>