<%-- Setup Expanded Navigation Bar --%>>
<nav class = "navbar navbar-expand-lg bg-light">
	<div class = "container-fluid">
		<a class = "navbar-brand" href = "index.jsp">Shop</a>
		
		<%-- Setup Toggle Button --%>>
		<button class = "navbar-toggler" type = "button" data-bs-toggle = "collapse" data-bs-target = "#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation" >
			<span class = "navbar-toggler-icon"></span>
		</button>
		
		<%-- Setup Collapsed Navigation Bar --%>
		<div class = "collapse navbar-collapse" id = "navbarNav" >
			<ul class = "navbar-nav ms-auto">
				<%-- Home Button --%>
				<li class = "nav-item">
					<a class = "nav-link active" aria-current = "page" href = "index.jsp">Home</a>
				</li>
				
				<%-- Cart Button --%>
				<li class = "nav-item">
					<a class = "nav-link" aria-current = "page" href = "cart.jsp">
						Cart 
						<span class ="badge text-bg-danger px-1">
							${cart_list.size()}
						</span>
					</a>
				</li>
				
				<%-- Setup Authorized User Buttons --%>
				<% 
				if(auth != null) 
				{%>
					<%-- Order Button --%>
					<li class = "nav-item">
						<a class = "nav-link" aria-current = "page" href = "order.jsp">Order</a>
					</li>
					
					<%-- Logout Button --%>
					<li class = "nav-item">
						<a class = "nav-link" aria-current = "page" href = "log-out">Logout</a>
					</li>
					
				<%}
				else
				{%>
					<%-- Login Button --%>
					<li class = "nav-item">
						<a class = "nav-link" aria-current = "page" href = "login.jsp">Login</a>
					</li>
				<% }
				%>
				
			</ul>
		</div>	
	</div>
</nav>