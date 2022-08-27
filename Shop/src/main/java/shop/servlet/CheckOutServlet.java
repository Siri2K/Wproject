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

// Import Shop Model Packages
import shop.model.*;
import shop.connection.DbConnection;
//Import Shop Model Packages
import shop.dao.*;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		try(PrintWriter out = response.getWriter())
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			Date date = new Date();
			
			// Get Cart List from Session
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("cart-list");
			
			// Get USer Login Info
			User auth = (User) session.getAttribute("auth");
			
			// Setup Order Information
			if(cart_List != null && auth != null) 
			{
				for(Cart c:cart_List) 
				{
					Order order = new Order();
					
					// Setup Order Info
					order.setID(c.getID());
					order.setUserID(auth.getID());
					order.setOrderQuantity(c.getQuantity());
					order.setOrderDate(dateFormat.format(date));
					
					boolean result = new OrderDao(DbConnection.getConnection()).insertOrder(order);
					
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
				response.sendRedirect("order.jsp");
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
