package midterm;

public class DNode<T> extends Node<T>
{
	private DNode<T> back; 
	
	public DNode (T item)
	{
		super(item);
		//next = this; Shouldn't have assigned next!!!! it's made in the super's constructor!!!
		back = this;
	}
	
	public DNode(T item, DNode next, DNode back)
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