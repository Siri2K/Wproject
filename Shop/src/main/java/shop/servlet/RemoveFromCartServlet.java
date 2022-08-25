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

import shop.model.Cart;

// Import Shop Packages

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
		
		try(PrintWriter out = response.getWriter())
		{
			// Check if There is a product in cart
			String id = request.getParameter("id");
			
			if(id != null) 
			{				
				// Show Cart Session
				HttpSession session = request.getSession();
				ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("cart-list");
				
				if(cart_List != null) 
				{
					for(Cart c:cart_List) 
					{
						if(c.getID() == Integer.parseInt(id)) 
						{
							cart_List.remove(cart_List.indexOf(c));
							break;
						}
					}
				}
				response.sendRedirect("cart.jsp");
			}
			else 
			{
				response.sendRedirect("cart.jsp");
			}

		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
	}

}
