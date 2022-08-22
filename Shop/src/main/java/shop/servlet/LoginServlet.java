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


// Import Shop Packages
import shop.connection.DbConnection;
import shop.dao.UserDao;
import shop.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=UTF-8");
		
		try (PrintWriter out = response.getWriter())
		{
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			
			// Setup New Users
			try 
			{
				UserDao user_dao = new UserDao(DbConnection.getConnection());
				User user = user_dao.userLogin(email, password);
				
				if(user != null) 
				{
					System.out.println("User Logged in");
					request.getSession().setAttribute("auth", user);
					response.sendRedirect("index.jsp");
				}
				else 
				{
					System.out.println("User Log in Failed");
				}
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
