package com.ds.HashSet;

import com.ds.set.*;
import com.ds.list.*;

public class HashSet<T extends Comparable> implements Set<T> {

	private static final int INIT_SIZE = 2;
	private static final int THRESHOLD = 4;
	private ListNode<T>[] buckets;
	private int size;
	public HashSet()
	{
		buckets = new ListNode[INIT_SIZE];
		for(int i=0;i<INIT_SIZE;i++)
	    {
	    	buckets[i] = new ListNode<T>();
	    }
	}
	
	@Override
	public boolean contains(T data) {
		// TODO Auto-generated method stub
		int index = data.hashCode()% buckets.length;
		
		return findElementinOrderedList(buckets[index], data);
	}
	private boolean findElementinOrderedList(ListNode<T> header,T data)
	{
		ListNode<T> current=header.next;
		while ( current != null )
		{
		    if(data.equals(current.data))
		    	return true;
		    current = current.next;
		}
		return false;
	}

	@Override
	public boolean add(T data) {
		// TODO Auto-generated method stub
		if ( size/buckets.length  >= THRESHOLD)
		{
			return reHash(data);
		}
		int index = data.hashCode() % buckets.length;
	    ListNode<T> tmp= new ListNode(data);
		boolean ret= addElementInOrderedList(buckets[index],tmp);
		if( ret )
			++size;
		return ret;
	}
	private boolean addElementInOrderedList(ListNode<T> node,ListNode<T> newNode)
	{
		ListNode<T> current = node.next;
		ListNode<T> parent  = node;
        boolean isPresent = false;
		while( current != null )
        {
        	if(newNode.data.equals(current.data))
        	{
        		isPresent = true;
        		return false;
        	}
        	else if((newNode.data.compareTo(current.data))< 0)
        	{
        		newNode.next = parent.next;
        	    parent.next = newNode;
        		isPresent = true;
        	    return true;
        	}
        	else
        	{
        		parent = current;
        	}
        	current = current.next;
        }
		if(! isPresent )
		{   
			parent.next = newNode;
			isPresent = true;
		}
	
		return isPresent;
	}
	private boolean reHash(T data)
	{
		ListNode<T>[] newBuckets = new ListNode[2 * buckets.length];
		
		for(int i=0;i<(2 * buckets.length);i++)
		{
			newBuckets[i] = new ListNode();
		}
		ListNode<T> temp;
	   for(int i=0;i< buckets.length;i++)
	   {
	      for(ListNode<T> current=buckets[i].next;current != null;current = temp)
	      {
	    	  temp= current.next;
	          int index = current.data.hashCode() % newBuckets.length;
	          addElementInOrderedList(newBuckets[index],current);
	      }
		  
	   }
	   buckets = newBuckets;	
	   return true;
	}
	public boolean remove(T data) {
		
		int index = data.hashCode() % buckets.length;
		
		boolean ret = removeFromOrderedList(buckets[index],data);
	
		if(ret) --size;
		return ret;
	}

	private boolean removeFromOrderedList(ListNode<T> listNode, T data) {
		
		ListNode<T> current = listNode.next;
		ListNode<T>  parent = listNode;
		boolean isFound = false;
		while( current != null )
		{
			if( data.equals(current.data) )
			{
				isFound = true;
				break;
			   
			}
			parent = current;
			current = current.next;
		}
		
		parent.next = current.next;
		// TODO Auto-generated method stub
		return isFound;
	}

}
