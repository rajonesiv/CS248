/** @author Andrew Jones
This is the main program for Sorting out Sorts
This program is designed to compare the running times of several sorting algorithms*/

import java.io.*;
import java.util.*;

public class SortsMain
{
	/* these are both time variables, one before the sort and one after.
	they are used to find the difference in times */
	public static long timeBefore;
	public static long timeAfter;
 
	public static void main(String[] args)
	  throws IOException
	{
		System.out.println();
		System.out.println("welcome to Butler University Software Technology Incoporated (BUSTInc)!");
		System.out.println("Please enter a number for the size of the list you would like to sort: ");
		System.out.print("n= ");
	
       	Scanner in = new Scanner(System.in);
		int n = in.nextInt();
			
		//boolean used to print list if n is less than 100
		boolean isLong=false;
		if(n>100)
			isLong=true;
		
		//The comparable sorting algorithms
		Comparable [] list = new Comparable[n];
		Comparable [] bubbleList = new Comparable[n];
		Comparable [] insertList = new Comparable[n];
		Comparable [] selectList = new Comparable[n];
		Comparable [] quickList = new Comparable[n];
		Comparable [] mergeList = new Comparable[n];
	
		int temp;
		for( int i=0; i<n; i++ )
		{
			temp = (int)(1+n*Math.random());
			bubbleList[i] = temp;
			insertList[i] = temp;
			selectList[i] = temp;
			quickList[i] = temp;
			mergeList[i] = temp;
		}
		
		//is n is less than 100, print the arrays
		if (!isLong)
		{
			System.out.print("Original List:  ");
    		for(int i=0; i<bubbleList.length; i++)
				System.out.print(bubbleList[i]+", ");
    			System.out.println();
				System.out.println();
		}
	
		/* Each sort function will restore the copied list 
		to the original one and keep track of the time it takes */
		bubble(bubbleList);
		select(selectList);
		insert(insertList);
		quick(quickList);
		merge(mergeList);	
	}
    
	/** @param bubbleList the Bubble sorting algorithm using Comparable array */
	public static void bubble(Comparable[] bubbleList)
	{
		System.out.println();
    
		timeBefore=System.currentTimeMillis();
		Sorts1.bubble(bubbleList);
		timeAfter=System.currentTimeMillis();
    
		System.out.println();
		System.out.println("Bubble Sort");
		System.out.println("  Time taken: "+(double)(timeAfter-timeBefore)+" milliseconds");
		System.out.println();
		if(bubbleList.length<=100)
		{
			for(int i=0; i<bubbleList.length; i++)
				System.out.print(bubbleList[i]+", ");
				System.out.println();
		}
	}
  
	/** @param insertList the Insertion sorting algorithm using Comparable array */
	public static void insert(Comparable[] insertList)
	{
		System.out.println();
    
		timeBefore=System.currentTimeMillis();
		Sorts1.insertion(insertList);
		timeAfter=System.currentTimeMillis();
    
		System.out.println();
		System.out.println("Insertion Sort");
		System.out.println("  Time taken: "+(double)(timeAfter-timeBefore)+" milliseconds");
		System.out.println();
		if(insertList.length<=100)
		{
			for(int i=0; i<insertList.length; i++)
				System.out.print(insertList[i]+", ");
				System.out.println();
		}
	}
  
	/** @param selectList the Selection sorting algorithm using Comparable array */
	public static void select(Comparable[] selectList)
	{
		System.out.println();
    
		timeBefore=System.currentTimeMillis();
		Sorts1.selection(selectList);
		timeAfter=System.currentTimeMillis();
    
		System.out.println();
		System.out.println("Selection Sort");
		System.out.println("  Time taken: "+(double)(timeAfter-timeBefore)+" milliseconds");
		System.out.println();
		if(selectList.length<=100)
		{
			for(int i=0; i<selectList.length; i++)
				System.out.print(selectList[i]+", ");
				System.out.println();
		}
	}
  
	/** @param quickList the Quicksort algorithm using Comparable array */
	public static void quick(Comparable[] quickList)
	{
		System.out.println();
    
		timeBefore=System.currentTimeMillis();
		Sorts1.quick(quickList);
		timeAfter=System.currentTimeMillis();
    
		System.out.println();
		System.out.println("Quick Sort");
		System.out.println("  Time taken: "+(double)(timeAfter-timeBefore)+" milliseconds");
		System.out.println();
		if(quickList.length<=100)
		{
			for(int i=0; i<quickList.length; i++)
				System.out.print(quickList[i]+", ");
				System.out.println();
		}
	}
  
	/** @param mergeList the Merge algorithm using Comparable array */
	public static void merge(Comparable[] mergeList)
	{
		System.out.println();
    
		timeBefore=System.currentTimeMillis();
		Sorts1.merge(mergeList);
		timeAfter=System.currentTimeMillis();
    
		System.out.println();
		System.out.println("Merge Sort");
		System.out.println("  Time taken: "+(double)(timeAfter-timeBefore)+" milliseconds");
		System.out.println();
		if(mergeList.length<=100)
		{
			for(int i=0; i<mergeList.length; i++)
				System.out.print(mergeList[i]+", ");
				System.out.println();
		}
	}
}
