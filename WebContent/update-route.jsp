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
<nav>
	<ul>
	<li><a href="index.html">Home</a></li>
	<li><a href="viewAllClimbersServlet">Climbers</a></li>
	<li><a href="viewAllRoutesServlet">Routes</a></li>
	<li><a href="new-climber.html">Add Climber</a></li>
	<li><a href="new-route.html">Add Route</a></li>
	</ul>
</nav>
<main>
	<form action="editRouteServlet" method="post">
		<input type="hidden" name="id" value="${routeToEdit.id}">
		Name:<br />
		<input type="text" name="name" value="${routeToEdit.name}"><br />
		Difficulty:<br />
		<input type="text" name="difficulty" value="${routeToEdit.difficulty}"><br />
		Notes:<br />
		<input type="text" name="notes" value="${routeToEdit.notes}"><br />
		<input type="submit" value="Edit Route">
	</form>
	<br />
	<a href="viewAllRoutesServlet">View all routes.</a>
</main>
</body>
</html>