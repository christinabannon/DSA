package Lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Exception;


/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/02/19
 * Submitted:  02/04/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.02
 */

public class ListArrayListBasedDriver
{
	public static void main(String []args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ListArrayListBasedPlus array = new ListArrayListBasedPlus();

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
				System.out.println("You are now inserting an item into the list.");
				System.out.print("\tEnter item: ");
				String item = reader.readLine().trim();
				System.out.println(item);
				System.out.print("\tEnter postition to insert item in: ");
				int index = Integer.parseInt(reader.readLine().trim());
				System.out.println(index);
			
				try 
				{
					array.add(index, item);
					System.out.println("Item " + item + " inserted into position "+ 
							index + " in the list.");
				}
				catch (IndexOutOfBoundsException e)
				{
					System.out.println("Position specified is out of range!");
				}
				System.out.println();
				System.out.print("Make your menu selection now: ");
				selection = Integer.parseInt(reader.readLine().trim());
				System.out.println(selection);
				
			}
			break;

			//CB removing an item from the list
			case 2: 
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
				catch (IndexOutOfBoundsException e)
				{
					System.out.print("Position specified is out of range!");
				}
				System.out.println();
				System.out.print("Make your menu selection now: ");
				selection = Integer.parseInt(reader.readLine().trim());
				System.out.println(selection);
			}
			break;
			
			//CB retrieving and item from the list
			case 3:
			{
				System.out.println("\tEnter position to retrieve ");
				int index = Integer.parseInt(reader.readLine().trim());
				System.out.println(index);
				
				try 
				{
					System.out.println("Item " + array.get(index) +
							" retrieved from postition "+ index + 
							" in the list.");
				}
				catch (IndexOutOfBoundsException e)
				{
					System.out.println("Position specified is out of range!");
				}
				
				System.out.println();
				System.out.print("Make your menu selection now: ");
				selection = Integer.parseInt(reader.readLine().trim());
				System.out.println(selection);
			}
			break;
			
			//CB clearing the list
			case 4: 
			{
				array.removeAll();
				
				System.out.println();
				System.out.print("Make your menu selection now: ");
				selection = Integer.parseInt(reader.readLine().trim());
				System.out.println(selection);
			}
			break;
			
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
				selection = Integer.parseInt(reader.readLine().trim());
				System.out.println(selection);
				
			}
			break;

			case 6:
			{
				array.reverse();
				
				System.out.println("List reversed");
				
				System.out.println();
				System.out.print("Make your menu selection now: ");
				selection = Integer.parseInt(reader.readLine().trim());
				System.out.println(selection);

			}
			break;
			
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Exiting program... Good bye!");
	}
}
