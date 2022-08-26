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

// Import Shop Connection Package
import shop.connection.DbConnection;

// Import Shop Dao Package
import shop.dao.*;

// Import Shop Model Packages
import shop.model.*;

/**
 * Servlet implementation class OrderNowServlet
 */
@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html; charset=UTF-8");
		
		try(PrintWriter out = response.getWriter())
		{
			// Setup Date
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			
			// Check if User is logged in
			User auth = (User) request.getSession().getAttribute("auth");
			
			if(auth != null) 
			{
				String productID = request.getParameter("id");
				int productQuantity = Integer.parseInt(request.getParameter("quantity"));
				
				if(productQuantity < 1) 
				{
					productQuantity = 1;
				}
				
				// Setup Order object
				Order order = new Order();
				order.setID(Integer.parseInt(request.getParameter("id")));
				order.setUserID(auth.getID());
				order.setOrderQuantity(productQuantity);
				order.setOrderDate(dateFormat.format(date));
				
				// Insert Values to Database
				OrderDao orderDao = new OrderDao(DbConnection.getConnection());
				boolean result = orderDao.insertOrder(order);
				
				if(result) 
				{
					// Show Cart Session
					HttpSession session = request.getSession();
					ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("cart-list");
					
					if(cart_List != null) 
					{
						for(Cart c:cart_List) 
						{
							if(c.getID() == Integer.parseInt(productID)) 
							{
								cart_List.remove(cart_List.indexOf(c));
								break;
							}
						}
					}
					response.sendRedirect("order.jsp");
				}
				else 
				{
					out.print("order failed");
				}
			}
			else 
			{
				response.sendRedirect("login.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
