/*
 * Purpose: Data Structure and Algorithms Lab 1 Problem 8
 * Status: Complete and thoroughly tested
 * Last update: 01/25/19
 * Submitted:  01/30/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.01.25
 */

//CB The Means class asks the user to enter an integer number numPairs for the pairs
// Then reads numPairs pairs (integer number, real number for the weight) provided by the user
// and finally displays the weighted arithmetic mean of all the n pairs 
//CB and the simple arithmetic mean of the n numbers
 
package work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Means 
{

	
	public static void main(String [] args) throws IOException
	{
		//CB Variables
		int              numPairs;  //CB holds th inputted number of pairs
		int                number;  //CB holds the integer number
		double             weight;  //CB holds the weight for that number, for a weighted mean
		double            sum = 0;  //CB accumulator for the sum of nonweighted numbers
		double   weightedMean = 0;  //CB accumulator for the sum of weighted means
		double               mean;  //CB holds the non-weighted mean
		
		//CB create BufferedReader instance
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		
		System.out.println("Enter number of pairs");
		numPairs = Integer.parseInt(reader.readLine().trim());
		
		//CB if statement to deal with a 0 number! If numPairs is not 0, this statement can execute
		if (numPairs != 0)
		{
		
			//CB for loop for fill arrays!- This loop will iterate for each pair, 
			//CB taking in the number and weight, while accumulating
			//a total (sum) and accumulating a calculated weightedMean 
			for (int i = 0; i < numPairs; i++)
			{
				System.out.println("Enter number :" + (i+ 1));
				number = Integer.parseInt(reader.readLine());
			
				//CBsum accumulates each grade;
				sum += number; 
			
				System.out.println("Enter weight :" + (i + 1));
				weight =(Double.parseDouble((reader.readLine()))/130.7);
			
				//CB weighted mean accumulates the weights
				weightedMean += (number * weight);
			}
		
			//CB finding the non-weighted mean
			mean = sum/numPairs;
		}
		
		//CB if numPairs is 0, the mean must also be 0
		else
		{
			mean = 0;
		}
		//CB displaying the output
		System.out.printf("The weighted mean is %.2f \n", weightedMean);
		System.out.printf("The mean is %.2f \n",  mean);
	}
}
