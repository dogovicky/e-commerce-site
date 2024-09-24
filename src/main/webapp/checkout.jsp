<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Place Order</title>
</head>
<body>

	<h1>Checkout</h1>
    <form action="checkout" method="POST">
    	<label>Email: </label><input type="text" name="email" required /><br />
        <label>City: </label><input type="text" name="city" required /><br />
        <label>Address: </label><input type="text" name="address" required /><br />
        <label>Credit Card: </label><input type="text" name="creditCard" required /><br />
        <button type="submit">Place Order</button>
    </form>

</body>
</html>