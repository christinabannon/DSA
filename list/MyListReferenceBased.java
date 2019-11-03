package list;

/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 3
 * Status: Complete and thoroughly tested         
 * Last update: 02/10/19                          
 * Submitted:  02/11/19                           
 * Comment: test suite and sample run attached    
 * @author: Christina Bannon                      
 * @version: 2019.02.07                           
 */                                               

public class MyListReferenceBased implements ListInterface

{
	// reference to linked list of items
	private Node head; 

	public MyListReferenceBased() 
	{
	 head = null;
	}  // end default constructor

	public boolean isEmpty() 
	{
	 return size() == 0;
	}  // end isEmpty

	public int size() 
	{
		Node curr = head;
		int size = 0;
		while (curr != null)
		{
			curr = curr.getNext();
			size++;
		}
		
		return size;
	}  // end size

	private Node find(int index) 
	{
	// --------------------------------------------------
	// Locates a specified node in a linked list.
	// Precondition: index is the number of the desired
	// node. Assumes that 0 <= index <= numItems 
	// Postcondition: Returns a reference to the desired 
	// node.
	// --------------------------------------------------
	 Node curr = head;
	 for (int skip = 0; skip < index; skip++) 
	 {
	   curr = curr.getNext();
	 } // end for
	 return curr;
	} // end find

	public Object get(int index) 
	             throws ListIndexOutOfBoundsException 
	{
	 if (index >= 0 && index < size()) 
	 {
	   // get reference to node, then data in node
	   Node curr = find(index);
	   Object dataItem = curr.getItem();
	   return dataItem;
	 } 
	 else 
	 {
	   throw new ListIndexOutOfBoundsException(
	                  "List index out of bounds exception on get");
	 } // end if
	} // end get

	public void add(int index, Object item)
	               throws ListIndexOutOfBoundsException 
	{
	 if (index >= 0 && index < size()+1) 
	 {
	   if (index == 0) 
	   {
	     // insert the new node containing item at
	     // beginning of list
	     Node newNode = new Node(item, head);
	     head = newNode;
	   } 
	   else 
	   {
	     Node prev = find(index-1);
	     // insert the new node containing item after 
	     // the node that prev references
	     Node newNode = new Node(item, prev.getNext());
	     prev.setNext(newNode);
	   } // end if
	 } 
	 else 
	 {
	   throw new ListIndexOutOfBoundsException(
	                 "List index out of bounds exception on add");
	 } // end if
	}  // end add

	public void remove(int index) 
	                throws ListIndexOutOfBoundsException 
	{
	 if (index >= 0 && index < size()) 
	 {
	   if (index == 0) 
	   {
	     // delete the first node from the list
	     head = head.getNext();
	   } 
	   else 
	   {
	     Node prev = find(index-1);
	     // delete the node after the node that prev
	     // references, save reference to node
	     Node curr = prev.getNext(); 
	     prev.setNext(curr.getNext());
	   } // end if
	 } // end if
	 else 
	 {
	   throw new ListIndexOutOfBoundsException(
	                "List index out of bounds exception on remove");
	 } // end if
	}   // end remove

	public void removeAll() 
	{
	 // setting head to null causes list to be
	 // unreachable and thus marked for garbage 
	 // collection
	 head = null;
	} // end removeAll
	
	@Override
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		
		for (Node curr = head; curr != null; curr = curr.getNext())
		{
			string.append(curr.getItem() + " ");
		}
		
		return string.toString();
	}
}
