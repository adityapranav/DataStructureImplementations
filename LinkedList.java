package com.ds.dsutils;
import com.ds.List.*;

class ListNode<T>
{
	T data;
	ListNode<T> next;
	
}

public class LinkedList<T> implements List<T>{

	private ListNode<T> header;
	private ListNode<T> tail;
	private int         size;
	
	public LinkedList()
	{
		this.header = new ListNode<T>();
		this.size=0;
		this.tail = this.header;
	}
	@Override
	public boolean contains(T element) {
	
		ListNode<T> current = header.next;
		
		while ( current != null )
		{
			if( element.equals(current.data) )
			{
				return true;
			}		
			current = current.next;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean add(T element) {
		// This by default adds at the end
		ListNode<T> newNode = new ListNode<T>();
	
		   newNode.data = element;
		   tail.next = newNode;
		   newNode.next = null;
		   tail = newNode;
		
		   size++;
	
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean add(int index, T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(T element) {
		
		// TODO Auto-generated method stub
		ListNode<T> current = header.next;
		ListNode<T> previous = header;
		
		if( current == null )
		{
			return false;
		}
		while ( current != null )
		{
		    if( element.equals(current.data) )
			{
			   previous.next = current.next;
			   size--;
			   if( tail == current )
				   tail = previous;
			   return true;
			}
		    previous = current;
		    current = current.next;
		}
		
		return false;
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
