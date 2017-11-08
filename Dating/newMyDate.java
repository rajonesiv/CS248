/**
Dating Game
@author Andrew Jones
*/

//This is the date class to be used for the Year3000 program.
import java.io.*;
import java.util.*;

public class newMyDate implements DateInterface /*using implements since i'm using 
the elements of the interface in my class, as opposed to extends (creating subclass
of the class i'm extending)*/
{
	int month, day, year, dow;
		
	/** @return the month of the year */
	public int getMonth()
	{
		return month;
	}
	/** @return the day of the month */
	public int getDay()
	{
		return day;
	}
	/** @return the year */
	public int getYear()
	{
		return year;
	}
	/** @return the day of the week */
	public int getDow()
	{
		return dow;
	}
	
	/** sets the date
		@param m the month of the year (0-11)
		@param d the day of the month (1-31)
		@param y the year (four digits)
		@param dow the day of the week (0-6)
	*/
	public void set(int m, int d, int y, int dw)
	{
		cal = Calendar.getInstance();
		Date date = cal.getTime();
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DAY_OF_MONTH);
		year = cal.get(Calendar.YEAR);
		dw = cal.get(Calendar.DAY_OF_WEEK);
	}
	
	/** moves date forward by one day */
	public void tomorrow()
	{
		if(checkMonth()==false)
		{
			if(checkDay()==false)
			{
				day++;
				nextDOW();
			}
			else
			{
				day=1;
				month++;
				nextDOW();
			}
		}
		else
		{
			if(checkDay()==false)
			{
				day++;
				nextDOW();
			}
			else
			{
				day=1;
				month=1;
				year++;
				nextDOW();
			}
		}
	}
	
	/** @return true if day is 31/30/29/28, @return false if not */
	public boolean checkDay()
	{
		switch(month) /*Found on page 17 of data structures book. Used to select among
		several small int or char values. each case represents a month in the year, 
		with February being either 28 or 29 days. */
		{
			case 1: case 3: case 5: case 7:
			case 8: case 10: case 12:  /*Harrison Lingren told me that I can actually
			combine similar cases!*/
				if(day>=31)
				{return true;}
				else
				{return false;}
			case 2:
				if(checkLeap()==false)
				{
					if(day>=28)
					{return true;}
					else
					{return false;}
				}
				else
				{
					if(day>=29)
					{return true;}
					else
					{return false;}
				}
			case 4: case 6: case 9: case 11:
				if(day>=30)
				{return true;}
				else
				{return false;}
		}
		return true;
	}
	
	/** @return true if month is December, */
	public boolean checkMonth()
	{
		if(month>=12)
		{return true;}
		else
		{return false;}
	}
	
	/** @return true if year is a leapyear*/
	public boolean checkLeap()
	{
		if((year % 4)==0 && (year % 100)!=0)
		{return true;}
		else if ((year % 400)==0)
		{return true;}
		else
		{return false;}
	}
	
	/** @return true if day of the week is Saturday*/
	public boolean checkDOW()
	{
		if(dow>=7)
		{return true;}
		else
		{return false;}
	}
	
	/**moves day of week forward*/
	public void nextDOW()
	{
		if(checkDOW()==false)
		{dow++;}
		else
		{dow=1;}
	}
	
	/** @return string as "dow, MM, dd, yyyy" */
	public String toString()
	{
		String dateString="";
		String dowString="";
		String monthString="";
		
		switch(dow)
		{
			case 0:
				dowString="Sunday";
				break;
			case 1:
				dowString="Monday";
				break;
			case 2:
				dowString="Tuesday";
				break;
			case 3:
				dowString="Wednesday";
				break;
			case 4:
				dowString="Thursday";
				break;
			case 5:
				dowString="Friday";
				break;
			case 6:
				dowString="Saturday";
				break;
		}
		
		switch(month)
		{
			case 1:
				monthString="January";
				break;
			case 2:
				monthString="February";
				break;
			case 3:
				monthString="March";
				break;
			case 4:
				monthString="April";
				break;
			case 5:
				monthString="May";
				break;
			case 6:
				monthString="June";
				break;
			case 7:
				monthString="July";
				break;
			case 8:
				monthString="August";
				break;
			case 9:
				monthString="September";
				break;
			case 10:
				monthString="October";
				break;
			case 11:
				monthString="November";
				break;
			case 12:
				monthString="December";
				break;
		}
		dateString=(dowString+ ", "+monthString+", "+day+", "+year);
		return dateString;
	}
	
	public void today() 
	{
		Calendar cal = new GregorianCalendar(2015,0,31);
		cal.setFirstDayOfWeek(Calendar.SUNDAY); //Sunday = 1
	}
	public void yesterday() {} //didn't do extra cred
}

/* sample run:
final days: 
Sunday, December, 29, 2999
Monday, December, 30, 2999
Tuesday, December, 31, 2999
Wednesday, January, 1, 3000
*/
