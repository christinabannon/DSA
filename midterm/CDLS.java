package midterm;

public class CDLS<T> extends SLS<T> implements ListInterface<T>
{
	// reference to linked list of items
	private DNode<T> head;
	private int numItems; // number of items in list

	public CDLS() {
		numItems = 0;
		head = null;
	} // end default constructor

	public boolean isEmpty() {
		return numItems == 0;
	} // end isEmpty

	public int size() {
		return numItems;
	} // end size

	private DNode<T> find(int index) {

		// CB modify index so that it has no limits
			index = (index % (numItems));

		DNode<T> curr = head;

		// CB since the decimal will truncate, it makes sense for us to
		// CB traverse from 0 is the case of the index being 
		// CB = to numItems/2, in this case, the # of traversals @ worst
		// CB could be (n/2) + 1
		
		
		if (index >= 0) {
			if (index >= (numItems / 2)) 
				{
					for (int i = 0; i < (numItems - index); i++) 
					{
					curr = curr.getBack();
					}
				} 
			else // CB if it's a positive number, smaller than n/2
			{
				for (int i = 0; i < index; i++) {
					curr =  curr.getNext();
				}
			}
		} else {
			index = index * -1; // CB simplification - making the index + to work with
								// CB absolutely distance values
			if (index >= (numItems / 2)) {
				for (int i = 0; i < (numItems - index); i++) {
					curr = curr.getNext();
				}
			} else // CB if the index is neg, and under n/2
			{
				for (int i = 0; i < index; i++) {
					curr = curr.getBack();
				}
			}
		}
		return curr;
	}

	@Override
	public T get(int index) {

		return (T)find(index).getItem();
	} // end get

	//CB new add!!
	@Override
	public void add(int index, T item) {
		switch(numItems)
		{
			case 0: 
			{
			head = new DNode<T>(item);	
			}
			break;
			
			default:		
			{
				//CB find's max traversals - (n/2) + 1
				//CB prev is locating the node before the index,
				//CB max traversals (n/2) +1 -1 = n/2
				DNode<T> prev = find(index-1); 
				//CB now with next, add() is up to n/2 + 1 traversals
				DNode<T> next = prev.getNext();
				DNode<T> newNode = new DNode<T>(item, next, prev);
		
				if (index == 0)
				{
					head = newNode;
				}
		
				prev.setNext(newNode);
				next.setBack(newNode);
			}
		 	break;
		}
		numItems++;
	} // end add	
	
	@Override
	public void remove(int index)
	{
		switch (numItems)
		{
		case 1: 
			head = null;
			break;
		default:
		{
			//CB find uses a max n/2 + 1 traversals
			//CB so prev required n/2 traversals
			DNode<T> prev = find(index-1);
			//CB next hops over the 'current' index
		
			//CB now it's [ (n/2)+2 ] = (n/2) + 2 traversals
			DNode<T> next = prev.getNext().getNext();
		
			//CB hop over the current and setNext as the one after
			prev.setNext(next);
		
			//CB hop over the current and setBack as the one behind
			next.setBack(prev);
		
			if (index == 0)
			{
				head = next;
			}
		}
		break;
		}
		numItems --;
	} // end remove

	@Override
	public void removeAll() 
	{
		// setting head to null causes list to be
		// unreachable and thus marked for garbage
		// collection
		head = null;
		numItems = 0;
	} // end removeAll
	
	@Override
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		DNode<T> curr = head;
		
		for (int i =0; i < numItems; i++)
		{
			string.append(curr.getItem() + " ");
			curr = curr.getNext();
		}	
		return string.toString();
	}

} 
