package Lab5;

/* Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/20/19
 * Submitted:  02/25/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.20
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
