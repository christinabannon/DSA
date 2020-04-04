package Lab6;

/* Purpose: Data Structure and Algorithms Lab 6 Problem 0
 * Status: Complete and thoroughly tested
 * Last update: 03/03/19
 * Submitted:  03/04/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.03.03
 */

public class Queue<T> implements QueueInterface<T>
{
	protected T[] items;
	protected int front;
	protected int back;
	protected int numItems;
	
	public Queue()
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
		numItems++;
		if( numItems > items.length)
		{
			items = resize();
		}	
		items[back] = newItem; //CB inserting new item, 
								//CB then incrementing the back
		back = ++back % items.length ;
	}
	
	protected T[] resize()
	{

		T[] biggerArray = (T[]) new Object [items.length * 2];
		
		for(int i = 0, f = front; i < items.length; i++, f++)
		{
			biggerArray[i] = items[f % items.length];
		}
		
		front = 0;
		back = items.length;

		return biggerArray;
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
		items = (T[]) new Object [3];
		numItems = 0;
		front = 0;
		back = 0;
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
		int i = front;
		do 
		{
			string.append(items[i].toString());
			i = ++i % items.length;	
		}
		while (i != back);
		return string.toString();	
	}
}
