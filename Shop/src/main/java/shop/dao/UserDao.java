package shop.dao;

// Setup SQL Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


// Setup Shop Imports
import shop.model.User;

public class UserDao 
{
	// Setup Instances
	private Connection connect;
	private String query;
	private PreparedStatement prepared_statement;
	private ResultSet result_set;
	
	
	// Setup Constructors
	public UserDao(Connection connect) 
	{
		this.connect = connect;
	}
	
	// Setup Methods
	public User userLogin(String email, String password) 
	{
		User user = null;
		
		try
		{
			query = "select * from user where email=? and password=?";
			
			// Extract Prepared Statement
			prepared_statement = this.connect.prepareStatement(this.query);
			prepared_statement.setString(1, email);
			prepared_statement.setString(2, password);
			result_set = prepared_statement.executeQuery();
			
			// Check for new Users
			if(result_set.next()) 
			{
				user = new User();
				user.setID(result_set.getInt("ID"));
				user.setName(result_set.getString("name"));
				user.setEmail(result_set.getString("email"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		return user;
	}
	
}
