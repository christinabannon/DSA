package theaterProject;

import java.util.Scanner;

public class LVDistanceTraveled
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		//CB these are all better off uninitialized, 
		// check the code below and please please
		// let me know if you understand why!
		double vehicleSpeed; 
		double distanceTravelled; 
		int    timeTravelled;


		System.out.println("Daevon Johnson \t 4/4 \n");

		//CB took this block of code OUT of the while loop...
		System.out.println("Enter the vehilce's speed: ");
		vehicleSpeed = scanner.nextDouble();

		//CB put this block of code IN to the while loop. 
		// Notice, it will only execute when it needs to - 
		// while the vehicleSpeed is valid!
		while (vehicleSpeed < 0)
		{
			System.out.println("Enter 0 or greater for speed: ");
			vehicleSpeed = scanner.nextDouble();
		}
		
		//CB I did the same thing with these blocks of code. 
		// This first block is going to execute no matter what, 
		// so it doesn't belong in a conditional statement. 
		System.out.println("Enter the number of "
					+ "hours the vehicle was in motion: ");
		timeTravelled = scanner.nextInt();
		
		//CB This code executes conditionally, and should loop
		// until it receives a valid input. So it goes
		// in a while loop!
		while (timeTravelled < 0)
		{
			System.out.println("Enter 1 or greater for hours: ");
			timeTravelled = scanner.nextInt();
		}

		System.out.println("Hour\tDistance Travelled"
				+ "\n--------------------" );
		
		//CB this for loop looks good!! 
		// I'm not sure what particular formatting 
		// is called for with this assignment, 
		// but everything you wrote here makes sense. 
		// Good job! for loops are super handy and you 
		// will definitely be using them again!
		for(int hour = 1; hour <= timeTravelled; hour++) 
		{
			distanceTravelled = (hour * vehicleSpeed );
			System.out.println( hour + 
					"\t" + distanceTravelled );
		}
	}
}