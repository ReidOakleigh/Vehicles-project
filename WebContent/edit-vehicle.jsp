<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sports Teams</title>
</head>
<body>
	<form action="updateTeam" method="post">
		City: <input type="text" name="city" value="${team.city}"><br /> 
		Name: <input type="text" name="name" value="${team.name}"><br /> 
		League: ${league} <br/><br/>
<%-- 	    Available Leagues:<br /> 
	    	<select name="sport" size="6">
			<c:forEach items="${requestScope.allLeagues}" var="league">
				<option value="${league.sport}" ${league.sport eq teamToEdit.league.sport ? 'selected' : ''}>${league.sport}</option>
			</c:forEach>
		</select> <br /> 
 --%>		
 		<input type="hidden" name="id" value="${team.id}">
		<input type="submit" value="Update Team">
	</form>
	<br/>
	<a href="index.html">Main Menu</a>
</body>
</html>