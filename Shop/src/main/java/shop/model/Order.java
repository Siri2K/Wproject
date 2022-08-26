package shop.model;

public class Order extends Product
{
	// Setup Instances
	private int orderID,userID,orderQuantity;
	private String orderDate;
	
	// Setup Constructor
	public Order() 
	{
		
	}

	public Order(int orderID, int userID, int orderQuantity, String orderDate) 
	{
		this.orderID = orderID;
		this.userID = userID;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
	}

	public Order(int userID, int orderQuantity, String orderDate) 
	{
		this.userID = userID;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
	}
	
	// Setup Setters and Getters
	/**
	 * @return the orderID
	 */
	public int getOrderID() 
	{
		return orderID;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() 
	{
		return userID;
	}

	/**
	 * @return the orderQuantity
	 */
	public int getOrderQuantity() 
	{
		return orderQuantity;
	}

	/**
	 * @return the orderDate
	 */
	public String getOrderDate() 
	{
		return orderDate;
	}

	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(int orderID) 
	{
		this.orderID = orderID;
	}

	/** 
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) 
	{
		this.userID = userID;
	}

	/**
	 * @param orderQuantity the orderQuantity to set
	 */
	public void setOrderQuantity(int orderQuantity) 
	{
		this.orderQuantity = orderQuantity;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) 
	{
		this.orderDate = orderDate;
	}

	
	// Setup Methods
	@Override
	public String toString() 
	{
		return "Order [orderID=" + orderID + ", userID=" + userID + ", orderQuantity=" + orderQuantity + ", orderDate=" + orderDate + "]";
	}
		
}
