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
	else
	{
		//response.sendRedirect("login.jsp");
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
	<%@include file = "includes/navbar.jsp" %>
	
	<%--Setup Cart Page --%>
	<div class = "container">
		<%-- Show Total Price of Items in cart --%>
		<div class = "d-flex py-3 "><h3>All Orders</h3>
		</div>
		
		<%-- Make Table containing all purchased items --%>
		<table class = "table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			
			<tbody>
			</tbody>
		</table>
	</div>
	
	<%@include file = "includes/footer.jsp" %>
</body>
	
</html>