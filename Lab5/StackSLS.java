package Lab5;

/* Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/19/19
 * Submitted:  02/25/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.19
 */

public class StackSLS <T> implements StackInterface<T>
{
	Node<T> head = null;

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	@Override
	public void popAll() 
	{
		head = null;	
	}

	@Override
	public void push(T newItem) throws StackException {
		if ( head == null)
		{
			head = new Node<T> (newItem);
		}
		else
		{
			head = new Node<T> (newItem, head);
		}
	}

	@Override
	public T pop() throws StackException {
		T result = null;
		if (head == null)
			throw new StackException("Empty!!");
		else
			result = head.getItem();
			head = head.getNext();
		return result;
	}

	@Override
	public T peek() throws StackException {
		T result;
		if (head == null)
			throw new StackException("Empty!!");
		else
			result = (T)head.getItem();
		return result;
	}
	
	@Override
	public String toString()
	{
		StringBuilder string = new StringBuilder();

		Node<T> curr = head;

		while (curr != null)
		{
			string.append(curr.getItem().toString() + " ");
			curr = curr.getNext();
		}
		return string.toString();
	}

}
