package com.ds.TreeSet;
import com.ds.bst.*;
import com.ds.set.*;

public class TreeSet<T extends Comparable> implements Set<T>{
    private BinarySearchTree bs;

    public TreeSet()
    {
      	bs = new BinarySearchTree<T>();
    }
	@Override
	public boolean contains(T data) {
		// TODO Auto-generated method stub
		return bs.contains(data);
	}

	@Override
	public boolean add(T data) {
		// TODO Auto-generated method stub
		return bs.add(data);
	}
       
}
