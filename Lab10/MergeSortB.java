package Lab10;

/* Purpose: Data Structure and Algorithms Lab 10 Problem 1
* Status: 
* Last update: 04/09/19
* Submitted:  04/15/19
* Comment: 
* @author: Christina Bannon
* @version: 2019.04.09
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortB 
{
	static BufferedReader reader = 
			new BufferedReader(
					new InputStreamReader(System.in));

	public static void main(String []args) throws IOException
	{
		int [] unSorted = getUnsorted();
		
		int menuSelection = makeMenuSelection();

		while (menuSelection != 5){
			
			switch (menuSelection){
				case 0: 
					unSorted = getUnsorted();
					break;
				case 1: 
					unSorted = evenOddSort(unSorted);
					break;
				case 2: 
					unSorted = cutInHalfSort(unSorted);
					break;
					
			
			}//end switch		
			menuSelection = makeMenuSelection();
		}//end while
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
				"1. 2n + 1 & 2n sort. \n"+
				"2. cutInHalf sort! \n"+
				"5. Exit");
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

	/*CB this method compared each even index with an odd,
	 * in an effort to take the first sorting step in mergeSort
	 */
	public static int[] evenOddSort(int [] unSorted)
	{
		int []gettingSorted = unSorted.clone();
		int comparisons = 0;
		
		for (int i = 0; i < (gettingSorted.length/2); i++)
		{
			if (gettingSorted[(2*i) + 1] < gettingSorted[2*i])
			{
				int temp = gettingSorted[2*i];
				gettingSorted[2*i] = gettingSorted[(2*i) + 1];
				gettingSorted[(2*i) + 1] = temp;
			}
			
			comparisons++;
		}
		int [] sorted = gettingSorted.clone();
		
		display(sorted, comparisons);
		
		return sorted;
	}
	
	public static int[] cutInHalfSort(int [] unSorted)
	{
		int [] gettingSorted = cutInFirstHalfSort(unSorted);
		
		//i guess like just organize the other half now????

		return gettingSorted;
	}
	
	/*
	 * 
	 * 
	 * cutting in half, and sorting in halves is right. BUT
	 * is it mergeSort? Will it work a value of whatever??
	 * or just of 8? 
	 * idk
	 * 
	 */
	public static int[] cutInFirstHalfSort(int [] unSorted)
	{
		int []gettingSorted = unSorted.clone();
		int comparisons = 0;
		
		for(int i = 0; i < ((gettingSorted.length/2) - 2); i++)
		{
			if ((gettingSorted[i + 2]) < gettingSorted[i])
			{
				//swapperoo
				int temp = gettingSorted[i + 2];
				gettingSorted[i + 2] = gettingSorted [i + 1];
				gettingSorted[i + 1] = gettingSorted [i];
				gettingSorted[i] = temp;
				
				comparisons --;
			}

			//CB this second clause might be unnecessary! 
			else if (gettingSorted[i + 2] < gettingSorted [i + 1])
			{
				int temp = gettingSorted[i + 2];
				gettingSorted[i + 2] = gettingSorted[i + 1];
				gettingSorted[i+1] = temp;
			}

			comparisons++;
			comparisons++;
		}	
		int [] firstHalfSorted = gettingSorted.clone();
		
		display(firstHalfSorted, comparisons);
		
		return firstHalfSorted;
	}
	

	/*
	public static int[] cutInFirstHalfSort(int [] unSorted)
	{
		int []gettingSorted = unSorted.clone();
		int comparisons = 0;
		
		for(int i = 0; i < ((gettingSorted.length/2) - 2); i++)
		{
			if ((gettingSorted[i + 2]) < gettingSorted[i])
			{
				//swapperoo
				int temp = gettingSorted[i + 2];
				gettingSorted[i + 2] = gettingSorted [i + 1];
				gettingSorted[i + 1] = gettingSorted [i];
				gettingSorted[i] = temp;
				
				comparisons --;
			}

			//CB this second clause might be unnecessary! 
			else if (gettingSorted[i + 2] < gettingSorted [i + 1])
			{
				int temp = gettingSorted[i + 2];
				gettingSorted[i + 2] = gettingSorted[i + 1];
				gettingSorted[i+1] = temp;
			}

			comparisons++;
			comparisons++;
		}	
		int [] firstHalfSorted = gettingSorted.clone();
		
		display(firstHalfSorted, comparisons);
		
		return firstHalfSorted;
	}
	
	
	
	
	
	
	int comparisons = 0;
	int innermostLoopLim = 1;
	
	int arrayAElem = 0;
	int competitorArrayElem;
	int [] sorted = new int[unSorted.length];
	
	int newIndex; 
	
	//number of outer rounds needed for any length
	//h = 0, 1, 2, 4, ... (unSorted.length/2 -1)
	for (int h = 0 ; h < (unSorted.length) / 2 ; h = h << 1)
	{
		newIndex = 0;
		innermostLoopLim = h << 1; 
		competitorArrayElem = innermostLoopLim;
		arrayAElem = 0;
			
		//how many times the innermost loop needs to happen
		//i = 4, 2, 1
		for ( int i = unSorted.length; i > 0; i = i / 2 ) 
		{	
			
			for (int j = 0; j < h; j++)
			{
				if ( unSorted [arrayAElem] 
						<= unSorted [competitorArrayElem] )
				{
					sorted[newIndex] = unSorted[arrayAElem];
					arrayAElem ++;
				}
				else
				{
					sorted[newIndex] 
							= unSorted[competitorArrayElem];
					competitorArrayElem++;
				}	
				newIndex++;
			}
			
			//copy the rest of it in!!!
			for (int k = newIndex; k < sorted.length; k++)
			{
				sorted[newIndex] = unSorted[newIndex];
			}
			
			display(sorted, comparisons);
			/*
			for ( newIndex = arrayAElem; 
					newIndex <= innermostLoopLim;
						newIndex++ )
			{
				if ( unSorted [arrayAElem] 
						<= unSorted [competitorArrayElem] )
				{
					sorted[newIndex] = unSorted[arrayAElem];
					arrayAElem ++;
				}
				else
				{
					sorted[newIndex] 
							= unSorted[competitorArrayElem];
					competitorArrayElem++;
				}				
				display(sorted, comparisons);
			} 	
		}
	}	
	display(sorted, comparisons);*/
}