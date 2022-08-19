<%-- Setup Expanded Navigation Bar --%>>
<nav class = "navbar navbar-expand-lg bg-light">
	<div class = "container-fluid">
		<a class = "navbar-brand" href = "index.jsp">JStore</a>
		
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
					<a class = "nav-link" aria-current = "page" href = "#">Cart</a>
				</li>
				
				<%-- Order Button --%>
				<li class = "nav-item">
					<a class = "nav-link" aria-current = "page" href = "#">Order</a>
				</li>
				
				<%-- Login &Logout Button --%>
				<li class = "nav-item">
					<a class = "nav-link" aria-current = "page" href = "#">Logout</a>
				</li>
				
				<li class = "nav-item">
					<a class = "nav-link" aria-current = "page" href = "#">Login</a>
				</li>
			</ul>
		</div>	
	</div>
</nav>