package Lab6;

/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 4
 * Status: Complete and thoroughly tested
 * Last update: 03/03/19
 * Submitted:  03/04/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.03.03
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4Driver 
{
	static BufferedReader reader = 
	new BufferedReader(new InputStreamReader(System.in));

	public static void main(String []args) 
			throws IOException
	{
		//CB delivery bag - add to back, take out from front
		//CB express - add to front, remove from front
		DQBag <Pack> bigBag = 
				new DQBag <Pack> (new DEQ());

		//CB sampleBag - 
		DQBag <Item> sampleBag = 
				new DQBag <Item>(new DEQ());

		
		System.out.println("Select from the following menu:\n" + 
				"	0. Exit.\n" + 
				"	1. Pick up an order.\n" + 
				"	2. Drop off an order.\n" + 
				"	3. Display number of packages"+
					" and weight of bag.\n" + 
				"	4. Display number of items "+
					"and weight of the bag of samples.\n" + 
				"	5. Enjoy an item from the"+
					" bag of samples.\n" + 
				"	6. Empty the bag of samples.\n" + 
				"	7. Pick up an express order.");
		
		System.out.print("Make your menu selection now: ");
		int selection = Integer
				.parseInt(reader.readLine().trim());
			System.out.print(selection);
		System.out.println();
	
		while (selection != 0)
		{
			switch(selection)
			{
			
				case 1: bigBag = case1(bigBag);
						break;
						
				case 2: sampleBag = case2(bigBag, 
									sampleBag);
						break;
						
				case 3: case3(bigBag);
						break;
						
				case 4: case4(sampleBag);
						break;
						
				case 5: sampleBag = case5(sampleBag);
						break;
						
				case 6: sampleBag = case6(sampleBag);
						break;
						
				case 7: bigBag = case7(bigBag);
						break;
			}

			System.out.println();
			System.out.println();
			System.out.print("You know the options. " 
					+"Make your menu selection now: ");
			selection = Integer
					.parseInt(reader.readLine().trim());
			System.out.print(selection);
			System.out.println();	
		}
		
		System.out.println("Bye");
	}
	
	//CB Pick up a regular order - add a pack to the bigBag!
	public static DQBag case1(DQBag bag)throws IOException
	{
		System.out.println("Please specify package info:" );
		
		System.out.print("item name: ");
		String name = reader.readLine().trim();
		System.out.print(name);
		
		System.out.print("\nitem weight: ");
		double weight = Double
				.parseDouble(reader.readLine().trim());
		System.out.print(weight);
		
		System.out.print("\nnumber of items: ");
		int numItems = Integer
				.parseInt(reader.readLine().trim());
		System.out.print(numItems);
		
		System.out.print("\nsender: ");
		String sender = reader.readLine().trim();
		System.out.print(sender);
		
		System.out.print("\nrecipient: ");
		String recipient = reader.readLine().trim();
		System.out.print(recipient);
		
		Pack pack = new Pack(sender, recipient,
				numItems,name, weight);
		
		//CB the adding!
		bag.add(pack);
		
		System.out.print("\nA package of " +
						pack.getItem().getName() + 
						"s each weighing " + 
						pack.getItem().getWeight() +
						" lbs are now in the bag.");

		return bag;
	}
	
	

	//CB case2
	//CB 1. accepts 2 Bags, 
	//CB 2. inquires about getting a sample
	//CB 3. adds sample to sampleBag, or doesn't 
	//CB 4. returns sampleBag
	public static DQBag case2(DQBag deliveryBag,
			DQBag sampleBag) 
			throws IOException
	{
		try 
		{
			Pack pack = (Pack)deliveryBag.dispenseFirst();

			System.out.print("Here is your package " + 
						pack.getRecipient() + ".");
			System.out.print("\nMay I please keep a "
						+ pack.getItem().getName() + 
						" (Y/N)?");
			
			String choice = reader.readLine().trim();
				System.out.println(choice);
			
			System.out.print("Your package contains: " 
			+ pack.getNumItems() + " " +
			pack.getItem().getName());
			System.out.printf("s each weighing %.2f lbs\n",
					pack.getItem().getWeight());
			System.out.print(" from " + pack.getSender() +
					 " to " + pack.getRecipient());
	
			switch(choice)
			{
				case "Y": case "y":
				System.out.print(" Thanks for letting me "
						+ "keep a " 
						+ pack.getItem().getName()
						+"!");
				sampleBag.add((Item)pack.getItem());
					break;
					
				default:	
				System.out.print("Thanks anyway.");
					break;
			}
		}
		catch (ExtendedQueueException | QueueException e)
		{
			System.out.print("No deliveries to process!");
		}
		return sampleBag;
	}
	
	//CB display number of package and weight of bigBag
	public static void case3(DQBag bag) 
	{
		System.out.print("Bag has " 
				+ bag.getNumBagItems());
		System.out.printf(" packages and weighs %.2f lbs.",
				bag.getBagWeight());
	}
	
	//CB display number of items and weight of sampleBag
	public static void case4(DQBag sampleBag)
	{
		System.out.print("Sample bag has " 
				+ sampleBag.getNumBagItems());
		System.out.printf(" items and weighs %.2f lbs.",
				sampleBag.getBagWeight());
	}
	
	//CB enjoy an item from the bag of samples
	public static DQBag case5(DQBag sampleBag)
	{
		try
		{
			Item item = (Item)sampleBag.dispenseFirst();
			System.out.print("This " + item.getName() + 
					" is amazing! I love free stuff!");
		}
		catch (QueueException | ExtendedQueueException e)
		{
			System.out.print("No samples to enjoy!");
		}
		return sampleBag;
	}
	
	//CB empty sampleBag
	public static DQBag case6(DQBag sampleBag)
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
	
	//CB for express orders! 
	public static DQBag case7(DQBag bag) 
			throws IOException
	{
		System.out.println("Please specify express package info:" );
		
		System.out.print("item name: ");
		String name = reader.readLine().trim();
		System.out.print(name);
		
		System.out.print("\nitem weight: ");
		double weight = Double
				.parseDouble(reader.readLine().trim());
		System.out.print(weight);
		
		System.out.print("\nnumber of items: ");
		int numItems = Integer
				.parseInt(reader.readLine().trim());
		System.out.print(numItems);
		
		System.out.print("\nsender: ");
		String sender = reader.readLine().trim();
		System.out.print(sender);
		
		System.out.print("\nrecipient: ");
		String recipient = reader.readLine().trim();
		System.out.print(recipient);
		
		Pack pack = new Pack(sender, recipient, 
				numItems, name, weight, true);
		
		bag.add(pack);
		
		System.out.print("\nA package of " +
						pack.getItem().getName() + 
						"s each weighing " + 
						pack.getItem().getWeight() +
						" lbs are now in the bag.");
		return bag;
	}
}