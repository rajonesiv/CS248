/**@author Andrew Jones
The La Food Restaurant Program
*/

import java.io.*;
import java.util.*;

public class LF
{
	/**main class for the simulation */
	public static void main(String[] args)
	  throws IOException
	{
		simLaFood driver = new simLaFood(); //use a driver for the actual
		//simulation
		driver.start();
	}
}

/** sample run:
thomas% javac LF.java
thomas% java LF

*** Welcome to the La Food Restaurant Simulator ***
Please wait at the bar,
  Party Merlin of 3 people.

Please wait at the bar,
  Party Arthur Pendragon of 2 people.

Table for  Merlin!

Please wait at the bar,
  Party Sir Lancelot of 2 people.

Table for  Arthur Pendragon!

Please wait at the bar,
  Party The Green Knight of 3 people.

Table for  Sir Lancelot!

*** Simulation complete! ***

The average waiting time was: 7.29.
The following parties were never seated:
 The Green Knight of 3 people
thomas% */