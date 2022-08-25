<%-- Setup Page Imports from Java --%>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "java.util.List" %>

<%-- Setup Shop Imports --%>
<%@ page import = "shop.connection.DbConnection" %>
<%@ page import = "shop.model.*" %>
<%@ page import = "shop.dao.*" %>

<%-- Configure Page --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%-- Setup User Personal Session --%>
<% 
	User auth = (User)request.getSession().getAttribute("auth");
	
	// Check auth
	if(auth != null)
	{
		response.sendRedirect("index.jsp");
	}
	
	// Get CartList from Session List
	ArrayList<Cart> cartlist = (ArrayList<Cart>) session.getAttribute("cart-list");
	
	if(cartlist !=null)
	{
		request.setAttribute("cart_list",cartlist);
	}
%>

<!DOCTYPE html>
<html>

<head>
	<title>Welcome to Shop</title>
	<%@include file = "includes/header.jsp" %>
</head>

<body>
	<%-- Setup Login Form --%>
	<%@include file = "includes/navbar.jsp" %>
	
	<div class = "container">
		<div class = "card w-50 mx-auto my-5">
			<%-- Setup Card Header --%>
			<div class = "card-header text-center"> User Login </div>
			
			<%-- Setup Card Body --%>
			<div class = "card-body">
				<form action = "user-login" method = "post">
					<%-- Ask for user Email --%>
					<div class = "form-group">
					<label> Email Address </label>
					<input type = "email" class = "form-control" name = "login-email" placeholder = "Enter your Email" required>
					</div>
					
					<%-- Ask for User Password --%>
					<div class = "form-group">
					<label> Password </label>
					<input type = "password" class = "form-control" name = "login-password" placeholder = "*******" required>
					</div>
					
					<%-- Put Login Button --%>
					<div class = "text-center my-5">
					<button type = "submit" class = "btn btn-primary">Login</button>
					</div>
					
				</form>
			</div>
			
			
		</div>
	</div>

	
	<%@include file = "includes/footer.jsp" %>
</body>
</html>