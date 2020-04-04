package Lab5;

/* Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/20/19
 * Submitted:  02/25/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.20
 */

public class Pack
{
	private String sender;
	private String recipient;
	private int numItems;
	private Item item;
	private double packageWeight;
	
	//CB constructor accepts all relevant values for a package, and instantiates all variables
	public Pack(String sender, String recipient, int numItems, String itemName, double itemWeight)
	{
		this.item = new Item(itemName, itemWeight);
		this.sender = sender;
		this.recipient = recipient; 
		this.numItems = numItems;
		packageWeight = numItems * item.getWeight();
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
