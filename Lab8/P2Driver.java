package Lab8;

/*
 * Purpose: Data Structure and Algorithms Lab 8 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 03/30/19
 * Submitted:  04/01/19
 * Comment: 
 * 	Used (A) Modified Sequential Search III for case4
 * 	and kind of case1.
 * @author: Christina Bannon
 * @version: 2019.03.30
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P2Driver
{
	static BufferedReader reader = 
			new BufferedReader(
					new InputStreamReader(System.in));

	public static void main(String []args) 
			throws IOException
	{
		ListArrayBasedPlus array = new ListArrayBasedPlus();

		System.out.println("Select from the following menu:");
		System.out.println(	"1. Insert item to list. \n" + 
				"2. Remove item from list. \n" + 
				"3. Get item from list. \n" + 
				"4. Search for a specified" +
				" item an ordered list\n" +
				"5. Clear list.\n"+
				"6. Print size and content of list. \n"+
				"7. Exit program.");	
		System.out.println("Make your menu selection now");
		int selection = Integer
				.parseInt(reader.readLine().trim());
		System.out.println(selection);
		while (selection != 7)	
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
			 * CB Getting an item from the list
			 */
			case 3: case3(array);
			break;

			/*
			 * CB Searching the list for an item
			 */
			case 4: case4(array);
			break;

			/*
			 * CB Clear list
			 */
			case 5: case5(array);
			break;

			/*
			 * CB Print list's toString
			 */
			case 6: case6(array);
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
	 * (2)Prompts the user for an integer to insert
	 * 	into the sorted list
	 * (3)If the LABP Object is not empty, method goes 
	 * 	into a loop (from 0 -> size-1) to determine
	 * 	where to store the integer...
	 * (4)..then stores it (if it is not already in 
	 * 	the loop) and exits the loop gracefully. 
	 * (5) Method then checks to see if the integer 
	 * 	entered is higher than the highest number
	 * 	in the array, 
	 * 		-> if this is so, then the inputted
	 * 		integer takes the last place in the LABP
	 * (6)If the LABP Object is empty, the integer
	 * 	is put in index 0 of the LABP object's array
	 * PRE: valid ListArrayBasedPlus is passed
	 * POST: integer added into ListArrayBasedPlus
	 * 	
	 */
	public static void
	case1(ListArrayBasedPlus array)	
			throws IOException
	{
		System.out.println("You are now inserting"
				+ " an integer into the list.");

		System.out.print("\tEnter number: ");
		Integer item = Integer.parseInt(reader
				.readLine()
				.trim());
		System.out.println(item);


		if (!array.isEmpty()) 
		{
			int i = 0;
			while ( i < array.size() )
			{
				//CB searching for the place to insert the item
				if(item > (Integer)array.get(i))
				{
					i++;
				}
				
				//CB for a successful insertion
				else if (item < (Integer)array.get(i))
				{
					array.add(i, item);
					System.out.println("Int " + item + 
							" has been inserted in " + 
							" position " + i);
					i = array.size();
				} 
				
				//CB for duplicates
				else
				{
					System.out.println("Int " + item + 
							" is already in position "+ 
							i + "." );
					i = array.size();
				}
			}

			//CB final clause for if the value 
			//happens to be higher than the other values 
			//in the array
			if (item > (Integer)array.get(array.size()-1))
			{
				array.add(array.size(), item);
			}

		}else {
			array.add(0, item);
			System.out.println("Int " + item + 
					" has been inserted in " + 
					" position 0.");
		}
	}

	/*
	 * CB
	 * case2: 
	 * (1)Accepts a ListArrayBasedPlus object
	 * (2)Prompts the user for index to remove object from
	 * (3)If the index is valid the object is deleted from
	 * 	the index
	 * (4)If the index is invalid, an error 
	 * message executes
	 * PRE: valid ListArrayBasedPlus is passed
	 * DURING: valid int inserted for index
	 * POST:object deleted from ListArrayBasedPlus
	 */
	public static void
	case2(ListArrayBasedPlus array) throws IOException
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
	 * (2)Prompts the user for index to retrieve object from
	 * (3)If the index is valid the object is accessed and 
	 * 	shown to the user
	 * (4)If the index is invalid, an error message executes
	 * PRE: valid ListArrayBasedPlus is passed
	 * DURING: valid int inserted for index
	 * POST:object accessed from ListArrayBasedPlus 
	 */
	public static void 
	case3(ListArrayBasedPlus array) throws IOException
	{
		System.out.println("\tEnter position to retrieve ");
		int index = Integer
				.parseInt(reader.readLine().trim());
		System.out.println(index);

		try 
		{
			System.out.println("Item " + array.get(index) +
					" retrieved from postition "+ index + 
					" in the list.");
		}
		catch (ListIndexOutOfBoundsException e)
		{
			System.out.println("Position specified "
					+ "is out of range!");
		}
	}

	/*
	 * CB
	 * case4: 
	 * (1)Accepts a ListArrayBasedPlus object
	 * (2)Prompts the user for an int to search the 
	 * 	underlying array for
	 * (3)If the int is found, method reports the index
	 * 	that it is found at
	 * (4)If the int is not found, method reports that 
	 * 	the int is not in this array
	 * PRE: valid ListArrayBasedPlus is passed
	 * DURING: String accepted
	 * POST: If String is in LABP array, index is printed
	 * 	if not, it is not 
	 */
	public static void
	case4(ListArrayBasedPlus array) throws IOException
	{	
		System.out.println("What is the number "
				+ "to search for? ");
		Integer item = Integer
				.parseInt(reader
						.readLine()
						.trim());
		
		if (!array.isEmpty())
		{
			
			if (item > (Integer)
					array.get(array.size() - 1))
			{
				System.out.println(item + " not found in "+ 
						"LABP.\nIf it were there,"
						+ " it would "+ 
						"be at index " + array.size() + ".");
			}
			else
			{
				int index = 0;
				
				//CB the Modified Sequential Search III
				while (index < array.size())
				{
					if (item > (Integer)array.get(index))
					{
						index++;
					}
					else if (item < (Integer)array.get(index))
					{
						System.out.println(item + " not "
								+ "found in LABP.\n If it"
								+ " were there, it would "+ 
								"be at index " 
								+ index + ".");
						index = array.size();
					}
					else 
					{
						System.out.println(array
								.get(index) + 
								" found at index " 
								+ index + 
								".");
						index = array.size();
					}
				}
			}
		}else {
			System.out.println("LABP is empty!!");
		}

	}

	/*
	 * CB 
	 * case5:
	 * (1)Accepts a ListArrayBasedPlus object
	 * (2) If LABP isn't empty...
	 * 	Empties the underlying array
	 * (3) If LABP is empty...
	 * 	Prints that LABP is empty. 
	 * PRE: valid ListArrayBasedPlus object
	 * POST: object's array is empty
	 */
	public static void case5(ListArrayBasedPlus array)
	{
		if (!array.isEmpty())
		{
			array.removeAll();
			System.out.println("LABP has been emptied.");
		}
		else
		{
			System.out.println("LABP is already empty!!");
		}
	}

	/*
	 * CB 
	 * case6: 
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
	public static void case6(ListArrayBasedPlus array)
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
