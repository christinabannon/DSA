package Lab2;

/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 02/04/19
 * Submitted:  02/04/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.04
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.Exception;

public class ECDriver 
{
		public static void main(String []args) throws IOException
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			EC array = new EC();

			System.out.println("Select from the following menu:");
			System.out.println(	"1. Add Reservation. \n" + 
					"2. Cancel Reservation \n" + 
					"3. Get reservation \n" + 
					"4. Clear list. \n" +
					"5. View Reservations \n"+
					"6. Exit");	
			System.out.println("Make your menu selection now");
			int selection = Integer.parseInt(reader.readLine().trim());
			System.out.println(selection);
			while (selection != 6)	
			{
				switch(selection)
				{
				case 1: //CB inserting an item to the list
				{
					System.out.println("You are now making a new reservation.");
					System.out.print("\tEnter name: ");
					String name = reader.readLine().trim();
					System.out.println(name);
					
					System.out.println("\tEnter time expected: ");
					String time = reader.readLine().trim();
					System.out.println(time);
					
					System.out.print("\tEnter party size: ");
					int size = Integer.parseInt(reader.readLine().trim());
					System.out.println(size);

						Reservation reservation = new Reservation(name, time, size);
						array.add(array.size(), reservation);
						
						System.out.println("Reservation for "+ reservation.getName()
						+ " scheduled for " + time);
						
					System.out.println();
					System.out.print("Make your menu selection now: ");
					selection = Integer.parseInt(reader.readLine().trim());
					System.out.println(selection);
					
				}
				break;

				//CB removing an item from the list
				case 2: 
				{
					System.out.println("Enter the name the reservation is under");
					String name = reader.readLine().trim();
					System.out.println(name);
					
					if (array.hasReservation(name))
					{
						System.out.println("Enter the time of the reservation: " );
						String time = reader.readLine().trim();
						System.out.println(time);
					
						System.out.println("Enter the size of the party");
						int size = Integer.parseInt(reader.readLine().trim());
						System.out.println(size);
					
						Reservation reservation = new Reservation(name, time, size);
						
						array.remove(reservation);
						
						System.out.println("Reservation for " + reservation.getName() + 
								" cancelled.");
					}
					else
					{
						System.out.println("No reservation under the name : "
											+ name);
					}
					
					System.out.println();
					System.out.print("Make your menu selection now: ");
					selection = Integer.parseInt(reader.readLine().trim());
					System.out.println(selection);
				}
				break;
				
				//CB retrieving an item from the list
				case 3:
				{
					System.out.println("What name is the reservation under?");
					String name = reader.readLine().trim();
					System.out.println(name);
					
					if (array.hasReservation(name))
					{
						Reservation reservation = array.getReservation(array.getReservationIndex(name));
						
						System.out.println("Reservation for " + reservation.getName() + 
								" at " + reservation.getTime() + 
								" for a party of " + reservation.getPartySize());
					}
					else
					{
						System.out.println("No reservations under that name!!");
					}
					System.out.println();
					System.out.print("Make your menu selection now: ");
					selection = Integer.parseInt(reader.readLine().trim());
					System.out.println(selection);
						
				}
				break;
				
				//CB clearing the list
				case 4: 
				{
					array.removeAll();
					System.out.println("All reservations cancelled.");
					System.out.println();
					System.out.print("Make your menu selection now: ");
					selection = Integer.parseInt(reader.readLine().trim());
					System.out.println(selection);
				}
				break;
				
				//CB printing the reservations!
				case 5:
				{
					if (!array.isEmpty())
					{
					System.out.println(array.toString());
					}
					else
					{
						System.out.println("No reservations tonight!");
					}
					
					System.out.println();
					System.out.print("Make your menu selection now: ");
					selection = Integer.parseInt(reader.readLine().trim());
					System.out.println(selection);
					
				}
				break;

			}
			
		}
			System.out.println("Good Bye!");
	
} }
