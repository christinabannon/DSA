package Lab8;
/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: This one kind of works. The main issue is now with returning 
 * 	from a search where a thing SHOULD be, if it is not in the search. I worked on it 
 * 	further in AOSL 2. 
 * Last update: 03/30/19
 * Submitted:  04/01/19
 * Comment: Extra Credit # 1 included, duplicates allowed in add!!
 * @author: Christina Bannon
 * @version: 2019.3.30
 */

public class AscendinglyOrderedStringListD implements AOSLInterface
{
	
	private String [] list;
	private int numItems;

	public AscendinglyOrderedStringListD()
	{
		list = new String [1];
		numItems = 0;
	}
	
	/*
	 * isEmpty
	 * returns a boolean to represent if the number of items
	 * in the array is 0 or not
	 */
	public boolean isEmpty()
	{
		boolean result = true;
		if (list.length > 0)
		{
			result = false;
		}
		return result; 
	}
	
	/*
	 * size
	 * returns an integer to represent the number of 
	 * items in the array
	 */
	public int size()
	{
		return numItems;
	}
	
	public void add(String item)
	{
			//////////
			System.out.println("ADD \n ........");
			System.out.println(item + "being passed to search()");
			int index = search(item);
			System.out.println("Index returned to Add: " + index);
			
			numItems++;
			
			//CB the index being higher than numItems signifies 
			//that the item which belongs @ the index is 
			//higher than anything in the array. 
			/*
			if(index > numItems )
			{
				///////
				System.out.print("index " + index + " > numItems " + numItems);
				index = index % (numItems + 1);
				System.out.print("Modulared index: " + index);
			}
			*/
			
			String[] largerArray = 
					new String[list.length + 1];
			
			for (int i = 0 ; i < index; i++)
			{
				largerArray[i] = list[i];
			}
			
			largerArray[index] = item;
			
			for (int i = index; i < list.length; i++)
			{
				largerArray[i + 1] = list[i];
			}
			
			list = largerArray;
	}

	public String get(int index) throws ListIndexOutOfBoundsException
	{
		String result; 
		if ((index < list.length) && (index >= 0))
		{
			result = list[index];
		}
		else
		{
			throw new ListIndexOutOfBoundsException("INVALID INPUT");
		}
		return result;
	}
	
	public void remove(int index) throws ListIndexOutOfBoundsException
	{
		if ((index < list.length) && (index >= 0))
		{
			for (int i = index; i < list.length-1; i++)
			{
				list[index] = list[index + 1];
			}
			list[list.length - 1] = null;
			numItems --; 
		}
	}
	
	public int search(String item)
	{
		System.out.println("SEARCH");
		
		int low = 0;
		int high = numItems;
		int mid = 0;
		int resultIndex = mid;

		while(low < high)
		{
			System.out.println("IN THE WHILE");
			
			mid = (low + high)/2;
			System.out.println("\tnew mid: " + mid);

			//if the number is less then the thing
			//in the middle of list we are looking at, 
			//we only look underneath that thing
			if (item.compareTo(list[mid].toString()) < 0)
			{
				System.out.println(item + " <= " + list[mid]);
				high = mid - 1;
				System.out.println("new high = " + high);
				
				//CB if the item is smaller than anything in 
				//the array, make the result 0 and exit the loop
				//
				if (item.compareTo(list[0].toString()) < 0 )
				{
					resultIndex = 0;
					low = high;
				}
			}
			else if (item.compareTo(list[mid].toString()) > 0)
			{
				System.out.println(item + " > " + list[mid]);
				low = mid + 1;
				System.out.println("new low = " + low);
				
				//CB if item is bigger than 
				//anything in the array - exit immediately 
				//with a an index of numItems + 
				//1 (the next numItems)
				if (item.compareTo(list[high-1].toString()) > 0)
				{
					resultIndex = high; //make the resultIn
					low = high;
				}
			}
			else
			{
				resultIndex = mid;
				low = high;
			}


		}//CB end while
		
		return resultIndex;

/*
		if (item.equals(list[mid].toString()))
		{
			resultIndex = mid;
		}
		else
		{
			if (item.compareTo(list[numItems-1]) > 0)
			{
				mid++;
			}
			resultIndex = mid + 1 + numItems;
		}
*/
	}
	
	public void clear()
	{
		list = new String [1];
		numItems = 0;
	}
	
	@Override
	public String toString()
	{
		StringBuilder string = 
				new StringBuilder("List of size " 
		+ numItems +" has the following items: ");
		
		for (int i = 0; i < list.length; i++)
		{
			string.append(list[i] + " ");
		}
		return string.toString();
	}
	
}