import java.util.*;
import java.io.*;


public class HTWbegin
{
	public static void main (String [] args)
	{
		// declare the file variable
		ifstream f;
		// open the file.  IT MUST EXIST!
		f.open("file.txt");
	
		// use the file
		int x,y;
		f >> x >> y;
		cout << "I read "<< x << " and "<< y << endl;
	
		// done.
		f.close();
		return 0;
	}
}