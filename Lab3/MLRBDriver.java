package Lab3;

/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/08/19
 * Submitted:  02/11/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.08
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MLRBDriver 
{
	public static void main(String [] args) throws IOException
	{
	BufferedReader reader = 
	new BufferedReader( new InputStreamReader(System.in));
		
	MyListReferenceBased list = new MyListReferenceBased();

	System.out.println("Select from the following menu: ");
	System.out.println("1. Insert item to list \n" + 
					"2. Remove item from list \n" + 
					"3. Get item from list \n" + 
					"4. Clear list \n" + 
					"5. Display size and content \n" + 
					"6. Delete largest item in the list \n" + 
					"7. Reverse the list \n" + 
					"8. Exit program");
	System.out.print("Make your menu selection now: ");
	int selection = Integer.parseInt(reader.readLine().trim());
	System.out.print(selection);
	System.out.println();
		
	while (selection != 8)
	{
	switch(selection)
	{
		//CB Adds a new node to the linked list!
		case 1: 
		{
			System.out.println("You are now inserting an item " + 
							"into the list.");
					
			System.out.print("\tEnter item: " );
			Object item = reader.readLine().trim();
			System.out.print(item);
			System.out.println();
					
			System.out.print("\tEnter position to insert item in: " );
			int index = Integer.parseInt(reader.readLine().trim());
			System.out.print(index);
			System.out.println();
					
			try
			{
				list.add(index, item);
						
				System.out.println("Item " + item +
						" inserted in position " + index + 
						" in the list.");
			}
			catch (ListIndexOutOfBoundsException e)
			{
				System.out.println("Position specified is out " + 
						  			"of range!");
			}
		}
		break;
		
		//CB removes an item from the list
		case 2:
		{
			System.out.print("\tEnter position to remove item from : ");
			int index = Integer.parseInt(reader.readLine().trim());
			System.out.print(index);
			System.out.println();
			try 
			{
				Object item = list.get(index);
				list.remove(index);
				System.out.println("Item " + item + " removed from " +
						"position " + index + " in the list.");
			}
			catch (ListIndexOutOfBoundsException e)
			{
				System.out.println("Position specified is out" +
									" of range!");
			}
		}
		break;
		
		//CB retrieves an item from the list
		case 3:
		{
			System.out.print("\tEnter position to retrieve item from: ");
			int index = Integer.parseInt(reader.readLine().trim());
			System.out.println(index);
			try 
			{
				System.out.println("\tItem " + list.get(index) + 
						" retrieved from position " + index + 
						" in the list");
			}
			catch (ListIndexOutOfBoundsException e)
			{
				System.out.println("Position specified is out" +
									" of range!");
			}
		}
		break;
		
		//CB Erases entire list!
		case 4: 
		{
			list.removeAll();
		}
		break;
		
		case 5:
		{
			if (!list.isEmpty())
			{
				System.out.print("\tList of "+
		   		"size " + list.size() + " has the following items : ");
				System.out.print(list.toString());
				System.out.println();
			}
			else
			{
				System.out.println("List is empty.");
			}
		}
		break;
				
		case 6:
		{
			if (!list.isEmpty())
			{
				int max =0;
				
				for( int i = 0, check; i < list.size(); i++)
				{
					check = ((String)list.get(max))
							.compareTo(((String)list.get(i)));
					if (check < 0)
					{
						max = i;
					}
				}

				System.out.print("Largest item "+ list.get(max) + " deleted.\n");
				list.remove(max);
			}
			else
			{
				System.out.println("List is empty, nothing to delete!");
			}
		}
		break;
				
		case 7: 
		{
			if (!list.isEmpty())
			{
				MyListReferenceBased newList = new MyListReferenceBased();
					
				for (int i = 0, size = list.size()-1; size >=0; i++, size--)
				{
					newList.add(i, list.get(size));
				}
				
				list = newList;	
				
				System.out.println("List has been reversed.");
				System.out.println("Here is the content:  "+ list.toString());
			}
			else
			{
				System.out.println("List is empty.. nothing to reverse!");
			}
		}
		break; 
				
		}
			System.out.println();
			System.out.print("Make your menu selection now: ");
			selection = Integer.parseInt(reader.readLine().trim());
			System.out.print(selection);
			System.out.println();
		}
		System.out.println("Good bye!");
	}
}
