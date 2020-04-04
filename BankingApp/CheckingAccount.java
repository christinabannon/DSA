package BankingApp;

public class CheckingAccount extends Account
{
	private Customer customer;
	private double balance;
	
	
	public CheckingAccount(Customer customer, double initalBalance)
	{
		super(customer);
		balance += initalBalance;
	}
	public void makeTransaction(double transaction)
	{
		balance += transaction;
		System.out.printf("Transaction of $%.2f made." , transaction);
		System.out.println();
	}
	
	@Override
	public double getBalance()
	{
		return balance;
	}
	
	public String getName()
	{
		return this.customer.getName();
	}
}
