package work;


/*
 * Purpose: Data Structure and Algorithms Lab 1 Problem 9 
 * Status: Complete and thoroughly tested - RESUBMITTAL
 * Last update: 02/11/19
 * Submitted:  02/11/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.11
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class ArrayListProcessor 
{
	static ArrayList <Character> data = new ArrayList<Character>();
	
	public static void main(String [] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter a character! \n");

			add(reader.readLine().charAt(0));
			add(reader.readLine().charAt(0));
			add(reader.readLine().charAt(0));
			add(reader.readLine().charAt(0));
			
		//CB first to last statements!
		displayFor();	
		displayEnhancedFor();
		displayIterator();
		displayListIterator();
		displayMethodRefForEach();
		displayLambdaForEach();
		displayForIterator();
		
		//CB the reversers
		reverseFor();
		reverseListIterator();
		reverseStringBuilder();
		
		//CB the palindrome
		palindromeFor();
	}
	
	public static void add(char character)
	{
		data.add(character);
	}
	
//CB Now the processing methods!
	//CB classic for statement
	public static void displayFor()
	{
		System.out.println("displayFor() method: ");
		for (int i = 0; i < data.size(); i++)
		{
			System.out.print (data.get(i));
		}
		System.out.println();
	}
	
	//CB enhanced for statement
	public static void displayEnhancedFor()
	{
		System.out.println("displayEnhancedFor() method: ");
		for (char element : data)
		{
			System.out.print(element);
		}
		System.out.println();
	}
	
	//CB this method uses an iterator method to loop the elements
	public static void displayIterator()
	{
		System.out.println("displayIterator() method: ");
		Iterator <Character> iterator = data.iterator();
		while (iterator.hasNext())
		{
			System.out.print(iterator.next());
		}
		System.out.println();
	}
	
	//CB this method uses a listIterator to loop the elements
	public static void displayListIterator()
	{
		System.out.println("displayListIterator() method: ");
		ListIterator <Character> listIterator = data.listIterator();
		while(listIterator.hasNext())
		{
			System.out.print(listIterator.next());
		}
	System.out.println();
	}
	
	//CB this method uses a methodRef to loop the elements
	public static void displayMethodRefForEach()
	{
		System.out.println("displayMethodRefForEach() method: ");
		data.forEach(System.out::print);
		System.out.println();
	}
	
	//CB this method uses a forEach lambda expression to loop
	public static void displayLambdaForEach()
	{
		System.out.println("displayLambdaForEach() method: ");
		
		data.forEach(c -> { System.out.print(c); });
		System.out.println();
	}
	
	public static void displayForIterator()
	{
		System.out.println("displaysForIterator() method: ");
		for(Iterator <Character> iterator = data.iterator(); 
				iterator.hasNext(); )
		{
			System.out.print(iterator.next());
		}
		System.out.println();
	}
	
//CB reverse methods
	//CB reversed for statement
	public static void reverseFor()
	{
		System.out.println("reverseFor() method: ");
		for (int i = (data.size()-1); i>= 0; i--)
		{
			System.out.print(data.get(i));
		}		
		System.out.println();
	}
	
	//CB List Iterator 
	public static void reverseListIterator()
	{			
		ListIterator <Character> listIterator = data.listIterator(data.size());
		
		System.out.println("reverseListIterator() method: ");
		while (listIterator.hasPrevious())
		{
			System.out.print(listIterator.previous());
		}
	}
	
	//CB using a StringBuilder
	public static void reverseStringBuilder()
	{
		System.out.println("reverseStringBuilder() method: ");		
		StringBuilder string = new StringBuilder();
		
		for (int i = 0; i < data.size(); i++)
		{
			string.insert(0, data.get(i));
		}	
		System.out.println(string.toString());	
	}	
	
//CB palindromes
	public static void palindromeFor()
	{
		System.out.println("palindromeFor() method: ");
		boolean palindrome = true;
		for (int i = 0; i < data.size() && palindrome; i++)
		{
			System.out.println(data.get(i) + " " + data.get((data.size()-(i+1))));
			
			if (data.get(i) != data.get(data.size()-(i+1)))
			{
				palindrome = false;	
				System.out.println("Not a palindrome");
			}
		}	
	}
}
