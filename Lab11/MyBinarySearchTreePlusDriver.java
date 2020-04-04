package Lab11;

/*
 * Purpose: Data Structure and Algorithms Lab 11 Problem 2
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

public class MyBinarySearchTreePlusDriver 
{
	static BufferedReader reader =
			new BufferedReader( 
					new InputStreamReader(System.in));
	
	public static void main(String [] args)
			throws IOException
	{	
		System.out.println("\n  Please select from "
				+ "the following menu: ");
		System.out.println("0. Exit Program\n"
				         + "1. Insert key in BST\n"
				         + "2. Delete key from BST\n"
				         + "3. Search for key in BST\n"
				         + "4. Display height of BST\n"
				         + "5. Display size of BST\n"
						 + "6. Display content "
						 + "of BST in order. \n"
						 + "7. Display content "
						 + "of BST in preorder \n"
						 + "8. Display content "
						 + "of BST in postorder\n"
						 + "9. Build a copy of "
						 + "the tree, and test it.");
		
		int menuSelection = makeMenuSelection();
		
		MyBinarySearchTreePlus<Item<String>, String> tree
						= new MyBinarySearchTreePlus<>();
		
		while (menuSelection != 0)
		{
			switch (menuSelection)
			{
				case 1: 
					newTreeItem(tree);
					break;
					
				case 2: 
					deleteKey(tree);
					break;
					
				case 3: 
					searchForKey(tree);
					break;
					
				case 4: 
					findHeight(tree);
					break;
					
				case 5: 
					findSize(tree);
					break;

				case 6: 
					displayInOrder(tree);
					break;

				case 7: 
					displayPreOrder(tree);
					break;
					
				case 8: 
					displayPostOrder(tree);
					break;
					
				case 9:
					makeCopy(tree);
					break;
					
				default:
					System.out.println("Enter an int "
							+ "between 0 and 9");			
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
		System.out.println("\nWhat now?" );
		
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
	newTreeItem(MyBinarySearchTreePlus<Item<String>, 
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
	 * deleteKey for option 2
	 * 
	 * @return void
	 * @param tree
	 */
	public static void 
	deleteKey(MyBinarySearchTreePlus<Item<String>,
			String> tree) throws IOException
	{
		System.out.println("Enter the key "
				+ "for the item to delete: ");
		String item = reader.readLine().trim();
		System.out.println(item);
		
		try
		{	
			tree.delete(item);
			System.out.println("item deleted!");
		}
		catch(TreeException e)
		{
			System.out.println("Item not found!");
		}
	}
	
	/**
	 * searchForKey for option 3  
	 * @param tree
	 * @throws IOException
	 */
	public static void 
	searchForKey(MyBinarySearchTreePlus<Item<String>,
			String> tree) throws IOException
	{
		System.out.println("Enter key to search for: ");
		String item = reader.readLine().trim();
		System.out.println(item);
		
		try 
		{
			Item<String> foundItem = tree.retrieve(item);
		
			System.out.println("Located! key " 
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
	 * Option 4 finds height!
	 * 
	 * @param tree
	 */
	public static void
	findHeight(MyBinarySearchTreePlus<Item<String>,
			String> tree)
	{
		System.out.println("The height is " + tree.getHeight());
		
	}
	

	public static void
	findSize(MyBinarySearchTreePlus<Item<String>,
			String> tree)
	{
		System.out.println("The size of the BST is " 
	                      + tree.getSize());
	}
	
	/**
	 * displayInOrder is for option 6
	 * 
	 * @param tree
	 */
	public static void 
	displayInOrder(MyBinarySearchTreePlus<Item<String>,String> 
	tree) 
	{
		System.out.println(tree.toStringInorder());
	}
	
	/**
	 * displayPreOrder is for option 7
	 * 
	 * @param tree
	 */
	public static void 
	displayPreOrder(MyBinarySearchTreePlus<Item<String>,String>
	tree)
	{
		System.out.println(tree.toStringPreorder());
	}
	
	/**
	 * displayInOrder is for option 6
	 * 
	 * @param tree
	 */
	public static void 
	displayPostOrder(MyBinarySearchTreePlus<Item<String>,
			String> tree)
	{
		System.out.println(tree.toStringPostorder());
	}
	
	/**
	 * displayPreOrder is for option 7
	 * 
	 * @param tree
	 */
	public static void 
	makeCopy(MyBinarySearchTreePlus<Item<String>, String> tree)
	{
		System.out.println("Tree being copied: ");
		
		System.out.println("\tPre-Order: " );
		displayPreOrder(tree);
		
		System.out.println("\tIn-Order: ");
		displayInOrder(tree);
		
		System.out.println("\tPostOrder: " );
		displayPostOrder(tree);
		
		System.out.println();
		
		System.out.println("Copy of tree: " );
		MyBinarySearchTreePlus<Item<String>, String> treeCopy = 
				tree.getCopyOfTree();
		
		System.out.println("\tPre-Order: " );
		displayPreOrder(treeCopy);
		
		System.out.println("\tIn-Order: ");
		displayInOrder(treeCopy);
		
		System.out.println("\tPostOrder: " );
		displayPostOrder(treeCopy);
	}
}
