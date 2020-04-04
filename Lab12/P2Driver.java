package Lab12;


/*
 * Purpose: Data Structure and Algorithms Lab 12 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 04/24/19
 * Submitted:  04/24/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.04.24
 */

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.IOException;

public class P2Driver {
	
	static BufferedReader reader =
			new BufferedReader( 
					new InputStreamReader(System.in));
	
	public static void main(String [] args)
			throws IOException
	{	
		HashTable <String, String> table = new HashTable<>();
		
		System.out.println("\n  Please select from "
				+ "the following menu: ");
		System.out.println(
				"0. Display the content" + 
				   " of the symbol table\n" + 
				"1. Insert a symbol key with an " + 
				   "associated \n\tvalue in the table\n" + 
				"2. Delete a symbol from the table\n" + 
				"3. Retrieve and display the value" + 
				   " associated \n\twith a symbol key in " + 
				   "the table\n" + 
				"4. Display the hash index of a " + 
				   "symbol key\n" + 
				"5. Exit program");
		
		int menuSelection = makeMenuSelection();
		
		while (menuSelection != 5)
		{
			switch (menuSelection)
			{
				case 0:
					displayContent(table);
					break;
				case 1: 
					insertSymbol(table);
					break;
				case 2: 
					deleteSymbol(table);
					break;
				case 3:
					retrieveValue(table);
					break;
				case 4: 
					getHashIndex(table);
					break;
				
			}
			menuSelection = makeMenuSelection();
		}
		
		System.out.println("Goodbye!!");
		System.exit(0);
	}
	
	/**
	 * CB avoiding repeated code - takes input for
	 * the switch statement
	 * 
	 * @return integer to represent the menu selection
	 */
	public static int makeMenuSelection() 
			throws IOException
	{	
		System.out.println("Make your choice.");
		int menuSelection;
		
		try 
		{
			menuSelection = 
				Integer.parseInt(reader
					         	.readLine()
					        	.trim());
			System.out.println(menuSelection);
		} 
		catch (NumberFormatException e)
		{ 
			System.out.println("Enter an INT!!!"
					+ " COME ON MAN " );
			menuSelection = 
					Integer.parseInt(reader
						         	.readLine()
						        	.trim());
			System.out.println(menuSelection);
			
		}
		return menuSelection;
	}
	
	/**
	 * Option 0
	 */
	public static void displayContent(HashTable<String,
			String> table)
	{
		System.out.println(table.toString());
	}
	
	/**
	 * Option 1
	 * @param table
	 * @throws IOException
	 */
	private static void insertSymbol(HashTable<String,
			String> table) throws IOException
	{
		System.out.println("Enter a 3 digit"
				+ " uppercase String as a key: " );
		String key = reader.readLine()
							 .trim()
							 .substring(0, 3)
							 .toUpperCase();
		
		System.out.println(key);
		
		System.out.println("Enter whatever you "
				+ "want as the value to be stored!" );
		String value = reader.readLine().trim();
		
		boolean result = table.tableInsert(key, value);
		
		if (result)
		{
			System.out.println(value + 
					" is saved under key " + key + 
					" in index " + table.hashIndex(key));
		}
		else
		{
			System.out.println(value + 
					" is already saved under " + 
					"index " + table.hashIndex(key));
		}
		
	}
	
	/**
	 * Option 2
	 * 
	 * @param table
	 * @throws IOException
	 */
	public static void deleteSymbol(HashTable<String,
			String> table) throws IOException
	{
		System.out.println("Enter the key to be deleted! " );
		String key = reader.readLine()
							 .trim()
							 .substring(0, 3)
							 .toUpperCase();
		
		System.out.println(key);
		
		boolean deleted = table.tableDelete(key);
		
		if (deleted)
		{
			System.out.println("Key was deleted!");
		}
		else
		{
			System.out.println("Key is not "
					+ "present in here!");
		}
	}
	
	public static void retrieveValue(HashTable<String,
			String> table) throws IOException
	{
		System.out.println("Enter the key you would "
				+ "like to retrieve\nthe value associated"
				+ " with: " );
		String key = reader.readLine()
							.trim()
							.substring(0,3)
							.toUpperCase();
		
		System.out.println(key);
		
		String value = table.tableRetrieve(key);
		
		if (value != null)
		{
			System.out.println("The value associated " + 
								"is " + value);
		}
		else
		{
			System.out.println("That key is not "
					+ "in the table!");
		}
	}
	
	/**
	 * Option 4
	 * 
	 * @param table
	 * @throws IOException
	 */
	public static void getHashIndex(HashTable<String,
			String> table) throws IOException
	{
		System.out.println("Enter the key you would "
				+ "like to retrieve\nthe "
				+ "hashIndex associated"
				+ " with: " );
		String key = reader.readLine()
							.trim()
							.substring(0,3)
							.toUpperCase();
		
		System.out.println(key);
		
		int hashIndex = table.hashIndex(key);
		
		if  (hashIndex >= 0)
		{
			System.out.println("The hash index is: "
					+ hashIndex + ". " );
		}
		else
		{
			System.out.println("The key doesn't exist,\n"
					+ "but if it did the index would be " + 
					(-1 * hashIndex) + ". ");
		}
	}
}


