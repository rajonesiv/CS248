/**@author Andrew Jones
Driver class for the Hunt The Woolly Mammoth program
*/
import java.util.*;
import java.io.*;

public class HTWDriver
{
	/*currentRoom the room number that the player is currently in
	  spearCount the number of spears on the player's back
	  the room containing the legendary Woolly Mammoth!
	  iceRoom1 first room containing a icy plunge into the cold water below
	  iceRoom2 second room containing a icy plunge into the cold water below
	  sbttRoom1 first room containing hungry Sabre-toothed Tigers
	  sbttRoom2 second room containing hungry Sabre-toothed Tigers
	  bansRoom a room containing a horde of bandits
	  supplyRoom the room for the player to restock with more spears */
	int currentRoom;
	int spearCount;
	int woolRoom;
	int iceRoom1;
	int iceRoom2;
	int sbttRoom1;
	int sbttRoom2;
	int bansRoom;
	int supplyRoom;
	/**@param hasUsedSupply false if the user has not resupplied with spears */
	boolean hasUsedSupply=false;
	/**@param the Room array */
	Room cave[];
	/**@param rgen a random generator for creating the map */
	Random rgen = new Random();
	/**@param input the scanner for the player's input */
	Scanner input = new Scanner(System.in);
	
	/** prints the welcome intro */
	static void intro()
	  throws IOException, InterruptedException
	{
		System.out.println();
		System.out.print("Welcome to ");
		Thread.sleep(200); //delays the time that the system prints--Harrison showed me this!
		System.out.print(".");
		Thread.sleep(200);
		System.out.print(".");
		Thread.sleep(200);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(" **The Hunter!**");
		Thread.sleep(200);
		System.out.print("10,000 B.C. ");
		Thread.sleep(200);
		System.out.print(".");
		Thread.sleep(200);
		System.out.print(".");
		Thread.sleep(200);
		System.out.println(".");
		Thread.sleep(500);
		System.out.println("You must kill the legendary Woolly Mammoth in order to");
		System.out.println("provide food for your starving tribe.");
		Thread.sleep(250);
		System.out.println("The Mammoth has taken refuge inside a glacier mountain!");
		Thread.sleep(250);
		System.out.println();
	}
	
	//set the map layout and fill the rooms 
	public void setRooms()
	  throws IOException
	{
		Scanner caveScan = new Scanner (new FileReader("cave.txt"));
		int n=caveScan.nextInt();
		int p=caveScan.nextInt(); //added icy plunge to cave.txt (there are 2)
		int t=caveScan.nextInt(); //added Sabre-toothed Tiger to cave.txt (there are 3)
		
		cave = new Room[n];
						
		//this will put the cave file into an array
		for(int i=0; i<cave.length; i++)
		{
			cave[i] = new Room(caveScan);
		}
		
		// create random map with rooms filled with characters
		int[] roomAssign = new int[cave.length];
		for(int i=0; i<cave.length-1; i++)
		{
			roomAssign[i]=i+2;
			//debugging: prints the roomAssign
			System.out.print(i+"="+roomAssign[i]+", ");
		}
		roomAssign=shuffleArray(roomAssign);
		woolRoom=roomAssign[0]; //room 1
		int [] plunge;
		plunge = new int[p];
		for(int i=0; i<p; i++) {
			plunge[i] = roomAssign[i+1]; //add 1 to i since woolRoom is taken
		}
		int [] tiger;
		tiger = new int[t];
		for(int i=0; i<t; i++) {
			tiger[i] = roomAssign[i+1+p]; //do not know what p is; add it to i+1
		}
		bansRoom=roomAssign[1+p+t]; //woolRoom + plunge + tigers
		supplyRoom=roomAssign[2+p+t]; //woolRoom + plunge + tigers + bandits
	}
	
	/**@param array the array
	   @return the shuffled array */
	public int[] shuffleArray (int[] array)
	{
		for(int i=0; i<array.length-1; i++)
		{
			int randPosition = rgen.nextInt(array.length-2);
			int temp = array[i];
			array[i] = array[randPosition];
			array[randPosition] = temp;
		}
		
		/*
		for(int i=0; i<array.length; i++)
		{
			System.out.print(i+"="+array[i]=", ");
		}
		*/
		return array;
	}
	
	/** this function actually starts/resets the game */
	public void startGame()
	  throws IOException, InterruptedException
	{
		setRooms();
		spearCount=3; //start with 3 spears
		currentRoom=1; //start in room 1
		
		intro(); //the welcome intro
		startTurn(currentRoom, cave); //starts the player's turn
	}
	
