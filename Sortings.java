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
        }
        a[i+1] = key;
      }
  }
  
  public static void mergeSort(int[] a);
  
}
