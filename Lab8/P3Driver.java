package Lab8;

/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 3
 * Status: Somewhat buggy and and moderately tested
 * Last update: 04/01/19
 * Submitted:  04/01/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.04.01
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P3Driver
{
	static BufferedReader reader = 
			new BufferedReader(
					new InputStreamReader(System.in));
	
	public static void main(String []args) 
			throws IOException
	{
		AscendinglyOrderedStringListD 
		array = new AscendinglyOrderedStringListD();

		System.out.println("Select from the following menu:");
		System.out.println(	"1. Insert item to list. \n" + 
				"2. Remove item from list. \n" + 
				"3. Search for a specified" +
					" item in the list\n" +
				"4. Clear list.\n"+
				"5. Print size and content of list. \n"+
				"6. Exit program.");	
		System.out.println("Make your menu selection now");
		int selection = Integer
				.parseInt(reader.readLine().trim());
		System.out.println(selection);
		
		while (selection != 6)	
		{
			switch(selection)
			{
			/*
			 * CB Inserting an item to the list
			 */
			case 1:	case1(array);
			break;

			/*
			 * CB Removing an item from the list
			 */
			case 2: case2(array);
			break;
			
			
			/*
			 * CB Searching the list for an item
			 */
			case 3: case3(array);
			break;
			
			/*
			 * CB Clear list
			 */
			case 4: case4(array);
			break;
			
			/*
			 * CB Print list's toString
			 */
			case 5: case5(array);
			break;
			}
			System.out.println();
			System.out.print("Make your menu selection now: ");
			selection = Integer
					.parseInt(reader.readLine().trim());
			System.out.println(selection);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Exiting program... Good bye!");
	}
	
	/*
	 * CB
	 * case1: 
	 * (1)Accepts a ListArrayBasedPlus object
	 * (2)Prompts the user for String to be inserted 
	 * PRE: valid ListArrayBasedPlus is passed
	 * DURING: valid String inserted
	 * 		  valid integer inserted for index
	 * POST: String added into ListArrayBasedPlus
	 * 	
	 */
	public static void
	case1(AscendinglyOrderedStringListD array)	
			throws IOException
	{
		System.out.println("You are now inserting"
				+ " an item into the list.");
		
		System.out.print("\tEnter item: ");
		String item = reader.readLine().trim();
		System.out.println(item);
		
		array.add(item);
		System.out.println("it's added.\n ");
		System.out.println("\nItem " + item + 
					" inserted into position "
					+ (array.search(item)) + 
					" in the list.");
	}
	
	/*
	 * CB
	 * case2: 
	 * (1)Accepts a ListArrayBasedPlus object
	 * (2)Prompts the user for index to remove object from
	 * (3)If the index is valid the object is deleted from
	 * 	the index
	 * (4)If the index is invalid, an error message executes
	 * PRE: valid ListArrayBasedPlus is passed
	 * DURING: valid int inserted for index
	 * POST:object deleted from ListArrayBasedPlus
	 */
	public static void
	case2(AscendinglyOrderedStringListD array)
			throws IOException
	{
		System.out.println("\tEnter position to"
				+ " remove item from");
		int index = 
				Integer.parseInt(reader.readLine().trim());
		System.out.println(index);
		
		try
		{
			System.out.println("Item " + array.get(index)+ 
					" removed from position " + index +
					" on the list.");
			array.remove(index);
		}
		catch (ListIndexOutOfBoundsException 
				| ArrayIndexOutOfBoundsException e)
		{
			System.out.print("Position specified"
					+ " is out of range!");
		}
	}
	
	
	/*
	 * CB
	 * case3: 
	 * (1)Accepts a ListArrayBasedPlus object
	 * (2)Prompts the user for a String to search the 
	 * 	underlying LABP array for
	 * (3)If the String is found, method reports the index
	 * 	that it is found at
	 * (4)If the String is not found, method reports that 
	 * 	the String is not in this array, but where 
	 * 	it would be if it were in the array
	 * PRE: valid ListArrayBasedPlus is passed
	 * DURING: String accepted
	 * POST: If String is in LABP array, index is printed
	 * 	if not, it is not 
	 */
	public static void
	case3(AscendinglyOrderedStringListD array)
			throws IOException
	{
			System.out.println("What is the string "
				+ "to search for? ");
		String item = reader.readLine().trim();
		System.out.println(item);

		int index = array.search(item);
		
		if (index <= array.size())
		{
			System.out.print("String " + item +
					" found in the array at index: " + 
					index);
		}
		else
		{
			System.out.println("String " + item + 
					" is not in the array, "
					+ "\nbut if it were in there it would"
					+ " be in position " + 
					index % array.size());
		}
	}
	
	/*
	 * CB 
	 * case4:
	 * (1)Accepts a ListArrayBasedPlus object
	 * (2) If LABP isn't empty...
	 * 	Empties the underlying array
	 * (3) If LABP is empty...
	 * 	Prints that LABP is empty. 
	 * PRE: valid ListArrayBasedPlus object
	 * POST: object's array is empty
	 */
	public static void 
	case4(AscendinglyOrderedStringListD array)
	{
		if (!array.isEmpty())
		{
			array.clear();
			System.out.println("LABP has been emptied.");
		}
		else
		{
			System.out.println("LABP is already empty!!");
		}
	}
		
	/*
	 * CB 
	 * case5: 
	 * (1)Accepts a ListArrayBasedPlus object
	 * (2)If the LABP isn't empty...
	 * 	Prints LABP's toString method, which is the
	 * 	size of the underlying array, and the items within
	 * 	it, formatted.
	 * (3)If the LABP is empty...
	 * 	Prints that the LABP is empty
	 * PRE: valid ListArrayBasedPlus is passed
	 * POST: Prints LABP's toString method, which is the
	 * 	size of the underlying array, and the items within
	 * 	it, formatted.
	 */
	public static void 
	case5(AscendinglyOrderedStringListD array)
	{
		if (!array.isEmpty())
		{
			System.out.println(array.toString());
		}
		else
		{
			System.out.println("List is empty!");
		}
	}	
}