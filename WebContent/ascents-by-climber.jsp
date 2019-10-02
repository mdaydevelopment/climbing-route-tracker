<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ascents by Climber</title>
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
<form method="post" action="allClimbersNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allClimbers}" var="currentClimber">
		<tr>
			<td><input type="radio" name="id" value="${currentClimber.id}"></td>
			<td><h2>${currentClimber.fName} ${currentClimber.lName}</h2></td>
			<td></td><td></td><td></td>
		</tr>
		<tr><td>Date of Birth: </td><td>${currentClimber.dob}</td>
			<td></td><td></td><td></td>
		</tr>
		<c:forEach items="${currentClimber.ascents}" var="currentAscent">
			<tr>
			<td>Ascent Date: </td>
			<td>${currentAscent.date}</td>
			<td>Route Name: </td>
			<td>${currentAscent.route.name}</td>
			<td>Route Difficulty: </td>
			<td>${currentAscent.route.difficulty}</td>
			<td>Route Notes: </td>
			<td>${currentAscent.route.notes}</td>
			</tr>
		</c:forEach>
	</c:forEach>
		<tr>
		<td><input type="submit" value="editClimber" name="doThis"></td>
		<td><input type="submit" value="editAscents" name="doThis"></td>
		<td><input type="submit" value="delete" name="doThis"></td>
		<td><input type="submit" value="add" name="doThis"></td>
		</tr>
	</table>
</form>
</body>
</html>
