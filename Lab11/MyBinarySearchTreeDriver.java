package Lab11;

/*
 * Purpose: Data Structure and Algorithms Lab 11 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 04/20/19
 * Submitted:  04/22/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.04.20
 */

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.IOException;

public class MyBinarySearchTreeDriver {
	

	static BufferedReader reader =
			new BufferedReader( 
					new InputStreamReader(System.in));
	
	public static void main(String [] args)
			throws IOException
	{	
		int menuSelection = makeMenuSelection();
		
		MyBinarySearchTree<Item<String>, String> tree
						= new MyBinarySearchTree<>();
		
		while (menuSelection != 0)
		{
			switch (menuSelection)
			{
				//CB inputting a new tree item
				case 1: 
					newTreeItem(tree);
					break;
					
				case 2: 
					findLeftMost(tree);
					break;
					
				case 3: 
					deleteLeftMost(tree);
					break;
					
				case 4: 
					retrieveItem(tree);
					break;
					
				case 6: 
					displayInOrder(tree);
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
		System.out.println("\n  Please select from "
				+ "the following menu: ");
		System.out.println("0. Exit\n"
				         + "1. Insert key in BST\n"
				         + "2. Find the left-most"
				         + " item of BST\n"
				         + "3. Delete the left-most"
				         + " item of BST\n"
				         + "4. Retrieve an item "
				         + "in the BST\n"
						 + "6. Display Content "
						 + "of BST in order. \n");
		
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
			System.out.println("Enter an INT!!! COME ON MAN " );
			menuSelection = 
					Integer.parseInt(reader
						         	.readLine()
						        	.trim());
			System.out.println(menuSelection);
			
		}
		return menuSelection;
	}
	
	/**
	 * newTreeItem is for option 1
	 * 
	 * @param tree
	 * @throws IOException
	 */
	public static void 
	newTreeItem(MyBinarySearchTree<Item<String>, 
			String> tree) throws IOException
	{
		System.out.println("Enter the item! " );
		String item = reader.readLine().trim();
		System.out.println(item);
		
		tree.insert(new Item<String>(item));
		
		System.out.println("Item " + 
		          item + " inserted!");
	}	
	
	/**
	 * find LeftMost is for option 2
	 * 
	 * @return void
	 * @param tree
	 */
	public static void 
	findLeftMost(MyBinarySearchTree<Item<String>, 
			String> tree)
	{
		System.out.println("Now finding the left-most!!");
		System.out.println("Leftmost Item -->  " 
		              + tree.findLeftmostAccessor());
	}
	
	/**
	 * delete LeftMost is for option 3
	 * 
	 */
	public static void
	deleteLeftMost(MyBinarySearchTree<Item<String>,
			String> tree)
	{
		System.out.println("Now deleting "
			   	+ "the left-most!!");
		System.out.println("Leftmost Item -->  " 
			  	+ tree.findLeftmostAccessor());
		System.out.println("Item deleted -->   "
				+ tree.deleteLeftmostAccessor());
	}
	
	/**
	 * retrieveItem is for option 4
	 * 
	 * 
	 */
	public static void 
	retrieveItem(MyBinarySearchTree<Item<String>,
			String> tree) throws IOException
	{
		System.out.println("Enter Item to retrieve: ");
		String item = reader.readLine().trim();
		System.out.println(item);
		
		try 
		{
			Item<String> foundItem = tree.retrieve(item);
		
			System.out.println("Located! Item " 
					+ foundItem + 
					" was found!");
		}
		// Is this ok style? 
		catch(NullPointerException e)
		{
			System.out.println("Not found!!!");
		}	
	}
	
	/**
	 * displayInOrder is for option 6
	 * 
	 * @param tree
	 * @throws IOException
	 */
	public static void 
	displayInOrder(MyBinarySearchTree<Item<String>,
			String> tree) throws IOException
	{
		System.out.println(tree.toStringLKRAccessor());
	}
}
