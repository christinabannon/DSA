package midterm;

public class LABP<T> extends LAB<T>
implements ListInterface<T> 
{	
	public LABP()
	{
		super();
	}  // end default constructor

	@Override
	public void add(int index, T item)
	{
		if (numItems == super.items.length)
		{
			resize();
		}
		super.add(index, item);
	}

	private void resize()
	{
		T[] largerArray = (T[])new Object [numItems*2];

		for (int i = 0; i < numItems; i++)
		{
			largerArray[i] = super.items[i];
		}	
		super.items = largerArray;	
	}

	public void reverse()
	{
		T[] reverseArray = (T[])new Object[numItems];

		for (int i = 0; i < numItems; i++)
		{
			reverseArray[i] = items[numItems - (i+1)];
		}
		super.items = reverseArray;
	}

	@Override
	public String toString()
	{
		StringBuilder string = 
				new StringBuilder("List of size " 
						+ numItems +" has the following items: ");
		for (int i = 0; i < items.length; i++)
		{
			if (items[i] != null)
			{
				string.append(items[i] + " ");
			}
		}
		return string.toString();
	}
}
