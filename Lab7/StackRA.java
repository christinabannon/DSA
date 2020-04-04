package Lab7;

import Lab5.StackException;
import Lab5.StackInterface;

public class StackRA <T> implements StackInterface<T>
{
	 protected T[] items = (T[])new Object[3];
	 private int numItems = 0;
	
	 public boolean isEmpty()
	 {
		 return (numItems == 0);
	 }
	 
	  public void popAll()
	  {
	        items = (T[]) new Object[3];
	        numItems = 0;
	  }

	 public void push (T newItem)
	 {
		 if (numItems == items.length)
		 {
			T[] largerArray = (T[]) new Object [items.length*2];
			
			for (int i = 0; i < numItems; i++)
			{
				largerArray[i] = items[i];
			}	
			items = largerArray;	
		 }
			
		 items[numItems] = newItem;
		 numItems++;
	 }

	@Override
	public T pop() throws StackException
	{
		if (numItems != 0)
		{
		T result = items [--numItems];
		  items [numItems] = null;
		  return result;
		}
		else 
		{
			throw new StackException("Empty stack!");
		}
	}

	@Override
	public T peek() throws StackException {

		 if (numItems == 0)
		 {
			throw new StackException("empty");
		 }
		 
		 return items[numItems -1];
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