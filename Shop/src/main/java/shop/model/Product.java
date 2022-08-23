package shop.model;

public class Product 
{
	// Setup Instances
	private int ID;
	private String name,category,price,image;
	
	// Setup Constructor
	
	public Product() 
	{
		
	}
	
	public Product(int iD, String name, String category, String price, String image) 
	{
		this.ID = iD;
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
	}
	
	
	// Setup Setters and Getters
	
	/**
	 * @return the iD
	 */
	public int getID() 
	{
		return ID;
	}

	/**
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() 
	{
		return category;
	}

	/**
	 * @return the price
	 */
	public String getPrice() 
	{
		return price;
	}

	/**
	 * @return the image
	 */
	public String getImage() 
	{
		return image;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) 
	{
		ID = iD;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) 
	{
		this.category = category;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) 
	{
		this.price = price;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) 
	{
		this.image = image;
	}
	
	// Setup String Method
	@Override
	public String toString() {
		return "Product [ID=" + ID + ", name=" + name + ", category=" + category + ", price=" + price + ", image=" + image + "]";
	}
	
	
	
	
		
	
	
}
