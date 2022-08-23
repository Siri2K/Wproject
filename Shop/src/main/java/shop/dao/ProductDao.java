package shop.dao;

//Setup SQL Imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


// Import Java Utility
import java.util.List;
import java.util.ArrayList;

//Setup Shop Imports
import shop.model.Product;


public class ProductDao 
{
	// Setup Instances
	private Connection connect;
	private String query;
	private PreparedStatement prepared_statement;
	private ResultSet result_set;
	
	
	// Setup Constructors
	public ProductDao(Connection connect) 
	{
		this.connect = connect;
	}
	
	// Get All Products from database
	public List<Product> getAllProduct() 
	{
		List<Product> product_list = new ArrayList<>();
		
		try 
		{
			query = "select * from product";
			prepared_statement = this.connect.prepareStatement(query);
			result_set = prepared_statement.executeQuery();
			
			// Check for new products
			while(result_set.next()) 
			{
				Product product_row = new Product();
				product_row.setID(result_set.getInt("ID"));
				product_row.setName(result_set.getString("name"));
				product_row.setCategory(result_set.getString("category"));
				product_row.setPrice(result_set.getString("price"));
				product_row.setImage(result_set.getString("image"));
				
				// Add Product Data to List
				product_list.add(product_row);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return product_list;
	}

}
