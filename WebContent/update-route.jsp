<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglibprefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Route</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<main>
	<form action="editRouteServlet" method="post">
		<input type="hidden" name="id" value="${routeToEdit.id}">
		Name:<br />
		<input type="text" name="name" value="${routeToEdit.name}"><br />
		Difficulty:<br />
		<input type="text" name="difficulty" value="${routeToEdit.difficulty}"><br />
		Completed: 
		<c:choose>
			<c:when test="${routeToEdit.completed}">
				<input type="checkbox" name="completed" checked>
			</c:when>
			<c:otherwise>
				<input type="checkbox" name="completed">
			</c:otherwise>
		</c:choose><br />
		<input type="submit" value="Edit Route">
	</form>
	<br />
	<a href="viewAllRoutesServlet">View all routes.</a>
</main>
</body>
</html>