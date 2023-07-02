<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Enter Product Details</h1>
	<form:form action="save" modelAttribute="product">
		Name: <form:input path="name" /><br><br>
		Brand:<form:input path="brand" /><br><br>
		Price:<form:input path="price" /><br><br>
		Quantity:<form:input path="quantity" /><br><br>

		<form:button>save</form:button>
	</form:form>

</body>
</html>