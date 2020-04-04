package Lab2;

/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/19/19
 * Submitted:  02/19/19
 * Comment: Re-do with corrections!
 * @author: Christina Bannon
 * @version: 2019.02.19
 */

import java.util.ArrayList;

import Lab8.ListIndexOutOfBoundsException;

public class ListArrayListBased implements ListInterface
{
	protected ArrayList <Object> items;
	
	public ListArrayListBased()
	{
		items = new ArrayList<>();
	}
	
	public boolean isEmpty()
	{
		return items.isEmpty();
	}
	
	public int size()
	{
		return items.size();
	}
	
	//CB adds an item to the ArrayList if the index is valid
	public void add(int index, Object item)
			throws ListIndexOutOfBoundsException
	{
		items.add(index,item);
	}
	
	//CB returns the Object from the given input if the input is valid
	public Object get(int index) 
			throws ListIndexOutOfBoundsException
	{
		try
		{
			return items.get(index);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			throw new 
			ListIndexOutOfBoundsException("OOP exception on get");
		}
	}

	//CB removes Object@ index if index is valid
	public void remove(int index) throws ListIndexOutOfBoundsException
	{
		if (index >= 0 && index < items.size() &&
				(items.get(index) != null))
		{
			items.remove(index);
		}	 
		else
		{
			throw new 
			ListIndexOutOfBoundsException("OOB exception on remove");
		}
	}
	
	public void removeAll()
	{
		items.clear();
	}

}
