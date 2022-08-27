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
	//Setup Decimal Format
	DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf);
	
	//Setup User
	User auth = (User)request.getSession().getAttribute("auth");
	List<Order> orders = null;
	if(auth != null)
	{
		request.setAttribute("auth", auth);
		OrderDao orderDao = new OrderDao(DbConnection.getConnection());
		orders = orderDao.userOrders(auth.getID());
	}
	else
	{
		response.sendRedirect("login.jsp");
	}
	
	// Get CartList from Session List
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	
	if(cart_list !=null)
	{
		request.setAttribute("cart_list",cart_list);
	}

%>


<!DOCTYPE html>
<html>

<head>
	<title>Order Page</title>
	<%@include file = "includes/header.jsp" %>
</head>

<body>
	<%@include file = "includes/navbar.jsp" %>
	
	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
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
				<%
					if(orders != null)
					{
						for(Order o:orders)
						{%>
						<tr>
							<td><%= o.getOrderDate() %></td>
							<td><%= o.getName() %></td>
							<td><%= o.getCategory() %></td>
							<td><%= o.getOrderQuantity() %></td>
							<td><%= o.getPrice() %></td>
							
							<%-- Setup Cancel Button --%>
							<td>
								<a class = "btn btn-small btn-danger" href = "cancel-order?id=<%=o.getOrderID()%>">Cancel</a>
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