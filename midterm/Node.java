package midterm;

public class Node<T>
{
	protected T item;
	protected Node<T> next;

	public Node(T newItem) 
	{
	  item = newItem;
	  next = null;
	} // end constructor

	public Node(T newItem, Node<T> nextNode) 
	{
	  item = newItem;
	  next = nextNode;
	} // end constructor

	public void setItem(T newItem) 
	{
	  item = newItem;
	} // end setItem

	public T getItem() 
	{
	  return item;
	} // end getItem

	public void setNext(Node<T> nextNode) 
	{
	  next = nextNode;
	} // end setNext
	
	
	public Node<T> getNext()
	{
		return next;
	}
}
