package BankingApp;


public class Account 
{
	int accountNumber;
	double balance;
	Customer customer;
	
	public Account(Customer customer)
	{
		this.customer = customer;
		this.customer = new Customer(customer.getName(), customer.getCity());
	}

	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) 
	{
		this.accountNumber = accountNumber;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance) 
	{
		this.balance = balance;
	}

	public Customer getCustomer() 
	{
		return customer;
	}
}
