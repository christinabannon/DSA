package Lab6;

/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 4
 * Status: Complete and thoroughly tested
 * Last update: 02/28/19
 * Submitted:  03/4/19
 * Comment: fancy new getters and setters!
 * @author: Christina Bannon
 * @version: 2019.03.4
 */

/* 
 * CB the Bag class represents a bag. 
 * It is to be used as a buffer/container
 * between a stack and the driver.
 * Keeps track of individual bag's weight
 * and number of things in the bag. 
 */

public class DQBag<T>
{
	private int numBagThings;
	private double bagWeight;
	private DEQ<T> dq;

	//CB used main
	public DQBag (DEQ dq)
	{
		this.dq = dq;
		numBagThings = 0;
		bagWeight = 0;
	}
	
	//CB add method accepts anything, 
	//CB sorts what it is to determine
	//CB where to put it in the DEQ
	public void add(T thing)
	{	
		if (thing instanceof Pack)
		{
			if (((Pack)thing).getExpress() == true)
			{
				dq.enqueueFirst(thing);
			}
			else
			{
				dq.enqueue(thing);
			}
			bagWeight += ((Pack)thing).getPackWeight();
		}	
		else if (thing instanceof Item)
		{
			dq.enqueueFirst(thing);
			
			bagWeight += ((Item)thing).getWeight();
		}
		numBagThings ++;
	}
		
	public int getNumBagItems()
	{
		return numBagThings;
	}
	
	public double getBagWeight()
	{
		return bagWeight;
	}
	
	public T showFirst()
	{
		return dq.peek();
	}
	
	public T showLast()
	{
		return dq.peekLast();
	}
	
	public T dispenseFirst()
	{
		if (dq.peek() instanceof Pack)
		{
			bagWeight -= ((Pack)dq.peek()).getPackWeight();
		}
		else if (dq.peek() instanceof Item)
		{
			bagWeight -= ((Item)dq.peek()).getWeight();
		}
		numBagThings--;
		return dq.dequeue();
	}

	public void dispenseAllitems()
	{
		dq.dequeueAll();
		numBagThings = 0;
		bagWeight = 0;
	}
}

