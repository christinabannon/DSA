package Lab6;

/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 03/25/19
 * Submitted:  03/25/19
 * Comment: RE-DO 
 * @author: Christina Bannon
 * @version: 2019.03.25
 */

public class QRAB<T> implements QueueInterface<T>
{
	private T[] items;
	private int front;
	private int back;
	private int numItems;
	
	public QRAB()
	{
		items = (T[]) new Object[3];
		front = 0;
		back = 0;
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return numItems == 0;
	}

	public void enqueue(T newItem)
	{	
		if( numItems == items.length)
		{
			items = resize();
		}
		
		//CB Correction - the back does not need to be empty!
		items[back] = newItem;
		back = ++back % items.length;
	}
	
	private T[] resize()
	{
		if( numItems == items.length)
		{
			T[] biggerArray = (T[]) new Object [items.length * 2];
		
			for(int i = 0, f = front; i < items.length; i++, f++)
			{
				biggerArray[i] = items[f % items.length];
			}
		
			items = biggerArray;
			front = 0;
			back = numItems;
		}
		return items;
	}
	
	public T dequeue () throws QueueException
	{
		T result; 
		
		if (numItems != 0)
		{
			result = items [front];
			items[front] = null;
			//front = (front + 1);
			front = ++front % items.length;
		}
		else
		{
			throw new QueueException("rut roh!");
		}
		
		return result;
	}
	
	public void dequeueAll()
	{
		items = null;
	}
	
	public T peek() throws QueueException
	{
		T item;
		if (numItems != 0)
		{
			item = items[front];
		}
		else 
		{
			throw new QueueException("Nothing to peek here!");
		}
		return item;
	}
	
	@Override
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		for (int i = front; i != back; i++)
		{
			i = i % (items.length);	
			if (items[i] != null)
			{
				string.append(items[i].toString());
			}
		}
		
		return string.toString();	
	}
}