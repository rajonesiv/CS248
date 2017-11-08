import java.io.*;
import java.util.*;

public class SortTest
{
  
  public static long time1;
  public static long time2;
  
   // swaps A[x] with A[y]
  private static void swap(Comparable [] A,
    int x, int y)
  {
    Comparable tmp=A[x];
	A[x]=A[y];
	A[y]=tmp;
  }
  
  private static int findmax(Comparable []A, int last)
  {
    int max=0;
	  
	  for(int i=1; i<=last; i++)
	    if(A[i].compareTo(A[max])>0)
	      max=i;
    return max;
  }
  
  public static void selection(Comparable [] A)
  {
    for(int i=A.length-1; i>0; i--)
	   {
      int maxpos=findmax(A,i);
	    swap(A,maxpos,i);
	   }
  }
  
 
  public static void main(String[] args)
    throws IOException
  {
   
    System.out.println();
    System.out.print("Size of list?  :");
    
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    
    boolean isLong=false;
    if(n>100) 
      isLong=true;
    
    Comparable [] list = new Comparable[n];
    Comparable [] bubbleList = new Comparable[n];
    Comparable [] insList = new Comparable[n];
    Comparable [] selectList = new Comparable[n];
    Comparable [] shellList = new Comparable[n];
    Comparable [] mergeList = new Comparable[n];
    
	int temp;
	for( int i=0; i<n; i++ )
    {
		temp = (int)(1+n*Math.random());
     	bubbleList[i] = temp;
		insList[i] = temp;
		selectList[i] = temp;
		shellList[i] = temp;
		mergeList[i] = temp;
	}
    
    if (!isLong)
    {
      System.out.print("Original List:  ");
    
      for(int i=0; i<bubbleList.length; i++)
      System.out.print(bubbleList[i]+", ");
    
      System.out.println();
      System.out.println();
    }
    
    // Go through each sort function with the list copy, restoring 
    // it each time to the original list and keeping track of time
    bubble(bubbleList);
    select(selectList);
    insert(insList);
    shell(shellList);
    merge(mergeList);
  }
    
  /** @param bubbleList
      the input Comparable array */
  public static void bubble(Comparable[] bubbleList)
  {
    System.out.println();
    
    time1=System.currentTimeMillis();
    Sorts1.bubble(bubbleList);
    time2=System.currentTimeMillis();
    
    /*if(!isLong)
    for(int i=0; i<bubbleList.length; i++)
      System.out.print(bubbleList[i]+", ");*/
    
    System.out.println();
    System.out.println("Bubble Sort");
    System.out.println("  Time taken: "+(double)(time2-time1)+" milliseconds");
    System.out.println();
  }
  
  /** @param insList
      the input Comparable array */
  public static void insert(Comparable[] insList)
  {
    System.out.println();
    
    time1=System.currentTimeMillis();
    Sorts1.insertion(insList);
    time2=System.currentTimeMillis();
    
    /*if(!isLong)
    for(int i=0; i<insList.length; i++)
      System.out.print(insList[i]+", ");*/
    
    System.out.println();
    System.out.println("Insertion Sort");
    System.out.println("  Time taken: "+(double)(time2-time1)+" milliseconds");
    System.out.println();
  }
  
  /** @param selectList
      the input Comparable array */
  public static void select(Comparable[] selectList)
  {
    System.out.println();
    
    time1=System.currentTimeMillis();
    Sorts1.selection(selectList);
    time2=System.currentTimeMillis();
    
    /*if(!isLong)
    for(int i=0; i<selectList.length; i++)
      System.out.print(selectList[i]+", ");*/
    
    System.out.println();
    System.out.println("Selection Sort");
    System.out.println("  Time taken: "+(double)(time2-time1)+" milliseconds");
    System.out.println();
  }
  
  /** @param shellList
      the input Comparable array */
  public static void shell(Comparable[] shellList)
  {
    System.out.println();
    
    time1=System.currentTimeMillis();
    Sorts1.shell(shellList);
    time2=System.currentTimeMillis();
    
    /*if(!isLong)
    for(int i=0; i<shellList.length; i++)
      System.out.print(shellList[i]+", ");*/
    
    System.out.println();
    System.out.println("Shell Sort");
    System.out.println("  Time taken: "+(double)(time2-time1)+" milliseconds");
    System.out.println();
  }
  
  /** @param mergeList
      the input Comparable array */
  public static void merge(Comparable[] mergeList)
  {
    System.out.println();
    
    time1=System.currentTimeMillis();
    Sorts1.merge(mergeList);
    time2=System.currentTimeMillis();
    
    /*if(!isLong)
    for(int i=0; i<mergeList.length; i++)
      System.out.print(mergeList[i]+", ");*/
    
    System.out.println();
    System.out.println("Merge Sort");
    System.out.println("  Time taken: "+(double)(time2-time1)+" milliseconds");
    System.out.println();
  }
}
