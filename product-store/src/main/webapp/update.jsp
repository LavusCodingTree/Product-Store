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

	<h1>UPDATE PRODUCT DATA</h1>
	<form:form action="update" modelAttribute="pro">
		Id:<form:input path="id" readonly="true"/><br><br>
		Name: <form:input path="name" /><br><br>
		Brand:<form:input path="brand" /><br><br>
		Price:<form:input path="price" /><br><br>
		Quantity:<form:input path="quantity" /><br><br>

		<form:button>update</form:button>
	</form:form>
	

</body>
</html>