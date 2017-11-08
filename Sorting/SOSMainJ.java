/** @programmer Jonathan Phoun */

import java.io.*;
import java.util.*;

public class SortsMain
{
	/** @param time 1
	@param time 2 */
	
	public static long t1;
	public static long t2;
	public static int n;
	
	public static void main(String[] args)
		throws IOException
	{
		System.out.println("What is the size of the list?");
		
		Scanner in= new Scanner(System.in);
		int n= in.nextInt();
		
		boolean isLong=false;
		if(n>100)
			isLong=true;
		
		Comparable [] list= new Comparable[n];
		Comparable [] bubbleList= new Comparable[n];
		Comparable [] insertList= new Comparable[n];
		Comparable [] selectList= new Comparable[n];
		Comparable [] quickList= new Comparable[n];
		Comparable [] shellList= new Comparable[n];
		
		int temp;
		for(int i=0; i<n; i++)
		{
			temp = (int)(1+n*Math.random());
			bubbleList[i]= temp;
			insertList[i]= temp;
			selectList[i]= temp;
			quickList[i]= temp;
			shellList[i]= temp;
		}
		
		if(!isLong)
		{
			System.out.println("Original Lists: ");
			
			for(int i = 0; i<bubbleList.length; i++)
			System.out.print(bubbleList[i]+", ");
			System.out.println();
			
		}
		
		bubble(bubbleList);
		insert(insertList);
		select(selectList);
		quick(quickList);
		shell(shellList);
	}
	
	/** @param bubbleList 
	Bubble List with Comparable array */
	public static void bubble(Comparable[] bubbleList)
	{
		t1=System.currentTimeMillis();
		Sorts.bubble(bubbleList);
		t2=System.currentTimeMillis();
		System.out.println();
		System.out.println("Bubble Sort");
		System.out.println("Time taken: "+(double)(t2-t1)+" milliseconds");
		System.out.println();
		if(n<=100)
		{
		for(int i = 0; i<bubbleList.length; i++)
			System.out.print(bubbleList[i]+", ");
			System.out.println();
		}	
	}
	
	/** @param insertList
	Insertion sort with Comparable array*/
	public static void insert(Comparable[] insertList)
	{
		t1=System.currentTimeMillis();
		Sorts.insertion(insertList);
		t2=System.currentTimeMillis();
		System.out.println();
		System.out.println("Insertion Sort");
		System.out.println("Time taken: "+(double)(t2-t1)+" milliseconds");
		System.out.println();
		if(n<=100)
		{
		for(int i = 0; i<insertList.length; i++)
			System.out.print(insertList[i]+", ");
			System.out.println();
		}
	}
	
	/** @param selectList
	Selection sort with Comparable array*/
	public static void select(Comparable[] selectList)
	{
		t1=System.currentTimeMillis();
		Sorts.select(selectList);
		t2=System.currentTimeMillis();
		System.out.println();
		System.out.println("Selection Sort");
		System.out.println("Time taken: "+(double)(t2-t1)+" milliseconds");
		System.out.println();
		if(n<=100)
		{
		for(int i = 0; i<selectList.length; i++)
			System.out.print(selectList[i]+", ");
			System.out.println();
		}
	}
	
	/** @param quickList
	Quick sort with Comparable array*/
	public static void quick(Comparable[] quickList)
	{
		t1=System.currentTimeMillis();
		Sorts.quick(quickList);
		t2=System.currentTimeMillis();
		System.out.println();
		System.out.println("Quick Sort");
		System.out.println("Time taken: "+(double)(t2-t1)+" milliseconds");
		System.out.println();
		if(n<=100)
		{
		for(int i = 0; i<quickList.length; i++)
			System.out.print(quickList[i]+", ");
			System.out.println();
		}
	}
	
