/** @author Andrew Jones
This is the main program for Sorting out Sorts
This program is designed to compare the running times of several sorting algorithms*/

import java.io.*;
import java.util.*;

public class SortsMainWorking
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
		if (bubbleList.length<100)
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
		Sorts.bubble(bubbleList);
		timeAfter=System.currentTimeMillis();
    
		System.out.println();
		System.out.println("Bubble Sort");
		System.out.println("  Time taken: "+(double)(timeAfter-timeBefore)+" milliseconds");
		System.out.println();
		if(bubbleList.length<100)
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
		Sorts.insertion(insertList);
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
		Sorts.selection(selectList);
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
		Sorts.quick(quickList);
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
		Sorts.merge(mergeList);
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

/* sample run

thomas% java SortsMainWorking

welcome to Butler University Software Technology Incoporated (BUSTInc)!
Please enter a number for the size of the list you would like to sort:
n= 12
Original List:  10, 11, 6, 6, 4, 3, 9, 6, 5, 8, 8, 6,



Bubble Sort
  Time taken: 1.0 milliseconds

3, 4, 5, 6, 6, 6, 6, 8, 8, 9, 10, 11,


Selection Sort
  Time taken: 0.0 milliseconds

3, 4, 5, 6, 6, 6, 6, 8, 8, 9, 10, 11,


Insertion Sort
  Time taken: 1.0 milliseconds

3, 4, 5, 6, 6, 6, 6, 8, 8, 9, 10, 11,


Quick Sort
  Time taken: 0.0 milliseconds

3, 4, 5, 6, 6, 6, 6, 8, 8, 9, 10, 11,


Merge Sort
  Time taken: 0.0 milliseconds

3, 4, 5, 6, 6, 6, 6, 8, 8, 9, 10, 11,
thomas% java SortsMainWorking

welcome to Butler University Software Technology Incoporated (BUSTInc)!
Please enter a number for the size of the list you would like to sort:
n= 10245


Bubble Sort
  Time taken: 1309.0 milliseconds



Selection Sort
  Time taken: 203.0 milliseconds



Insertion Sort
  Time taken: 152.0 milliseconds



Quick Sort
  Time taken: 7.0 milliseconds



Merge Sort
  Time taken: 16.0 milliseconds

thomas% */

/* running the times (which I created a graph for)
thomas% java SortsMainWorking

welcome to Butler University Software Technology Incoporated (BUSTInc)!
Please enter a number for the size of the list you would like to sort:
n= 10000


Bubble Sort
  Time taken: 1332.0 milliseconds



Selection Sort
  Time taken: 213.0 milliseconds



Insertion Sort
  Time taken: 150.0 milliseconds



Quick Sort
  Time taken: 7.0 milliseconds



Merge Sort
  Time taken: 18.0 milliseconds

thomas% java SortsMainWorking

welcome to Butler University Software Technology Incoporated (BUSTInc)!
Please enter a number for the size of the list you would like to sort:
n= 20000


Bubble Sort
  Time taken: 5362.0 milliseconds



Selection Sort
  Time taken: 856.0 milliseconds



Insertion Sort
  Time taken: 575.0 milliseconds



Quick Sort
  Time taken: 23.0 milliseconds



Merge Sort
  Time taken: 21.0 milliseconds

thomas% java SortsMainWorking

welcome to Butler University Software Technology Incoporated (BUSTInc)!
Please enter a number for the size of the list you would like to sort:
n= 30000


Bubble Sort
  Time taken: 12266.0 milliseconds



Selection Sort
  Time taken: 1929.0 milliseconds



Insertion Sort
  Time taken: 1277.0 milliseconds



Quick Sort
  Time taken: 26.0 milliseconds



Merge Sort
  Time taken: 24.0 milliseconds

thomas% java SortsMainWorking

welcome to Butler University Software Technology Incoporated (BUSTInc)!
Please enter a number for the size of the list you would like to sort:
n= 40000


Bubble Sort
  Time taken: 21861.0 milliseconds



Selection Sort
  Time taken: 3416.0 milliseconds



Insertion Sort
  Time taken: 2279.0 milliseconds



Quick Sort
  Time taken: 34.0 milliseconds



Merge Sort
  Time taken: 29.0 milliseconds

thomas% java SortsMainWorking

welcome to Butler University Software Technology Incoporated (BUSTInc)!
Please enter a number for the size of the list you would like to sort:
n= 50000


Bubble Sort
  Time taken: 31731.0 milliseconds



Selection Sort
  Time taken: 4889.0 milliseconds



Insertion Sort
  Time taken: 3269.0 milliseconds



Quick Sort
  Time taken: 31.0 milliseconds



Merge Sort
  Time taken: 30.0 milliseconds

thomas% java SortsMainWorking

welcome to Butler University Software Technology Incoporated (BUSTInc)!
Please enter a number for the size of the list you would like to sort:
n= 60000


Bubble Sort
  Time taken: 49618.0 milliseconds



Selection Sort
  Time taken: 7706.0 milliseconds



Insertion Sort
  Time taken: 5083.0 milliseconds



Quick Sort
  Time taken: 34.0 milliseconds



Merge Sort
  Time taken: 35.0 milliseconds

thomas% java SortsMainWorking

welcome to Butler University Software Technology Incoporated (BUSTInc)!
Please enter a number for the size of the list you would like to sort:
n= 70000


Bubble Sort
  Time taken: 67452.0 milliseconds



Selection Sort
  Time taken: 10480.0 milliseconds



Insertion Sort
  Time taken: 7552.0 milliseconds



Quick Sort
  Time taken: 38.0 milliseconds



Merge Sort
  Time taken: 38.0 milliseconds

thomas% java SortsMainWorking

welcome to Butler University Software Technology Incoporated (BUSTInc)!
Please enter a number for the size of the list you would like to sort:
n= 80000


Bubble Sort
  Time taken: 87815.0 milliseconds



Selection Sort
  Time taken: 13731.0 milliseconds



Insertion Sort
  Time taken: 8983.0 milliseconds



Quick Sort
  Time taken: 43.0 milliseconds



Merge Sort
  Time taken: 40.0 milliseconds

thomas% java SortsMainWorking

welcome to Butler University Software Technology Incoporated (BUSTInc)!
Please enter a number for the size of the list you would like to sort:
n= 90000


Bubble Sort
  Time taken: 120447.0 milliseconds



Selection Sort
  Time taken: 18086.0 milliseconds



Insertion Sort
  Time taken: 11352.0 milliseconds



Quick Sort
  Time taken: 45.0 milliseconds



Merge Sort
  Time taken: 47.0 milliseconds

thomas% java SortsMainWorking

welcome to Butler University Software Technology Incoporated (BUSTInc)!
Please enter a number for the size of the list you would like to sort:
n= 100000


Bubble Sort
  Time taken: 195636.0 milliseconds



Selection Sort
  Time taken: 27422.0 milliseconds



Insertion Sort
  Time taken: 14087.0 milliseconds



Quick Sort
  Time taken: 48.0 milliseconds



Merge Sort
  Time taken: 49.0 milliseconds

thomas% */