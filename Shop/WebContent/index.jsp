<%@ page import = "shop.connection.DbConnection" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<title>Welcome to Shop</title>
	<%@include file = "includes/header.jsp" %>
</head>

<body>
	<%@include file = "includes/navbar.jsp" %>
	
	<% DbConnection.getConnection();  %>
	
	<%@include file = "includes/footer.jsp" %>
</body>
</html>