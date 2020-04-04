package BankingApp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BankApp 
{
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	//CB opening the bank
	static Bank bank;
	public static void main(String [] args) throws IOException
	{
		System.out.println("Enter the name of the bank: ");
		String bankName = reader.readLine();
		System.out.println(reader.readLine());
		
		System.out.println("Enter the location of the bank: ");
		String locale = reader.readLine();
		System.out.println(reader.readLine());
		
		bank = new Bank(bankName, locale);
		
		//CB initializing the bank's assets
		System.out.println("Enter the amount of assets the bank holds: ");
		bank.updateAssets(Double.parseDouble(reader.readLine()));
		System.out.println(reader.readLine());
		
	int option = optionList();
	while (option !=0)
	{
	switch (option)
	{
	case 1: option = option1();
		break;
	case 2: option = option2();
		break;
	case 3: option = option3();
		break;
	case 4: option = option4();
		break;
	case 5: option = option5();
		break;
	case 6: option = option6();
		break;
	case 7: option = option7();
		break;
	case 8: option = option8();
		break;
	case 9: option = option9();
		break;
	case 10: option = option10();
		break;
	case 11: option = option11();
	break;
		default: System.out.println("Good bye!");
		option = 0;
	}
	
	}
	}
	
	public static int optionList() throws IOException
	{
		System.out.println("Select from the following menu: ");
		System.out.println("0. Exit.  \n" + 
                 "1. Award a loan at the bank. \n" + 
                 "2. Open a checking account at the bank. \n" + 
                 "3. Make a loan payment. \n" +
                 "4. Make a checking account transaction. \n " +
                 "5. Pay off a loan and close the account. \n" + 
                 "6. Withdraw balance and close a checking account. \n" +
                 "7. Change the interest rate on a loan. \n" +
                 "8. Update the assets of the bank. \n" +
                 "9. Display information about loans. \n" +
                 "10. Display information about checking accounts. \n" + 
                 "11. Display detailed bank information.\n \n");
		
		System.out.println("Make your selection now");
		return Integer.parseInt(reader.readLine().trim());
	}
	
	public static int optionChoice() throws IOException
	{
		System.out.println("Make your selection Now");
		return Integer.parseInt(reader.readLine().trim());
	}
	
	//CB OPTION 1 
	public static int option1() throws IOException
	{
		System.out.println("You are now awarding a new loan.");
		System.out.println("\tEnter the name of the customer: ");
		String name = reader.readLine().trim();
		
		if (bank.hasAccount(name))
		{
			System.out.println("Customer already has a loan.");

		}
		else
		{
			//CB get more info about customer to create a customer account
			System.out.println("\tEnter the city of the customer:");
			String city = reader.readLine();
			Customer customer = new Customer (name, city);
		
			System.out.println("\tEnter the initial amount of the loan: ");
			double amount = Double.parseDouble(reader.readLine().trim());
			
			System.out.println("\tEnter the interest rate of the loan: ");
			double interestRate = Double.parseDouble(reader.readLine().trim());
		
			LoanAccount loan = new LoanAccount(customer, amount, interestRate);
		
			bank.addAccount(loan);
		
			System.out.println("Congratulations " + customer.getName() + 
					"! \nYou have been awarded a loan for " + loan.getBalance() + ".");
		}
		System.out.println( "\n");
		int option = optionChoice();
		return option;
	}
	
	//CB OPTION 2
	public static int option2() throws IOException
	{
		System.out.println("You are now opening a new checking account.");
		System.out.println("\tEnter the name of the customer: ");
		String name = reader.readLine().trim();
		if (bank.hasAccount(name))
		{
			System.out.println("Customer already has a checking account.");
		}
		else
		{
			System.out.println("\tEnter the city of the customer: ");
			String city = reader.readLine().trim();
		
			Customer customer = new Customer (name, city);
			System.out.println("\tEnter the initial amount of deposit, must be over $100.00");
			double input = Double.parseDouble(reader.readLine());
			while (input < 100)
			{
				System.out.println("Checking account must be over $100.00 at all times,\n" + 
		                       "please enter a valid input");
				input = Double.parseDouble(reader.readLine());
			}
			
			CheckingAccount checkingAccount = new CheckingAccount(customer, input);
			bank.addAccount(checkingAccount);
			System.out.println("Congrats! \nYou have a new checking account, " + 
							customer.getName()+".");
		}
		System.out.println("\n");
		int option = optionChoice();
		return option;
	}
	
	//CB OPTION 3
	public static int option3() throws IOException
	{
		System.out.println("\tEnter the name of the customer: ");
		String customerName = reader.readLine().trim();
		
		//CB if a loan exists in the person's name
		if (bank.hasAccount(customerName) &&  bank.isLoan(bank.getAccountIndex(customerName)))
		{
			System.out.println("\tEnter the payment amount for the loan");
			double payment = Double.parseDouble(reader.readLine());
			
			//CB chain - 		
			bank.getLoan(customerName).makePayment(payment);		
		}
		else 
		{
			System.out.println("Customer does not have a loan.");
		}
		
		System.out.println("\n");
		 
		return optionChoice();
	}
	
	public static int option4() throws IOException
	{
		System.out.println("Enter the name of the customer: ");
		String customerName = reader.readLine().trim();
		if(bank.hasAccount(customerName))
		{
			System.out.println("Please enter the amount \n" +
										"you would like to withdrawal");
			double withdrawal = Double.parseDouble(reader.readLine());
					
			//CB this 'while' statement does not allow a user to take out more 
			//CB than what would leave user with a valid amount of money
					
			if (bank.getCheckingAccount(customerName).getBalance() < (withdrawal + 100))
			{
				System.out.println("Insufficient Funds: ");
				System.out.printf("Your checking account holds $%.2f.\n ", 
							bank.getCheckingAccount(customerName).getBalance());
				System.out.println("\tYour account has a minimum balance of $100.00");
			}
			else
			{
			bank.getCheckingAccount(customerName).makeTransaction(-1*withdrawal);
			}		
		}
		else
		{
			System.out.println("Customer does not have a checking account.");	
		}
		System.out.println();
		return optionChoice();
	}
	
	//CB option 5 is for paying off and closing a loan
	public static int option5() throws IOException
	{
		System.out.println("\tEnter the name of the customer: ");
		String customerName = reader.readLine().trim();
		
		if (bank.hasAccount(customerName) && 
				bank.isLoan(bank.getAccountIndex(customerName)))
		{
			bank.removeAccount(customerName);
			System.out.println("Customer " + customerName + "'s loan has been paid"
					+ "off and loan account closed.");
		}
		else
		{
			System.out.println("Customer does not have a loan to pay off");
		}
		System.out.println();
		return optionChoice();
	}
	
	//CB option 6 is to withdraw a balance and close a checking account
	public static int option6() throws IOException
	{
		System.out.println("/tEnter the name of the customer: ");
		String customerName = reader.readLine();
		
		if (bank.hasAccount(customerName) && 
				!bank.isLoan(bank.getAccountIndex(customerName)))
		{
			bank.removeAccount(customerName);
			System.out.println("Customer " + customerName + "'s checking account"
					+ "closed and balance withdrawn.");
		}
		else
		{
			System.out.println("Customer does not have a checking account to close.");
		}
		
		System.out.println();
		return optionChoice();
	}
	
	//CB this method is to change the interest rate on a loan
	public static int option7() throws IOException
	{
		System.out.print("\tEnter the name of the customer: ");
		String customerName = reader.readLine();
		
		if (bank.hasAccount(customerName))
		{
			System.out.println("\tEnter new interest rate:");
			bank.getLoan(customerName)
			.changeIntRate(Double.parseDouble(reader.readLine().trim()));
			
			//bank.updateIntRate(customerName,(Double.parseDouble(reader.readLine().trim())));
		}
		else
		{
			System.out.println("Customer does not have a loan.");
		}	
		System.out.println();
		return optionChoice();
	}
	
	//CB option8 updates the assets of the bank
	public static int option8() throws IOException
	{
		System.out.println("\tEnter new amount for bank assets");
		if (Double.parseDouble(reader.readLine()) >= 0)
		{
			bank.updateAssets(Double.parseDouble(reader.readLine()));
		}
		else
		{
			System.out.println("Invalid input.");
		}
		System.out.println();
		return optionChoice();
	}
	
	//CB option 9 prints the sum & average of loans
	public static int option9() throws IOException
	{
		System.out.printf("Cumulative amount of loans: $%.2f \n", bank.sumTotalLoans());
		System.out.printf("Average amount of loan balance: $%.2f \n", bank.averageLoans());
		System.out.println();
		
		for (int i = 0; i < bank.getNumberOfAccounts(); i++)
		{
			if (bank.indexAccount(i) instanceof LoanAccount)
			{
				LoanAccount loanAccount = (LoanAccount) bank.indexAccount(i);
				System.out.println("Borrower " +loanAccount.getCustomer().getName() + 
								" residing in " + loanAccount.getCustomer().getCity() + 
								"\nAccount Number: " + loanAccount.getAccountNumber() + 
								"\nInitial Loan Amount: $" + loanAccount.getInitialBalance() + 
								"\nLoan Balance: $" + loanAccount.getBalance() + 
								"\nInterestRate: " + loanAccount.getIntRate() + "%");
				System.out.println();
			}
		}
		System.out.println();
		return optionChoice();
	}
	
	//CB option 10 displays info on checking accounts
	public static int option10() throws IOException
	{
		System.out.printf("Cumulative amount of Checking Accountss: $%.2f \n", bank.sumTotalCheckingAccounts());
		System.out.printf("Average Checking Account balance: $%.2f \n", bank.averageCheckingAccounts());
		System.out.println();
		
		for (int i = 0; i < bank.getNumberOfAccounts(); i++)
		{
			if (bank.indexAccount(i) instanceof CheckingAccount)
			{
				CheckingAccount checkingAccount = (CheckingAccount) bank.indexAccount(i);
				System.out.println("Depositer " +checkingAccount.getCustomer().getName() + 
								" residing in " + checkingAccount.getCustomer().getCity() + 
								"\nAccount Number: " + checkingAccount.getAccountNumber() + 
								"\nAccount Balance: $" + checkingAccount.getBalance());
				System.out.println();
			}
		}
		System.out.println();
		return optionChoice();
	}
	
	//CB option 11 displays all of the bank's account info
	public static int option11() throws IOException
	{
		System.out.println("Bank" + bank.getBankName() + 
				" in " + bank.getBankCity() + "($" + bank.getAssets() + " in assets)\nhas" +
				bank.getNumTotalLoans() + " loan and " + bank.getNumCheckingAccounts());
		System.out.println("Cumulative amount of loans: $" + bank.sumTotalLoans());
		System.out.println("Average amount of loan balance: $" + bank.averageLoans());
		System.out.println("Average amount of balances: $" + bank.averageCheckingAccounts());
		
		
		System.out.println();
		
		System.out.println(bank.toString());

		
		System.out.println();
		return optionChoice();
	}
}
