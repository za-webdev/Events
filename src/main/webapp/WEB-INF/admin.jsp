<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<title>Only Admin</title>
</head>
<body>
	<h1>Welcome Admin</h1>
	
	<c:forEach items="${allUsers}" var="user">
			<p>${user.firstName} ${user.lastName}</p>
	</c:forEach>
</body>
</html>