package shop.servlet;

// Import Java Packages
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// Import Servlet Packages
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Import Shop Packages
import shop.model.Cart;

/**
 * Servlet implementation class QuantityServlet
 */
@WebServlet("/quantity")
public class QuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html; charset=UTF-8");
		
		try(PrintWriter out = response.getWriter())
		{
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			
			//Setup Session
			HttpSession session = request.getSession();
			ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");
			
			if(action != null && id>=1) 
			{
				// Setup Increment Functionality
				if(action.equals("inc")) 
				{
					for(Cart c:cartList) 
					{
						if(c.getID() == id) 
						{
							int quantity = c.getQuantity();
							c.setQuantity(++quantity);
							response.sendRedirect("cart.jsp");
						}
					}	
				}
				
				// Setup Increment Functionality
				if(action.equals("dec")) 
				{
					for(Cart c:cartList) 
					{
						if(c.getID() == id && c.getQuantity()>1) 
						{
							int quantity = c.getQuantity();
							c.setQuantity(--quantity);
							break;
						}
					}
					response.sendRedirect("cart.jsp");
				}
				
			}
			else 
			{
				response.sendRedirect("cart.jsp");
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
