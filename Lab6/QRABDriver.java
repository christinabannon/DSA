package Lab6;

/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/26/19
 * Submitted:  03/4/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.26
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QRABDriver
{
	static BufferedReader reader = 
			new BufferedReader(new InputStreamReader(System.in));

	public static void main(String []args) throws IOException
	{

	QSLS qrab = new QSLS();
		
		System.out.println("1. Insert item at back of queue.\n" + 
				"\n" + 
				"2. Remove item from front of queue.\n" + 
				"\n" + 
				"3. Display front item of queue.\n" + 
				"\n" + 
				"4. Clear queue.\n" + 
				"\n" + 
				"5. Display content of queue.\n" + 
				"\n" + 
				"6. Exit.");
		
		System.out.print("Make your menu selection now: ");
		int selection = Integer.parseInt(reader.readLine().trim());
			System.out.print(selection);
			System.out.println();
		
		while (selection != 6)
		{
			switch(selection)
			{
			case 1: qrab = case1(qrab);
			break;

			case 2: qrab = case2(qrab);
			break;
			
			case 3: case3(qrab);
			break;
			
			case 4: qrab = case4(qrab);
			break;
			
			case 5: case5(qrab);
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
	public static QSLS case1(QSLS qrab) throws IOException
	{
		System.out.print("Enter the item:");
		String item = reader.readLine().trim();
		System.out.print(item);
		qrab.enqueue(item);

		return qrab;
	}
	
	public static QSLS case2(QSLS qrab)
	{
		try
		{
			System.out.println(qrab.dequeue());;
		}
		catch (QueueException e)
		{
			System.out.println("nothing here!!");
		}
		
		return qrab;
	}
	
	public static void case3(QSLS qrab)
	{
		System.out.println(qrab.peek());
	}
	
	public static QSLS case4(QSLS qrab)
	{
		try 
		{
			qrab.dequeueAll();
		}
		catch(QueueException e)
		{
			System.out.println("Not a thing to even clear!!!");
		}
		
		return qrab;
	}
	public static void case5(QSLS qrab)
	{
		System.out.print(qrab.toString());
	}
}
