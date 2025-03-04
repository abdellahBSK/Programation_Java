package ex1;

import static java.lang.System.*;
public class Somme {
	
	private static int total = 0;
	
	public static void main(String argv[])
	{
		for(String arg: argv)
		{
			try
			{
				total += Integer.parseInt(arg);
			}
			catch(NumberFormatException numberE) {
				
			}			
		}
		
		out.println("Total: " + total);
		
	}
	
}
