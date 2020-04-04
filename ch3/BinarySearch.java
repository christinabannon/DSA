package ch3;

//CB p 147

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch 
{
	public static void main (String [] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("What size should the array be?");
		int size = Integer.parseInt(reader.readLine().trim());
		
		while (size < 1)
		{
			System.out.println("What size should the array be?");
			size = Integer.parseInt(reader.readLine().trim());
		}
		
		int [] array = new int[size];
		
		System.out.println("Lets put some things in it.");
		for (int i = 0; i < size; i++)
		{
			System.out.print("Index # " + i + ": ");
			array[i] = Integer.parseInt(reader.readLine().trim());
		}
		
		System.out.println();
		
		System.out.println("What's the value you want the index of?");
		int value = Integer.parseInt(reader.readLine().trim());
		
		System.out.println("Here is the index: " 
				+ binarySearch(array, 0, size -1, value));
		
		
	}

	public static int binarySearch(int anArray[], int first, int last, int value) 
	{
		/*
		 * Searches the array items anArray[first] through anArray[last] 
		 * for value by using a binary search.
		 * PRE: 0 <= first, last <= SIZE - 1, where SIZE is the maximum size
		 * of the array, and anArray[first] <= anArray[first + 1]... <= anArray[last]
		 * POST: If the value is in the array, the method returns the index of
		 * the array item that equals value. Otherwise it returns -1. 
		 */
		int index;
		
		//CB if first > last, there has been an error. 
		if (first > last)
		{
			index = -1;
		}
		else
		{
			//Invariant: If value is in anArray, 
			//     anArray[first] <= value <= anArray[last]
			
			int mid = (first + last)/2;
			
			//CB if we have found the value, send it in! (base case)
			if (value == anArray[mid])
			{
				index = mid;
			}
			else if (value < anArray[mid])
			{
				//CB search the front! Recursive call X
				index = binarySearch(anArray, first, mid-1, value);
			}
			else
			{
				//CB search the back! Recursive call Y
				index = binarySearch(anArray, mid+1, last, value);
				
			}
		}

		return index;
	}
}
