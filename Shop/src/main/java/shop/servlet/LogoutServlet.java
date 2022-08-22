package shop.servlet;

// Import Java Packages
import java.io.IOException;
import java.io.PrintWriter;

// Import Servlet Packages
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/log-out")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try (PrintWriter out = response.getWriter())
		{
			if(request.getSession().getAttribute("auth") != null)
			{
				// Remove Authorization
				request.getSession().removeAttribute("auth");
				response.sendRedirect("login.jsp");
				System.out.println("User Logged Out");
			}
			else 
			{
				response.sendRedirect("index.jsp");
			}
		}
		catch(Exception e) 
		{
			
		}
	}

}
