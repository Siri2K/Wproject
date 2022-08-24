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
import shop.model.Cart;


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
				product_row.setPrice(result_set.getDouble("price"));
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
	
	public List<Cart>getCartProduct(ArrayList<Cart> cartList)
	{
		List<Cart> products = new ArrayList<Cart>();
		
		try 
		{
			if(cartList.size()>0) 
			{
				for(Cart item:cartList) 
				{
					query = "select * from product where ID=?";
					prepared_statement = this.connect.prepareStatement(query);
					prepared_statement.setInt(1, item.getID());
					result_set = prepared_statement.executeQuery();
					
					while(result_set.next()) 
					{
						Cart cart = new Cart();
						cart.setID(result_set.getInt("ID"));
						cart.setName(result_set.getString("name"));
						cart.setCategory(result_set.getString("category"));
						cart.setPrice(result_set.getDouble("price")*item.getQuantity());
						cart.setQuantity(item.getQuantity());
						products.add(cart);
					}
				}
				
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return products;
	}

}
