package Lab2;

import Lab8.ListIndexOutOfBoundsException;

/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/02/19
 * Submitted:  01/29/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.02
 */

/*CB Source code from:
 * http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/tip/src/share/classes/java/util/ArrayList.java
 */

	// *********************************************************
	public interface ListInterface 
	{
	  boolean isEmpty();
	  /*   
	   *  public boolean isEmpty() 
	   *  	{
	   * 		 return size == 0;
	   *	}
	   */
	  
	  int size();
	  /*
	   *     public int size() 
	   *     {
       *  		return size;
       *     }
	   */
	  
	  void add(int index, Object item) 
	                  throws ListIndexOutOfBoundsException;
	  
	  /*	public void add(int index, E element) 
	   *	{
	   *     	rangeCheckForAdd(index);
	   *
	   *     	ensureCapacityInternal(size + 1);  // Increments modCount!!
	   *     	System.arraycopy(elementData, index, elementData, index + 1,
	   *                      size - index);
	   *     	elementData[index] = element;
	   *     	size++;
	   *	}
	   */
	  
	  Object get(int index) 
	                    throws ListIndexOutOfBoundsException;
	  /*
	   *	public E get(int index)
	   *	{
	   * 		rangeCheck(index);
	   *			return elementData(index);
	   *	}
	   */
	  
	  void remove(int index) 
	                     throws ListIndexOutOfBoundsException;
	  
	  /*
	   * 	 public void remove() 
	   *   {
	   *       if (lastRet < 0)
	   *         throw new IllegalStateException();
	   *     	 checkForComodification();
	   *
       * 	 	 try 
       * 	 		 {
       *		      ArrayList.this.remove(lastRet);
       * 		      cursor = lastRet;
       * 		      lastRet = -1;
       * 		      expectedModCount = modCount;
       *			}
       *		 catch (IndexOutOfBoundsException ex)
       *  	 		{
       *   		   	 throw new ConcurrentModificationException();
       *   			}
       * 	}
       */
	  
	  
	  void removeAll();
	  /*
	   *     public void clear() 
	   *   {
       * 		modCount++;
       *
       * 		// clear to let GC do its work
       * 		for (int i = 0; i < size; i++)
       *     	elementData[i] = null;
       *
       * 		size = 0;
       *	}
	   */
	  
	  
	}  // end ListInterface