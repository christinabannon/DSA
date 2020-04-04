package Lab11;
/*
 * Purpose: Data Structure and Algorithms Lab 11 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 04/22/19
 * Submitted:  04/22/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.04.22
 */

/**
 * <h1> MyBinarySearchTree </h1>
 * 
 * working methods: 
 *  - findLeftmost / findLeftmostAccessor
 *  - deleteLeftmost / deleteLeftmostAccessor
 *  - 
 * 
 * buggy methods: 
 *  - insert, incorrectly sorts negative 
 *    numbers, sorts them by absolute value
 *       ex) 
 *      -1, -2, -3, 1, 2, 3
 *  
 */
public class MyBinarySearchTree<T extends KeyedItem<KT>,
			 				   KT extends Comparable<? super KT>>
								  extends BinaryTreeBasis<T> 

{

	public MyBinarySearchTree() 
	{
		
	}  // end default constructor

	public MyBinarySearchTree(T rootItem) 
	{
		super(rootItem); //CB this class extends BinaryTreeBasis
	}  // end constructor

	public void setRootItem(T newItem)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}  // end setRootItem

	public void insert(T newItem) {
		root = insertItem(root, newItem);
	}  // end insert
	
	public T retrieve(KT searchKey) {

		TreeNode<T> traversingNode = root;

		TreeNode<T> resultNode = null; 
		
		while (traversingNode != null)
		{
			//less than - keep looping
			if (searchKey
					  .toString()
					  .compareTo(traversingNode
								.getItem()
						    	.toString()) < 0)
			{
				traversingNode = traversingNode.getLeftChild();
			}
			
			//greater than - keep looping
			else if(searchKey
						.toString()
						.compareTo(traversingNode
								.getItem()
								.toString()) > 0)
			{
				traversingNode = traversingNode.getRightChild();
			}
			
			else //match found - save the node & exit loop
			{
				resultNode = traversingNode;
				traversingNode = null;
			}
		}
		
		return resultNode.getItem();
		
	}  // end retrieve

	
	public void delete(KT searchKey) throws TreeException {
		root = deleteItem(root, searchKey);
	}  // end delete
	

	protected TreeNode<T> insertItem(TreeNode<T> tNode,
			T newItem) 
	{
		TreeNode<T> newSubtree;
		if (tNode == null) 
		{
			// position of insertion found; insert after leaf
			// create a new node
			tNode = new TreeNode<T>(newItem, null, null);
			return tNode;
		}  // end if
		T nodeItem = tNode.getItem();

		// search for the insertion position

		if (newItem.getKey().compareTo(nodeItem.getKey()) < 0) {
			// search the left subtree
			newSubtree = insertItem(tNode.getLeftChild(), newItem);
			tNode.setLeftChild(newSubtree);
			return tNode;
		}
		else { // search the right subtree
			newSubtree = insertItem(tNode.getRightChild(), newItem);
			tNode.setRightChild(newSubtree);
			return tNode;
		}  // end if
	}  // end insertItem


	protected TreeNode<T> deleteItem(TreeNode<T> tNode,
			KT searchKey) {
		// Calls: deleteNode.
		TreeNode<T> newSubtree;
		if (tNode == null) {
			throw new TreeException("TreeException: Item not found");
		}
		else {
			T nodeItem = tNode.getItem();
			if (searchKey.compareTo(nodeItem.getKey()) == 0) {
				// item is in the root of some subtree
				tNode = deleteNode(tNode);  // delete the item
			}
			// else search for the item
			else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
				// search the left subtree
				newSubtree = deleteItem(tNode.getLeftChild(), searchKey);
				tNode.setLeftChild(newSubtree);
			}
			else { // search the right subtree
				newSubtree = deleteItem(tNode.getRightChild(), searchKey);
				tNode.setRightChild(newSubtree);
			}  // end if
		}  // end if
		return tNode;
	}  // end deleteItem
	
	/**
	 * deleteNode finds the node given, 
	 * sorts through which case it is,
	 * and deletes the node in the 
	 * appropriate way
	 * 
	 * @param tNode
	 * @return
	 */
	protected TreeNode<T> deleteNode(TreeNode<T> tNode) {
		// Algorithm note: There are four cases to consider:
		//   1. The tNode is a leaf.
		//   2. The tNode has no left child.
		//   3. The tNode has no right child.
		//   4. The tNode has two children.
		// Calls: findLeftmost and deleteLeftmost
		T replacementItem;

		// test for a leaf
		if ( (tNode.getLeftChild() == null) &&
				(tNode.getRightChild() == null) ) {
			return null;
		}  // end if leaf

		// test for no left child
		else if (tNode.getLeftChild() == null) {
			return tNode.getRightChild();
		}  // end if no left child

		// test for no right child
		else if (tNode.getRightChild() == null) {
			return tNode.getLeftChild();
		}  // end if no right child

		// there are two children:
		// retrieve and delete the inorder successor
		else {
			replacementItem = findLeftmost(tNode.getRightChild());
			tNode.setItem(replacementItem);
			tNode.setRightChild(deleteLeftmost(tNode.getRightChild()));
			return tNode;
		}  // end if
	}  // end deleteNode

	/**
	 * "filter" method for findLeftMost to 
	 * more seamlessly interact w driver
	 * 
	 * @return i
	 */
	public T findLeftmostAccessor()
	{
		return findLeftmost(root);
	}
	
	
	/**
	 * findLeftMost locates the lowest item 
	 * in the BST & returns it
	 * 
	 * @param tNode
	 * @return
	 */
	private T findLeftmost(TreeNode <T> tNode)  
	{
		while(tNode.getLeftChild() != null)
		{
			tNode = tNode.getLeftChild();
		}
		
		return tNode.getItem();
		//implement iteratively
	}  // end findLeftmost

	/**
	 * "filter" method so that all that goes back 
	 * to the driver is the item in the node. 
	 * 
	 * @return
	 */
	public T deleteLeftmostAccessor()
	{
		TreeNode<T> tNode = deleteLeftmost(root);
		
		return tNode.getItem();
	}
	
	/**
	 * deleteLeftMost seeks out the left-most item in 
	 * the BST, and then deletes it!
	 * 
	 * @param tNode
	 * @return
	 */
	protected TreeNode<T> deleteLeftmost(TreeNode<T> tNode) 
	{
		TreeNode <T> returnNode;
		TreeNode <T> parentNode = null;
		
		// loops through until we have arrived
		// at the "leftest" of them all
		while(tNode.getLeftChild() != null)
		{
			parentNode = tNode;
			tNode = tNode.getLeftChild();
		}
		
       /*
	    *  CB checking to see what kind of case
		*  we have to work with
		*  - if the parentNode has been initialized, 
		*  we don't just have a right-veering list
		*/
		if (parentNode != null)
		{
			if (tNode.getRightChild() == null)
			{
				returnNode = tNode;
				tNode = null;
				parentNode.setLeftChild(null);
			}
			else 
			{
				returnNode = tNode;
				parentNode.setLeftChild(tNode
					          .getRightChild());
				tNode = null;
			}
		}
		else //if it is, infact, a list queue
		{
			//CB empty list Option
			if (tNode.getRightChild() == null)
			{
				returnNode = tNode;
				root = null;
			}
			//CB totally right-veering list option
			else 
			{
				returnNode = tNode;
				root = tNode.getRightChild();
			}
		}
		
		return returnNode;			
	}  // end deleteLeftmost
	

	/**
	 * Simple accessor for toString
	 * @return
	 */
	public String toStringLKRAccessor()
	{
		return toStringRecursiveLKR(root);
	}
	
	/**
	 * toStringRecursiveLKR returns a 
	 * String of items from the tree 
	 * in ascending order.. 
	 * This method was more or less
	 * made for debugging, 
	 * 
	 * @param node
	 * @return String
	 */
	private String toStringRecursiveLKR(TreeNode<T> node)
	{
		StringBuilder resultString = new StringBuilder();
		
		if (node != null)
		{
			TreeNode<T> leftNode = node.getLeftChild();
			
			
			resultString.append(toStringRecursiveLKR(leftNode));
			
			resultString.append(node.getItem().toString());
			resultString.append(" ");
			
			TreeNode<T> rightNode = node.getRightChild();
			
			resultString.append(toStringRecursiveLKR(rightNode));
		}
			return resultString.toString();
	}
}  // end MyBinarySearchTree
