/**@author Andrew Jones
The Customer class for the La Food Restaurant Program
*/

import java.util.*;

public class Customer
{
	/**@param sets arrival time to 0 
	   @param sets the group number to 0 
	   @param sets the bribe */
	int toa = 0;
	int groupNum = 0;
	String name = "";
	
	/** Default basic constructor */
	public Customer()
	{
		toa = 0;
		groupNum = 0;
		name = "";
	}
	
	/** @param at the arrival time of the customer
		@param g the number of people in the group
		@param n the name of the customer */
	public Customer(int at, int g, String n)
	{
		toa = at;
		groupNum = g;
		name = n;
	}
	
	/** assigns to the Customer class */
	public Customer(Customer c)
	{
		toa = c.toa;
		groupNum = c.groupNum;
		name = c.name;
	}
	
	/** @param s Scanner for reading from the file "data.txt" */
	public Customer(Scanner s)
	{
		toa = s.nextInt();
		groupNum = s.nextInt();
		name = s.next();
	}
	
	/** @return the arrival time of the customer */
	public int getToa()
	{ return toa; }
	
	/** @return the number of people in the group */
	public int getGroupNum()
	{ return groupNum(); }
	
	/** @return the name of the customer */
	public String getName()
	{ return name; }
	
	/** the output of the string */
	public String toString()
	{
		return (name + " of "+groupNum+" people");
	}
	
}