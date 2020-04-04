package Lab10;

/*
 * Purpose: REDO Data Structure and
 *  Algorithms Lab 10 Problem 1
 * Status: Working on powers of 2
 * Last update: 05/01/19
 * Submitted:  05/01/19
 * Comment: 
 * 
 * To write this / understand the implementation,
 *  I studied the code from these websites:
 *  
 *  1. https://www.geeksforgeeks.org/merge-sort/
 *  2. http://www.mathcs.emory.edu/~cheung/Courses/
 *      171/Syllabus/7-Sort/merge-sort5.html
 *  3. https://www.baeldung.com/java-merge-sort
 *  
 * @author: Christina Bannon
 * @version: 2019.05.01
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort 
{
	static BufferedReader reader = 
			new BufferedReader(
					new InputStreamReader(System.in));

	static int comparisons = 0;
	
	public static void main(String []args) throws IOException
	{
		int [] unSorted = getUnsorted();
		
		int menuSelection = makeMenuSelection();

		while (menuSelection != 2){
			
			switch (menuSelection){
				case 0: 
					unSorted = getUnsorted();
					break;
				case 1: 
					mergeyLoop(unSorted);
					break;
					
			
			}//end switch		
			menuSelection = makeMenuSelection();
		}//end while

		System.out.println("BYE");
		System.exit(0);
	}

	/*
	 * CB avoiding repeated code - takes input for
	 * the switch statement
	 */
	public static int makeMenuSelection() 
			throws IOException
	{
		System.out.println("\n  Please select from "
				+ "the following menu: ");
		System.out.println("0. Input New Unsorted" + 
				" Integers\n" + 
				"1. MergeSort\n" + 
				"2. Exit");
		int menuSelection = 
				Integer.parseInt(reader
						.readLine()
						.trim());
		return menuSelection;
	}

	/*
	 * getUnsorted
	 * prompts user for integer input for the array,
	 * puts in it an array, which it then returns
	 */
	public static int[] getUnsorted() throws IOException
	{
		System.out.println("Enter number of"
				+ " integers: ");
		int size = 
				Integer.parseInt(reader
						.readLine()
						.trim());
		System.out.println(size);

		int [] unSorted = new int [size];

		int index = 0;

		while ( index < unSorted.length )
		{
			System.out.print("\tEnter integer number "
					+ (index + 1) + ": " );
			int newElement = 
					Integer.parseInt(reader
							.readLine()
							.trim());
			System.out.println("\t" + newElement);
			unSorted[index] = newElement;
			index++;
		}

		System.out.println("Input data: " );
		index = 0;

		System.out.print("\t");
		while ( index < unSorted.length )
		{
			System.out.print(unSorted[index] 
					+ " ");
			index++;
		}
		System.out.println();	

		return unSorted;
	}
	
	/*
	 * simple duplicate code saving displayer. 
	 */
	private static void display(int [] sorted, int comparisons)
	{
		System.out.print("\t");
		for (int i = 0; i < sorted.length; i++)
		{
			System.out.print(sorted[i] + " ");
		}
		
		System.out.println();
		
		System.out.println("\tNumber of comparisons: " 
							+ comparisons);					
	}
	
	/*
	 * mergeyLoop is the main looper to send the right 
	 * index's to the merge method. All it does is 
	 * index management and some funky bit shifting. 
	 * 
	 * @param unSorted
	 */
	public static void mergeyLoop(int []unSorted)
	{
		int width;
		int sorted [] = new int[unSorted.length];
		
		for (width = 1; width < unSorted.length; width = width << 1)
		{
			for (int i = 0; i < unSorted.length; i += width << 1)
			{
				int left = i; 
				int middle = i + width;
				int right = i + 2* width;
				
				merge (unSorted, left, middle, right, sorted);
			}
			
			for (int i = 0; i < unSorted.length; i ++)
			{
				unSorted[i] = sorted[i];
			}
		}
		
		display(unSorted, comparisons);
	}

	/*
	 * 
	 * merge()
	 * 
	 * the actual comparison method - 
	 * puts the smaller element from 2 mini
	 * arrays as the next element in the temp array 
	 * (sorted) and continues with that pattern until 
	 * one of the mini arrays has been copied over. 
	 * Then it copies over the other mini array. 
	 */
	public static void merge (int [] unSorted, int init, 
			int mid, int end, int []sorted)
	{	
		int i = init;
		int m = mid; // index between 2 mini arrays being sorted
		int sortedIndex = init;

		//while there are things left to sort
		while (i < mid && m < end)
		{
			if (unSorted[i] < unSorted[m])
			{
				sorted[sortedIndex] = unSorted[i];
				i++;
			}
			else
			{
				sorted[sortedIndex] = unSorted[m];
				m++;
			}
			comparisons++;
			sortedIndex++;
		}
		while (i < mid) // first half empty
			// fill in second half r
		{
			sorted[sortedIndex++] = unSorted[i++];			
		}
	}
}