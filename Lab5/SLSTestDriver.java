package Lab5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SLSTestDriver 
{
	static BufferedReader reader = 
			new BufferedReader(new InputStreamReader(System.in));

	public static void main(String []args) throws IOException
	{

	StackSLS stack = new StackSLS();
		
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
	public static StackSLS case1(StackSLS s) throws IOException
	{
		System.out.print("Enter the item to put on the stack:");
		String item = reader.readLine().trim();
		System.out.println(item);
		
		s.push(item);
		return s;	
	}
	
	//CB pop
	public static StackSLS case2(StackSLS s)
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
	public static void case3(StackSLS s) 
	{
		try
		{
			System.out.println(s.peek());
		} catch (StackException se)
		{
			System.out.println("Nothing in here!!");
		}
	}
	
	public static void case4(StackSLS s)
	{
		if (!s.isEmpty())
		{
			System.out.print(s.toString());
			System.out.println();
		}
		else
		{
		System.out.println("Nothing in here!");
		}
	}
	
	public static StackSLS case5(StackSLS s)
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
