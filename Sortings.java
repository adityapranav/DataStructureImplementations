package com.ds.sort;

public abstract class Sortings
{
  public static void insertionSort(int[] a)
  {
      for(int j=1; j<a.length;  ++j )
      {
        int key = a[j];
        int i= j-1;
        while( i >=0 && a[i] > key )
        {
          a[i+1] = a[i];
          --i;
        }
        a[i+1] = key;
      }
  }
  
  public abstract void mergeSort(int[] a);
  
  public static void selectionSort(int[] a)
  {
    for(int i=0; i < a.length; ++i)
    {
      int pos = i;
      for(int j=i+1; j < a.length-1; ++j)
      {
        if(a[j] < a[pos])
        {
          pos = j;
        }
      }
      int temp=a[i];
      a[i] = a[pos];
      a[pos] = temp;
      
    }
  }
 
