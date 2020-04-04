package work;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;


class HelloClass 
{
	
	
	public static void main(String []args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of classmates");
		String number = in.readLine();
		int n = Integer.parseInt(number);
		
		while (n < 1)
		{
			System.out.println("Please enter a valid number of classmates: ");
			number = in.readLine();
			n = Integer.parseInt(number);
		}
		
	/*	StringBuilder hello = new StringBuilder("shouts hello class!")
		
		for (int index = 0; index < n; index++)
		{
			System.out.println("Please enter name #" + (index + 1)+ ":");
			String name = in.readLine();
			
			if ( n == 1)
			{
				System.out.println(name + hello);
			}
			else if (n == 2)
			{
				hello.deleteCharAt(5);
				
			}
				
		}
		*/
		
	}

	
}
