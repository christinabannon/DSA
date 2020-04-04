package midterm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QDriver
{

	
	static BufferedReader reader = 
			new BufferedReader(new InputStreamReader(System.in));

	public static void main(String []args) throws IOException
	{
		DEQ deq = new DEQ();
		
		System.out.println("1. Insert item at back of DEQ.\n" + 
				"\n" + 
				"2. Insert item at front of DEQ.\n" + 
				"\n" + 
				"3. Remove item from front of DEQ.\n" + 
				"\n" + 
				"4. Remove item from back of DEQ.\n" + 
				"\n" + 
				"5. Display front item of DEQ.\n" + 
				"\n" + 
				"6. Display last item of DEQ.\n" + 
				"\n" + 
				"7. Clear DEQ.\n" + 
				"\n" + 
				"8. Display content of DEQ.\n" + 
				"\n" + 
				"9. Exit");
		
		System.out.print("Make your menu selection now: ");
		int selection = Integer.parseInt(reader.readLine().trim());
			System.out.print(selection);
			System.out.println();
		
		while (selection != 9)
		{
			switch(selection)
			{
			//CB insert item @ back
			case 1: deq = case1(deq);
			break;
			
			case 2: deq = case2(deq);
			break;

			//CB removes first thing in q
			case 3: deq = case3(deq);
			break;
			
			//CB removes last thing in DEQ
			case 4: deq = case4(deq);
			break;
			
			//CB peeks first thing
			case 5: case5(deq);
			break;
			
			//CB peeks last thing
			case 6: case6(deq);
			break;
			
			//CB clears deq
			case 7: deq = case7(deq);
			break;
			
			//CB displays deq
			case 8: case8(deq);
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
	
	//CB inserts item @ back
	public static DEQ case1(DEQ deq) throws IOException
	{
		System.out.print("Enter the item:");
		String item = reader.readLine().trim();
		System.out.print(item);
		deq.enqueue(item);

		return deq;
	}
	
	//CB insert item in front of deq
	public static DEQ case2(DEQ deq) throws IOException
	{
		System.out.print("Enter the item: ");
		String item = reader.readLine().trim();
		System.out.print(item);
		
		deq.enqueueFirst(item);
		
		return deq;
	}
	
	//CB case 3 removes the item from the front of DEQ
	public static DEQ case3(DEQ deq)
	{
		try
		{
			System.out.println(deq.dequeue());;
		}
		catch (ExtendedQueueException | QueueException e)
		{
			System.out.println("nothing here!!");
		}	
		return deq;
	}
	
	public static DEQ case4(DEQ deq)
	{
		try
		{
			System.out.println(deq.dequeueLast());
		}
		catch (ExtendedQueueException | QueueException e)
		{
			System.out.println("nothing here!!");
		}
		return deq;
	}
	
	//CB shows first thing in q
	public static void case5(DEQ deq)
	{
		try 
		{
		System.out.println(deq.peek());
		}
		catch (ExtendedQueueException | QueueException e)
		{
			System.out.println("Nothing to peek!");
		}
	}
	
	//CB peeks last thing!
	public static void case6 (DEQ deq)
	{
		try 
		{
		System.out.println(deq.peekLast());
		}
		catch (ExtendedQueueException | QueueException e)
		{
			System.out.println("Nothing to peek!");
		}
	}
	
	//CB to clear the entire DEQ
	public static DEQ case7(DEQ deq)
	{
		try 
		{
			deq.dequeueAll();
		}
		catch(QueueException e)
		{
			System.out.println("Not a thing to even clear!!!");
		}	
		return deq;
	}
	
	//CB display the contents of deq
	public static void case8(DEQ deq)
	{
		if (!deq.isEmpty())
		{
			System.out.print(deq.toString());
		}
		else 
			System.out.println("Empty DEQ!");
	}
}
