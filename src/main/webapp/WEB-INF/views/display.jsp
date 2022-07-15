<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
</head>
<body>

	<h2>PRODUCT DETAILS:</h2>
	<table border="1px solid black" width="100%">
	<tr>
		<th>PID</th>
		<th>PNAME</th>
		<th>PRICE</th>
		
	</tr>
	<c:forEach items="${list}" var="product">
				<tr>
						<td>${product.pid}</td>
						<td>${product.pname}</td>
						<td>${product.price}</td>
				</tr>
	
	</c:forEach>
	</table>
</body>
</html>