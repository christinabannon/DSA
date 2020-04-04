package Lab8;

/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: This is the AOSL that can also use a 
 * 	binary search to relay if it's right
 * Last update: 04/02/19
 * Submitted:  04/01/19
 * Comment: Extra Credit # 1 included,
 *  duplicates allowed in add!!
 * @author: Christina Bannon
 * @version: 2019.4.02
 */

public class AOSL2 implements AOSLInterface
{

	private String [] list;
	private int numItems;

	public AOSL2()
	{
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
		if (!(numItems == 0))
		{

			int index = search(item);

			//CB decoding the index from it's 
			// invalid index = index + numItems + 1
			// valid index = index 
			// translator

			if (index > numItems)
			{
				index = index % (numItems + 1);
			}

			numItems++; 


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
			System.out.println(toString());
		}
		else
		{

			list = new String [1];
			list [0] = item;
			numItems++;

			System.out.println(toString());
		}

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

		int low = 0;
		int high = numItems - 1;
		int mid = 0;
		int resultIndex = mid;

		while(low <= high)
		{

			mid = (low + high)/2;


			//if the number is less then the thing
			//in the middle of list we are looking at, 
			//we only look underneath that thing
			if (item.compareTo(list[mid].toString()) < 0)
			{
				high = mid - 1;

				resultIndex = mid + numItems + 1;	
			}
			else if (item.compareTo(list[mid].toString()) > 0)
			{
				low = mid + 1;

				resultIndex = mid + numItems + 1;

				if (item.compareTo(list[numItems - 1]) > 0)
				{
					resultIndex = numItems;
				}

			}
			//CB This is the only successful one. 
			//there is nothing added to it
			else
			{
				resultIndex = mid;
				low = high + 1; //CB exiting the loop
			}

		}//CB end while

		return resultIndex;
	}

	public void clear()
	{
		list = null;
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
