package Lab12;

/*
 * Purpose: Data Structure and Algorithms Lab 12 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 04/24/19
 * Submitted:  04/24/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.04.24
 */

//********************************************************
//Hash table implementation.
//Assumption: A table contains unique items(at most one 
//          item with a given search key at any time)
//*********************************************************

public class HashTable<K, V>
implements HashTableInterface<K,V> {
	
	private ChainNode<K,V>[] table;     
	private int size = 3;        

	public HashTable() {
		table = new ChainNode[3];
	}  // end default constructor

	//table operations
	public boolean tableIsEmpty() {
		return size==0;
	}  // end tableIsEmpty

	public int tableLength() {
		return size;
	}  // end tableLength

	/**
	 * tableInsert
	 * inserts  association (key,value) only if key
	 * is not already in HashTable and returns true; 
	 * returns false if the key already has an associated 
	 * value in HashTable and does not insert
	 * @param key
	 * @param value
	 * @return boolean - determinant of a successful insert
	 */
	public boolean tableInsert(K key, V value) 
	{
		int hashIndex = hashIndexCreator(key);

		boolean original = isOriginal(value);

		if (original)
		{
			if (table[hashIndex] != null)
			{
				ChainNode <K, V> traversingNode 
				= table[hashIndex];

				while (traversingNode.getNext() != null)
				{
					traversingNode
					= traversingNode.getNext();
				}

				traversingNode
				.setNext(new ChainNode<K,V> 
				(key, value, null ));
			}
			else
			{
				table[hashIndex] =
						new ChainNode<K,V> 
						(key, value, null);
			}
		}

		return original;
	}

	/**
	 * isOriginal tracks whether or not the value 
	 * is originial to the list (true)
	 * or a duplicate (false)
	 * @param value
	 * @return
	 */
	private boolean isOriginal(V value)
	{
		boolean original = true;
		for (int i = 0; i < table.length; i++)
		{
			ChainNode<K,V> traversingNode 
			= (ChainNode<K, V>)table[i];

			while (traversingNode != null & original)
			{
				if (value
						.equals(traversingNode
								.getValue()))
				{
					original = false;
					i = table.length;
				}
				else
				{
					traversingNode 
					= traversingNode.getNext();
				}
			}
		}

		return original; 
	}

	/**
	 * tableDelete finds the key to delete
	 * if the key is not in the array
	 * it returns false. 
	 * Otherwise it deletes the key 
	 * and returns true.
	 * 
	 * @param searchKey
	 * @return
	 */
	public boolean tableDelete(K searchKey) 
	//deletes the key and its association from 
	//the HashTable if it is in the table and returns true;
	//returns false if key is not in the HashTable
	{ 
		boolean deleted = false;

		int hashIndex = hashIndexCreator(searchKey);

		if (table[hashIndex] != null)
		{
			deleted = deleteChecker(searchKey, hashIndex);
		}
		return deleted; 
	}

	/**
	 * deleteChecker does the "heavy lifting" 
	 * for tableDelete.
	 *  deleted key and returns true 
	 *  if they key is present
	 * @param searchKey
	 * @param hashIndex
	 * @return
	 */
	private boolean deleteChecker(K searchKey, 
			int hashIndex)
	{
		boolean deleted = false;
		
		ChainNode<K,V> traversingNode 
		= (ChainNode<K, V>)table[hashIndex];

		//checking the first
		if (searchKey
				.equals(traversingNode
						.getKey()))
		{
			//if it's singleton
			if (traversingNode.getNext() != null)
			{
				table[hashIndex] = null;
				deleted = true;
			}
			//if it's not
			else
			{
				table[hashIndex] = 
						traversingNode.getNext();
				deleted = true;
			}
		}
		else
		{			//cb looping through the rest!
			deleted = 
				traversalForDeletion(traversingNode,
					searchKey, deleted);
		}
		
		return deleted;
	}
	
	/**
	 * traversalForDeletion traverses the link
	 * until it finds the key!
	 * then deletes it, and returns true. 
	 * If it does not find the key, it returns false. 
	 * 
	 * @param traversingNode
	 * @param searchKey
	 * @param deleted
	 * @return
	 */
	private boolean 
	traversalForDeletion(ChainNode<K,V> traversingNode, 
			K searchKey, boolean deleted)
	{
		
		while (traversingNode.getNext()
				!= null && !deleted)
		{
			if (searchKey
					.equals(traversingNode
							.getNext().getKey()))
			{
				traversingNode
				.setNext(traversingNode
						.getNext()
						.getNext());
				deleted = true;		
			}
			else
			{
				traversingNode = traversingNode.getNext();
			}

		}
		
		return deleted;
	}
	
	/**
	 * tableRerieve returns the value associated 
	 * with a serachKey in Hashtable of null if
	 * there is no association
	 * @param searchKey
	 * @return
	 */
	public V tableRetrieve(K searchKey) 
	{
		V value = null;

		int hashIndex = hashIndexCreator(searchKey);

		ChainNode <K,V> traversingNode = table[hashIndex];

		while ( ( value == null ) && 
				(traversingNode != null) )
		{
			if (searchKey.equals(traversingNode.getKey()))
			{
				value = traversingNode.getValue();
			}
			else
			{
				traversingNode = traversingNode.getNext();
			}
		}	
		return value;	
	}

	/**
	 * hashIndexCreater retrieves the hashIndex for a 
	 * Key with the help of: 
	 *  - hashIndexCreator
	 * then it checks to see if it's a valid 
	 * index, returns a negative if it is not, 
	 * and a positive if it is. 
	 *  
	 * @param key
	 * @return integer - the index!
	 */
	public int hashIndex(K key) 
	{
		int hashIndex = hashIndexCreator(key);
		boolean existence = false;
		
		ChainNode <K,V> traversingNode 
					= table[hashIndex];
		while (traversingNode != null && !existence)
		{
			if (key.equals(traversingNode.getKey()))
			{
				existence = true;
			}
			else
			{
				traversingNode 
				= traversingNode.getNext();
			}
		}
		
		if (!existence)
		{
			hashIndex *= -1;
		}
		return hashIndex;
	}
	
	/**
	 * hashIndex computes the hashIndex for a 
	 * Key with the help of: 
	 *  - stringToUni
	 *  - hornersRule
	 *  
	 * @param key
	 * @return integer - the index!
	 */
	private int hashIndexCreator(K key)
	{
		int uniArray [] = stringToUni(key);
		double bigOldHornerSum = hornersRule(uniArray);
		return (int)(bigOldHornerSum % size);
	}

	/**
	 * stringToUni translates a string to an 
	 * int array of uniCode values
	 * 
	 * @param input
	 * @return an  int [] of unicode values
	 */
	private int[] stringToUni(K input) 
	{	
		int [] uniArray = 
				new int[input.toString().length()];

		for (int i = 0; i < uniArray.length; i++)
		{
			uniArray[i] = (int)input.toString().charAt(i);

			// putting letters in domain [1,26]
			uniArray[i] =
					(uniArray[i] % ((int)'A' - 1) );
		}
		return uniArray;
	}

	/**
	 * hornersRule bit shifts elements 
	 * in the uniCode array, and 
	 * accumulates them into one big
	 * return value
	 * 
	 * @return the sum of the value!
	 */
	private double hornersRule( int [] uniArray)
	{
		double accumulator = 0;
		int value;

		for (int i = 0; i < uniArray.length; i++)
		{
			value = uniArray[i] * (1 << 5 * 
					(uniArray.length - (i + 1)));

			accumulator += value;
		}
		return accumulator;
	}

	/**
	 * toString checks the array items, 
	 * and adds them to the string
	 * 
	 * @return String representation of linked tree!
	 */
	@Override
	public String toString()
	{
		StringBuilder string = new StringBuilder();

		for (int i = 0; i < size; i++)
		{
			if (table[i] != null)
			{
				String key = table[i].getKey().toString();

				String value = 
						table[i].getValue().toString();
				string.append("Index " + i + ": ");
				string.append("\n\tKey: " + key);
				string.append(", ");
				string.append("Value: " + value);

				ChainNode <K,V> traversingNode 
						= table[i];
				while (traversingNode.getNext() != null)
				{
					traversingNode = 
							traversingNode.getNext();

					key = traversingNode.getKey()
							.toString();

					value = 
						traversingNode.getValue()
						.toString();

					string.append("\n\tKey: " + key);
					string.append(", ");
					string.append("Value: " + value);
				}
			}
			else
			{
				string.append("Index " 
						+ i + " is empty! ");
			}
			string.append("\n");
		}

		return string.toString();
	}
}  // end HashTable

