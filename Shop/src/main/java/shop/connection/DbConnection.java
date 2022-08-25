package shop.connection;

// Import Packages
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection 
{
	// Setup Instances
	private static Connection connect;
	
	// Setup Set & Get Functions
	public static Connection getConnection()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","DBA123");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connect;
	}
	
}
