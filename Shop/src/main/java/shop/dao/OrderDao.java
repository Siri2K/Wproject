package shop.dao;

//Setup SQL Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Import Java Utility
import java.util.List;
import java.util.ArrayList;

//Setup Shop Imports
import shop.model.Order;
import shop.model.Product;

public class OrderDao 
{
	// Setup Instances
	private Connection connect;
	private String query;
	private PreparedStatement prepared_statement;
	private ResultSet result_set;
	
	// Setup Constructor
	public OrderDao(Connection connect) 
	{
		this.connect = connect;
	}
	
	// Setup Getter Method
	/**
	 * @return the connect
	 */
	public Connection getConnect() 
	{
		return connect;
	}

	// Setup Methods
	public boolean insertOrder(Order model) 
	{
		boolean result = false;
		
		try 
		{
			query = "insert into shop.order (productID, userID, orderQuantity, orderDate) values(?,?,?,?)";
			
			// Prepare & Update Query 
			prepared_statement = this.connect.prepareStatement(query);
			prepared_statement.setInt(1, model.getID());
			prepared_statement.setInt(2, model.getUserID());
			prepared_statement.setInt(3,model.getOrderQuantity());
			prepared_statement.setString(4, model.getOrderDate());
			prepared_statement.executeUpdate();
			
			result = true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		return result;
	}
	
	
	public List<Order> UserOrder(int id)
	{
		List<Order> userList = new ArrayList<>();
		
		try 
		{
			query = "select * from shop.order where userID=? order by order by shop.order.orderID desc";
			prepared_statement = this.connect.prepareStatement(query);
			prepared_statement.setInt(1, id);
			result_set = prepared_statement.executeQuery();
			
			// Check for new Orders
			while(result_set.next()) 
			{
				Order order = new Order();
				
				// Obtain Product info from data base
				ProductDao pDao = new ProductDao(this.getConnect());
				int productID = result_set.getInt("productID");
				Product product = pDao.getSingleProduct(productID);
				
				// Setup Order Data
				order.setOrderID(result_set.getInt("orderID"));
				order.setID(productID);
				order.setName(product.getName());
				order.setCategory(product.getCategory());
				order.setPrice(product.getPrice()*result_set.getInt("orderQuantity"));
				order.setOrderQuantity(result_set.getInt("orderQuantity"));
				order.setOrderDate(result_set.getString("orderDate"));
				
				userList.add(order);
			}
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		return userList;
	}
}
