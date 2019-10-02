<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Climber</title>
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
	<form action="editClimberServlet" method="post">
		<input type="hidden" name="id" value="${climberToEdit.id}">
		First Name:<br />
		<input type="text" name="fName" value="${climberToEdit.fName}"><br />
		Last Name:<br />
		<input type="text" name="lName" value="${climberToEdit.lName}"><br />
		Date of Birth: 
			<input type="text" name="month" value="${dateFields.month}" size="4">
			<input type="text" name="day" value="${dateFields.day}" size="4">
			<input type="text" name="year" value="${dateFields.year}" size="4">
		<input type="submit" value="Edit Climber">
	</form>
	<br />
	<a href="viewAllClimbersServlet">View all Climbers.</a>
</main>
</body>
</html>