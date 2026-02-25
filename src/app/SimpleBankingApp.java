package app;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import controller.AccountController;
import controller.UserController;
import model.Account;
import model.Transaction;
import model.User;

public class SimpleBankingApp {
	public static Vector<User> users = new Vector<User>();
	public static Vector<Account> accounts  = new Vector<Account>();
	public static Vector<Transaction> transactions =  new Vector<Transaction>();
	
//	public static void loadUserData() {
//		// structure of each record: username (email address), password, first_name, last_name, mobile_number
//		
//		// in the ideal case (real deployment of the app), we will read from file or database, but let's hard-code for now
//		User aUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
//		users.add(aUser);
//		
//		aUser = new User("james.cameron@gmail.com", "angel", "James", "Cameron",  "07777654321");
//		users.add(aUser);
//		
//		aUser = new User("julia.roberts@gmail.com", "change_me",   "Julia", "roberts",   "07770123456");
//		users.add(aUser); 
//		
//	}
	
	public static void printAllUsers() {
//		System.out.println("There are: " + users.size() + " users in the system.");	
//		System.out.println(String.format("%-25s| %-15s| %-15s| %-15s| %-15s", 
//				"username", "password", "first_name", "last_name", "mobile_number"));
//		System.out.println("-------------------------------------------------------------------------------------------");
//		for  (int i = 0; i < users.size(); i++) 
//            System.out.println(users.get(i).toString());	
//		System.out.println();
//	}
		System.out.println("There are: " + users.size() + " users in the system.");	
		System.out.println(String.format("%-25s| %-15s| %-15s| %-15s| %-15s", 
				"username", "password", "first_name", "last_name", "mobile_number"));
		System.out.println("-------------------------------------------------------------------------------------------");
		
		for (int i = 0; i < users.size(); i++) {
			User u = users.get(i);
			// Format the data retrieved from the getters to match the header columns
			System.out.println(String.format("%-25s| %-15s| %-15s| %-15s| %-15s", 
					u.getUsername(), u.getPassword(), u.getFirst_name(), u.getLast_name(), u.getMobile_number()));	
		}
		System.out.println();
	}
	
//	public static void loadAccountData()  {
//		// structure of each record: 
//		// account number, username (email) of account holder, account type (Standard or Saving), account_opening_date
//
//		// in the ideal case, we will read from file or database, but let's hard-code for now
//		Account anAccount;
//		try {
//			anAccount = new Account("5495-1234", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
//			accounts.add(anAccount);
//			
//			anAccount = new Account("5495-1239", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
//			accounts.add(anAccount);
//
//			anAccount = new Account("5495-1291", "mike", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2019"));
//			accounts.add(anAccount);
//
//			anAccount = new Account("5495-6789", "David.McDonald@gmail.com", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
//			accounts.add(anAccount);
//
//		} catch (ParseException e) {			
//			e.printStackTrace();
//		}  
//	}
	
	public static void printAllAccounts() {
		System.out.println("There are: " + accounts.size() + " accounts in the system.");
		System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| %-15s", 
				"Account #", "username_of_account_holder", "type", "opening_date", "Balance"));
		System.out.println("--------------------------------------------------------------------------------");
		
		// Create the date formatter here in the presentation layer
		SimpleDateFormat sdf = new SimpleDateFormat("(MMM dd, yyyy)");
		
		for (int i = 0; i < accounts.size(); i++) {
			Account a = accounts.get(i);
			String formattedDate = sdf.format(a.getAccount_opening_date());
			
			// Format the account details to align with the headers
			String formattedAccountInfo = String.format("%-10s| %-30s| %-10s| %-15s", 
					a.getAccount_number(), a.getUsername_of_account_holder(), a.getAccount_type(), formattedDate);
			
			// FIX: Call getBalance from AccountController and pass the transactions Vector!
			double accountBalance = AccountController.getBalance(a.getAccount_number(), transactions);
			System.out.println(formattedAccountInfo + "| $" + accountBalance);
		}
		System.out.println();
	}
	
//	public static void addTransaction(String account_number, double amount) { 
//		Transaction aTransaction =  new Transaction(account_number, amount, Calendar.getInstance().getTime());
//		transactions.add(aTransaction);
//	}
	
	/**
	 * Calculate the balance of a given account (by its number). To do that, it needs to go over all transactions
	 * that match the account and get their sum total. For example, if an account has only two transactions in the 
	 * system, with values = $10.79 and $-140, the balance would be $-129.21
	 * 
	 * @param account_number
	 * @return A double value, being the balance of the account
	 */
//	public static double getBalance(String account_number) {
//		double currentBalance = 0;
//		for (int i = 0; i<transactions.size(); i++) {
//			Transaction tempTransaction = transactions.get(i);
//			String tempAccountNumber = tempTransaction.getAccount_number();
//			if (tempAccountNumber.compareTo(account_number)== 0) {
//				double amountToAdd = tempTransaction.getTransaction_amount();
//				currentBalance = currentBalance + amountToAdd;
//				
//			}else {
//				continue;
//			}
//		}
//		int tempIntBalance = (int) (currentBalance * 100.00);
//		double finalBalance = tempIntBalance / 100.00;
//		return finalBalance;
//		
//	}
	
	
	//////////////////////////////////////////////////////
	// Inside your SimpleBankingApp class...

	public static void main(String[] args) {
	    // 1. Ask the UserController for the data, and store it in our local Vector
	    users = UserController.loadUserData();
	    printAllUsers();
	    
	    // 2. Ask the AccountController for the data, and store it
	    accounts = AccountController.loadAccountData();
	    System.out.println("Accounts: initial state, after loading...");
	    printAllAccounts(); // Note: You'll need to update printAllAccounts to pass 'transactions' into getBalance()!
	    
	    // 3. To add a transaction, ask the controller to make it, then add it to our list
	    transactions.add(AccountController.addTransaction("5495-1234", -50.21));
	    System.out.println("Account: after the 1st addTransaction function call...");
	    printAllAccounts();
	}
}