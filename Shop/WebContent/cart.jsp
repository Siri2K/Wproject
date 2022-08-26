<%-- Setup Page Imports from Java --%>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "java.util.List" %>
<%@ page import= "java.text.DecimalFormat" %>

<%-- Setup Page Imports from Shop --%>
<%@ page import = "shop.connection.DbConnection" %>
<%@ page import = "shop.model.*" %>
<%@ page import = "shop.dao.*" %>

<%-- Configure Page --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<% 
	// Setup Decimal Format
	DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf);

	// Setup User
	User auth = (User)request.getSession().getAttribute("auth");
	if(auth != null)
	{
		request.setAttribute("auth", auth);
	}
	
	// Get CartList from Session List
	ArrayList<Cart> cartlist = (ArrayList<Cart>) session.getAttribute("cart-list");
	List<Cart> cartProduct = null;
	
	if(cartlist !=null)
	{
		ProductDao product_dao = new ProductDao(DbConnection.getConnection());
		cartProduct = product_dao.getCartProduct(cartlist);
		double total_price = product_dao.getTotalCartPrice(cartlist);
		request.setAttribute("cart_list",cartlist);
		request.setAttribute("total", total_price);
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
			<div class = "d-flex py-3 "><h3>Total Price =$ ${(total>0)?dcf.format(total):0}</h3>
			<a class = "mx-3 btn btn-primary" href = "cart-check-out"> Check Out</a>
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
					<% if(cartlist != null)
					   {
						for(Cart c:cartProduct)
						{%>
							<tr>
							<td><%= c.getName() %></td>
							<td><%= c.getCategory() %></td>
							<td>$<%= dcf.format(c.getPrice()) %> </td>
							
							<%-- Setup Buttons --%>
							<td>
								<form action ="order-now" method = "post" class = "form-inline">
									<input type = "hidden" name = "id" value = "<%= c.getID() %>" class = "form-input">
									
									<div class = "form-group d-flex justify-content-start w-100">
										<a class = "btn btn-sm btn-decre" href = "quantity?action=dec&id=<%=c.getID() %>">
											<i class = "fas fa-minus-square"></i>
										</a>

										<input type="text" name="quantity" class="form-control col-left w-50" value="<%= c.getQuantity() %>" readonly>
										
										<a class = "btn btn-sm btn-incre" href = "quantity?action=inc&id=<%=c.getID()%>">
											<i class = "fas fa-plus-square"></i>
										</a>
										
										<button type = "submit" class = "btn btn-primary btn-sm">Buy Now</button>
									</div>
								</form>	
								</td>
							<td>
								<a class = "btn btn-small btn-danger" href = "remove-from-cart?id=<%=c.getID()%>">Remove</a>
							</td>					
						</tr>
						<%}
					   }
					%>
					
				</tbody>
			</table>
		</div>
		
		<%@include file = "includes/footer.jsp" %>
	</body>
</html>