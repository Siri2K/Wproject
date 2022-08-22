<%-- Setup Pages Imports --%>
<%@ page import = "shop.connection.DbConnection" %>
<%@ page import = "shop.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%-- Setup auth variable --%>
<% 
	User auth = (User)request.getSession().getAttribute("auth");
	
	// Check auth
	if(auth != null)
	{
		request.setAttribute("auth", auth);
	}
%>

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