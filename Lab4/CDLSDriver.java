package Lab4;


/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/17/19
 * Submitted:  02/18/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.17
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CDLSDriver 

{

static BufferedReader reader = 
new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args)
			throws IOException 
	{
		ListCDLSBased list = new ListCDLSBased();

		System.out.println("Select from the following menu: ");
		System.out.println("0. Exit Program \n"
				+ "1. Insert item to list. \n"
				+ "2. Remove item from list. \n"
				+ "3. Get item from list. \n"
				+ "4. Clear list. \n"
				+ "5. Display size and content. \n"
				+ "6. Reverse the List. \n");
		System.out.print("Make your menu selection now: ");
		int selection = Integer.parseInt(reader.readLine().trim());
			System.out.print(selection);
		System.out.println();

		while (selection != 0) {
			switch (selection) {
			// CB Adds a new node to list!
			case 1: {
				list = case1(list);			
			}
				break;

			// CB removes an item from the list
			case 2: {
				list = case2(list);
			}
				break;

			// CB retrieves an item from the list
			case 3: {
				list = case3(list);
			}
				break;

			// CB Erases entire list!
			case 4: {
				list = case4(list);
			}
				break;

			case 5: {
				case5(list);
			}
				break;
				
				//CB reversing the list
			case 6: {
				list = case6(list);
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
	
	//CB Case 1 into a method!!
	public static ListCDLSBased case1(ListCDLSBased list) 
			throws IOException
	{
		System.out.println("You are now inserting an item "
				+ "into the list.");

		System.out.print("\tEnter item: ");
		Object item = reader.readLine().trim();
			System.out.print(item);
		System.out.println();

		System.out.print("\tEnter position to insert item in: ");
		int index = Integer.parseInt(reader.readLine().trim());
			System.out.print(index);
		System.out.println();

		list.add(index, item);
		System.out.println("Item " + item 
				+ " inserted in position " + index 
				+ " in the list.");

		return list;
	}
	
	//CB Case 2 into a method
	public static ListCDLSBased case2(ListCDLSBased list) 
			throws IOException
	{
		
		System.out.print("\tEnter position to remove item from : ");
		int index = Integer.parseInt(reader.readLine().trim());
		System.out.print(index);
		System.out.println();

		Object item = list.get(index);
		list.remove(index);
		System.out.println("Item " + item + " removed from " 
			+ "position " + index + " in the list.");
		
		return list;
	}
	
	//CB Case 3 into a method - 'gets' and item
	public static ListCDLSBased case3(ListCDLSBased list) 
			throws IOException
	{
		System.out.print("\tEnter position to retrieve item from: ");
		int index = Integer.parseInt(reader.readLine().trim());
		System.out.println(index);

			System.out.println("\tItem " + list.get(index) 
			+ " retrieved from position " + index + " in the list");

		return list;
	}
	
	//CB Case 4 removes the entire method
	public static ListCDLSBased case4(ListCDLSBased list)
	{
		list.removeAll();
		System.out.println("List cleared!");
		return list;
	}
	
	//CB Case 5 is just the display, no mutating
	public static void case5(ListCDLSBased list)
	{
		if (!list.isEmpty()) {
			System.out.print("\tList of " + "size " 
					+ list.size() + " has the following items : ");
			System.out.print(list.toString());
			System.out.println();
		} else {
			System.out.println("List is empty.");
		}
	}
	
	public static ListCDLSBased case6(ListCDLSBased list)
	{
		if (!list.isEmpty()) {
			
			ListCDLSBased newList = new ListCDLSBased();

			for (int i = 0, j = list.size()-1; i < list.size(); i++, j--)
			{
				newList.add(i, list.get(j));
			}
			list = newList;
			
			System.out.println("List has been reversed.");
			System.out.println("Here is the content:  " + list.toString());
		} else {
			System.out.println("List is empty.. nothing to reverse!");
		}
		return list;
	}
	
	
	
	
	
}
