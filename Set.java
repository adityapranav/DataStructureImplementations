package com.ds.set;

public interface Set<T extends Comparable> {
	
	public boolean contains(T data);
    public boolean add(T data);
}
