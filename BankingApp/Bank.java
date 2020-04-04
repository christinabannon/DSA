/**
 * 
 *This class simulates a bank its self
/**
 /* @author christinabannon
 *
 *
 *?
 */

package BankingApp;


import java.util.ArrayList;
import java.util.Random;

public class Bank {
	private String name;
	private String city;
	private double assets;
	private ArrayList<Account> allAccounts;

//CB Bank methods	
//
	public Bank(String city, String name) 
	{
		this.name = name;
		this.city = city;
		// loanAccounts = new HashMap <String, LoanAccount>();
		// checkingAccounts = new HashMap <String, CheckingAccount> ();
		allAccounts = new ArrayList<>();
		assets = 0;
	}
	
	//CB the toString method takes in no parameter
	// and returns a string which lists all 
	//of the accounts at the bank in the order that
	// they were put in
	@Override
	public String toString()
	{
		StringBuilder string = new StringBuilder();

		for (int i = 0; i < allAccounts.size(); i++)
		{
			string.append((i+1) + ". ");
			
			if (isLoan(i))
			{
				LoanAccount loanAccount = (LoanAccount) allAccounts.get(i);
				
				string.append("Borrower " + loanAccount
											.getCustomer()
											.getName() +
							" residing in " + loanAccount
											.getCustomer()
											.getCity() +
							"\nAccount number: " + loanAccount
											.getAccountNumber() + 
							"\nInitial Loan amount: $" + loanAccount
											.getInitialBalance() +
							"\nLoan Balance: $" + loanAccount.getBalance() + 
							"\nInterest Rate: "+ loanAccount.getInitialBalance() + 
							"% \n \n" );
			}
			else 
			{
				CheckingAccount checkingAccount = (CheckingAccount) allAccounts.get(i);
				
				string.append("Depositer " + checkingAccount
											.getCustomer()
											.getName() +
							" residing in " + checkingAccount
											.getCustomer()
											.getCity() +
							"\nAccount number: " + allAccounts.get(i) + 
							"\nAccount balance: $" + checkingAccount.getBalance()+
							"\n \n");
			}
		}
		return string.toString();
	}
	
	//CB GetBankName method takes in to parameter 
	//and returns the name of the bank
	public String getBankName()
	{
		return name;
	}
	
	//CB getBankCity method takes in no parameter
	// and returns String name of bank city
	public String getBankCity()
	{
		return city;
	}
	
	//CB getNumberOfAccounts method takes in no parameter
	//and returns the number of accounts @ bank
	public int getNumberOfAccounts()
	{
		return allAccounts.size();
	}

	//CB getAccountIndex method takes in a string of an indivial
	// who has an account, and returns their index!
	public int getAccountIndex(String customerName)
	{
		boolean valid = false;
		int index = 0;
		for (int i = 0; i < allAccounts.size() && valid == false; i++) 
		{
			if (allAccounts.get(i).getCustomer().getName().equals(customerName)) {
				valid = true;
				index = i;
			}
		}
		return index;
	}
	
	//CB the indexAccount method accepts an integer to represent the index and returns the 
	//CB Account held @ that index
	public Account indexAccount(int i)
	{
		return allAccounts.get(i);
	}
	
	//CB hasAccount method accepts a String representing a name
	//and returns a boolean indicating whether the customer does
	//or does not have an account
	public boolean hasAccount(String name)
	{
		boolean valid = false;
		
		for (int i = 0; i < allAccounts.size() && valid == false; i++) 
		{
			if (allAccounts.get(i).getCustomer().getName().equals(name)) 
			{
				valid = true;
			}
		}
		return valid;
	}
	
	//CB addAccount method accepts an Account, assigns it a unique number,
	//CB and adds it to the array
	public void addAccount(Account account)
	{
		account.setAccountNumber(makeAccountNum());
		allAccounts.add(account);
	}
	
