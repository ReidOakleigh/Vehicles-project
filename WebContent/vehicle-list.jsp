<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicle List</title>
<link href="styles.css" rel="stylesheet" />
</head>
<body>
  <h2>Vehicle List</h2>
  <form method="post" action="navigationServlet">
	<table>
		<thead>
			<tr>
				<th>Sel</th>
				<th>Vin ID</th>
				<th>Make</th>
				<th>Model</th>
				<th>Mfg. Date</th>
				<th>Color</th>
				<th>Trans.</th>
				<th class="seats">Seats</th>
				<th class="mpg">MPG</th>
			</tr>
		</thead>
		<tbody>
		  <c:forEach items="${requestScope.vehicles}" var="vehicle">
			<tr>
				<td><input type="radio" name="id" value="${vehicle.vinId}"></td>
				<td class="vinid">${vehicle.vinId}</td>
				<td class="make"> ${vehicle.manufacturer.manufacturerName}</td>
				<td class="model">${vehicle.model}</td>
 				<td class="date"> ${vehicle.manDate}</td>
				<td class="color">${vehicle.color}</td>
				<td class="trans">${vehicle.trans}</td>
				<td class="seats">${vehicle.seats}</td>
				<td class="mpg">  ${vehicle.mpg}</td>
			</tr>
		  </c:forEach>
		</tbody>
	</table>
	<input type="submit" value="edit"   name="editVehicle">
	<input type="submit" value="delete" name="deleteVehicle">
  </form>
  <br/>
  <a href="index.html">Main Menu</a>
</body>
</html>