/*@author Andrew Jones
	Camp Posanivee Main Program */

import java.io.*;
import java.util.*;

public class Pos
{
	public static void main (String args[])
	  throws FileNotFoundException
	{
		welcome();
		BST camp = new BST();

		readIn(camp);
		
		System.out.println("\nCommand: Q");
		System.out.println("End of program.");
		System.out.println("Bring plenty of Calamine!");
	}
	
	static void welcome() {
		System.out.println("***Welcome to Camp Posanivee!!***");
		System.out.println("Here is the list of possible commands:");
		System.out.println("H-- Help: print a list of commands");
		System.out.println("E-- Enroll/insert a new camper (name age sex)");
		System.out.println("W-- Withdraw/delete a camper (name)");
		System.out.println("D-- Display the age and gender of a camper (name)");
		System.out.println("A-- Print the average age of the campers");
		System.out.println("L-- List all campers names in alphabetical order");
		System.out.println("S-- Print the number of boy and girl campers");
		System.out.println("P-- List all campers names in preorder");
		System.out.println("Q-- Quit the program");
		System.out.println();
		System.out.println("Please enter a command.");
		System.out.println();
	}
	
	public static void readIn(BST t)
	  throws FileNotFoundException
	{
		Scanner file_input = new Scanner( new FileReader("camp.txt") );
		char command;
		Camper nodeKey = new Camper();
		command = file_input.next().charAt(0);
		
		do
		{
			if(command=='H'||command=='h') {
				System.out.println();
				System.out.println("Command: H");
				/*@return the list of commands */
				help();
			}
			else if(command=='E'||command=='e') {
				System.out.println();
				System.out.print("Command: E ");
				// enroll the student
				enroll(t, file_input);
			}
			else if(command=='W'||command=='w') {
				System.out.println();
				System.out.println("Command: W");
				// withdraw the student
				nodeKey = bstLookup(t, file_input);
				withdraw(t, nodeKey);
			}
			else if(command=='D'||command=='d') {
				System.out.println();
				/*@return the age and gender of a given camper */
				nodeKey = bstLookup(t, file_input);
				System.out.println("Command: D "+nodeKey.name);
				display(nodeKey);
			}
			else if(command=='A'||command=='a') {
				System.out.println();
				System.out.println("Command: A");
				/* @return the average of the campers */
				average(t);
			}
			else if(command=='L'||command=='l') {
				System.out.println();
				System.out.println("Command: L");
				/* @return the campers in an alphabetized fashion */
				alphabetize(t);
			}
			else if(command=='S'||command=='s') {
				System.out.println();
				System.out.println("Command: S");
				/* @return the number of boy and girl campers */
				genCount(t);
			}
			else if(command=='P'||command=='p') {
				System.out.println();
				System.out.println("Command: P");
				/* @return the preorder of the camper's names */
				preorder(t);
			}
			try {command = file_input.next().charAt(0);}
			catch (NoSuchElementException ex) {
				return;
			}
		} while (command != 'Q'||command != 'q');
	}
	
	static void help() {
		System.out.println();
		System.out.println("Here is the list of possible commands:");
		System.out.println("H-- Help: print a list of commands");
		System.out.println("E-- Enroll/insert a new camper (given the camper's name age sex)");
		System.out.println("W-- Withdraw/delete a camper (given the camper's name)");
		System.out.println("D-- Display the age and gender of a camper (given the camper's name)");
		System.out.println("A-- Print the average age of the campers");
		System.out.println("L-- List all campers names in alphabetical order");
		System.out.println("S-- Print the number of boy and girl campers");
		System.out.println("P-- List all campers names in preorder");
		System.out.println("Q-- Quit the program");
		System.out.println();
	}
	
	public static Camper bstLookup(BST t, Scanner s) {
		String search = s.next();
		Camper key = new Camper(0,'A',search);
    
		Camper answer = (Camper)
		t.search(key);
    
		if(answer==null)
		{
		System.out.println(search+" not found");
		return null;
		}
		else
      return answer;
	}
	
	private static void enroll(BST t, Scanner s) {
		t.insert(new Camper(s));
		System.out.println("New camper added.\n");
	}
	
	private static void withdraw(BST t, Camper key) {
		t.delete(key);
		System.out.println("Camper withdrawn.");
	}
	
	private static void display(Camper key) {
		System.out.println("  Name: " + key.name);
		System.out.println("  Age: " + key.age);
		System.out.println("  Gender: " + key.gender);
	}
	
	private static void average(BST t) {
		t.reset();
		double totalAge=0;
		double count=0;
		while(t.hasNext()) {
			totalAge += (double)getAge( (Camper)t.getNext() );
			count++;
		}
		
		if (count>0) {
			double avg = (totalAge / count);
			System.out.println("The average age is: "+avg);
		}
		else
		System.out.println("Error: No campers");
	}
	
	private static int getAge(Camper x) {
		return x.age;
	}
	
	public static void alphabetize(BST t) {
		t.reset();
		ArrayList<String> words = new ArrayList<String>();
		while (t.hasNext()) {
			words.add( ( (Camper)(t.getNext()) ).name );
		}
    
		Collections.sort(words);
		System.out.println("Alphabetical list of campers:");
    
		for (String word : words) {
			System.out.println("  "+word);
		}
	}
	
	private static void genCount(BST t) {
		int boyCount=1;
		int girlCount=1;
		t.reset();
		do
		{
			if ( (((Camper)(t.getNext())).gender)=='M' )
				boyCount++;
			else if ( (((Camper)(t.getNext())).gender)=='F' )
				girlCount++;
		} while(t.hasNext());
		System.out.println("Camper count:");
		System.out.println(" Boys:  " + boyCount);
		System.out.println(" Girls: " + girlCount);
	}
  
  /*NOTE: not sure how you had compared the campers. By name? # of characters?
          by age? */
	private static void preorder(BST t) {
		t.reset(0);
		System.out.println("Preorder traversal:");
		while(t.hasNext())
		System.out.println("  "+((Camper)(t.getNext())).name);
	}
}

/* sample run:
thomas% javac *.java
Note: Some input files use unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
thomas% java Pos
***Welcome to Camp Posanivee!!***
Here is the list of possible commands:
H-- Help: print a list of commands
E-- Enroll/insert a new camper (name age sex)
W-- Withdraw/delete a camper (name)
D-- Display the age and gender of a camper (name)
A-- Print the average age of the campers
L-- List all campers names in alphabetical order
S-- Print the number of boy and girl campers
P-- List all campers names in preorder
Q-- Quit the program

Please enter a command.


Command: A
Error: No campers

Command: E Kanga 26 F
New camper added.


Command: E Tigger 28 M
New camper added.


Command: E Pooh 31 M
New camper added.


Command: L
Alphabetical list of campers:
  Kanga
  Pooh
  Tigger

Command: D Tigger
  Name: Tigger
  Age: 28
  Gender: M

Command: E Rabbit 30 M
New camper added.


Command: A
The average age is: 28.75

Command: S
Camper count:
 Boys:  3
 Girls: 1

Command: E Eeyore 36 M
New camper added.


Command: W
Camper withdrawn.

Command: P
Preorder traversal:
  Pooh
  Eeyore
  Tigger
  Rabbit

Command: Q
End of program.
Bring plenty of Calamine!
thomas% */