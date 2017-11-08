//Andrew Jones
//This java program allows the user to guess a number chosen by the program between 1 and 100
import java.io.*;
import java.util.*;

public class Guessing
{
	static Scanner cin= new Scanner(System.in);
	  
	static void intro()
	{
	//void function for the welcome intro
	System.out.println("\n***Welcome to the GUESSING GAME!!***\n");
	System.out.println("I have a number between 1 and 100. Can you guess it?\n");
	}

public class Insult
{
	Static Scanner cin = new Scanner(system.in);
	int START = 1;
    int END = 10;
    Random random = new Random();
    for (int idx = 1; idx <= 10; ++idx)
	{
      showRandomInteger(START, END, random);
    }
		
}
	public static void main(String [] args)
	{
		char choice; //only once the player says no will the function stop looping;
		intro();
		do
		{
			int number, guess;
			number = 1 + rand()%100; //random number between 1 and 100
			do
			{	
				System.out.println("\nEnter your guess: ");
				Scanner scan = new Scanner(System.in);
				guess=cin.nextInt(); //cannot find cin symbol
				for (int p = 1; p <= 10; ++p)
				{
					int randomInt = randomGenerator.nextInt(100);
					log("Generated : " + randomInt);
				}
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
			choice = input.next().charAt(0); //cannot find cin symbol
		} while(choice =='Y'); //char cannot be dereferenced
		System.out.println("\nHasta la vista, baby!\n\n");
		System.exit(0); //used this instead of return(o);
		
		//do I need to include the "return" at the end of the program??
	}
}
