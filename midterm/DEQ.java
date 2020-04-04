package midterm;

public class DEQ<T> extends Queue<T>
{
	  public void enqueueFirst(T newItem) 
			  throws ExtendedQueueException
	  {
		  numItems++;
		  
			if( numItems > items.length)
			{
				items = super.resize();
			}

			front = (items.length + front - 1) % items.length;
			items[front] = newItem;

	  }
	  
	  public T dequeueLast() throws ExtendedQueueException
	  {
		  T item;
		  if ( numItems > 0)
		  {
			  back = (items.length + back - 1) % items.length;
			  item = (T)items[back];
			  items[back] = null;
			  numItems--;
		  }
		  else 
		  {
			  throw new ExtendedQueueException
			  ("There is nothing to Dequeue here!!!");
		  }  
		  return item;
	  }
	  
	  public T peekLast() throws ExtendedQueueException
	  {
		  T item;
		  if (numItems > 0)
		  {
			  item = (T)items[(back-1) % items.length];
		  }
		  else
		  {
			  throw new ExtendedQueueException("Nothing to peek at!");
		  }
		  return item;
	  }
}