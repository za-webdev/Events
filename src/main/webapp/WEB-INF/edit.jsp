<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Edit an event</title>
</head>
<body>
	<h1>${myEvent.name}</h1>
	
	
		<form:form method="POST" action="/update/${event.id}" modelAttribute="event">
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
			 <input type="submit" value="Edit">
		</form:form>

</body>
</html>