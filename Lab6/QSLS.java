package Lab6;

/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/26/19
 * Submitted:  03/4/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.26
 */

public class QSLS<T> 
{
	Node<T> front;
	Node<T> back;
	
	public QSLS()
	{
		front = null;
		back = null;
	}
	
	public boolean isEmpty()
	  {
		  return (front == null);
	  }
	   
	  public void enqueue(T newItem) 
	  {
		  if (front != null)
		  {
			  back.setNext(new Node<T>(newItem));
			  back = back.getNext();
		  }
		  else
		  {
			  front = new Node<T>(newItem);
			  back = front;
		  }
	  }
	  
	  public T dequeue() throws QueueException
	  {
		  T item;
		  if (front != null)
		  {
			  item = front.getItem();
			  front = front.getNext();
		  }
		  else
		  {
			  throw new QueueException("Nothing in here to dequeue!!");
		  }
		  return item;
	  }

	  public void dequeueAll()
	  {
		  front = null;
		  back = null;
	  }

	  public T peek() throws QueueException
	  {
		  T item;
		  if (front != null)
		  {
			  item = front.getItem();
		  }
		  else
		  {
			  throw new QueueException("Nothing to peek at!");
		  }
		  
		  return item;
	  }
	  
	  public String toString()
	  {
		  StringBuilder string = new StringBuilder();
		  Node curr = front;
		  
		  while (curr != null)
		  {
			  string.append(" " + curr.getItem());
			  curr = curr.getNext();
		  }
		  return string.toString();
	  }
	}  