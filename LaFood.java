/**@author Andrew Jones
The La Food Restaurant Program
*/

import java.io.*;
import java.util.*;

public class LaFood
{
	char name;
	int party;
	int time;
	
	public Queue waitList = new QueueLL();
	public Queue checkedIn = new QueueLL();
	public int[] Tables = new int[3];
	public int checkedInCustomers=0;
	public int timeWaited=0;
	
	public Rest(Scanner s)
	{
		int restNum;
		restNum = s.nextInt();
		
		s.nextLine();
		/**the array for the customers */
		Rest cust [];
		return;
	}
	
	/** this is the welcome function which also asks for the file name */
	public void intro()
	{
		System.out.println("*** Welcome to the La Food Restaurant Simulator ***");
		System.out.println("Enter data file name: ");
	}
	
	/** sets up the file into corresponding information */
	public void setTable()
	{
		
		Scanner custScan = new Scanner (new FileReader("customer.txt"));
		int n = custScan.nextInt();
		cust = new Rest[n];
		
		//this will put the file into an array
		for(int i=0; i<cust.length; i++)
		{cust[i] = new Rest(custScan);}
	}

	public void start()
	{
		readFile();
		
		int currentTime=0;
		int tableIndex=0;
		
		while (currentTime<20)
		{
			currentTime++;
			
			if (!waitList.isEmpty() && currentTime==((Customer)waitList.getFront()).getArrivalTime() )
			{
				System.out.println("Please wait at the bar, ");
				System.out.println("party "+((Customer)waitList.getFront()).toString()+".");
				checkedIn.enqueue(new Customer( ((Customer)waitList.getFront()) ));
				
				waitList.dequeue();
			}
			
			else if (currentTime==Tables[tableIndex])
			{
				System.out.println("Table for "+((Customer)checkedIn.getFront()).groupNumber, ((Customer)checkedIn.getFront()).getArrivalTime(), currentTime );
				avgWaitTime( ((Customer)checkedIn.getFront()).groupNumber, ((Customer)checkedIn.getFront()).getArrivalTime(), currentTime );
				checkedInCustomers += ((Customer)checkedIn.getFront());
			}
		}
	}
	
	
	
	public static void main(String [] args)
	  throws IOException
	{
		intro();
		Scanner data = new Scanner ("customer.txt");
		start();
		
	}
		
}