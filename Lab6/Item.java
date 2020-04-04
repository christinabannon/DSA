package Lab6;

/* Purpose: Data Structure and Algorithms Lab 6 Problem 4
 * Status: Complete and thoroughly tested
 * Last update: 03/01/19
 * Submitted:  03/05/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.03.05
 */

public class Item
{
	private String name;
	private double weight;
	
	public Item(String name, double weight) 
	{
		this.name = name;
		this.weight = weight;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getWeight()
	{
		return weight;
	}
}

