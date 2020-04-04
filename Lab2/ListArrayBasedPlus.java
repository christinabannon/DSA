package Lab2;

/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/19/19
 * Submitted:  02/19/19
 * Comment: Re-do with corrections!
 * @author: Christina Bannon
 * @version: 2019.02.19
 */

import java.lang.StringBuilder;

//********************************************************
//Array-based implementation of the ADT list.
//*********************************************************
public class ListArrayBasedPlus extends ListArrayBased 
	implements ListInterface 
{	
	public ListArrayBasedPlus()
	{
		super();
	}  // end default constructor

	@Override
	public void add(int index, Object item)
	{
		if (numItems == super.items.length)
		{
			resize();
		}
		super.add(index, item);
	}

	private void resize()
	{
		Object[] largerArray = new Object [numItems*2];
	
		for (int i = 0; i < numItems; i++)
		{
			largerArray[i] = super.items[i];
		}	
		super.items = largerArray;	
	}

	public void reverse()
	{
		Object [] reverseArray = new Object[numItems];
	
		for (int i = 0; i < numItems; i++)
		{
			reverseArray[i] = items[numItems - (i+1)];
		}
		items = reverseArray;
	}

	@Override
	public String toString()
	{
		StringBuilder string = 
				new StringBuilder("List of size " 
		+ numItems +" has the following items: ");
		for (int i = 0; i < items.length; i++)
		{
			if (items[i] != null)
			{
			string.append(items[i] + " ");
			}
		}
		return string.toString();
	}
}
