// This is a subclass of LinkedList which has some of the most important Algorithms implemented.
public LinkListAlgos<T> extends LinkedList<T>
{

  public boolean isSizeOdd( )
  {

    ListNode<T> current = header;
    
    byte flag = 0;
    
    while( current )
    {
      flag = ~flag;
      
      current= current.next;
    }

    if( flag == 0)
       return true;
       
    return false;
    
  }


}
