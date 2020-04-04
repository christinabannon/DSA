package Lab7;

/*
 * Purpose: Data Structure and Algorithms Lab 7 Problem 1 
 * Status: Complete and thoroughly tested
 * Last update: 03/12/19
 * Submitted:  03/12/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.03.12
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Factorial 
{
	public static void main(String []args) throws IOException
	{
		BufferedReader reader = 
				new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter a number");
		
		//CB saving the string as a big int
		BigInteger n =  new BigInteger((reader.readLine().trim()));
		
		System.out.print(n.toString() + "! Recursive: "+ 
		rFact(n).toString());
		System.out.println();
		
		System.out.print(n.toString() + "! Iterative: "+ 
		itFact(n).toString());
		System.out.println();
	}
	
	//CB rFact accepts a BigInteger and returns 
	//another BigInteger that is 
	// the factorial of the parameter
	
	public static BigInteger rFact(BigInteger n)
	{
		BigInteger result = BigInteger.ONE;
		//CB allocating a huge, but useless array to blow up the heap!
		BigInteger [] bigArray = new BigInteger [n.intValue() + 1];
		
		if (n.compareTo(BigInteger.ZERO) == 0 ||
				n.compareTo(BigInteger.ONE) == 0 )
		{
			System.out.println("if executing");
			result = BigInteger.ONE;
		}
		else
		{	
			result = n.multiply(rFact(n.subtract(BigInteger.ONE)));		
		}		
		return result;
	}
	
	//CB itFactfinds the given BigInteger's 
	//CB factorial iteratively and returns the 
	//factorial as a BigInteger
	public static BigInteger itFact(BigInteger n)
	{
		BigInteger result = BigInteger.ONE;
		
		for (BigInteger i = new BigInteger("1"); 
				i.compareTo(n) <= 0;
				i = i.add(BigInteger.ONE))
		{
			result = result.multiply(i);
		}
		return result;
	}
}
