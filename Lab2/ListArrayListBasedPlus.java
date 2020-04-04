/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/02/19
 * Submitted:  02/04/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.02
 */

package Lab2;
import java.util.ArrayList;


public class ListArrayListBasedPlus extends ListArrayListBased implements ListInterface
{
	ListArrayListBasedPlus()
	{
		super();
	}
	
	@Override
	public void add(int index, Object item)
	{
		resize(index);
		super.add(index, item);
	}
	
	private void resize(int index)
	{
		if (index > items.size())
		{
			items.ensureCapacity(index + 1);
		}
	}
	
	public void reverse()
	{
		ArrayList <Object> reverseArray = new ArrayList<>();
		
		for (int i = 1; i <= items.size(); i++)
		{
			reverseArray.add(items.get((items.size()-i)));
			System.out.println(reverseArray.get(i-1));	
		}
		
		super.items = reverseArray;
	}
	
	@Override
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < items.size(); i++)
		{
			string.append(items.get(i) + " ");
		}
		
		return string.toString();
	}
	
}

