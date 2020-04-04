package BankingApp;

public class LoanAccount extends Account
{
	private Customer customer;
	double initialBalance;
	double interestRate;
	
	public LoanAccount(Customer customer, double initialAmount,
						double interestRate)
	{
		super(customer);
		initialBalance = initialAmount;
		balance = initialAmount;
		this.interestRate = interestRate;
	}
	
	public void changeIntRate(double interestRate)
	{
		this.interestRate = interestRate;
	}
	
	public double getIntRate()
	{
		return (interestRate);
	}
	public double getInitialBalance()
	{
		return initialBalance;
	}
	
	@Override
	public double getBalance()
	{
		return balance;
	}
	
	public void makePayment(double payment)
	{
		balance -= payment;
	}
	
	public String getName()
	{
		return customer.getName();
	}

}
