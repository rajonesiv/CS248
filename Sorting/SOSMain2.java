/** @author Andrew Jones
Sorting Out Sorts Main Program */

import java.io.*;
import java.util.*;

public class SOSMain2
{
	/* these are both time variables */
	public static long time1;
	public static long time2;
	
	static int n;
	int temp;
	
	
	Comparable [] list = new Comparable[n];
	Comparable [] bubbleList = new Comparable[n];
	Comparable [] insList = new Comparable[n];
	Comparable [] selectList = new Comparable[n];
	Comparable [] shellList = new Comparable[n];
	Comparable [] mergeList = new Comparable[n];
	
	
	static void intro()
	{
		// void function for the welcome intro. it also asks user for size n
		System.out.println("welcome to Butler University Software Technology Incoporated (BUSTInc)!");
		System.out.println("Please enter a number for the size of the list you would like to sort: ");
	}
	
	// set up the list
	public void setList()
	{
		intro();
		
		Scanner in = new Scanner(System.in);
		
		//n the length of the list we are sorting
		int n = in.nextInt();
		
		// declares array of integers
		int[] List;
	
		//allocates for "n" integers
		List = new int[n];
	}
	
	static void printArray()
	{
		
	}
	
	static void sortArray()
	{
		System.out.println("Here are the arrays: ");
		System.out.println("00");
	}
	
	static void setArrays()
	{
	
	}
	
	/** @param bubbleList the input Comparable array */
	public static void bubble(Comparable[] bubbleList)
	{
		System.out.println();
    
		time1=System.currentTimeMillis();
		Sorts.bubble(bubbleList);
		time2=System.currentTimeMillis();
    
		/*if(!isLong)
		for(int i=0; i<bubbleList.length; i++)
		System.out.print(bubbleList[i]+", ");*/
    
		System.out.println();
		System.out.println("Bubble Sort");
		System.out.println("  Time taken: "+(double)(time2-time1)+" milliseconds");
		System.out.println();
	}
		
	public static void main(String[] args)
	  throws IOException
	{
		SOSMain driver = new SOSMain();
		driver.setList();
		
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
		/** @return the random array if the number is at most */
		if(n<=100)
		{
			printArray();
			setArrays();
			sortArray();
		}
		
		//list();
		//print();
	}
}