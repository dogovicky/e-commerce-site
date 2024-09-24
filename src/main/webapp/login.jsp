<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
</head>
<body>

	<div class="container">
	
		<h4>Login to access your account</h4>
		
		<div class="form-container">
		
			<form action="login" method="get">
			
				<div class="input-box">
					
					<input type="email" name="email" id="email" placeholder="Email" required />
				
				</div>
				
				<div class="input-box">
					
					<input type="password" name="password" id="password" placeholder="password" required />
				
				</div>
				
				<input type="submit" value="Login" id="loginBtn" />
			
			</form>
			
			<p>Don't have an account yet? <a href="signup.jsp">Sign Up</a></p>
		
		</div>
	
	</div>

</body>
</html>