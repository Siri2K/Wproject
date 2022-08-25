<%-- Setup Page Imports from Java --%>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "java.util.List" %>

<%-- Setup shop Imports --%>
<%@ page import = "shop.connection.DbConnection" %>
<%@ page import = "shop.model.*" %>
<%@ page import = "shop.dao.*" %>

<%-- Configure  Page  --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<% 
	// Setup User
	User auth = (User)request.getSession().getAttribute("auth");
	if(auth != null)
	{
		request.setAttribute("auth", auth);
	}
	
	// Setup Products
	ProductDao product_dao = new ProductDao(DbConnection.getConnection());
	List<Product> products = product_dao.getAllProduct();
	
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
	
	<%-- Create Product Card --%>
	<div class = "container">
		
		<%-- Card Header --%>
		<div class = "card-header my-3"> All Product </div>
		<div class = "row">
			
			<%
				if(!products.isEmpty())
				{
					for(Product p:products)
					{%>
						<div class = "col-md-3 my-3">
						<div class = "card w-100" style="width: 18rem;">
							<img class = "card-img-top" src = "product-image/<%= p.getImage() %>" alt = "Card image cap">
							
							<%-- Card Body --%>
							<div class = "card-body">
								<h5 class = "card-title"><%=p.getName() %></h5>
								<h6 class = "price">Price :  $<%= p.getPrice() %></h6>
								<h6 class = "category">Category : <%= p.getCategory() %></h6>
								
								<div class = "mt-3 d-flex justify-content-between">
									<a href = "add-to-cart?id=<%=p.getID() %>" class = "btn btn-dark"> Add to cart</a>
									<a href = "#" class = "btn btn-primary"> Buy now</a>
								</div>
							</div>
						</div>	
					</div>
					<%}
				}
				else
				{
					System.out.println("There is no product");
				}
			%>	
			
		</div>
		
	</div>
	
	<%@include file = "includes/footer.jsp" %>
</body>
</html>