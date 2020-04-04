package Lab3;

/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 02/10/19
 * Submitted:  02/11/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.10
 */

/*
 * This class demonstrates the compareTo method with different strings. 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Compare 
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input1;
		String input2;
		
		do
		{
			System.out.println("Enter 2 inputs to compare them.");
			System.out.println("Enter 'stop' to quit");
			System.out.print("Input 1: " );
			input1 = reader.readLine().trim();
			System.out.print(input1);
			
			if (!input1.toLowerCase().equals("stop"))
			{
				System.out.println();
			
				System.out.print("Input 2: ");
				input2 = reader.readLine().trim();
				System.out.println(input2);
			
				//CB created a variable to not have to call the method multiple 
				//CB times in the same loop
			
				int difference = input1.compareTo(input2);
				if (difference > 0)
				{
					System.out.println(input1 + " has a larger value by : "
						+ difference + ". " );
				}
				else if (difference < 0)
				{
					System.out.println(input2 + " has a larger value by : " 
						+ (difference *-1) + ". ");
				}
				else
				{
					System.out.println("Same exact value!");
				}
			}
			System.out.println();
		}while (!input1.toLowerCase().equals("stop"));
		
		System.out.println("Good bye!");
	}
}

