package Lab7;

/*
 * Purpose: Data Structure and Algorithms Lab 7 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 03/20/19
 * Submitted:  03/25/19
 * Comment: The main method of this class asks the user
 * 	to input a number of disks, and from there gives
 * 	the user instructions on how to solve the Towers 
 * 	of Hanoi puzzle from the solve() method. 
 * @author: Christina Bannon
 * @version: 2019.03.20
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class TowersOfHanoi 
{
	static int numMoves;
	static int numCalls;
	
	public static void main(String args[]) 
			throws IOException
	{
		BufferedReader reader = 
		new BufferedReader(new InputStreamReader(System.in));
		
		int n = 0;
		while (n >=0 )
		{
			System.out.println("Enter the number of disks!! "
					+ "Enter a negative number to exit");
			n = Integer.parseInt(reader.readLine().trim());
			System.out.println(n);
			
			if (n >= 0)
			{
				//CB getting together a prediction
				numMoves = 0;
				
				for (int i = 0; i < n; i++)
				{
					numMoves = (2 * numMoves) + 1;
				}
				
				System.out.println("Prediction of move numbers: "
				+ numMoves);
		
				//CB resetting numCalls/numMoves
				numMoves = 0;
				numCalls = 0;
				
				solve(n, "initial", "destination", "temp");
				
				System.out.println("Number of calls: "
				+ numCalls);
				System.out.println("Number of moves: " 
				+ numMoves);
			}
			System.out.println("\n");
		}	
		System.out.println("Au Revoir!");	
	}
	
	/*
	 * solve() method uses witchcraft and recursion to give 
	 * user instructions in the proper sequence
	 */
	public static void solve(int n, String init,
			String dest, String temp)
	{
		numCalls++;
		if (n > 0)
		{
			solve (n - 1, init, temp, dest);
			numMoves++;
			System.out.println("\tMove disk from "
			+ init + " to " + dest);
			
			System.out.println( "\t\t" + 
			numMoves + " moves");
			System.out.println("\t\t" + 
			numCalls + " calls");
			
			solve (n-1, temp, dest, init);
		}	
	}
}