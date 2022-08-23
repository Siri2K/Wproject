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
	
	<%-- Create Product Card --%>
	<div class = "container">
		
		<%-- Card Header --%>
		<div class = "card-header my-3"> All Product </div>
		<div class = "row">
			<div class = "col-md-3">
				<div class = "card w-100" style="width: 18rem;">
					<img class = "card-img-top" src = "product-image/female-shoes.jpg" alt = "Card image cap">
					
					<%-- Card Body --%>
					<div class = "card-body">
						<h5 class = "card-title">Card Title</h5>
						<h6 class = "price">Price : $450</h6>
						<h6 class = "category">Category : some category</h6>
						
						<div class = "mt-3 d-flex justify-content-between">
							<a href = "#" class = "btn btn-primary"> Add to cart</a>
							<a href = "#" class = "btn btn-primary"> Buy now</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
	
	<%@include file = "includes/footer.jsp" %>
</body>
</html>