import java.util.*;


public class arrayTest {

	static int n;
	static int num;
	
	static void intro()
	{
		System.out.println("Welcome to the array Test!");
		System.out.println("Enter a value: ");
	}

    private static double[] anArray;

    public static double[] list()
	{
        anArray = new double[10];
		for(int i=0;i<anArray.length;i++)
		{
			anArray[i] = randomFill();
		}		
        return anArray;
    }

    public static void print()
	{
        for(double num: anArray)
		{
			System.out.println(n+" ");
        }
    }


    public static double randomFill()
	{
		Random rand = new Random();
		int randomNum = rand.nextInt() + 1;
		return randomNum;
    }

    public static void main(String args[])
	{
		intro();
		
		Scanner num = new Scanner(System.in);
		int n = num.nextInt();
		
		list();
		print();
    }
}