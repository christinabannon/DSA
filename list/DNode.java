package list;
/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/15/19
 * Submitted:  02/18/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.15
 */

public class DNode extends Node
{
	private DNode back; 
	
	public DNode (Object item)
	{
		super(item);
		//next = this; Shouldn't have assigned next!!!! it's made in the super's constructor!!!
		back = this;
	}
	
	public DNode(Object item, DNode next, DNode back)
	{
		super(item, next);
		this.back = back;
	}
	
	public DNode getBack()
	{
		return back;
	}
	
	public void setBack(DNode back)
	{
		this.back = back;
	}
	
	public DNode getNext() 
	{
		return (DNode)next;
	}
}
