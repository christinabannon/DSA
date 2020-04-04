package Lab5;

/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/24/19
 * Submitted:  02/25/19
 * Comment: Extra Credit Driver
 * @author: Christina Bannon
 * @version: 2019.02.24
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ECDriver 
{
	static BufferedReader reader = 
			new BufferedReader(new InputStreamReader(System.in));

	public static void main(String []args) throws IOException
	{
		StackRA stack = new StackRA();
	//	StackSLS stackSLS = new StackSLS();
		
		System.out.println("1.        Push item onto stack.\n" + 
				"2.        Pop item from stack.\n" + 
				"3.        Display top item from stack.\n" + 
				"4.        Display items in stack.\n" + 
				"5.        Clear stack.\n" + 
				"6.        Exit.");
		
		System.out.print("Make your menu selection now: ");
		int selection = Integer.parseInt(reader.readLine().trim());
			System.out.print(selection);
			System.out.println();
		
		while (selection != 6)
		{
			switch(selection)
			{
			case 1: stack = case1(stack);
			break;
			case 2: stack = case2(stack);
			break;
			case 3: case3(stack);
			break;
			case 4: case4(stack);
			break;
			case 5: stack = case5(stack);
			break;
			}
			
			System.out.print("Make your menu selection now: ");
				selection = Integer.parseInt(reader.readLine().trim());
				System.out.print(selection);
				System.out.println();
		}
		System.out.println("Adios!");
	}
	
	//CB push
	public static StackRA case1(StackRA s) throws IOException
	{
		System.out.println("Enter the item to put on the stack:");
		String item = reader.readLine().trim();
		
		s.push(item);
		return s;	
	}
	
	//CB pop
	public static StackRA case2(StackRA s)
	{
		try
		{
			Object item = s.pop();
		} catch (StackException se)
		{
			System.out.println("Nothing in here!");
		}
		return s;
	}
	
	//CB peep
	public static void case3(StackRA s) 
	{
		try
		{
			System.out.println(s.peek());
		} catch (StackException se)
		{
			System.out.println("Nothing in here!!");
		}
	}
	
	public static void case4(StackRA s)
	{
		if (!s.isEmpty())
		{
			System.out.print(s.toString());
		}
		else
		{
		System.out.println("Nothing in here!");
		}
	}
	
	public static StackRA case5(StackRA s)
	{
		try
		{
			s.popAll();
		} catch (StackException se)
		{
			System.out.println("Nothing in here!");
		}
		return s;
	}
}
