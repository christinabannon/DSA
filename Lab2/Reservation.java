package Lab2;

/*
 * Purpose: Data Structure and Algorithms Lab 2 Extra Credit
 * Status: Complete and thoroughly tested
 * Last update: 02/02/19
 * Submitted:  02/04/19
 * Comment: test suite and sample run attached
 * @author: Christina Bannon
 * @version: 2019.02.02
 * 
 * This class, reservation is very simple - it only contains methods to access
 * info on reservations. The info recognized include name, time, and party size
 * with setter and getter methods to update changes
 */



public class Reservation 
{
	private String name;
	private String time;
	private int partySize;
	
	public Reservation (String name, String time, int partySize)
	{
		this.name = name;
		this.time = time;
		this.partySize = partySize;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getTime() 
	{
		return time;
	}

	public void setTime(String time) 
	{
		this.time = time;
	}

	public int getPartySize() 
	{
		return partySize;
	}

	public void setPartySize(int partySize) 
	{
		this.partySize = partySize;
	}
}
