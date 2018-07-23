<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Displaying Event</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<h1>${event.name}</h1>
	<h3>Host: ${event.uploader.firstName}</h3>
	<h3>Date:<fmt:formatDate pattern = "MMMM dd',' yyyy" value="${event.date}"/></h3>
	<h3>Location: ${event.location}</h3>
	
	
	<div class="msg_box">
		<c:forEach items="${event.messages}" var="msg">
			<p>${msg.viewer.firstName} says: ${msg.comment}</p>
		</c:forEach>
	
	</div>
	
	<div class="event_box">
		<c:forEach items="${event.attendees}" var="person">
			<p>${person.firstName} from  ${person.location}</p>
		</c:forEach>
	
	</div>
	
	<form:form method="POST" action="/msg/${event.id}" modelAttribute="message">
		<form:label path="comment">Add a comment here:
			  <form:input path="comment"/>
			  <form:errors path="comment"/>
		 </form:label><br>
		
		 <input type="hidden" name="event" value="${event.id}"/>
		 <input type="hidden" name="viewer" value="${user.id}"/>
		 
		  <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>