<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Ascent</title>
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
<form method="post" action="updateAscentServlet">
		Ascent date: <input type="text" name="month" value="${dateFields.month}" size="4">
				   <input type="text" name="day" value="${dateFields.day}" size="4">
				   <input type="text" name="year" value="${dateFields.year}" size="4">
		Climbers:<br /> <select name="climber" multiple size="6">
			<c:forEach items="${climbers}" var="currentClimber">
				<option value="${currentClimber.id}">${currentClimber.fName}|
					${currenClimber.lName}</option>
			</c:forEach>
			</select><br />
		Routes:<br /> <select name="route" multiple size="6">
			<c:forEach items="${routes}" var="currentRoute">
				<option value="${currentRoute.id}">${currentRoute.name}|
					${currenRoute.difficulty}</option>
			</c:forEach>
		</select><br />
	<input type="submit" value="Update Ascent">
</form>
</main>
</body>
</html>