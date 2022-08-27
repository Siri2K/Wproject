package shop.servlet;

// Import Java Packages
import java.io.IOException;
import java.io.PrintWriter;

// Import Java Servlet Packages
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Import Connection
import shop.connection.DbConnection;

// Import Dao
import shop.dao.OrderDao;

/**
 * Servlet implementation class CancelOrderServlet
 */
@WebServlet("/cancel-order")
public class CancelOrderServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try(PrintWriter out = response.getWriter())
		{
			String id = request.getParameter("id");
			
			if(id != null) 
			{
				OrderDao orderDao = new OrderDao(DbConnection.getConnection());
				orderDao.cancelOrder(Integer.parseInt(id));
			}
			response.sendRedirect("order.jsp");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
	}
}
