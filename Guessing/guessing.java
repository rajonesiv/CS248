//Andrew Jones
//This java program allows the user to guess a number chosen by the program between 1 and 100
import java.io.*;
import java.util.*;

class guessing
{
	static Scanner cin= new Scanner(System.in);
	  
	static void intro()
	{
	//void function for the welcome intro
	System.out.println("\n***Welcome to the GUESSING GAME!!***\n");
	System.out.println("I have a number between 1 and 100. Can you guess it?\n");
	}

	public static void main(String [] args)
	{
		char choice; //only once the player says no will the function stop looping;
		intro();
		do
		{
			int number, guess;
			number = (int) + (1+100*Math.random()); //random number between 1 and 100
			do
			{	
				int insult;
				System.out.println("\nEnter your guess: ");
				Scanner scan = new Scanner(System.in);
				guess=scan.nextInt();
				insult = (int) + (1+3*Math.random()); //random number between 1 and 3
				if(guess<number)
				{
					if(insult==1)
						{
							System.out.println("Too low! Do you accept defeat?\n");
						}
					else if(insult==2)
						{
							System.out.println("Too low! I would ask how old you are, but I know you can't count that high...\n");
						}
					else if (insult==3)
						{
							System.out.println("too low! Hey, you have something on your chin....third one down.\n");
						}
				}
		
				else if(guess>number)
				{
					if(insult==1)
						{
							System.out.println("Too high! You're killing me, smalls! ");
							System.out.println("You dare compare yourself to me!\n");
						}
					else if(insult==2)
						{
							System.out.println("Too high! If you were twice as smart, you'd still be stupid!\n");
						}
					else if(insult==3)
						{
							System.out.println("Too high! We all sprang from apes, but you didn't spring far enough!\n");
						}
				}
				else if(guess==number)
				{
					System.out.println("\nYou may not be my equal, but you have won my respect!\n");
				}
		
			}while(guess!=number); //allows the player to keep on guessing as long as he guesses incorrectly
	
			Scanner input = new Scanner(System.in);
			System.out.println("\nDo you want to play again? Y/N .\n");
			choice = input.next().charAt(0);
		} while(choice=='Y'||choice=='y');
		System.out.println("\nHasta la vista, baby!\n\n");
	}
}

/* sample run
thomas% javac guessing.java
thomas% java Guessing

***Welcome to the GUESSING GAME!!***

I have a number between 1 and 100. Can you guess it?


Enter your guess:
50
Too high! We all sprang from apes, but you didn't spring far enough!


Enter your guess:
30
Too high! We all sprang from apes, but you didn't spring far enough!


Enter your guess:
10
Too low! Do you accept defeat?


Enter your guess:
20

You may not be my equal, but you have won my respect!


Do you want to play again? Y/N .

y


Enter your guess:
50
Too low! Do you accept defeat?


Enter your guess:
70
Too high! You're killing me, smalls!
You dare compare yourself to me!


Enter your guess:
60
Too high! If you were twice as smart, you'd still be stupid!


Enter your guess:
55
Too low! Do you accept defeat?


Enter your guess:
57

You may not be my equal, but you have won my respect!


Do you want to play again? Y/N .

n

Hasta la vista, baby!


thomas%

*/