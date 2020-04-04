package Lab6;


/* Purpose: Data Structure and Algorithms Lab 6 Problem 4
 * Status: Complete and thoroughly tested
 * Last update: 03/01/19
 * Submitted:  03/04/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.03.01
 */

public class Pack
{
	private String sender;
	private String recipient;
	private int numItems;
	private Item item;
	private double packageWeight;
	private boolean express;      //CB this new variable is here to determine if a 
								//CB package is an express order or not
	
	//CB constructor accepts all relevant values
	//for a package, and instantiates all variables
	public Pack(String sender, String recipient,
			int numItems, String itemName, double itemWeight)
	{
		this.item = new Item(itemName, itemWeight);
		this.sender = sender;
		this.recipient = recipient; 
		this.numItems = numItems;
		packageWeight = numItems * item.getWeight();
		express = false;
	}
	
	//CB constructor accepts all relevant values 
	//for an express package, and instantiates all variables
	public Pack(String sender, String recipient,
			int numItems, String itemName, 
			double itemWeight, boolean express)
	{
		this.item = new Item(itemName, itemWeight);
		this.sender = sender;
		this.recipient = recipient; 
		this.numItems = numItems;
		packageWeight = numItems * item.getWeight();
		this.express = express;
	}
	
	public boolean getExpress()
	{
		return express;
	}
	
	public String getSender() {
		return sender;
	}

	//CB used case2
	public String getRecipient() {
		return recipient;
	}

	//CB used
	public int getNumItems() {
		return numItems;
	}

	//used
	public Item getItem() {
		return item;
	}
	
	public double getPackWeight()
	{
		return packageWeight;
	}
}