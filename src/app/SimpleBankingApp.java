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
		SimpleDateFormat sdf = new SimpleDateFormat("(MMM dd, yyyy)");
		
		for (int i = 0; i < accounts.size(); i++) {
			Account a = accounts.get(i);
			String formattedDate = sdf.format(a.getAccount_opening_date());
			
			String formattedAccountInfo = String.format("%-10s| %-30s| %-10s| %-15s", 
					a.getAccount_number(), a.getUsername_of_account_holder(), a.getAccount_type(), formattedDate);
			
			
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
	

	public static void main(String[] args) {
	    users = UserController.loadUserData();
	    
	    System.out.println("\n--- Testing User Registration ---");
	    
	    try {
	    	model.User validUser = UserController.registerUser("new.user@gmail.com", "secure123", "New", "User", "07779998888");
	    	users.add(validUser); 
	    	System.out.println("Successfully registered: " + validUser.getUsername());
	    } catch (IllegalArgumentException e) {
	    	System.out.println(e.getMessage());
	    }
	
	    try {
	    	System.out.println("Attempting to register user 'bad_email'...");
	    	model.User invalidUser = UserController.registerUser("bad_email", "password", "Bad", "Email", "0000");
	    	users.add(invalidUser);
	    } catch (IllegalArgumentException e) {
	    	System.out.println("Caught Expected Error: " + e.getMessage());
	    }
	    
	    System.out.println("\nUsers after registration attempts:");
	    printAllUsers();
	    System.out.println("---------------------------------\n");
	    
	    accounts = AccountController.loadAccountData();
	    System.out.println("Accounts: initial state, after loading...");
	    printAllAccounts(); 
	    
	    try {
	        transactions.add(AccountController.addTransaction("5495-1234", -50.21, transactions));
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    
	    System.out.println("Account: after the 1st addTransaction function call...");
	    printAllAccounts();
	    

	    System.out.println("\n--- Testing Account Closure ---");
	    

	    try {
	        System.out.println("Attempting to close account '5495-1239' (Balance is £0.0)...");
	        AccountController.closeAccount("5495-1239", accounts, transactions);
	        System.out.println("Successfully closed account 5495-1239.");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    

	    try {
	       
	        transactions.add(AccountController.addTransaction("5495-1291", 50.00, transactions));
	        
	        System.out.println("Attempting to close account '5495-1291' (Balance is £50.0)...");
	        AccountController.closeAccount("5495-1291", accounts, transactions);
	    } catch (Exception e) {
	        System.out.println("Caught Expected Error: " + e.getMessage());
	    }
	    
	    System.out.println("\nAccounts after closure attempts:");
	    printAllAccounts();
	    System.out.println("---------------------------------\n");
	    
	}
}