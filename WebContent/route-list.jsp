<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglibprefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Route List</title>
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
	<form method="post" action="routeNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allRoutes}" var="route">
				<tr>
					<td><input type="radio" name="id" value="${route.id}"></td>
					<td>${route.name}</td>
					<td>${route.difficulty}</td>
					<td>${route.notes}</td>
				</tr>
			</c:forEach>
		</table>
		<table>
		<tr>
			<td><input type="submit" value="edit" name="doThis"></td>
			<td><input type="submit" value="delete" name="doThis"></td>
			<td><input type="submit" value="add" name="doThis"></td>
		</tr>
		</table>
	</form>
</main>
</body>
</html>