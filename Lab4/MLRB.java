package Lab4;

/*
//Please note that this code is slightly different from the textbook code 
//to reflect the fact that the Node class is implemented using data encapsulation


//****************************************************
//Reference-based implementation of ADT list.
//****************************************************
public class MLRB implements ListInterface 
{
//reference to linked list of items
private DNode head; 
private int numItems; // number of items in list

public MLRB()
{
numItems = 0;
head = null;
}  // end default constructor

public boolean isEmpty() 
{
return numItems == 0;
}  // end isEmpty

public int size() 
{
return numItems;
}  // end size

private Node find(int index) 
{
//--------------------------------------------------
//Locates a specified node in a linked list.
//Precondition: index is the number of the desired
//node. Assumes that 0 <= index <= numItems 
//Postcondition: Returns a reference to the desired 
//node.
//--------------------------------------------------
	
//CB modify index so that it has no limits	
index = (index % numItems);
DNode curr = head; 

//CB since the decimal will truncate, it makes sense for us to
//CB transverse from 0 is the case of the index being = to numItems/2
if (index >= 0)
{
	if (index >= (numItems/2)) 
	{
		for (int i = 0; i <= (numItems - index); i++)
		{
			curr = curr.getBack();
		}
	}
	else //CB if it's a positive number, smaller than n/2
	{
		for (int i = 0; i <= index; i++)
		{
			curr = ((DNode)curr.getNext());
		}
	}
}
else 
{  
	index = index *-1; //CB simplification - making the index + to work with 
						//CB absolutely distance values
	if ( index >= (numItems/2))
	{
		for (int i = 0; i <= (numItems - index); i++)
		{
			curr = ((DNode)curr.getNext());
		}
	}
	else //CB if the index is neg, and under n/2
	{
		for (int i = 0; i <= index; i++)
		{
			curr = curr.getBack();
		}
	}	
}
return curr;
}
public Object get(int index) 
           throws ListIndexOutOfBoundsException 
{
if (index >= 0 && index < numItems) 
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
if (index >= 0 && index < numItems+1) 
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
 numItems++;
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
if (index >= 0 && index < numItems) 
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
 numItems--;
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
numItems = 0;
} // end removeAll

} // end ListReferenceBased*/
