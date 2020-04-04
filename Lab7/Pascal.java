package Lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pascal 
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader reader =
				new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a row to complete "
				+ "pascal's triangle to:");
		int row = Integer.parseInt(reader.readLine().trim());
		
		iterativePascal(row);
	}
	//CB Displaying Pascal's Triangle with an Iterative method
	public static void iterativePascal(int n)
	{
		int pascal [][] = new int [++n][n];

		pascal [0][0] = 1;
		System.out.println(pascal [0][0]);
		
		for (int row = 1; row < n; row++)
		{
			pascal [row][0] = 1;
			System.out.print(pascal [row][0] +" ");
			for (int col = 1; col < n; col++)
			{
				if (row != col)
				{
					pascal[row][col] = 
							pascal[row-1][col-1] + pascal[row -1][col];
					System.out.print(pascal [row][col] + " ");
				}
				else
				{
					pascal[row][col] = 1;
					System.out.println(pascal [row][col]);
					col = n;
				}
			}
		}
		
		//int pascal1D[] = new int 
	}

}
