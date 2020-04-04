package Lab7;


/*
 * Purpose: Data Structure and Algorithms Lab 7 Problem 1 
 * Status: Complete and thoroughly tested
 * Last update: 03/12/19
 * Submitted:  03/12/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.03.12
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2
{
	public static void main(String []args) throws IOException
	{
		BufferedReader reader = 
		new BufferedReader(new InputStreamReader(System.in));

		long n = 0;
		
		while (n >= 0)
		{
			System.out.print("Enter a positive number to get a factorial,"
					+ "\nEnter a negative number to exit."
					+ "\nInput:");
		
			n = Long.parseLong(reader.readLine().trim());
		
			System.out.println(n);
			
			if (n > 0)
			{
				System.out.printf("%,d ! Recursive: %,d",
					n, rFact(n));
				System.out.println();

				System.out.printf("%,d ! Iterative: %,d",
					n, itFact(n));
			
				System.out.println();
			}
		}
		System.out.println("Au Revoir!");
	}

	//CB rFact accepts an int and returns 
	//another int that is 
	// the factorial of the parameter
	public static long rFact(long n)
	{
		long result = 1;

		if (n == 0 || n == 1 )
		{
			System.out.println("if executing");
			result = 1;
		}
		else
		{	
			result = n * rFact(n-1);	
		}	
		
		return result;
	}

	//CB itFact finds the given int's
	//CB factorial iteratively and returns the 
	//factorial as an int
	public static long itFact(long n)
	{
		long result = 1;

		for (int i = 1; i <= n; i++)
		{
			result = result * i;
		}
		
		return result;
	}
}