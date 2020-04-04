package midterm;

/* issues:
 * -useless line class
 * -not understanding how objects are passed in static methods
 * -how are object passed in regular methods?
 * -obviously a lack of plan, but how to plan?
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
	Queue <Customer> giver = new Queue<>();
	Queue <Customer> getter = new Queue<>();
	Queue <Customer> pending = new Queue<>();
	
	System.out.println("Welcome to the pokemon Exchange Center!");
	
	System.out.print("Enter the number of Ghost Pokemon in Stock: " );
	int ghost = Integer.parseInt(reader.readLine().trim());
	System.out.println(ghost);
	
	System.out.print("Enter the number of Fire Pokemon in Stock: " );
	int fire = Integer.parseInt(reader.readLine().trim());
	System.out.println(fire);
	
	System.out.print("Enter the number of Ice Pokemon in Stock: " );
	int ice = Integer.parseInt(reader.readLine().trim());
	System.out.println(ice);
	
	Stock stock = new Stock(ghost, fire, ice);
		
	System.out.println("Select from the following menu: ");
	System.out.print(
	"1. Customer enters.\n"+
	"2. Customer giving Pokemon is served.\n" + 
	"3. Customer getting Pokemon is served.\n" + 
	"4. Employee processes pending requests\n" + 
	"5. Display customers waiting to give Pokemon" + 
			" and their requests.\n" + 
	"6. Display customers waiting to get Pokemon"+ 
			" and their requests.\n" + 
	"7. Display pending requests.\n" + 
	"8. Display stock and number of customers" +
			" that have left.\n"+ 
	"9. Exit the program.");
	
		System.out.print("Make your menu selection now: ");
		int selection = Integer.parseInt(reader.readLine().trim());
			System.out.print(selection);
			System.out.println();
		
		while (selection != 9)
		{
			switch(selection)
			{
			case 1: case1(giver,getter);
			break;
			
			case 2: case2(giver, stock);
			break; 

			case 3: case3(getter, stock, pending);
			break;
		
			case 4: case4(pending, stock);
			break;

			case 5: case5(giver);
			break;
			
			/*
			case 6: case6(waiting);
			break;
			
			case 7: case7(waiting);
			break;
			*/
			
			case 8: case8(stock);
			break;
			}
			
			System.out.println();
			System.out.println();
			System.out.print("Make your menu selection now: ");
				selection = Integer.parseInt(reader.readLine().trim());
				System.out.print(selection);
				System.out.println();
		}
		
		System.out.println("See ya!");
	}

	//CB Customer enters!! add to one line or the other.
	/*
	 * case1 
	 * Accepts 2 Queues representing the giver
	 * queue and the getter queue
	 * (1)acknowledges when a customer enters. 
	 * (2)takes a name
	 * (3)deciphers which queue (giver or getter) the
	 * customer should be added to by typed input
	 * (4)
	 */
	public static void case1(Queue<Customer> giver,
			Queue<Customer> getter) throws IOException
	{
		System.out.print("Welcome, your name please:");
		String name = reader.readLine().trim();
		System.out.println(name);
	
		System.out.print("Are you here to give Pokemon?(Y/N)");
		String choice = reader.readLine().trim();
		System.out.println(choice);

		switch(choice.charAt(0))
		{
			case 'Y':
				case 'y':
				{
					Customer customer = customerBuilder(name);
					System.out.println(name + 
					" is now waiting to give Pokemon!");
					giver.enqueue(customer);
				}
				break;
				
			case 'N': 
				case 'n':	
				{
					Customer customer = customerBuilder(name);
					System.out.println(name + 
						" is now waiting to get Pokemon!");		
					getter.enqueue(customer);
				}
			default: 
				System.out.println("Invalid input!! /nTry again: ");
				break;
		}
	}
	
	/*
	 * case1Input accepts the String name of a customer, and
	 * retrieves the other necessary info 
	 * to utilize a  customer constructor, 
	 * then returns a Customer object
	 */
	private static Customer customerBuilder(String name) throws IOException
	{
		System.out.print("How many Ghost Pokemon?");
		int ghost = Integer.parseInt(reader.readLine().trim());
		System.out.println(ghost);
		
		System.out.print("How many Fire Pokemon?");
		int fire = Integer.parseInt(reader.readLine().trim());
		System.out.println(fire);
		
		System.out.print("How many Ice Pokemon?");
		int ice = Integer.parseInt(reader.readLine().trim());
		System.out.println(ice);
		
		Customer customer = new Customer (name, ghost, fire, ice);
		
		return customer;
	}
	
	/*
	 * Question: Which is the preferable way to go about this?
	 * validating the conditions with an if-else statement like 
	 * in case 2? Or would it be preferable to just bundle all 
	 * of the validation in a try-catch statement??
	 */
	public static void case2(Queue<Customer> giver, 
			Stock stock) throws IOException
	{
		if (!giver.isEmpty())
		{
			Customer customer = giver.dequeue();
			
			stock.accept(customer.getGhost(), 
					customer.getFire(), customer.getIce());
			
			System.out.print(customer.getName() + "dropped off " + 
					customer.getGhost() +  " ghosts, " +
					customer.getFire() + " fires, " +
					customer.getIce() + "ices");
		}
		else
		{
			System.out.println("Line is empty!!");
		}
	}
	
	/*
	 * 
	 */
	public static void case3(Queue<Customer> getter,
			Stock stock, Queue<Customer> pending) throws IOException
	{
		Customer customer; 
		while (!getter.isEmpty())
		{
			customer = getter.dequeue();
			if ( customer.getFire() <= stock.getFire()
					&& customer.getGhost() <= stock.getGhost()
					&& customer.getIce() <= stock.getIce())
			{
				stock.give(customer.getGhost(), 
						customer.getFire(), 
						customer.getIce());
				
				System.out.print(customer.getName() + "picked up " + 
						customer.getGhost() +  " ghosts, " +
						customer.getFire() + " fires, " +
						customer.getIce() + "ices");
			}
			else
			{
				pending.enqueue(customer);
			}
		}	
	}

	/*
	 * Employee processes pending
	 */
	public static void  case4(Queue<Customer> pending, Stock stock )
	{
		Customer customer;
		while (!pending.isEmpty())
		{
			customer = pending.dequeue();
			if ( customer.getFire() <= stock.getFire()
					&& customer.getGhost() <= stock.getGhost()
					&& customer.getIce() <= stock.getIce())
			{
				stock.give(customer.getGhost(), 
						customer.getFire(), 
						customer.getIce());
			}
		}
	}
	
	/*
	 * 	"5. Display customers waiting to give Pokemon" + 
	 *	" and their requests.\n"
	 */
	public static void case5(Queue <Customer> giver)
	{
		if (!giver.isEmpty())
		{
			System.out.println("These customers getting pokemon are waiting to be served: ");

			Queue <Customer> newQ = new Queue<>();
			
			while (!giver.isEmpty())
			{
				Customer customer = giver.dequeue();
				System.out.println(customer.getName()+ 
						"wishes to give " + 
						customer.getGhost() + 
						" ghost  pokemon," + 
						customer.getFire() +
						" fire pokemon, " +
						" and " + customer.getIce() + 
						" ice pokemon."
						);
			}
		}
		else
		{
			System.out.println("No customers getting pokemon are waiting to be served!");
		}
	}
	
	/*
	public static void case6 (Line line)
	{
		if (!line.isGetterEmpty())
		{
			System.out.println("These customers getting pokemon are waiting to be served: ");
			System.out.println(line.getGetters());
		}
		else
		{
			System.out.println("No customers getting pokemon are waiting to be served!");
		}
	}
	
	public static void case7(Line line)
	{
		System.out.println(line.pendingStack());

	}
	*/
	//CB display the contents of deq
	public static void case8(Stock stock)
	{

		System.out.println("Stock: " 
		+ stock.getFire() + " fire " + 
				+ stock.getGhost() + " ghost " + 
				+ stock.getIce() + " ice");
		System.out.println("People served: " + stock.getTransactions());
	}
}