<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>PRODUCTS TABLE</h1>
	<table border="10px">
		<tr>
			<th>PRODUCT_ID</th>
			<th>PRODUCT_NAME</th>
			<th>PRODUCT_BRAND</th>
			<th>PRODUCT_PRICE</th>
			<th>PRODUCT_QUANTITY</th>
			<th>DELETE</th>
			<th>UPDATE</th>
		</tr>

		<c:forEach var="p" items="${data}">
			<tr>
				<td>${p.getId()}</td>
				<td>${p.getName()}</td>
				<td>${p.getBrand()}</td>
				<td>${p.getPrice()}</td>
				<td>${p.getQuantity()}</td>
				<td><a href="delete?id=${p.getId()}">Delete</a></td>
				<td><a href="edit?id=${p.getId()}">Update</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>