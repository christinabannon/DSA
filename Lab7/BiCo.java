package Lab7;

/*
 * Purpose: Data Structure and Algorithms Lab 7 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 03/20/19
 * Submitted:  03/25/19
 * Comment: The BiCo class 
 * 	(1) accepts a row number (int n) and a 
 * 		column (int k) number, 
 * 	(2) prompts the user to respond if they want 
 * 		to see 
 * 		(R) the BiCo found recursively, 
 * 		(I) the BiCo found iteratively,
 * 		(P) Pascal's triangle up to row (n)
 * 	(3) displays the proper response
 * @author: Christina Bannon
 * @version: 2019.03.20
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BiCo 
{
	public static void main(String [] args) 
			throws IOException
	{
		String response;
		
		BufferedReader reader = 
				new BufferedReader(new 
						InputStreamReader(System.in));
		
		/*
		 * do-while loop to allow for multiple 
		 * runs on multiple different inputs
		 * 
		 */
		do
		{	
			System.out.println("Would you like"
					+ " the Recursive BiCo, \n"
					+ "the Iterative BiCo, \n"
					+ "Pascal's Triangle \n"
					+ "or the Formulaic BiCo??"
					+ "\nType your response.");
			
			response = 
					reader.readLine().trim().toUpperCase();
			System.out.println(response);
			switch (response.charAt(0))
			{
			case 'R':
			{
				System.out.println("Enter the row number: ");
				int n = Integer
						.parseInt(reader
								.readLine()
								.trim());
				System.out.println(n);

				System.out.println("Enter the column number: ");
				int k = Integer
						.parseInt(reader
								.readLine()
								.trim());
				System.out.println(k);
				
				/*
				 * CB any suggestions on how to turn this input 
				 * validation block into a coherent method would
				 * be greatly appreciated
				 */
				while (k > n || k < 0 || n < 0)
				{
					System.out.println("Please enter valid"
							+ " input: Positive integers,"
							+ " with a column number"
							+ " lower than the row number.");

					System.out.println("Enter the row number: ");
					n = Integer
							.parseInt(reader
									.readLine()
									.trim());
					System.out.println(n);

					
					System.out.println("Enter the "
							+ "column number: ");
					k = Integer
							.parseInt(reader
									.readLine()
									.trim());	
					System.out.print(k);
				}
				System.out.println("\tRecursive: "
				+recursiveBiCo(n,k));
				System.out.println();
			}
				break;
			case 'I': 
			{
				System.out.println("Enter the row number: ");
				int n = Integer
						.parseInt(reader
								.readLine()
								.trim());
				System.out.println(n);
				
				System.out.println("Enter the column number: ");
				int k = Integer
						.parseInt(reader
								.readLine()
								.trim());
				System.out.println(k);

				while (k > n || k < 0 || n < 0)
				{
					System.out.println("Please enter"
							+ " valid input: Positive "
							+ "integers, with"
							+ " a column number lower "
							+ "than the row number.");

					System.out.println("Enter the "
							+ "row number: ");
					n = Integer
							.parseInt(reader
									.readLine()
									.trim());
					System.out.println(n);

					System.out.println("Enter the "
							+ "column number: ");
					k = Integer
							.parseInt(reader
							.readLine()
							.trim());		
					System.out.println(k);
				}
				System.out.println("\tIterative: "
				+ iterativeBiCo(n,k));
				System.out.println();
			}
				break;
			case 'P':
			{
				System.out.println("Enter the "
						+ "row number: ");
				int n = Integer
						.parseInt(reader
								.readLine()
								.trim());
				
				System.out.println("\tPascal's Triangle: \n" 
				+ iterativePascal(n));
			}
				break;
				
			case 'F': 
			{
				System.out.println("Enter the"
						+ " row number: ");
				int n = Integer
						.parseInt(reader
								.readLine()
								.trim());
				System.out.println(n);

				System.out.println("Enter the "
						+ "column number: ");
				int k = Integer
						.parseInt(reader
								.readLine()
								.trim());
				System.out.println(k);

				while (k > n || k < 0 || n < 0)
				{
					System.out.println("Please enter valid"
							+ " input: Positive integers,"
							+ " with a column number"
							+ " lower than the row number.");

					System.out.println("Enter the"
							+ " row number: ");
					n = Integer
							.parseInt(reader
									.readLine()
									.trim());
					System.out.println(n);

					
					System.out.println("Enter the "
							+ "column number: ");
					k = Integer
							.parseInt(reader
									.readLine()
									.trim());	
					System.out.println(k);
				}
				
				System.out.println("\tFormulaic method: "
				+ formulaicBiCo(n,k));
				System.out.println();
			}
				break;
			default:
				System.out.println("Invalid input.");
				break;
			}
			
			System.out.println("Enter EXIT when "
					+ "finished or CONTINUE to \n"
					+ "evaluate another. ");
			
			response = reader
					.readLine()
					.trim()
					.toUpperCase();
			System.out.println(response);
		}while (!response.startsWith("E"));
		
		System.out.println("Goodbye!");
		System.exit(0);
	}

	/*
	 * recursiveBiCo accepts integers n and k
	 * to represent the row and column that 
	 * you would find a certain binomial
	 * coefficient in. This method finds the
	 * binomial coefficient recursively, 
	 * and returns it as a double.
	 * Preconditions: ints n & k >= 0, and 
	 * 	int n >= int k
	 * Postconditions: returns a double to 
	 * represent the BiCo
	 */
	public static double recursiveBiCo(int n, int k)
	{
		double result = 0;

		//CB base case
		if (n == k || k == 0)
		{
			result = 1;
		}
		else
		{
			result = recursiveBiCo(n-1, k-1)
					+ recursiveBiCo(n-1, k);
		}
		return result;
	}

	/*
	 * iterativeBico accepts integers n and k to
	 * represent the row and column that you could 
	 * find a certain Binomial Coefficient in. 
	 * Method iteratively returns a double value that 
	 * represents the Binomial coefficient
	 * Preconditions: ints n & k >= 0, and 
	 * 	int n >= int k
	 * Postconditions: returns a double to 
	 * represent the BiCo
	 */
	public static double iterativeBiCo(int n, int k)
	{
		double result;

		if (n != k)
		{
			int pascal [][] = new int [++n][++k];

			pascal [0][0] = 1;

			for (int row = 1; row < n; row++)
			{
				pascal [row][0] = 1;

				for (int col = 1; col < k; col++)
				{
					if (row != col)
					{
						pascal[row][col] = 
								pascal[row-1][col-1] 
									+ pascal[row -1][col];
					}
					else
					{
						pascal[row][col] = 1;
						col = k;
					}
				}
			}
			result = pascal[--n][--k];
		}
		else
		{
			result = 1;
		}

		return result;
	}
	
	/*
	 * The interativePascal method accepts an integer 
	 * that represents the row to complete
	 * Pascal's triangle to, and returns a 
	 * String of Pascal's triangle
	 * Precondition: input an integer >=0
	 * Postcondition: returns a String 
	 * of Pascal's triangle
	 */
	public static String iterativePascal(int n)
	{
		StringBuilder pascal = new StringBuilder();
		int topRow [];
		int bottomRow [] = new int [++n];

		bottomRow[0] = 1;
		pascal.append(bottomRow[0] + "\n");

		//CB iterates (n-1) times
		for (int row = 1; row < n; row++)
		{	
			bottomRow [0] = 1;
			pascal.append(bottomRow[0]);
			
			topRow = bottomRow.clone();
			
			//CB iterates (k-1) times
			for (int col = 1; col < n; col++) 
			{	
				if (col != row)
				{	
					bottomRow[col] = 
							topRow[col-1] + topRow[col];
					pascal.append(" " 
							+ bottomRow[col]);
				}
				else 
				{
					bottomRow[col] = 1;
					pascal.append(" " 
							+ bottomRow[col] + "\n");
					col = n;
				}
			}
		}
		return pascal.toString();
	}
	
	/*
	 * formulaic BiCo accepts an int n and an int k and 
	 * find the binomial coefficient by using a simplified 
	 * version of the formula.
	 * Preconditions: n >= k >= 0
	 * Postcondition: returns a double to represent the
	 * binomial coefficient
	 */
	public static double formulaicBiCo(int n, int k)
	{
		double numerator = 1;
		double denominator = 1; 
		
		if (k > (n-k))
		{
			//CB iterates n-k times
			for (int i = n; i > k; i--)
			{
				numerator = numerator * i;
				denominator = denominator * (i-k);
			}
		}
		else
		{
			//CB iterates k times
			for (int i = n; i > (n-k); i--)
			{
				numerator = numerator * i;
				denominator = denominator * (i - (n-k));
			}
		}	
		return (numerator / denominator);
	}
}