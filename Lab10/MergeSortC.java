package Lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortC {
	
	static BufferedReader reader = 
			new BufferedReader(
					new InputStreamReader(System.in));

	static int comparisons = 0;
	
	public static void main(String []args) throws IOException
	{
		int [] unSorted = null;
		int [] sorted = null; 
		
		int menuSelection = makeMenuSelection();

		while (menuSelection != 4){
			
			switch (menuSelection){
				case 0: 
					unSorted = getUnsorted();
					break;
				case 1: 
					showArray(unSorted);
					break;
				case 2: 
					sorted = recursiveMerge(unSorted, 0, unSorted.length);
					break;
				case 3:
					showArray(sorted);
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
				"1. Show Unsorted Array\n" + 
				"2. merge\n" + 
				"3. Show merged array\n");
		int menuSelection = 
				Integer.parseInt(reader
						.readLine()
						.trim());
		return menuSelection;
	}
	
	public static int[] getUnsorted()  {
		System.out.println("How many integers?");
		int[] unSorted = null; 
		int size = -1;
		do {
			try {
				size = Integer.parseInt(reader.readLine().trim());
				try {
					int i = 0; 
					unSorted = new int[size];
					while (i < size) {
						System.out.print("unsorted[" + i +"] = ");
						unSorted[i] = Integer.parseInt(reader.readLine().trim());
						i++;
					}
				} catch (IOException E) {
					System.out.println("INVALID");
				}
			} catch (IOException E) {
				System.out.println("Enter a valid int");
			}
		} while (size < 0);
		
		return unSorted; 
	}
	
	public static void showArray(int[] array) {
		int i = 0;
		while (i < array.length) {
			System.out.print(array[i] + " ");
			i++;
		}
	}
	
	public static int[] recursiveMerge(int [] array, int start, int end) {
		if (start > end) {
			int midIndex = (start + end / 2);
			
			int[] leftArray = recursiveMerge(array, start, midIndex);
			int[] rightArray = recursiveMerge(array, (midIndex + 1), end);
			
			if (array[start] > array[end])
			{
				int holder = array[end];
				array[end] = array[start];
				array[start] = holder;
			}
			
			showArray(array);
		}
		return array;
	}
}
