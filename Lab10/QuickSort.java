package Lab10;

/*
 * Purpose: REDO Data Structure and Algorithms Lab 10 Problem 1 
 * Status: WORKING
 * Last update: 05/01/19
 * Submitted:  05/01/19
 * Comment:  
 * @author: Christina Bannon
 * @version: 2019.05.01
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort 
{
	static BufferedReader reader = 
			new BufferedReader(
					new InputStreamReader(System.in));
	static int comparisons = 0;

	public static void main(String []args) throws IOException
	{
		int [] unSorted = getUnsorted();
		
		int menuSelection = makeMenuSelection();

		while (menuSelection != 4){
			
			switch (menuSelection){
				case 0: 
					unSorted = getUnsorted();
					break;
				case 1: 
					unSorted = findPivot(unSorted, 0, unSorted.length);
					break;
				case 2: 
					quickSort (unSorted, 0, unSorted.length -1);				
					break;
				case 3: 
					display( unSorted, comparisons);
					
			
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
				"1. find pivot\n" + 
				"2. QuickSort\n" + 
			    "3. Display current array"
			    +"4. Exit");
		int menuSelection = 
				Integer.parseInt(reader
						.readLine()
						.trim());
		System.out.println(menuSelection);
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
	 * 
	 * partition is the actual organizer method in quicksort
	 * it gets called recursively as long as lowest < highest, 
	 * so that we know that there are still things to sort. 
	 */
	public static int partition(int [] unSorted, int lowest, int highest)
	{
		unSorted = findPivot(unSorted, lowest, highest);
		
		int pivot = unSorted [lowest]; //0
		int greaterThan = lowest; //0 
		int lessThan = lowest; //0
		
		
		for (int reader = lowest + 1; reader <= highest; reader++)
		{
			if (unSorted[reader] < pivot)
			{
				int temp = unSorted[++lessThan];
				unSorted[lessThan] = unSorted[reader];
				unSorted[reader] = temp;		
			}		
			greaterThan++;
			comparisons++;
		}	
		
		//swap back the pivot
		unSorted[lowest] = unSorted[lessThan];
		unSorted[lessThan] = pivot;

			return lessThan; //CB THE PARTITION
	}
	
	
	/**
	 * recursive sorter 
	 * 
	 * sorts the first half recursively. then the second half
	 * @param unSorted
	 * @param lessThanIndex
	 * @param intToCheckIndex
	 * @return
	 */
	public static void quickSort(int [] unSorted, int startAtIndex, int endAtIndex)
	{
		if (startAtIndex < endAtIndex)
		{
			
			int partition = partition(unSorted, startAtIndex, endAtIndex);
		
			quickSort(unSorted, startAtIndex, partition);
			
			quickSort(unSorted, partition + 1 , endAtIndex);
		}
	}
	
	
	/*
	 *findPivot
	 *organized the first 3 items in the array 
	 *in pivot, less than, greater than
	 *order so that we know we aren't 
	 *getting the worst case
	 */
	public static int [] findPivot(int [] unSorted, int start, int end)
	{
		
		
		if (end - start >= 3)
		{
			comparisons++; 
			if (unSorted [start] <= unSorted [start + 1]) // 0, 1
			{
				comparisons++;
				if (unSorted [start + 1] <= unSorted [start + 2]) // 0, 1, 2
				{
					comparisons ++; 

					swap(unSorted, start, start + 1);
				}
				else if (unSorted [start] <= unSorted [start + 2]) // 0 2 1
				{
					comparisons +=2;
					
					swap (unSorted, start, start + 2);
				}
			}
			else // 1, 0
			{
				if (unSorted[start + 1] >= unSorted[start + 2]) //2, 1, 0
				{
					comparisons++; 
					swap ( unSorted, start, start + 1);
				}
				else if (unSorted[start] >= unSorted[start + 2]) // 1 2 0
				{
					comparisons++; 
					
					swap( unSorted, start, start + 2);

				}
						
			}
		}
		display(unSorted, comparisons);
		
		return unSorted;
	}
	
	private static void swap(int [] unSorted, int swapIndexA, int swapIndexB)
	{
		int temp = unSorted[swapIndexA];
		unSorted[swapIndexA] = unSorted[swapIndexB];
		unSorted[swapIndexB] = temp;
	}
}