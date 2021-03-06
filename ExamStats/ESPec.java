//Andrew Jones
//This java program is supposed to compute and display statistics using a text file with exam
//scores.

import java.io.*;
import java.util.*;

class ESPec
{
	static Scanner scan=new Scanner(System.in);
	static Scanner inputfile;
	
	public static void main(String [] args)
		throws IOException
	{
		System.out.println("***Welcome to the Exam Statistics Program!***");
		System.out.println("Please enter the name of your data file: ");
		
		String fileName=scan.next(); //enter file name
		inputfile=new Scanner(new FileReader(fileName));
		int n=inputfile.nextInt(); //place the input file in an array
		
		int [] scores;
		scores=new int[n];
		for(int i=0; i<n; i++)
		{
			scores[i]=inputfile.nextInt();
		}
		
		//find min, max, and avg scores
		System.out.println("Minimum score: "+getMinValue(scores));
		System.out.println("Maximum score: "+getMaxValue(scores));
		System.out.println("Average score: "+getAverageValue(scores));
		
		System.out.println("number of scores by letter grade: ");
		CountGrades(scores); //outputs the number of scores for each letter grade
		System.out.println("There are "+scores.length+" scores.");
		
		//System.out.println("Here is the sample input file "+ fileName);	
	}
	
	public static int getMaxValue(int[] A) //'A' is the array
	{
		int maxValue = A[0];
		for(int i=1; i<A.length; i++)
		{
			if(A[i]>maxValue)
			{
				maxValue=A[i]; //getting the maximum value
			}
		}
		return maxValue;
	}
	
	public static int getMinValue(int [] A) //'A' is the array
	{
		for(int i=1; i<A.length; i++)
		{
			if(A[i]>minValue)
			{
				minValue=A[i]; //getting the minimum value
			}
		}
		return minValue;
	}
	
	public static int getAverageValue(int[] A) //'A' is the array
	{
		int total=0;
		for(int i=0; i<A.length; i++)
		{
			total=total+A[i]; //getting the total value
		}
		int average=total/A.length;
		return average;
	}
	
	public static int getMedianValue(int[] A) //'A' is the array
	{
		//sort the scores
		Arrays.sort(A);
		//if the total number of scores is even
		if(A.length/2 %2 == 0)
		{
			int numMid = A.length / 2;
			double medianValue=((double) A[numMid]);
			return medianValue;
		}
		else
		{
			int numMid;
			numMid = new int [2];
			
		}
	}
}