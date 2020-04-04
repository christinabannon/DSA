package Lab12;

/*
 * Purpose: Data Structure and Algorithms Lab 12 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 04/23/19
 * Submitted:  04/24/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.04.23
 */

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.IOException;

public class P1Driver {
	
	static BufferedReader reader =
			new BufferedReader( 
					new InputStreamReader(System.in));
	
	public static void main(String [] args)
			throws IOException
	{	

		int menuSelection = makeMenuSelection();
		
		while (menuSelection != 0)
		{
			switch (menuSelection)
			{
				case 1: 
					hashAbash();
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
		System.out.println("\n  Please select from "
				+ "the following menu: ");
		System.out.println("0. Exit\n"
				         + "1. Input a String");
		
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
			System.out.println("Enter an INT!!!"
					+ " COME ON MAN " );
			menuSelection = 
					Integer.parseInt(reader
						         	.readLine()
						        	.trim());
			System.out.println(menuSelection);
			
		}
		return menuSelection;
	}
	
	private static String inputString() 
			throws IOException
	{
		System.out.println("Enter a 3 digit"
				+ " uppercase String: " );
		String input = reader.readLine()
							 .trim()
							 .substring(0, 3)
							 .toUpperCase();
		
		System.out.println(input);
		
		System.out.println();
		return input;
	}
	
	private static int[] stringToUni( String input) 
			throws IOException
	{	
		int [] uniArray = new int[3];
		
		for (int i = 0; i < uniArray.length; i++)
		{
			uniArray[i] = (int)input.charAt(i);
			
			// putting letters in domain [1,26]
			uniArray[i] = 
				(uniArray[i] % ((int)'A' - 1) );
			
			System.out.print(uniArray[i] 
					         + " --> " + 
			                 input.charAt(i)
					         + "\n");
		}
		
		System.out.println();
		return uniArray;
	}
	
	private static double hornersRule()
			throws IOException
	{
		String input = inputString();
		int [] uniArray = stringToUni(input);
		double accumulator = 0;
		int value;
		
		for (int i = 0; i < uniArray.length; i++)
		{
			System.out.println("Value: " );
			value = uniArray[i] * (1 << 5 * 
					   (uniArray.length - (i+ 1)));
			System.out.println(value);
			
			System.out.println("Accumulator: ");
			accumulator += value;
			System.out.println(accumulator);
		}

		System.out.println();
		return accumulator;
	}
	
	public static void hashAbash()
			throws IOException
	{
		double accumulator = hornersRule();	

		int tableSize = 3; 

		double hashIndex = accumulator % tableSize;
		
		System.out.print("Hash index : " + hashIndex);
	}
}
