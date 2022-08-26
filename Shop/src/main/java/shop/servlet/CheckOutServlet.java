package shop.servlet;

// Import Java Packages
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// Import Servlet Packages
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.connection.DbConnection;
import shop.dao.OrderDao;
// Import hop Packages
import shop.model.Cart;
import shop.model.Order;
import shop.model.User;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		try(PrintWriter out = response.getWriter())
		{
			// Setup Date
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			
			// Retrieve all cart Products
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("cart-list");
			
			// Check if User is logged in
			User auth = (User) request.getSession().getAttribute("auth");
			
			// Check auth and cart_list
			if(cart_List != null && auth != null) 
			{
				// Retrieve info from cart list
				for(Cart c:cart_List) 
				{
					Order order = new Order();
					order.setID(c.getID());
					order.setUserID(auth.getID());
					order.setOrderQuantity(c.getQuantity());
					order.setOrderDate(dateFormat.format(date));
					
					// Insert Values to Database
					OrderDao oDao = new OrderDao(DbConnection.getConnection());
					boolean result = oDao.insertOrder(order);
					
					if(!result) 
					{
						break;
					}
				}
				cart_List.clear();
				response.sendRedirect("order.jsp");
			}
			else 
			{
				if(auth == null) 
				{
					response.sendRedirect("login.jsp");
				}
				response.sendRedirect("cart.jsp");
			}
						
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
