<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Vehicle</title>
</head>
<body>
	<form action="addVehicleServlet" method="post">
		<label>Make</label><br/>
		<input class="make"  type="text" name="make"><br/>
		<label>Model</label><br/>
		<input class="model" type="text" name="model"><br/>
		<label>Mfg. Date (yyyy/mm/dd)</label><br/>
		<input class="date"  type="text" name="date"><br/>
		<label>Color</label><br/>
		<input class="color" type="text" name="color"><br/>
		<label>Trans. (auto/manual)</label><br/>
		<input class="trans" type="text" name="trans"><br/>
		<label>Seats</label><br/>
		<input class="seats" type="text" name="seats"><br/>
		<label>MPG</label><br/>
		<input class="mpg"   type="text" name="mpg"><br/>
	
		<input type="submit" value="Add Vehicle">
	</form>
	<br/>
	<a href="index.html">Main Menu</a>
</body>
</html>
