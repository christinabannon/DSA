package Lab11;

/*
 * Item translated into KeyedItem
 */

public class Item <KT extends Comparable<? super KT>>extends KeyedItem <KT>
{
	public Item(KT key)
	{
		super(key);
	}
	
	@Override
	public String toString()
	{
		return getKey().toString();
	}
}
