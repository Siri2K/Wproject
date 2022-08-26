package shop.dao;

//Setup SQL Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Import Java Utility


//Setup Shop Imports
import shop.model.Order;

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
	
	
	
}
