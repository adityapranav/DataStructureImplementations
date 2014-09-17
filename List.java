// This is an interface to List Data Strcture.
// For Array Implementation of this List , Please check ArrayList.java
// For Linked Implementation of this List, Please check LinkedList.java

package com.ds.List;

public interface List<T> {

	boolean contains(T element);

	int size();

	boolean add(T element);

	boolean add(int index, T element);

	boolean remove(T element);

	boolean remove(int index);

	void sort();

	T get(int index);
}
