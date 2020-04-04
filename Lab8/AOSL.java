package Lab8;

/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: GOOD TO GO
 * Last update: 04/03/19
 * reSubmitted:  04/08/19
 * Comment: This is the corrected 
 *  AscengindlyOrderedStringList ADT
 *  that uses a binary search to 
 *  (A) locate where to place a String
 *  element in an Ascending Sorted List, 
 *  (B) locate an existing String element 
 *  in an ASL & 
 *  (C) locate where a nonexistent 
 *  element would be if it did exist 
 *  in the ASL
 *  (D) relay whether the given String exists 
 *  in the ASL or not
 * @author: Christina Bannon
 * @version: 2019.4.03
 */

public class AOSL implements AOSLInterface
{
	private String [] list;
	private int numItems;

	/*
	 * CB
	 * AOSL constructor initializes 
	 * numItems variable to 0,
	 */
	public AOSL()
	{
		numItems = 0;
	}

	/*
	 * CB
	 * isEmpty
	 * returns a boolean to represent if the number of 
	 * items in the array is 0 or not
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
	 * CB
	 * size
	 * returns an integer to represent the number of 
	 * items in the array
	 */
	public int size()
	{
		return numItems;
	}

	/*
	 * add
	 * method accepts a String item and inserts 
	 * the item into the spot it would belong in the 
	 * array of Strings ordered lowest to highest. 
	 * The add method does this by: 
	 * (1) checking to see if item is the initial item
	 * being put in the array, if it is then the 
	 * String is simply inserted at index 0. If not, 
	 * (2) the item is passed to the search method 
	 *  which returns an index encoded index (see 
	 *  search() method for index meaning)
	 * (3a) A temporary array (tempLargerArray) is 
	 * 	filled up to (but not including) the index
	 * (3b) input item was inserted into the index
	 * (3c) remainder of array is filled into the
	 *  temporary array into it's now-higher index
	 * (4) array is assigned a clone of 
	 * 	tempLargerArray, and tempLargerArray is marked 
	 *	for garbage collection
	 * 
	 * PRE: String passed to method
	 * POST: String is arranged in array 
	 * 	in ascending order position
	 */
	public void add(String item)
	{
		if (!(numItems == 0))  // (1)
		{
			int index = search(item); // (2)

			/*
			 * CB
			 * decoding the index from it's 
			 * invalid index = index + numItems + 1
			 * valid index = index 
		 	 * translator
			 */
			if (index > numItems)
			{
				index = index % (numItems + 1);
			}

			numItems++; 

			/*
			 * CB
			 * Making a new array to fill it each time a 
			 * a new element is added. Shifting is contingent
			 * on where the search() method decides that 
			 * the item belongs. Once tempLargerArray 
			 * is full, list is assigned as a clone 
			 * & tempLargerArray is marked for GC
			 */
			String[] tempLargerArray = 
					new String[list.length + 1];

			for (int i = 0 ; i < index; i++) //3a
			{
				tempLargerArray[i] = list[i];
			}

			tempLargerArray[index] = item; //3b

			for (int i = index; i < list.length; i++)
			{
				tempLargerArray[i + 1] = list[i]; //3c
			}

			list = tempLargerArray.clone(); //4
			tempLargerArray = null;
		}
		else  //1
		{
			/*
			 * It made sense to put the initialization 
			 * of the array down here - if we don't have anything
			 * to put in the array, why make the array?
			 * Is this legal or bad practice?
			 */
			list = new String [1];
			list [0] = item;
			numItems++;
		}

	}

	/*
	 * CB
	 * 
	 * get
	 * accepts an integer index and 
	 * if it is valid returns the String stored 
	 * 	at that position of the list.
	 * if index is invalid throws a 
	 * 	ListIndexOutOfBoundsException
	 * 
	 * PRE: 0 <= index < numItems index is passed to 
	 * 	method
	 * POST: String value stored at index is returned
	 */
	public String get(int index) 
			throws ListIndexOutOfBoundsException
	{
		String result; 
		if ((index < numItems) && (index >= 0))
		{
			result = list[index];
		}
		else
		{
			throw new ListIndexOutOfBoundsException("INVALID INPUT");
		}
		return result;
	}

	/*
	 * CB
	 * 
	 * get
	 * (1) accepts an integer index and 
	 * (2) if index is valid removes the String stored 
	 * 	at that position of the list, then 
	 * (3) everything previously in the list, 
	 * 	after the position of the removed String
	 *  is shifted to its new correct position 
	 * (4) if it is invalid throws a 
	 * 	ListIndexOutOfBoundsException
	 * 
	 * PRE: 0 <= index < numItems index is passed to 
	 * 	method
	 * POST: String value stored at index is removed
	 */
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
			if (numItems == 0)
			{
				list = null;
			}
		}
		else
		{
			throw new ListIndexOutOfBoundsException
			("Theres nothing here!!!");
		}
	}
	
	/*
	 * CB 
	 * 
	 * search
	 * Accepts a String, utilizes a binary search to 
	 * locate exactly where that String is OR belongs
	 * in an ascendingly ordered array, and returns 
	 * a single integer with this information encoded:
	 *  - the index is encoded in the search method to 
	 *   be a single integer which can relay the 
	 *   existence or nonexistence of the item 
	 *   passed in the array. 
	 *  - for an item existing in the array, the search
	 *   method will return the exact index of where in 
	 *   the array the item is. 
	 *  - for an item that does not exist in the array,
	 *   the method will return (index of where it 
	 *   would be  + 1 + numItems)
	 *   
	 *  PRE: String item passed to be searched for
	 *  POST: index of where String is or 
	 *    belongs is returned
	 */
	public int search(String item)
	{
		int low = 0;
		int high = numItems - 1;
		int mid = 0;
		int resultIndex = mid;

		while(low <= high)
		{
			mid = (low + high)/2;
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
			
			/*
			 * CB
			 * the execution of this else 
			 * statement signifies the only "success"
			 * and only executes the the item entered into 
			 * the search method has met it's 
			 * lexio match. That is why this is the only 
			 * resultIndex option that returns
			 * the true index of where an item is. 
			 */
			else
			{
				resultIndex = mid;
				low = high + 1; //CB exiting the loop
			}

		}//CB end while
		return resultIndex;
	}

	/*
	 * CB
	 * 
	 * clear
	 * sets numItems to null and marks list for garbage 
	 * collection
	 * POST: no more list
	 */
	public void clear()
	{
		list = null;
		numItems = 0;
	}

	/*
	 * toString 
	 * 
	 * PRE: list array cannot be null,
	 * 	 must have some value in it
	 * POST: returns a String showing every element in 
	 * the list array ordered
	 */
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