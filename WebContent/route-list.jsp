<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglibprefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Route List</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allRoutes}" var="route">
				<tr>
					<td><input type="radio" name="id" value="${route.id}"></td>
					<td>${route.name}</td>
					<td>${route.difficulty}</td>
					<td>
						<c:choose>
							<c:when test="${route.completed}">Sent</c:when>
							<c:otherwise>Unsent</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThis">
		<input type="submit" value="delete" name="doThis">
		<input type="submit" value="add" name="doThis">
	</form>
</body>
</html>