	/**@return true if the Woolly Mammoth is in 'r'
	   @param r the room being checked by the player */
	public boolean woolCheck(int r)
	{
		if(r==woolRoom)
		{
			return true;
		}
		else {return false;}
	}
	
	/**@return true if Sabre-toothed Tigers are in 'r'
	   @param r the room being checked */
	public boolean sbttCheck(int r)
	{
		if(r==sbttRoom1 || r==sbttRoom2)
		{
			return true;
		}
		else {return false;}
	}
	
	/**@return true if an icy plunge is in 'r'
	   @param r the room being checked */
	public boolean iceCheck(int r)
	{
		if(r==iceRoom1 || r==iceRoom2)
		{
			return true;
		}
		else {return false;}
	}
	
	/**@return true if 'r' is the supplyRoom
	   @param r the room being checked */
	public boolean supplyCheck(int r)
	{
		if(r==supplyRoom)
		{
			return true;
		}
		else {return false;}
	}
	
	/**@return true if cannibal bandits are in 'r'
	   @param r the room being checked */
	public boolean bansCheck(int r)
	{
		if(r==bansRoom) {return true;}
		else {return false;}
	}
	
	/**starts turn
	   @param r the room the player is in
	   @param cave the array of rooms */
	public void startTurn(int r, Room[] cave)
	  throws IOException, InterruptedException
	{
		//initialize input 
		String ans="";
		int ansNum;
		
		//print the room number the player's in
		System.out.println("You are in room "+r+".");
		Thread.sleep(50);
		//print spearCount
		System.out.println("You have "+spearCount+" spear(s) left.");
		Thread.sleep(50);
		//print Sign--had to use comments to debug
		//System.out.println("A wooden sign reads in Wenja, \"Beware of the Woolly Mammoth\"!");
		Thread.sleep(50);
		//print the room scenario
		System.out.println(cave[r-1].scenario);
		Thread.sleep(50);
		//print which rooms are available for the player to move to
		System.out.println("There are tunnels to rooms "+cave[r-1].adj1+
		  ", "+cave[r-1].adj2+", and "+cave[r-1].adj3+".");
		//for debugging, as per Harrison Lingren
		/*System.out.println( "Woolly Mammoth:"+woolRoom+" "+woolCheck(r)+" icy plunge:"+
		     iceRoom1+","+iceRoom2+" "+iceCheck(r)+" Sabre-toothed Tiger:"+sbttRoom1
			 +","+sbttRoom2+" "+sbttCheck(r)+" bans:"+bansRoom+""+
			 bansCheck(r)+" supply:"+supplyRoom+""+supplyCheck(r) ); */
		
		//check dangerous factors (Woolly Mammoth, Bats, Icy Plunges , etc) and print warning
		if(woolCheck(cave[r-1].adj1) || woolCheck(cave[r-1].adj2) || woolCheck(cave[r-1].adj3))
		{
			Thread.sleep(50);
			System.out.println("You hear the roar of the legendary Woolly Mammoth!");
		}
		if(sbttCheck(cave[r-1].adj1) || sbttCheck(cave[r-1].adj2) || sbttCheck(cave[r-1].adj3))
		{
			Thread.sleep(50);
			System.out.println("You hear a faint growl...");
		}
		if(iceCheck(cave[r-1].adj1) || iceCheck(cave[r-1].adj2) || iceCheck(cave[r-1].adj3))
		{
			Thread.sleep(50);
			System.out.println("You feel a very cold breeze by your ankles, coming from one of the tunnels...");
		}
		if(bansCheck(cave[r-1].adj1) || bansCheck(cave[r-1].adj2) || bansCheck(cave[r-1].adj3))
		{
			Thread.sleep(50);
			System.out.println("You hear rustling and several grunts...");
		}
	
		//Have player decide if he wants to move or lunge (didn't use throw to avoid confusion)
		System.out.println();
		System.out.print("(M)ove or (L)unge?");
		System.out.println(":");
		ans=input.next();
		
		//player moves
		if(ans.equals("M") || ans.equals("m"))
		{
			startMove(r, cave);
		}
		else if (ans.equals("L") || ans.equals("l"))
		{
			lunge(r, cave);
		}
		else
		{
			//reset game
			System.out.println("Incorrect input!");
			startTurn(r, cave);
		}
	}
	
