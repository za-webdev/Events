<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome,${user.firstName}</h1> 
	<a href="/logout">Log Out</a>
	<a href="/admin/info">Settings</a>
	
	<h3>Here are some of the events</h3>
	
	<table border=1>
		<tr>
			<th>Name</th>
			<th>Date</th>
			<th>Location</th>
			<th>Host</th>
			<th>Action</th>
		
		</tr>
			 <c:forEach items="${allEvents}" var="eve">
		<tr>
			<td><a href="/show/${eve.id}">${eve.name}</a></td>
			<td> <fmt:formatDate pattern = "MMMM dd',' yyyy" value="${eve.date}"/></td>
			<td>${eve.location}</td>
			<td>${eve.uploader.firstName}</td>
			<td>
				<c:if test="${user.id == eve.uploader.id}">
				<a href="/edit/${eve.id}"><button>Edit</button></a>
				<a href="/delete/${eve.id}"><button>Delete</button></a>
				</c:if>
				<form action="/join" method="get">
					<input type="hidden" name="user_id" value="${user.id}">
					<input type="hidden" name="event_id" value="${eve.id}">
					<input type="submit" value="join">
				</form>
				
			</td>
		
		</tr>
			
            </c:forEach>
	</table>
	
	<fieldset>
	
		<legend>Create an Event</legend>
		<form:form method="POST" action="/new/event" modelAttribute="event">
			 <form:label path="name">Name:
			    <form:input path="name"/>
			    <form:errors path="name"/>
		    </form:label><br>
		    
		    <form:label path="date">Date:
			    <form:input type="date" path="date"/>
			    <form:errors path="date"/>
		    </form:label><br>
		    
		    <form:label path="location">Location:
			    <form:input path="location"/>
			    <form:errors path="location"/>
			 </form:label><br> 
			<input type="hidden" name="uploader" value="${user.id}"/>
			<input type="submit" value= "Add"/>
		     
		</form:form>
	
	</fieldset>
</body>
</html>