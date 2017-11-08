/**@author Andrew Jones
The simulation for the La Food Restaurant Program 
*/

import java.io.*;
import java.util.*;

public class sLF
{
	public Queue waitList = new QueueLL();
	public Queue checkedIn = new QueueLL();
	public int[] Tables = new int[tableIndex];
	public int checkedInCustomers=0;
	public int timeWaited=0;
	
	public void start()
	  throws IOException
	{
		intro();
		readFile(); //read the file "data.txt"
		/** sets the time counters to zero (restaurant is closed) */
		int currentTime=0;
		int tableIndex=0; 
		
		while (currentTime!= ) //the program terminates at Q.
		{
			currentTime++;
			if (!waitList.isEmpty() && currentTime==((Customer)waitList.getFront()).getArrivalTime());
			{
				System.out.println("Please wait at the bar, ");
				System.out.println("  Party"+((Customer)waitList.getFront()).toString()+".");
				System.out.println();
				//places Customer into the waiting queue
				checkedIn.enqueue(new Customer( ((Customer)waitList.getFront()) ));
				
				waitList.dequeue();
			}
			else if (currentTime==Tables[tableIndex])
			{
				/** takes the first group in line for the open table */
				System.out.println("Table for "+((Customer)checkedIn.getFront()).getName()+"!");
				System.out.println();
				avgWaitTime((Customer)checkedIn.getFront()).groupNum, ((Customer)checkedIn.getFront()).getArrivalTime(), currentTime);
				checkedInCustomers += ((Customer)checkedIn.getFront()).groupNum;
				
				checkedIn.dequeue();
				tableIndex++;
			}
		}
		
		System.out.println("*** Simulation complete! ***");
		System.out.println();
		
		/** find the average waiting time for all of the customers*/
		double average = ((double)totmins / (double)checkedInCustomers);
		System.out.println("The average waiting time was: "+String.format("%.2f", average)+".");
		
		/** print the remaining customers that are still waiting in the queue */
		if(!checkedIn.isEmpty())
		{
			System.out.println("The following parties were never seated: ");
			while (!checkedIn.isEmpty())
			{
				System.out.println(((Customer)checkedIn.getFront()).toString());
				checkedIn.dequeue();
			}
		}
	}
		
	/** this is the welcome function */
	public void intro()
	{
		System.out.println("*** Welcome to the La Food Restaurant Simulator ***");
		System.out.println();
	}
	
	/** read the input file (data.txt)*/
	public void readFile()
	  throws IOException
	{
		Scanner data = new Scanner(new FileReader("data.txt"));
		int index=0;
		boolean eof=false; //use this to avoid error attempting to get input past the end of file
		String action;
		
		while(!eof) //end of file
		{
			action = data.next();
			if(action.equals("A")) //A is the arrival of a group
			{
				waitList.enqueue(new Customer(data.nextInt(), data.nextInt(), data.nextLine()));
			}
			else if (action.equals("T")) //T is the opening of a table
			{
				Tables[index]=data.nextInt();
				index++;
			}
			else if (action.equals("Q")) //Q is for quitting/terminating the program
			{
				eof=true;
				return;
			}
			else {System.out.println("Unknown token: "+action);}
		}
	}
	
	/** compute the average wait time (need both times; compute only when the party has been seated) */
	public void avgWaitTime(int partySize, int tos, int toa)
	{
		double average=0;
		totmins = totmins + partySize*(tos - toa)//tos is the time of seating
		//toa is the time of arrival
	}
}
