<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>

	<div class="container-sm wrapper">
	
		<h4>Welcome to your preferred online shopping site, we offer the best services country wide.</h4>
		
		<div class="form-container">
		
			<form action="signup" method="post">
			
				<div class="input-box">
					<input type="text" name="firstname" id="firstname" placeholder="First Name" required />
				</div>
				
				<div class="input-box">
					<input type="text" name="lastname" id="lastname" placeholder="Last Name" required />
				</div>
				
				<div class="input-box">
					<input type="text" name="email" id="email" placeholder="Email" required />
				</div>
				
				<div class="input-box">
					<input type="password" name="password" id="password" placeholder="Password" required />
				</div>
				
				<div class="input-box">
					<input type="text" name="phone" id="phone" placeholder="Phone Number" required />
				</div>
			
				<input type="submit" value="Sign Up" id="signupBtn" />
			</form>
			
			<p>Already have an account? <a href="login.jsp">Sign In</a></p>
		
		</div>
	
	</div>

</body>
</html>