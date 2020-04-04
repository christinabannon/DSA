package Lab7;

public class Fibonacci 
{
	public static int rFib(int n)
	{
		int result = 0;
		if (n == 1 | n == 0)
		{
			result = n;
		}
		else
		{
			result = rFib(n-1) + rFib(n-2);
		}
		return result;
	}
	
	public static int itFib(int n)
	{
		int result = 0;
		int fib0 = 0;
		int fib1 = 1;
		
		for (int i = 2; i <= 6; i++)
		{
			result = fib1 + fib0;
			fib0 = fib1;
			fib1 = result;
		}
		return result;
	}
}