	//CB private makeAccountNum method takes in no parameter and returns
	//CB a unique 3 digit int to be an account number
	private int makeAccountNum()
	{
		boolean invalid = true;
		int num = 0;
		while (invalid) 
		{
		invalid = false;
		Random rand = new Random();
		num = (100 + rand.nextInt(899));
			
			if (allAccounts.size() > 0)
			{

				for (int i = 0; i < allAccounts.size() && !invalid; i++) 
				{
				if (num == allAccounts.get(i).getAccountNumber()) 
				{
				invalid = true;
				}
				}
			}
		}
		return num;
	}
	
	//CB remove account accepts a String customer's name
	//CB and removes their account from Bank's ArrayList
	public void removeAccount(String customerName) 
	{
			allAccounts.remove(getAccountIndex(customerName));
	}

	// CB getAssets returns assets
	public double getAssets() 
	{
		return assets;
	}

	//CB updateAssets changes assets
	public void updateAssets(double amount) 
	{
		assets = amount;
	}
	
//CB Loans
//
	// CB isLoan method accepts an index and returns a boolean type 
	//indicating where the account is a LoanAccount or not
	public boolean isLoan(int index)
	{
		boolean accountStatus;
		
		if ( allAccounts.get(index) instanceof LoanAccount)
		{
			accountStatus = true;
		}
		else 
		{
			accountStatus = false;
		}
	return accountStatus;
	}
	
	//CB getLoan accepts a customerName and returns the loanAccount 
	// of the customer name
	public LoanAccount getLoan(String customerName)
	{
		int i = getAccountIndex(customerName);
		LoanAccount loanAccount = (LoanAccount) allAccounts.get(i);
		
		return loanAccount;	
	}
	
	//CB sumTotalLoans uses a super cool stream to sum the loans of the
	// bank, and returns that sum
	public double sumTotalLoans() 
	{
	   	Double loanSum = allAccounts.stream()
								.filter(account -> account instanceof LoanAccount)
								.mapToDouble(account -> ((LoanAccount) account).getBalance())
								.reduce(0, (total, element) -> total + element);
		return loanSum;
	}
	
	//CB getNumTotalLoans accepts no variables but returns a count of every
	//CB Loan Account @ the bank
	public double getNumTotalLoans()
	{
		double count = allAccounts.stream()
				.filter(account -> account instanceof LoanAccount)
				.count();
		
		return count;
	}

	//CB averageLoans returns the average of the loans
	public double averageLoans() 
	{
		double average = 0;
		
		if (sumTotalLoans() != 0) 
		{
			average = (sumTotalLoans() / getNumTotalLoans());
		}
		else
		{
			average = 0;
		}
		return average;
	}
	
//CB CheckingAccounts
//
	//CB getCheckingAccount accepts a String to represent a customer's
	// name and returns a CheckingAccount
	public CheckingAccount getCheckingAccount(String customerName)
	{
		CheckingAccount checkingAccount = (CheckingAccount) 
				allAccounts.get(getAccountIndex(customerName));
		
		return checkingAccount;
	}

	//CB the sumTotalCheckingAccounts does not take in any variables, but returns the sum total
	//CB of balances in the checking accounts @ the bank
	public double sumTotalCheckingAccounts() 
	{
		double sum = allAccounts.stream()
				.filter(account -> account instanceof CheckingAccount)
				.mapToDouble(account -> ((CheckingAccount)account).getBalance())
				.reduce(0, (total, element) -> total + element);	
		return sum;
	}

	//CB getNumCheckingAccounts accepts no variables, and returns a count of the number of 
	//CB Checking Accounts in the bank
	public double getNumCheckingAccounts()
	{
		double count = allAccounts.stream()
									.filter(account -> account instanceof CheckingAccount)
									.count();
		return count;
	}
	//CB the averageCheckingAccounts returns an average of all of the balances in all of the 
	//CB checking accounts
	public double averageCheckingAccounts() 
	{
		double average;
		
		if (sumTotalCheckingAccounts() > 0)
		{
			average = (sumTotalCheckingAccounts() / getNumCheckingAccounts());
		}
		else 
		{
			average = 0;
		}
		return average;
	}
}

