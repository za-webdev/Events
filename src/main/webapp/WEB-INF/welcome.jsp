<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome</h1>
	
	<fieldset>
		<legend>Register</legend>
		<form action="/register" method="post">
		
			FirstName:<input type="text" name="firstName">
			<p>${errors.firstName}</p>
			LastName:<input type="text" name="lastName">
			<p>${errors.lastName}</p>
			Email:<input type="text" name="email">
			<p>${errors.email}</p>
			Location:<input type="text" name="location">
			<p>${errors.location}</p>
			Password:<input type="password" name="password">
			<p>${errors.password}</p>
			Confirm Password:<input type="password" name="confirm">
			<p>${errors.confirm}</p>
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
			<input type="submit" value="Register">
		</form>
	
	</fieldset>

	<fieldset>
		<legend>Login</legend>
	
		<form action="/login" method="post">
			<p>${loginErr}</p>
			Email:<input type="text" name="email"><br>
			Password:<input type="password" name="password"><br>
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
			<input type="submit" value="Login">
		</form>
	</fieldset>
	
</body>
</html>