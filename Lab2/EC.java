package Lab2;

/*
 * Purpose: Data Structure and Algorithms Lab 2 Extra Credit
 * Status: Complete and thoroughly tested
 * Last update: 02/04/19
 * Submitted:  02/04/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.04
 * 
 * 
 * This program - called (EC for Extra Credit) uses pretty much the same
 * program we have made, with additional features, to simulate functions
 * that might be used on software that manages reservations for a 
 * restaurant
 */

public class EC extends ListArrayListBasedPlus 
{
	public EC()
	{
		super();		
	}
	
	//CB simple boolean method for determining if a person has a reservation or not
	public boolean hasReservation(String name)
	{
		boolean res = false;
		
		for (int i = 0; i< super.items.size(); i++)
		{
			Reservation reservation = ((Reservation)super.items.get(i));
			
			if (reservation.getName().equals(name))
			{
				res = true;
			}
		}
		return res;
	}
	
	//CB once it is determined that an individual has a reservation, this is for 
	//CB locating the reservation in the ArrayList
	public int getReservationIndex(String name)
	{
		int index= 0;
		for (int i = 0; i<super.items.size(); i++)
		{
			Reservation reservation = ((Reservation)super.items.get(i));
			if (reservation.getName().equals(name))
			{
				index = i;
			}
		}

		return index;
	}
	public Reservation getReservation (int index)
	{
		Reservation reservation = ((Reservation)super.items.get(index));
		return reservation;
	}
	
	public void remove(Reservation reservation)
	{
		super.items.remove(getReservationIndex(reservation.getName()));
	}
	
	@Override
	public String toString()
	{
		
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < items.size(); i++)
		{
			Reservation reservation =((Reservation) super.items.get(i));
			string.append("Reservation for " + reservation.getName() + 
					" at " + reservation.getTime() + " for a party of " + 
					reservation.getPartySize() + "\n");
		}
		return string.toString();
	}
	
}


