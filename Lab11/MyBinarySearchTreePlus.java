package Lab11;

/*
 * Purpose: Data Structure and Algorithms Lab 11 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 04/22/19
 * Submitted:  04/22/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.04.22
 */

public class MyBinarySearchTreePlus <T extends KeyedItem<KT>,
KT extends Comparable <? super KT>> 
extends MyBinarySearchTree<T,KT> //implements BSTPInterface<T,KT>
{
	/**
	 * getHeight returns the height - 
	 * simple accessor for private
	 * getHeightRecursive
	 * @return
	 */
	public int getHeight()
	{
		return (-1 + getHeightRecursive(root, 0, 0));
	}
	
	/**
	 *getHeightRecursive
	 *recursively finds the height of the tree
	 * 
	 * @param node
	 * @param currentHeight
	 * @param largestHeight
	 * @return
	 */
	private int getHeightRecursive(TreeNode<T> node, 
			int currentHeight, int largestHeight)
	{
		
		if (node != null)
		{
			// if we see another level, we can add to the height!
			currentHeight++; 
			
			TreeNode <T> leftNode = node.getLeftChild();
			int leftHeight = 
					getHeightRecursive(leftNode, 
							  currentHeight, 
							  largestHeight);
			
			TreeNode <T> rightNode = node.getRightChild();
			int rightHeight = 
					getHeightRecursive(rightNode, 
							       currentHeight, 
							       largestHeight);
			
			largestHeight = (rightHeight > leftHeight) 
					? rightHeight : leftHeight;
			
		}
		else
		{
			largestHeight = (currentHeight > largestHeight)
					? currentHeight : largestHeight;
		}	
		return largestHeight;
	}
	
	/**
	 * getSize() helper for getSizeRecursive
	 * @return
	 */
	public int getSize()
	{
		getSizeRecursive (root);
		return size;
	}

	/**
	 * getSizeRecursive 
	 * 
	 * returns the number of nodes 
	 * in the tree(recursive 
	 * implementation)
	 * 
	 * @param tNode
	 * @param size
	 * @return
	 */
	static int size = 1;
	public void getSizeRecursive(TreeNode<T> tNode)
	{
		if (tNode.getLeftChild() != null)
		{
		    getSizeRecursive(tNode.getLeftChild());
			size++;
		}
		if (tNode.getRightChild() != null)
		{
			getSizeRecursive(tNode.getRightChild());
			size++;
		}
	}
	
	/**
	 * Accessor to the accessor for 
	 * in order recursive traversal of the tree
	 * @return
	 */
	public String toStringInorder()
	{
		return toStringLKRAccessor();
	}
	// returns String representation of 
	//Tree with items in Inorder
	//(recursive implementation)

	/**
	 * accessor to preorder String of tree Items
	 * @return
	 */
	public String toStringPreorder()
	{
		return toStringRecursiveKLR(root);
	}
	// returns String representation of Tree with items in Preorder
	//(recursive implementation)

	/**
	 * toStringRecursiveKLR recursively 
	 * builds a string of the items in the BST in 
	 * pre order
	 * @param node
	 * @return
	 */
	private String toStringRecursiveKLR(TreeNode<T> node)
	{
		StringBuilder resultString = new StringBuilder();
		
		if (node != null)
		{
			
			resultString.append(node.getItem().toString());
			resultString.append(" ");
			
			TreeNode<T> leftNode = node.getLeftChild();	
			resultString
				.append(toStringRecursiveKLR(leftNode));			
			
			TreeNode<T> rightNode = node.getRightChild();		
			resultString
				.append(toStringRecursiveKLR(rightNode));
		}
			return resultString.toString();
	}
	 	
	/**
	 * accessor to postorder String of tree Items
	 * @return
	 */
	public String toStringPostorder()
	{
		return toStringRecursiveLRK(root);
	}
	
	/**
	 * toStringRecursiveLRK recursively 
	 * builds a string of the items in the BST in 
	 * post order
	 * @param node
	 * @return
	 */
	private String toStringRecursiveLRK(TreeNode<T> node)
	{
		StringBuilder resultString = new StringBuilder();
		
		if (node != null)
		{	
			TreeNode<T> leftNode = node.getLeftChild();	
			resultString.append(toStringRecursiveKLR(leftNode));			
			
			TreeNode<T> rightNode = node.getRightChild();		
			resultString.append(toStringRecursiveKLR(rightNode));
			
			resultString.append(node.getItem().toString());
			resultString.append(" ");
		}
			return resultString.toString();
	}

	/**
	 * getCopyOfTree assigns a blank tree to the root 
	 * a copy of a tree!!
	 * @return
	 */
	public MyBinarySearchTreePlus<T,KT> getCopyOfTree()
	{
		MyBinarySearchTreePlus <T, KT> copyTree 
		= new MyBinarySearchTreePlus<>();
		return copyChildren (copyTree, root);
	}
	
	/**
	 * copyChildren builds a copy of a tree recursively 
	 * from another tree's root. 
	 * @param copyTree
	 * @param tNode
	 * @return
	 */
	public MyBinarySearchTreePlus <T,KT> 
			copyChildren( 
					MyBinarySearchTreePlus<T,KT> copyTree,
				   	TreeNode<T> tNode)
	{
		if (tNode != null)
		{
			copyTree.insert(tNode.getItem());
			
			copyChildren(copyTree, tNode.getLeftChild());
			copyChildren(copyTree, tNode.getRightChild());
		}
	
		return copyTree;
	}

	// returns a new tree containing a copy of the original tree 
	// with the same structure. Note: the new tree should not have
	// any shared nodes with the original.(recursive implementation
}
