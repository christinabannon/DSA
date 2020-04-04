package Lab5;



/* Purpose: Data Structure and Algorithms Lab 5 Problem 3
 * Status: Complete and thoroughly tested
 * Last update: 02/23/19
 * Submitted:  02/25/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.23
 */

public class GenericDNode<T> extends Node
{
	private GenericDNode<T> back; 
	
	public GenericDNode ( T item)
	{
		super(item);
		next = this;
		back = this;
	}
	
	public GenericDNode(T item, GenericDNode next, GenericDNode back)
	{
		super(item, next);
		this.back = back;
	}
	
	public GenericDNode getBack()
	{
		return back;
	}
	
	public void setBack(GenericDNode back)
	{
		this.back = back;
	}
	
	public GenericDNode getNext() 
	{
		return (GenericDNode)next;
	}
}
