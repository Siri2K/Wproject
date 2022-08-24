<%-- Setup Page Imports --%>
<%@ page import = "shop.connection.DbConnection" %>
<%@ page import = "shop.model.*" %>
<%@ page import = "shop.dao.*" %>

<%-- Configure Page --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<% 
	// Setup User
	User auth = (User)request.getSession().getAttribute("auth");
	if(auth != null)
	{
		request.setAttribute("auth", auth);
	}
%>


<!DOCTYPE html>

<html>
	<head>
		<title>Cart Page</title>
		<%@include file = "includes/header.jsp" %>
		
		<%-- Use CSS to Style Table --%>
		<style type = "text/css">
			.table tbody td 
			{
				vertical-align: middle;
			}
			
			.btn-incre, .btn-decre
			{
				box-shadow : none;
				font-size : 25px;
			}
			
		</style>
	</head>
	
	<body>
		<%@include file = "includes/navbar.jsp" %>
		
		<%--Setup Cart Page --%>
		<div class = "container">
			<%-- Show Total Price of Items in cart --%>
			<div class = "d-flex py-3 "><h3>Total Price = $1000</h3>
			<a class = "mx-3 btn btn-primary" href = "#"> Check Out</a>
			</div>
			
			<%-- Make Table containing all purchased items --%>
			<table class = "table table-light">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Category</th>
						<th scope="col">Price</th>
						<th scope="col">Buy Now</th>
						<th scope="col">Cancel</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td>Pink Shoes</td>
						<td>Women Shoes</td>
						<td>$119.99</td>
						
						<%-- Setup Buttons --%>
						<td>
							<form action = "" method = "post" class = "form-inline">
								<input type = "hidden" name = "id" value = "1" class = "form-input">
							</form>
							
							<div class = "form-group d-flex justify-content-between">
								<a class = "btn btn-sm btn-decre" href = "">
									<i class = "fas fa-minus-square"></i>
								</a>
								
								<input type="text" name="quantity" class="form-control" value="1" readonly>
								
								<a class = "btn btn-sm btn-incre" href = "#">
									<i class = "fas fa-plus-square"></i>
								</a>
							</div>
						</td>
						
						<td>
							<a class = "btn btn-small btn-danger" href = "#">Remove</a>
						</td>
						
					</tr>
				</tbody>
			</table>
		</div>
		
		<%@include file = "includes/footer.jsp" %>
	</body>
</html>