package BankingApp;

public class Customer 
{
	private String name;
	private String city;
	
	Customer(String name, String city)
	{
		this.name = name;
		this.city = city;
	}
	
	//CB the getCity method returns a String, which represents the customer's
	//CB current city
	public String getCity()
	{
		return city;
	}
	
	//CB the getName method returns a String that is the customer's name
	public String getName()
	{
		return name;
	}
}
