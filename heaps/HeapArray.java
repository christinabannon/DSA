package heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapArray 
{

	static BufferedReader reader =
			new BufferedReader( 
					new InputStreamReader(System.in));
	

	
	public static void main(String [] args) throws IOException
	{

		int heap[] = 
	{
				 80, 
	  	 	30,       11, 
	  	 25,   15,   9,  1, 
      12, 20, 3
								};

		char menuSelection = makeMenuSelection(); 
		while (menuSelection != 0)
		{
			switch (menuSelection)
			{
				//displaying the heap
				case '1': displayHeap(heap);
				break; 
				
				case '2': heap = insert(heap);
				break;
				
				case '3' : heap = deleteMax(heap);
				break;
				
				default: System.out.println("Enter something valid.");
			}
			menuSelection = makeMenuSelection();
		}
		
		System.out.println("Goodbye!!");
		System.exit(0);
	}
	
	public static char makeMenuSelection() 
			throws IOException
	{
		System.out.println("\n  Please select from "
				+ "the following menu: ");
		System.out.println("0. Exit\n"
				         + "1. Display Heap\n"
				         + "2. Insert an int\n"
				         + "3. deleteMax \n");

		return reader.readLine().charAt(0);
	}
	
	public static void displayHeap(int [] heap)
	{
		int i = 0; 
		int h = 1; 
		
		while (i < heap.length){
			int coltracker = 0;
			
			while (coltracker < h && i < heap.length){
				System.out.print(heap[i] + " ");
				coltracker++;
				i++;
			}
			
			System.out.println();
			h = h << 1;
		}	
		
		System.out.println();
		
		i = 0;
		while ( i < heap.length){	
			System.out.print(heap[i] + " ");
			i++;
		}	
	}
	
	public static int [] insert(int [] heap) throws IOException
	{
		System.out.println("Enter item to insert: " );
		int item = Integer.parseInt(reader.readLine().trim());
		
		int index = heap.length;
		int parentIndex = ((index - 1) / 2);
		
		heap = makeSpace(heap, item);
		
		while (heap[index] > heap[parentIndex] && index > 1)
		{
			int temp = heap[index];
			heap[index] = heap[parentIndex];
			heap[parentIndex] = temp;
			
			index = parentIndex;
			parentIndex = ((index - 1) / 2);
		}
		
		displayHeap(heap);
		
		return heap;
	}
	
	private static int [] makeSpace(int [] heap, int item)
	{
		int[] biggerHeap = new int [heap.length + 1];
		
		for (int i = 0; i < heap.length; i++)
		{
			biggerHeap[i] = heap[i];
		}
		
		biggerHeap [biggerHeap.length -1] = item;
		
		heap = biggerHeap;
		
		return heap;
	}
	
	public static int[] deleteMax(int [] heap)
	{
		System.out.println("deleting max......." );
		int index = 0;
		int leftChild = index * 2 + 1;
		int rightChild = index * 2 + 2; 
		
		while (index < ((heap.length + 1)/2))
		{	
			heap[index] = 
					heap[leftChild] > heap[rightChild] 
					? heap[leftChild] : heap[rightChild];
			
			index = heap[leftChild] > heap [rightChild]
					? leftChild : rightChild; 
			
			leftChild = index * 2 + 1;
			rightChild = index * 2 + 2; 
		}
		
		heap = arrayDelete(index, heap);
		
		displayHeap(heap);
		return heap;
	}
	
	public static int [] arrayDelete(int index, int [] heap)
	{
		int [] smallerHeap = new int[heap.length -1];
		
		for (int i = 0; i < index; i++)
		{
			smallerHeap[i] = heap[i];
		}
		
		for (int i = index + 1; i < heap.length; i++)
		{
			smallerHeap[i-1] = heap[i];
		}
		
		heap = smallerHeap; 
		
		return heap;
	}
}
