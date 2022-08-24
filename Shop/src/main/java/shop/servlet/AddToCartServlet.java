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

// Import Shop Class
import shop.model.Cart;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
		
		// Setup New Item in Cart
		try(PrintWriter out = response.getWriter())
		{
			ArrayList<Cart> cartList = new ArrayList<>();
			
			// Make a Cart ID
			Cart cart = new Cart();
			int id = Integer.parseInt(request.getParameter("id"));
			cart.setID(id);
			cart.setQuantity(1);
			
			// Show Cart Session
			
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_List = (ArrayList<Cart>) session.getAttribute("cart-list");
			
			// Check if there is a cart Session
			if(cart_List == null) 
			{
				cartList.add(cart);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("index.jsp");
			}
			else 
			{
				cartList = cart_List;
				
				// Check if ID already exist
				boolean exist = false;
				for(Cart c:cartList) 
				{
					if(c.getID() == id) 
					{
						exist = true;
						out.print("<h3 style = 'color:crimson; text-align:center'>Iteration already exist. <a href = 'cart.jsp'> Go to Cart Page</a></h3>");
					}
				}
				
				if(!exist) 
				{
					cartList.add(cart);
					response.sendRedirect("index.jsp");
				}
			}
			
			
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
