/**
Room class for HuntTheWumpus main program
@author Andrew Jones
*/

import java.io.*;
import java.util.*;

public class Room
{
	/** @param roomNum the room number
		@param scenario the room layout
		@param adj1 the first adjacent room
		@param adj2 the second adjacent room
		@param adj3 the third adjacent room
	*/
	
	int roomNum;
	String scenario;
	int adj1, adj2, adj3;
	
	/** initializes the object
		@param s input scanner to read from the file */
	public Room(Scanner s)
	{
		roomNum=s.nextInt();
		
		adj1=s.nextInt();
		adj2=s.nextInt();
		adj3=s.nextInt();
		
		s.nextLine();
		scenario=s.nextLine();
	}
	
	/** writes the Room to string for debugging */
	public String toString()
	{
		String ans=(roomNum+" adj1="+adj1+" adj2="+adj2+" adj3="+adj3);
		return ans;
	}
}