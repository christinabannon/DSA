package Lab10;


//CB this is not a quick sort that I made, 
//CB this is a QS I am trying to learn from. 

public class QuickSortInterviewBit
{
	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	// Driver program 
	public static void main(String args[]) 
	{ 
		int arr[] = {10, 7, 8, 9, 1, 5}; 
		int n = arr.length; 

		sort(arr, 0, n-1); 

		System.out.println("sorted array"); 
		printArray(arr); 
	} 
	
	public static int partition(int [] arr, int low, int high)
	{
		int pivot = arr[high]; //assign pivot 
							//as the highest thing in the 
							// array
		
		int i = (low - 1); //index of smaller element

		for (int j = low; j < high; j++)
		{
			if (arr[j] <= pivot) 
			{
				i++;
			
				// swap the two elements
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		
		return i + 1;
	}
	
	public static void sort(int arr[], int low, int high)
	{
		if( low < high )
		{
			int pi = partition(arr, low, high);
			
			sort(arr, low, pi-1);
			
			sort(arr, pi + 1, high);
		}
	}
}
