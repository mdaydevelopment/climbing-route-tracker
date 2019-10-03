<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Climber Ascents</title>
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
<form method="post" action="climberAscentNavigationServlet">
	<input type="hidden" name="climber" value="${climberToEdit.id}">
	<table>
		<tr>
			<td><h2>${climberToEdit.fName} ${climberToEdit.lName}</h2></td>
			<td></td><td></td><td></td>
		</tr>
		<tr><td>Date of Birth: </td><td>${climberToEdit.dob}</td>
			<td></td><td></td><td></td>
		</tr>
		<c:forEach items="${climberToEdit.ascents}" var="currentAscent">
			<tr>
			<td><input type="radio" name="id" value="${currentAscent.id}"></td>
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