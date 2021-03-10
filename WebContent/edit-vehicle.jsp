<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Vehicle</title>
</head>
<body>
<h2>Edit Vehicle</h2>
	<form action="editVehicle" method="post">
		<label>Make</label><br/>
		<div class="make"> ${vehicle.manufacturer.manufacturerName}</div>
		<label>Model</label><br/>
		<input class="model" type="text"   name="model" value="${vehicle.model}"><br /> 
		<label>Mfg. Date (yyyy/mm/dd)</label><br/>
		<input class="date"  type="text"   name="date"  value="${vehicle.manDate}"><br/>
		<label>Color</label><br/>
		<input class="color" type="text"   name="color" value="${vehicle.color}"><br/>
		<label>Trans. (auto/manual)</label><br/>
		<input class="trans" type="text"   name="trans" value="${vehicle.trans}"><br/>
		<label>Seats</label><br/>
		<input class="seats" type="text"   name="seats" value="${vehicle.seats}"><br/>
		<label>MPG</label><br/>
		<input class="mpg"   type="text"   name="mpg"   value="${vehicle.mpg}"><br/>
 		<input               type="hidden" name="vinId" value="${vehicle.vinId}">
		
		<input type="submit" value="Update Vehicle">
	</form>
	<br/>
	<a href="index.html">Main Menu</a>
</body>
</html>