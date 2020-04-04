/*
 * Purpose: Data Structure and Algorithms Lab 1 Problem 7 
 * Status: Complete and thoroughly tested
 * Last update: 01/25/19
 * Submitted:  01/30/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.01.25
 */

//CB This program asks the user to enter an integer number n, then reads n names
//CB provided by the user, then displays the provided names followed 
//CB by “shout(s) Hello Class!!!” using correct grammar and punctuation.

package work;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Hello 
{
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String [] args) throws IOException
	{
		
		final int NUMBER_OF_PEOPLE = numberAsker();
		
		xShoutsHello(NUMBER_OF_PEOPLE);
		
	}
	//CB the numberAsker method takes in the # of classmates, 
	//CB and turns the input into an int, which it then returns
	private static int numberAsker() throws IOException
	{
		
		System.out.println("Enter a number of classmates: ");
		String n = reader.readLine();
		int number = Integer.parseInt(n);
		System.out.println(number);
		return number;
	}
	
	//CB the xShoutsHello method accepts an integer to represent the number of
	//CB people shouting hello, then through an if, else if structure determines
	//CB how the sentence will be formatted
	private static void xShoutsHello(int n) throws IOException
	{
		int number = n;
		
		//CB if statement for the case that there is only one student shouting hello. 
		//reader reads input, and does a simple response with the ending statement
		if(number == 1)
		{
			System.out.println("Enter student # 1: ");
			String name = reader.readLine();
			System.out.println(name);
			System.out.println(name + "shouts hello!");
		}
		
		//CB else if the input number is 2, this is the same type of combination and print out
		else if(number ==2 )
		{
			System.out.println("Enter student # 1: " );
			String name1 = reader.readLine();
			System.out.println(name1); 
			
			System.out.println("Enter student # 2: " );
			String name2 = reader.readLine();
			System.out.println(name2);
			System.out.println(name1 + " and " + name2 + " shout hello!");
		}
		
		//CB else if the input number is 3 or more, this if statements reads the first user input
		// then loops to take in and add every other input.
		else if(number >= 3)
		{
			System.out.println("Enter student # 1");
			String name = reader.readLine();
			System.out.println(name);
			
			for (int index = 2; index < number; index++)
			{
				System.out.println("Enter student # " + index);
				
				String nextName = reader.readLine();
				
				System.out.println(nextName);
				
				name = name +", " + nextName;
			}
			
			System.out.println("Enter student # " + number);
			String finalName = reader.readLine();
			
			System.out.println(name + " and " + finalName + " shout hello!");
		
		}
	}
}



