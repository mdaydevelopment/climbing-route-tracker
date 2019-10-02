<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ascent</title>
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
<form method="post" action="addAscentServlet">
		Climber: ${climber.fName} ${climber.lName}<br />
					<input type="hidden" name="climberId" value="${climber.id}">
		Ascent date: <input type="text" name="month" placeholder="MM" size="4">
				   <input type="text" name="day" placeholder="DD" size="4">
				   <input type="text" name="year" placeholder="YYYY" size="4">
		Routes:<br /> <select name="route" multiple size="6">
			<c:forEach items="${routes}" var="currentRoute">
				<option value="${currentRoute.id}">${currentRoute.name}|
					${currenRoute.difficulty}</option>
			</c:forEach>
		</select><br />
	<input type="submit" value="Add Ascent">
</form>
</main>
</body>
</html>