	/** @param shellList
	Shell sort with Comparable array*/
	public static void shell(Comparable[] shellList)
	{
		t1=System.currentTimeMillis();
		Sorts.quick(shellList);
		t2=System.currentTimeMillis();
		System.out.println();
		System.out.println("Shell Sort");
		System.out.println("Time taken: "+(double)(t2-t1)+" milliseconds");
		System.out.println();
		if(n<=100)
		{
		for(int i = 0; i<shellList.length; i++)
			System.out.print(shellList[i]+", ");
			System.out.println();
		}
	}
}

/* test program
What is the size of the list?
25
Original Lists:
24, 3, 12, 9, 24, 12, 5, 17, 19, 1, 19, 1, 20, 22, 3, 1, 13, 14, 23, 7, 15, 16, 5, 1, 17,

Bubble Sort
Time taken: 1.0 milliseconds

1, 1, 1, 1, 3, 3, 5, 5, 7, 9, 12, 12, 13, 14, 15, 16, 17, 17, 19, 19, 20, 22, 23, 24, 24,

Insertion Sort
Time taken: 0.0 milliseconds

1, 1, 1, 1, 3, 3, 5, 5, 7, 9, 12, 12, 13, 14, 15, 16, 17, 17, 19, 19, 20, 22, 23, 24, 24,

Selection Sort
Time taken: 0.0 milliseconds

1, 1, 1, 1, 3, 3, 5, 5, 7, 9, 12, 12, 13, 14, 15, 16, 17, 17, 19, 19, 20, 22, 23, 24, 24,

Quick Sort
Time taken: 0.0 milliseconds

1, 1, 1, 1, 3, 3, 5, 5, 7, 9, 12, 12, 13, 14, 15, 16, 17, 17, 19, 19, 20, 22, 23, 24, 24,

Shell Sort
Time taken: 1.0 milliseconds

1, 1, 1, 1, 3, 3, 5, 5, 7, 9, 12, 12, 13, 14, 15, 16, 17, 17, 19, 19, 20, 22, 23, 24, 24,

What is the size of the list?
100
Bubble Sort
Time taken: 5.0 milliseconds

Insertion Sort
Time taken: 0.0 milliseconds

Selection Sort
Time taken: 0.0 milliseconds

Quick Sort
Time taken: 0.0 milliseconds

Shell Sort
Time taken: 0.0 milliseconds

thomas% java SortsMain
What is the size of the list?
1000
Bubble Sort
Time taken: 20.0 milliseconds

Insertion Sort
Time taken: 16.0 milliseconds

Selection Sort
Time taken: 5.0 milliseconds

Quick Sort
Time taken: 1.0 milliseconds

Shell Sort
Time taken: 1.0 milliseconds

thomas% java SortsMain
What is the size of the list?
10000
Bubble Sort
Time taken: 1335.0 milliseconds

Insertion Sort
Time taken: 148.0 milliseconds

Selection Sort
Time taken: 214.0 milliseconds

Quick Sort
Time taken: 7.0 milliseconds

Shell Sort
Time taken: 3.0 milliseconds

thomas% java SortsMain
What is the size of the list?
20000
Bubble Sort
Time taken: 5425.0 milliseconds

Insertion Sort
Time taken: 570.0 milliseconds

Selection Sort
Time taken: 856.0 milliseconds

Quick Sort
Time taken: 22.0 milliseconds

Shell Sort
Time taken: 6.0 milliseconds

thomas% java SortsMain
What is the size of the list?
50000
Bubble Sort
Time taken: 34204.0 milliseconds

Insertion Sort
Time taken: 3496.0 milliseconds

Selection Sort
Time taken: 5331.0 milliseconds

Quick Sort
Time taken: 30.0 milliseconds

Shell Sort
Time taken: 10.0 milliseconds

thomas% java SortsMain
What is the size of the list?
100000
Bubble Sort
Time taken: 197651.0 milliseconds

Insertion Sort
Time taken: 14338.0 milliseconds

Selection Sort
Time taken: 27703.0 milliseconds

Quick Sort
Time taken: 49.0 milliseconds

Shell Sort
Time taken: 24.0 milliseconds
*/

