package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import model.Account;
import model.Transaction;

public class AccountController {

	/**
	 * Loads the initial account data for the application.
	 * @return A Vector containing the loaded Account objects.
	 */
	public static Vector<Account> loadAccountData() {
		Vector<Account> accounts = new Vector<Account>();
		try {
			// structure: account number, username (email), account type, account_opening_date
			accounts.add(new Account("5495-1234", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019")));
			accounts.add(new Account("5495-1239", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020")));
			accounts.add(new Account("5495-1291", "mike", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2019")));
			accounts.add(new Account("5495-6789", "David.McDonald@gmail.com", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019")));

		} catch (ParseException e) {			
			e.printStackTrace();
		}  
		return accounts;
	}

	/**
	 * Creates a new transaction based on the provided details.
	 * Notice this now RETURNS a Transaction object so the main app can add it to its list.
	 * * @param account_number
	 * @param amount
	 * @return The newly created Transaction
	 */
	public static Transaction addTransaction(String account_number, double amount) { 
		Transaction aTransaction = new Transaction(account_number, amount, Calendar.getInstance().getTime());
		return aTransaction;
	}

	/**
	 * Calculates the balance of a given account. 
	 * Notice we must now PASS the transactions Vector into this method, 
	 * as the Controller does not hold the global list of transactions.
	 * * @param account_number
	 * @param transactions The current list of all transactions in the system
	 * @return A double value, being the balance of the account
	 */
	public static double getBalance(String account_number, Vector<Transaction> transactions) {
		double currentBalance = 0;
		for (int i = 0; i < transactions.size(); i++) {
			Transaction tempTransaction = transactions.get(i);
			String tempAccountNumber = tempTransaction.getAccount_number();
			
			if (tempAccountNumber.compareTo(account_number) == 0) {
				double amountToAdd = tempTransaction.getTransaction_amount();
				currentBalance = currentBalance + amountToAdd;
			}
		}
		
		int tempIntBalance = (int) (currentBalance * 100.00);
		double finalBalance = tempIntBalance / 100.00;
		return finalBalance;
	}
}
