package com.ds.bst;

import java.io.Serializable;

public class BinarySearchTree<T extends Comparable> implements Serializable {

	private BSTNode<T> root;

	public BinarySearchTree() {
		root = null;
	}

	public boolean add(T data) {
		BSTNode<T> current = root;
		BSTNode<T> parent = null;
		BSTNode<T> tmp = null;
		int ret = 0;
		while (current != null) {
			parent = current;
			ret = data.compareTo(current.data);

			if (ret == 0)
				return false; // cannot insert duplicates into a BST ( This BST
								// is for set )
			if (ret < 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		tmp = new BSTNode(data);
		if (ret > 0) {
			parent.right = tmp;
		} else if (ret < 0) {
			parent.left = tmp;
		} else {
			root = tmp;
		}

		return true;
	}

	public boolean remove(T data) {
		//case 1: remove leaf nodes
		//case 2: remove node with one child
		//case 3: remove node with both children
		Boolean isFound = new Boolean(false);
		root = auxRemove(root,data,isFound);
		
		return isFound;
	}
	private BSTNode<T> auxRemove(BSTNode<T> current,T data,Boolean isFound)
	{
	   if( current == null )
		   return null;
	    int ret = data.compareTo(current.data);
		if( ret < 0 )
		{
		   current.left=auxRemove(current.left,data,isFound);
		}
		else if(ret > 0)
		{
			current.right=auxRemove(current.right,data,isFound);
		}
		else
		{
			isFound = true;
		  if( current.right !=null && current.left!=null)    	
		  {
			  T value = findSmallestInRightSubTree(current.right);
		      current.data = value;
		      current.right = auxRemove(current.right, value, isFound);
		  }
		  else
		  {
			  return (current.left !=null)?current.left:current.right;
		  }
		}
		
	  return current;
	}
    private T findSmallestInRightSubTree(BSTNode<T> current)
    {
    	while( current.left != null)
    		current = current.left;
        return current.data;
    }
	public boolean contains(T data) {

		BSTNode<T> current = root;

		while (current != null) {
			int ret = data.compareTo(current.data);

			if (ret > 0)
				current = current.right;
			else if (ret < 0)
				current = current.left;
			else
				return true;
		}

		return false;
	}

	public void display() {
		auxDisplay(root);
	}

	private void auxDisplay(BSTNode<T> current) {
		if (current == null)
			return;
		auxDisplay(current.left);
		System.out.print(current.data+"   ");
		auxDisplay(current.right);
	}
}
