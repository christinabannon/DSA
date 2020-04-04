package Lab4;
import java.util.Scanner;

public class Bag 
{
	static String bag [];
	
	public static void main(String [] args)
	{
		String item  = "carrots";
		
		bag = new String [] {item};
		
		add(item);
		add("onions");
		add("muffins");
		add("corn");
		
		for (int i = 0; i < bag.length; i++)
		{
			System.out.println(bag[i]);
		}
		
		removeLast();
		
		System.out.println("\nremoveLast()");
		for (int i = 0; i < bag.length; i++)
		{
			System.out.println(bag[i]);
		}

	}

	public static void add(String item)
	{
		String biggerBag[] = new String [1 + bag.length];
		biggerBag [0] = item;
		for (int i = 1; i < biggerBag.length; i++)
		{
			biggerBag[i] = bag[i-1];
		}
	
		bag = biggerBag;
	}
	
	public static void removeLast()
	{
		String smallerBag[] = new String [bag.length -1];
		for (int i = 1; i < bag.length; i++)
		{
			smallerBag[i-1] = bag[i];
		}
		
		bag = smallerBag;
	}
}
