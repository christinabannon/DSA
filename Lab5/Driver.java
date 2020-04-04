package Lab5;

/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/24/19
 * Submitted:  02/25/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.24
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver 
{
	static BufferedReader reader = 
			new BufferedReader(new InputStreamReader(System.in));

	public static void main(String []args) throws IOException
	{
		//CB delivery bag
		StackRA stackRA = new StackRA();
		Bag deliveryBag = new Bag(stackRA);
		
		//CB sample bag
		StackSLS stackSLS = new StackSLS();
		Bag sampleBag = new Bag(stackSLS);
		
		System.out.println("Select from the following menu:\n" + 
				"	0. Exit.\n" + 
				"	1. Pick up an order.\n" + 
				"	2. Drop off an order.\n" + 
				"	3. Display number of packages and " +
				  	"weight of bag.\n" + 
				"	4. Display number of items and weight " + 
					"of the bag of samples.\n" + 
				"	5. Enjoy an item from the bag of samples.\n" + 
				"	6. Enjoy all the samples in the " + 
					"bag of samples.\n" );
		
		System.out.print("Make your menu selection now: ");
		int selection = Integer.parseInt(reader.readLine().trim());
			System.out.print(selection);
		System.out.println();
	
		while (selection != 0)
		{
			switch(selection)
			{
				case 1: deliveryBag = case1(deliveryBag);
						break;
				case 2: sampleBag = case2(deliveryBag, sampleBag);
						break;
				case 3: case3(deliveryBag);
						break;
				case 4: case4(sampleBag);
						break;
				case 5: sampleBag = case5(sampleBag);
						break;
				case 6: sampleBag = case6(sampleBag);
						break;
			}

			System.out.println();
			System.out.println();
			System.out.print("You know the options. " 
					+"Make your menu selection now: ");
			selection = Integer.parseInt(reader.readLine().trim());
			System.out.print(selection);
			System.out.println();	
		}
		
		System.out.println("Bye");
	}
	
	//CB to push a package onto the stackkk
	public static Bag case1(Bag deliveryBag)throws IOException
	{
		System.out.println("Please specify package info:" );
		
		System.out.print("item name: ");
		String name = reader.readLine().trim();
		System.out.print(name);
		
		System.out.print("\nitem weight: ");
		double weight =
				Double.parseDouble(reader.readLine().trim());
		System.out.print(weight);
		
		System.out.print("\nnumber of items: ");
		int numItems = Integer.parseInt(reader.readLine().trim());
		System.out.print(numItems);
		
		System.out.print("\nsender: ");
		String sender = reader.readLine().trim();
		System.out.print(sender);
		
		System.out.print("\nrecipient: ");
		String recipient = reader.readLine().trim();
		System.out.print(recipient);
		
		Pack pack = 
				new Pack(sender, recipient, numItems, name, weight);
		
		deliveryBag.add(pack);
		
		System.out.print("\nA package of " +
						pack.getItem().getName() + 
						"s each weighing " + 
						pack.getItem().getWeight() +
						" lbs are now in the bag.");

		return deliveryBag;
	}
	
	//CB case2a - the decision making part of dropping off an order
	//CB 1. accepts 2 Bags, 
	//CB 2. inquires about getting a sample
	//CB 3. adds sample to sampleBag, or doesn't 
	//CB 4. returns sampleBag
	public static Bag case2(Bag deliveryBag, Bag sampleBag) 
			throws IOException
	{
		try 
		{
			Pack pack = deliveryBag.dispensePack();

			System.out.print("Here is your package " + 
						pack.getRecipient() + ".");
			System.out.print(" May I please keep a "
						+ pack.getItem().getName() + 
						" (Y/N)?");
			
			String choice = reader.readLine().trim();
				System.out.println(choice);
			
			System.out.print("Your package contains: " 
			+ pack.getNumItems() + " " +
			pack.getItem().getName());
			System.out.printf("s each weighing %.2f lbs",
					pack.getItem().getWeight());
			System.out.print(" from " + pack.getSender() +
					 " to " + pack.getRecipient());
	
			switch(choice)
			{
				case "Y": case "y":
				System.out.print(" Thanks for letting me "
						+ "keep a " + pack.getItem().getName()
						+"!");
				sampleBag.add(pack.getItem());
					break;
			default:	
				System.out.print("Thanks anyway.");
					break;
			}
		}
		catch (StackException e)
		{
			System.out.println("empty!");
		}
		return sampleBag;
	}
	
	//CB case 5 shows the number of items and weight of bag!
	public static void case3(Bag deliveryBag) 
	{
		System.out.print("Bag has " 
				+ deliveryBag.getNumBagItems());
		System.out.printf(" packages and weighs %.2f lbs.",
				deliveryBag.getBagWeight());
	}
	
	public static void case4(Bag sampleBag)
	{
		System.out.print("Sample bag has " 
				+ sampleBag.getNumBagItems());
		System.out.printf(" items and weighs %.2f lbs.",
				sampleBag.getBagWeight());
	}

	public static Bag case5(Bag sampleBag)
	{
		try
		{
			Item item = sampleBag.dispenseItem();
			System.out.print("This " + item.getName() + 
					" is amazing! I love free stuff!");
		}
		catch (StackException e)
		{
			System.out.print("No samples to enjoy!");
		}
		return sampleBag;
	}
	
	public static Bag case6(Bag sampleBag)
	{

		if (sampleBag.getNumBagItems() > 0)
		{
			sampleBag.dispenseAllitems();
			System.out.print("Sample bag has been emptied!");
		}
		else
		{
			System.out.print("Sample bag is already empty.");
		}
		return sampleBag;
	}
}
