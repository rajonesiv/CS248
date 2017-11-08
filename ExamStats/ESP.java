//Andrew Jones
//This java program is supposed to compute and display statistics using 
//a text file with exam scores.

import java.io.*;
import java.util.*;

class ESP
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
		Grades(scores); //outputs the number of scores for each letter grade
		System.out.println("There are "+scores.length+" scores.");
		
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
		int minValue = A[0];
		for(int i=1; i<A.length; i++)
		{
			if(A[i]<minValue)
			{
				minValue=A[i]; //getting the minimum value
			}
		}
		return minValue;
	}
	
	public static double getAverageValue(int[] A) //'A' is the array
	{
		double total=0.0;
		for(int i=0; i<A.length; i++)
		{
			total=total+A[i]; //getting the total value
		}
		double average=total/A.length; //dividing by amount of grades
		return average;
	}
	
	public static void Grades(int[] A) //'A' is the array
	{
		int numberA=0; //the number of grades per letter
		int numberB=0;
		int numberC=0;
		int numberD=0;
		int numberF=0;
		
		for(int i=0; i<A.length; i++)
		{
			if(A[i]>=90)
			{
				numberA=numberA+1;
			}
			else if(A[i]<90 && A[i]>=80)
			{
				numberB=numberB+1;
			}
			else if(A[i]<80 && A[i]>=70)
			{
				numberC=numberC+1;
			}
			else if(A[i]<70 && A[i]>=60)
			{
				numberD=numberD+1;
			}
			else
			{
				numberF=numberF+1;
			}
		}
		System.out.println("A: "+numberA);
		System.out.println("B: "+numberB);
		System.out.println("C: "+numberC);
		System.out.println("D: "+numberD);
		System.out.println("F: "+numberF);
	}
}

/*   sample run with 7 scores of value 1
thomas% javac ESP.java
thomas% java ESP
***Welcome to the Exam Statistics Program!***
Please enter the name of your data file:
exam.txt
Minimum score: 1
Maximum score: 1
Average score: 1.0
number of scores by letter grade:
A: 0
B: 0
C: 0
D: 0
F: 7
There are 7 scores.
    sample run with 9 scores of values of 90,80,70,60,50,40,30,20,10
thomas% javac ESP.java
thomas% java ESP
***Welcome to the Exam Statistics Program!***
Please enter the name of your data file:
exam.txt
Minimum score: 10
Maximum score: 90
Average score: 50.0
number of scores by letter grade:
A: 1
B: 1
C: 1
D: 1
F: 5
There are 9 scores.
    sample run with 9 scores of values of 98,56,77,80,93,85,60,72,64
thomas% javac ESP.java
thomas% java ESP
***Welcome to the Exam Statistics Program!***
Please enter the name of your data file:
exam.txt
Minimum score: 56
Maximum score: 98
Average score: 76.11111111111111
number of scores by letter grade:
A: 2
B: 2
C: 2
D: 2
F: 1
There are 9 scores.
*/