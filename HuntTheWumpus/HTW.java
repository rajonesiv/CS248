/**@author Andrew Jones
Hunt The Wumpus program
*/
import java.io.*;
import java.util.*;

public class HTW
{
	/**this is the main class for HuntTheWumpus */
	public static void main(String[] args)
	  throws IOException, InterruptedException
	{
		//Using a driver to start the game. This way I can reset it when needed.
		HTWDriver driver=new HTWDriver();
		driver.startGame();
	}
}

/* SAMPLE RUN
thomas% java HTW
0=2, 1=3, 2=4, 3=5, 4=6, 5=7, 6=8, 7=9, 8=10,
Welcome to ... **The Hunter!**
10,000 B.C. ...
You must kill the legendary Woolly Mammoth in order to
provide food for your starving tribe.
The Mammoth has taken refuge inside a glacier mountain!

You are in room 1.
You have 3 spear(s) left.
A wooden sign reads in Wenja, "Beware of the Woolly Mammoth!"
There are tunnels to rooms 2, 6, and 10.
You hear rustling and several grunts...

(M)ove or (L)unge?:
m

Which room? (2, 6, or 10)
:6
You are now in room 6
You are in room 6.
You have 3 spear(s) left.
A couple of evil rats stare at you from under a pile of rocks.
There are tunnels to rooms 1, 5, and 7.

(M)ove or (L)unge?:
m

Which room? (1, 5, or 7)
:7
You are now in room 7
You are in room 7.
You have 3 spear(s) left.
You find a sparkling rock on the floor.
There are tunnels to rooms 2, 6, and 8.

(M)ove or (L)unge?:
m

Which room? (2, 6, or 8)
:8
You are now in room 8
You are in room 8.
You have 3 spear(s) left.
The ceiling is very low and you have to stoop.
There are tunnels to rooms 3, 7, and 9.
You hear the roar of the legendary Woolly Mammoth!

(M)ove or (L)unge?:
l

Which room? (3, 7, or 9)
:3
Your spear goes down the tunnel and finds its mark!
You speared the legendary Woolly Mammoth!  **Your tribe can eat well!**
Do you want to play again?  (Y/N)
n
thomas%

*/