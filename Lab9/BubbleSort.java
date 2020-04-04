package Lab9;


/*
 * Purpose: Data Structure and Algorithms Lab 9 Problem 1
 * Status: improvedSelectionSort - not actually improved
 * Last update: 04/02/19
 * Submitted:  04/01/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.04.02
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class BubbleSort 
{

	static BufferedReader reader =
			new BufferedReader( 
					new InputStreamReader(System.in));
	
	public static void main(String [] args)
			throws IOException
	{

		int []unSorted = getUnsorted();
		
		int menuSelection = makeMenuSelection();
		
		while (menuSelection != 6)
		{
			switch (menuSelection)
			{
				case 0: 
					unSorted = getUnsorted();
					break;

				case 1: 
					System.out.println("Bubble Sort: " );
					bubbleSort(unSorted);
					break;
					
				case 2: 
					System.out.println("Improved "
									+ "Bubble Sort: ");
					improvedBubbleSort(unSorted);
					break;
					
				case 3: 
					System.out.println("Selection Sort: ");
					selectionSort(unSorted);
					break;
					
				case 4: 
					System.out.println("Improved Selection Sort: ");
					improvedSelectionSort(unSorted);
					break;
					
				case 5:
					System.out.println("Insertion Sort: " );
					insertionSort(unSorted);
					break;
			}
			menuSelection = makeMenuSelection();
		}
		
		System.out.println("Goodbye!!");
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
				     "1. Bubble Sort\n" +
			 	     "2. Improved Bubble Sort\n" + 
			 	     "3. Selection Sort\n" +
			 	     "4. Improved Selection Sort\n" + 
			 	     "5. Insertion Sort\n" + 
			 	     "6. Exit");
		int menuSelection = 
				Integer.parseInt(reader
					         	.readLine()
					        	.trim());
		return menuSelection;
	}
	
	/*
	 * getUnsorted
	 * gets integer input for the array
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
	 * bubbleSort
	 * accepts an unSorted array of integers, 
	 * sorts them using a bubble sort method, 
	 * then displays them!
	 */
	public static void bubbleSort(int [] unSorted)
	{
		int [] sorted = unSorted.clone();	
		int passCount = 0;
		int bubbleRound;
		int comparisons = 0;
		int swaps = 0;
		
		//outer loop runs through each new 
		//element to bubble up
		while (passCount < sorted.length )
		{
			bubbleRound = 1;
			
			//inner loop bubbles up a single element
			while ( bubbleRound < (sorted.length - passCount))
			{
				int prev = sorted[bubbleRound - 1];
				int next = sorted [bubbleRound];
			
				if (prev > next)
				{
					sorted [bubbleRound] = prev;
					sorted [bubbleRound - 1] = next;
					swaps++;
				}
					
				bubbleRound++;
				comparisons++;
			}
			passCount ++;
		}
		
		display(sorted, comparisons, swaps);
	}
	
	/*
	 * improvedBubbleSort
	 * accepts an unSorted array of integers, 
	 * stops sorting when it has 
	 */
	public static void improvedBubbleSort(int [] unSorted)
	{
		int [] sorted   = unSorted.clone();	
		int passCount   = 0;
		int bubbleRound;
		int comparisons = 0;
		int swaps       = 0;
		
		//outer loop runs through each new 
		//element to bubble up
		while (passCount < sorted.length )
		{
			bubbleRound = 1;
			
			//CB flag will stay true if an entire round goes by 
			// without any swaps
			boolean organized = true; 
			
			//inner loop bubbles up a single element
			while ( bubbleRound < (sorted.length - passCount))
			{
				int prev = sorted[bubbleRound - 1];
				int next = sorted [bubbleRound];
			
				if (prev > next)
				{
					sorted [bubbleRound] = prev;
					sorted [bubbleRound - 1] = next;
					swaps++;
					organized = false;
				}
					
				bubbleRound++;
				comparisons++;
			}
			passCount ++;
			if (organized)
			{
				passCount = sorted.length;
			}
		}
		
		display(sorted, comparisons, swaps);
	}
	
	/*
	 * selectionSort
	 * compares before swapping, only
	 * does one strategic swap per "sortRound
	 */
	public static void selectionSort( int [] unSorted)
	{
		int [] sorted = unSorted.clone();

		int max; 
		int passCount = 1;
		int sortRound;
		int comparisons = 0;
		int swaps = 0;
		
		while (sorted.length - passCount > 0)
		{
			sortRound = 0;
			
			//length of unsorted sub-array
			max = sorted.length - passCount; 
			int temp;
			
			while (sortRound < sorted.length - passCount)
			{
				if (sorted[max] < sorted [sortRound])
				{
					max = sortRound;
				}
				sortRound ++;
				comparisons++;
			}
			
			temp = sorted[max];
			sorted[max] = sorted [sortRound];
			sorted[sortRound] = temp;	
			swaps++;
			passCount++;
		}	
		display(sorted, comparisons, swaps);

	}
	
	/*
	 * selectionSort
	 * compares before swapping, only
	 * does one strategic swap per "sortRound"
	 * I don't beleive I have actually 
	 * improved this, but I'll keep trying. 
	 */
	public static void improvedSelectionSort( int [] unSorted)
	{
		int [] sorted = unSorted.clone();

		int max; 
		int passCount = 1;
		int sortRound;
		int comparisons = 0;
		int swaps = 0;
		
		boolean organized = false;
		
		while (sorted.length - passCount > 0)
		{
			sortRound = 0;
			
			//CB checking if during a run an item 
			// is the largest
			organized = true; 

			//length of unsorted sub-array
			max = sorted.length - passCount; 
			int temp;
			
			while (sortRound < sorted.length - passCount)
			{
				if (sorted[max] < sorted [sortRound])
				{
					max = sortRound;
				} 
				else
				{	
				    organized = false;
				}
				sortRound ++;
				comparisons++;
			}
			
			//swap
			temp = sorted[max];
			sorted[max] = sorted [sortRound];
			sorted[sortRound] = temp;	
			
			swaps++;
			passCount++;
			
			if (organized)
			{
				passCount = sorted.length;
			}
		}	
		display(sorted, comparisons, swaps);
	}
	
	/*
	 * insertionSort checks all indexes, and puts in 
	 * the "next smallest" in the next largest index!
	 */
	public static void insertionSort(int [] unSorted)
	{
		int []  sorted = unSorted.clone();
		
		int indexOfSmallest = 0;
		int           swaps = 0;
		int     comparisons = 0;
		
		boolean  moveNeeded;

		for (int i = 1; i < unSorted.length; i++)
		{
			moveNeeded = false; 
			
			//only executes in the case of a swap being necessary, 
			//and doesnt stop until it find the proper index!!
			for (int j = i-1; (j >= 0) && (sorted[i] < sorted[j]); j--)
			{
				indexOfSmallest = j;
				moveNeeded = true;
				comparisons++;		
			}
			
			if (moveNeeded)
			{
				int temp = sorted[i];
				
				for (int k = i; k > indexOfSmallest; k--)
				{
					 sorted[k] = sorted[k-1];
				}
				
				sorted[indexOfSmallest] = temp;
				swaps++;
			}
		}
		display(sorted, comparisons, swaps);
	}
	
	/*
	 * improvedInsertionSort checks all indexes, and puts in 
	 * the "next smallest" in the next largest index!
	 */
	public static void improvedInsertionSort(int [] unSorted)
	{
		int []  sorted = unSorted.clone();
		
		int indexOfSmallest = 0;
		int           swaps = 0;
		int     comparisons = 0;
		
		boolean  moveNeeded;

		for (int i = 1; i < unSorted.length; i++)
		{
			moveNeeded = false; 
			
			//only executes in the case of a swap being necessary, 
			//and doesnt stop until it find the proper index!!
			for (int j = i-1; (j >= 0) && (sorted[i] < sorted[j]); j--)
			{
				indexOfSmallest = j;
				moveNeeded = true;
				comparisons++;		
			}
			
			if (moveNeeded)
			{
				int temp = sorted[i];
				
				for (int k = i; k > indexOfSmallest; k--)
				{
					 sorted[k] = sorted[k-1];
				}
				
				sorted[indexOfSmallest] = temp;
				swaps++;
			}
		}
		display(sorted, comparisons, swaps);
	}
	
	/*
	 * simple duplicate code saving displayer. 
	 */
	private static void display(int [] sorted, int comparisons, int swaps)
	{

		System.out.print("\t");
		for (int i = 0; i < sorted.length; i++)
		{
			System.out.print(sorted[i] + " ");
		}
		
		System.out.println();
		
		System.out.println("\tNumber of comparisons: " 
							+ comparisons);
		System.out.println("\tNumber of swaps: " 
							+ swaps);						
	}
}
