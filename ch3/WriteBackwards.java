package ch3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteBackwards 
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter a String of characters, receive it backwards!");
		String s = reader.readLine().trim();
		
		writeBackwards(s, s.length());
		
		writeBackwards2(s, s.length());
	}
	
	
	public static void writeBackwards(String s, int size)
	{
		/*
		 * Writes a character string backwards
		 * Pre: String s contains size characters, 
		 * where size >= 0
		 * Post: s is written backwards, bu remains unchanged. 
		 */
		if (size > 0)
		{
			//write the last character
			System.out.print(s.substring(size-1, size));
			
			//write the rest of the string backwards
			writeBackwards(s, size-1);
		}
	}
	
	public static void writeBackwards2(String s, int size)
	{
		/*
		 * Writes a character string backwards
		 * Pre- String s contains size characters, where size >= 0
		 * Post - s is writted backwards, but remains unchanged
		 */
		if (size > 0)
		{
			writeBackwards2(s,size -1);
			
			//CB size keeps getting smaller, so the index keeps getting larger
			System.out.print(s.charAt(s.length() - size));
		}
	}
}
