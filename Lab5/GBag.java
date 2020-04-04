package Lab5;

/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/27/19
 * Submitted:  02/27/19
 * Comment: Revisions!!
 * @author: Christina Bannon
 * @version: 2019.02.27
 */

/* 
 * CB the Bag class represents a bag. 
 * It is to be used as a buffer/container
 * between a stack and the driver.
 * Keeps track of individual bag's weight
 * and number of things in the bag. 
 */

public class GBag<T>
{
	private int numBagThings = 0;
	private double bagWeight = 0;
	private StackInterface stack;

	//CB used main
	public GBag (StackInterface stack)
	{
		this.stack = stack;
		numBagThings = 0;
		bagWeight = 0;
	}
	
	//CB used case 1
	public void add(T thing)
	{
		stack.push(thing);	
		
		if (thing instanceof Pack)
		{
			bagWeight += ((Pack)thing).getPackWeight();
		}
		else
		{
			bagWeight += ((Item)thing).getWeight();	
		}
		numBagThings++;
	}
	
		
	//CB used case 3
	public int getNumBagItems()
	{
		return numBagThings;
	}
	
	public double getBagWeight()
	{
		return bagWeight;
	}
	
	//CB possibly unnacceptable cast?
	public Object getTop()
	{
		return  stack.peek();
	}

	public Pack dispensePack()
	{
		Pack pack = (Pack)stack.pop();
		bagWeight -= pack.getPackWeight();
		numBagThings --;
		return pack;
	}
	
	public Item dispenseItem() throws StackException
	{
		Item item = (Item)stack.pop();
		bagWeight -=item.getWeight();
		numBagThings--;	
		return item;
	}
	
	public void dispenseAllitems()
	{
		stack.popAll();
		numBagThings = 0;
		bagWeight = 0;
	}
}
