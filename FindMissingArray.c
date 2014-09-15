// Given an Array of size n which contains numbers from 0 to n ( no duplicates ). Find the missing number 

int findMissingElement(int a[],int size)
{
  int i;
  int temp = 0;
  for( i=1; i<=size ; i++ )
  {
    temp = temp^i^a[i];   
  }
  return temp;
  /* or we can do this also 
  int i;
  int temp = 0;
  for( i=0; i<size ; i++ )
  {
    temp = temp^i^a[i];   
  }
  return temp^i;
  */
}
