package shop.model;

public class Cart extends Product
{
	// Setup Private Instances
	private int quantity;

	// Setup Constructors
	public Cart() 
	{
		
	}
	
	// Setup Setters and Getters
	/**
	 * @return the quantity
	 */
	public int getQuantity() 
	{
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
}
