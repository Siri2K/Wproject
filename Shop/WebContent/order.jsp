<%-- Setup Page Imports from Java --%>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "java.util.List" %>
<%@ page import= "java.text.DecimalFormat" %>

<%-- Setup shop Imports --%>
<%@ page import = "shop.connection.DbConnection" %>
<%@ page import = "shop.model.*" %>
<%@ page import = "shop.dao.*" %>

<%-- Configure Page --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
	//Setup User
	User auth = (User)request.getSession().getAttribute("auth");
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
	
	<%@include file = "includes/footer.jsp" %>
</body>
	
</html>