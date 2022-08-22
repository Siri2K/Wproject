package shop.model;

public class User 
{
	// Setup Instances
	private int ID;
	private String name,email,password;
	
	// Setup Constructor
	public User(int iD, String name, String email, String password) 
	{
		this.ID = iD;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User() 
	{
		
	}
	
	// Setup Set and Get
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
	 * @return the email
	 */
	public String getEmail() 
	{
		return email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() 
	{
		return password;
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
	 * @param email the email to set
	 */
	public void setEmail(String email) 
	{
		this.email = email;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	// Method
	@Override
	public String toString()
	{
		return "User [id = " + this.getID() + " name = " + this.getName() + "email = " + this.getEmail() + "password = " + this.getPassword() + "]" ; 
	}
	
}
