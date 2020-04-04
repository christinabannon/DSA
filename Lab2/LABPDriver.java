package Lab2;

/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/02/19
 * Submitted:  02/04/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.02
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Lab8.ListIndexOutOfBoundsException;

import java.io.IOException;

public class LABPDriver
{
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String []args) throws IOException
	{
		ListArrayBasedPlus array = new ListArrayBasedPlus();

		System.out.println("Select from the following menu:");
		System.out.println(	"1. Insert item to list. \n" + 
				"2. Remove item from list. \n" + 
				"3. Get item from list. \n" + 
				"4. Clear list. \n" +
				"5. Print size and content of list. \n"+
				"6. Reverse list. \n"+
				"7. Exit program.");	
		System.out.println("Make your menu selection now");
		int selection = Integer.parseInt(reader.readLine().trim());
		System.out.println(selection);
		while (selection != 7)	
		{
			switch(selection)
			{
			case 1: //CB inserting an item to the list
			{
				case1(array);
			}
			break;

			//CB removing an item from the list
			case 2: 
			{
				case2(array);
			}
			break;
			
			//CB retrieving and item from the list
			case 3:
			{
				case3(array);
			}
			break;
			
			//CB clearing the list
			case 4: 
			{
				
			}
			
			//CB printing the 
			case 5:
			{
				if (!array.isEmpty())
				{
				System.out.println(array.toString());
				}
				else
				{
					System.out.println("List is empty!");
				}
				
				System.out.println();
				System.out.print("Make your menu selection now: ");
				selection = Integer
						.parseInt(reader.readLine().trim());
				System.out.println(selection);
				
			}
			break;

			case 6:
			{
				array.reverse();
				
				System.out.println("List reversed");
				
				System.out.println();
				System.out.print("Make your menu selection now: ");
				selection = Integer
						.parseInt(reader.readLine().trim());
				System.out.println(selection);

			}
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
	 * case1: 
	 * (1)Accepts a ListArrayBasedPlus object
	 * (2)Prompts the user for String to be inserted and the position
	 *   to insert the item in
	 * (3)If the index is valid the String is entered at the index
	 * (4)If the index is invalid, an error message executes
	 * PRE: valid ListArrayBasedPlus is passed
	 * 		valid String inserted
	 * 		valid int inserted for index
	 * POST: String added into ListArrayBasedPlus
	 * 	
	 */
	public static void
	case1(ListArrayBasedPlus array)	throws IOException
	{
		System.out.println("You are now inserting"
				+ " an item into the list.");
		
		System.out.print("\tEnter item: ");
		String item = reader.readLine().trim();
		System.out.println(item)
		;
		System.out.print("\tEnter postition to insert item in: ");
		int index = Integer.parseInt(reader.readLine().trim());
		System.out.println(index);
	
		try 
		{
			array.add(index, item);
			System.out.println("Item " + item + 
					" inserted into position "+ 
					index + " in the list.");
		}
		catch (ListIndexOutOfBoundsException e)
		{
			System.out.println("Position specified"
					+ " is out of range!");
		}
	}
	
	/*
	 * case2: 
	 * (1)Accepts a ListArrayBasedPlus object
	 * (2)Prompts the user for index to remove object from
	 * (3)If the index is valid the object is deleted from
	 *  the index
	 * (4)If the index is invalid, an error message executes
	 * PRE: valid ListArrayBasedPlus is passed
	 * 		valid int inserted for index
	 * POST:object deleted from ListArrayBasedPlus
	 */
	public static void
	case2(ListArrayBasedPlus array) throws IOException
	{
		System.out.println("\tEnter position to remove item from");
		int index = Integer.parseInt(reader.readLine().trim());
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
	 * case3: 
	 * (1)Accepts a ListArrayBasedPlus object
	 * (2)Prompts the user for index to retrieve object from
	 * (3)If the index is valid the object is accessed and 
	 * 	shown to the user
	 * (4)If the index is invalid, an error message executes
	 * PRE: valid ListArrayBasedPlus is passed
	 * 		valid int inserted for index
	 * POST:object accesed from ListArrayBasedPlus 
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
	 * case 4:
	 * 
	 */
	public static void
	case4(ListArrayBasedPlus array, 
			String item) throws IOException
	{
		
	}
}