	/** case where player moves, ask which room player wants to move to
	    @param r the current room the player is in
		@param cave the input array */
	public void startMove(int r, Room[] cave)
	  throws IOException, InterruptedException
	{
		int ansNum=-1;
		System.out.println();
		System.out.println("Which room? ("+cave[r-1].adj1+", "+cave[r-1].adj2
		   +", or "+cave[r-1].adj3+")");
		System.out.print(":");
		ansNum=input.nextInt();
		
		if(ansNum==(cave[r-1].adj1) || ansNum==(cave[r-1].adj2) || 
		  ansNum==(cave[r-1].adj3))
		{
			move(ansNum, cave);
		}
		else
		{
			System.out.println("You can't get to there from here!");
			startMove(r, cave);
		}
	}
	
	/** move the player to destination room
	    @param r the current room
		@param cave the input array */
	public void move(int r, Room[] cave)
	  throws IOException, InterruptedException
	{
		System.out.println("You are now in room "+r);
		currentRoom=r;
		
		//check to see if room is supplyRoom
		if(supplyCheck(r))
		{
			if(hasUsedSupply==false)
			{
				System.out.println("You happen upon a crate full of spears!");
				System.out.println("Your spears have been replenished!");
				spearCount=3;
			}
		}
		
		//check for bans, icy plunges, and the Woolly Mammoth
		if(woolCheck(r))
		{
			gameOver("The legendary Woolly Mammoth got you!");
			return;
		}
		else if(sbttCheck(r))
		{
			gameOver("Sabre-toothed Tigers surround you, hungry for their meal...");
			return;
		}
		else if (iceCheck(r))
		{
			gameOver("You have fallen into an icy plungeeeeeeeeee!");
			return;
		}
		else if(bansCheck(r))
		{
			System.out.println("A group of bandits knock you out with a club!");
			int newR = 1+rgen.nextInt(cave.length-1);
			move(newR, cave);
		}
		startTurn(r, cave);
	}
	
	/** where the player lunges, ask which room player wants to lunge toward
		@param r the current room
		@param cave the input array */
	public void lunge(int r, Room[] cave)
	  throws IOException, InterruptedException
	{
		int ansNum;
		if(spearCount==0)
		{
			System.out.println();
			System.out.println("You are out of spears!");
			startTurn(r, cave);
			return;
		}
		
		System.out.println();
		System.out.println("Which room? ("+cave[r-1].adj1+", "+cave[r-1].adj2+", or "+cave[r-1].adj3+")");
		System.out.print(":");
		ansNum=input.nextInt();
		if(ansNum==(cave[r-1].adj1))
		{
			if(woolCheck(cave[r-1].adj1))
			{
				winGame();
				return;
			}
		}
		else if(ansNum==(cave[r-1].adj2))
		{
			if(woolCheck(cave[r-1].adj2))
			{
				winGame();
				return;
			}
		}
		else if(ansNum==(cave[r-1].adj3))
		{
			if(woolCheck(cave[r-1].adj3))
			{
				winGame();
				return;
			}
		}
		else
		{
			System.out.println("You can't lunge toward that room from here!");
			lunge(r, cave);
		}
		
		//if the Woolly Mammoth is not located in any of the adjacent rooms:
		System.out.println("You lunged into room "+ansNum);
		spearCount--;
		System.out.println("Your spear goes down the tunnel and is lost!");
		startTurn(r, cave);
	}
	
	/**If the player hits the Woolly Mammoth, end the game */
	public void winGame()
	  throws IOException, InterruptedException
	{
		String ans;
		
		System.out.println("Your spear goes down the tunnel and finds its mark!");
		System.out.println("You speared the legendary Woolly Mammoth!  **Your tribe can eat well!**");
		System.out.println("Do you want to play again?  (Y/N)");
		ans=input.next();
		
		if(ans.equals("Y") || ans.equals("y"))
		{
			startGame();
		}
		else {return;}
	}
	
	/**If the user is killed, end the game */
	public void gameOver(String reason)
	  throws IOException, InterruptedException
	{
		String ans;
		System.out.println("Oh no!");
		System.out.println(reason);
		System.out.println("GAME OVER...");
		System.out.println("Do you want to play again? (Y/N)");
		System.out.print(":");
		ans=input.next();
		if(ans.equals("Y") || ans.equals("y"))
		{
			startGame();
		}
		else {return;}
	}
	
}