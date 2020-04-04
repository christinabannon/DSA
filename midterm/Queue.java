package midterm;

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
		
		//CB back doesn't have to be null!
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
		back = items.length; //the back doesn't 

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
		
		numItems--;
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
			Customer customer = (Customer)items[i];
			string.append(customer.getName().toString());
			i = (++i)%items.length;
		}
		while (i != back);
		return string.toString();	
	}
}
