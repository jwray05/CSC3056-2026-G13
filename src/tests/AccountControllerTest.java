package tests;

import java.util.Vector;
import controller.AccountController;
import model.Account;
import model.Transaction;
import utils.TestUtils;

public class AccountControllerTest {

	public static void testLoadAccountData() {
		Vector<Account> testAccounts = AccountController.loadAccountData();
		
		if (testAccounts.size() == 4) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadAccountData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadAccountData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
		}
	}
	
	public static void testDeposits() {
		// 1-Setup phase
		Vector<Transaction> testTransactions = new Vector<>();
		String testAccount = "5495-1234";
		double balanceBefore = AccountController.getBalance(testAccount, testTransactions); 
		double depositAmount = 50.21;
		
		try {
			// 2-Exercise phase
			
			testTransactions.add(AccountController.addTransaction(testAccount, depositAmount, testTransactions));
			double balanceAfter = AccountController.getBalance(testAccount, testTransactions);
			
			// 3-Verify
			if (balanceBefore + depositAmount == balanceAfter) {
				System.out.println(TestUtils.TEXT_COLOR_GREEN + "testDeposits: TC1 passed"+ TestUtils.TEXT_COLOR_RESET);
			} else {
				System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
			}
		} catch (Exception e) {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED with exception: " + e.getMessage() + TestUtils.TEXT_COLOR_RESET);
		}
	}

//	public static void testDeposits() {
//		// 1-Setup phase: Create an empty transaction list for testing
//		Vector<Transaction> testTransactions = new Vector<>();
//		String testAccount = "5495-1234";
//		double balanceBefore = AccountController.getBalance(testAccount, testTransactions); 
//		double depositAmount = 50.21;
//		
//		// 2-Exercise phase: Add a transaction to our test list
//		testTransactions.add(AccountController.addTransaction(testAccount, depositAmount));
//		double balanceAfter = AccountController.getBalance(testAccount, testTransactions);
//		
//		// 3-Verify
//		assert balanceBefore + depositAmount == balanceAfter;
//		if (balanceBefore + depositAmount == balanceAfter) {
//			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testDeposits: TC1 passed"+ TestUtils.TEXT_COLOR_RESET);
//		} else {
//			System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED");
//		}
//	}

//	public static void testWithdrawals() {
//		// 1-Setup phase
//		Vector<Transaction> testTransactions = new Vector<>();
//		String testAccount = "5495-1234";
//		double balanceBefore = AccountController.getBalance(testAccount, testTransactions); 
//		double withdrawalAmount = 50.21; 
//		
//		// 2-Exercise phase (Negative amount for withdrawal)
//		testTransactions.add(AccountController.addTransaction(testAccount, -withdrawalAmount));
//		double balanceAfter = AccountController.getBalance(testAccount, testTransactions);
//		
//		// 3-Verify phase
//		assert balanceBefore - withdrawalAmount == balanceAfter;
//		if (balanceBefore - withdrawalAmount == balanceAfter) {
//			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testWithdrawals: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
//		} else {
//			System.out.println(TestUtils.TEXT_COLOR_RED + "testWithdrawals: TC1 FAILED");
//		}
//	}
	
	public static void testWithdrawals() {
		// 1-Setup phase
		Vector<Transaction> testTransactions = new Vector<>();
		String testAccount = "5495-1234";
		
		try {
			
			testTransactions.add(AccountController.addTransaction(testAccount, 100.00, testTransactions));
			
			double balanceBefore = AccountController.getBalance(testAccount, testTransactions); 
			double withdrawalAmount = 50.21; 
			
			// 2-Exercise phase (Negative amount for withdrawal)
			testTransactions.add(AccountController.addTransaction(testAccount, -withdrawalAmount, testTransactions));
			double balanceAfter = AccountController.getBalance(testAccount, testTransactions);
			
			// 3-Verify phase
			if (Math.abs((balanceBefore - withdrawalAmount) - balanceAfter) < 0.01) { 
				System.out.println(TestUtils.TEXT_COLOR_GREEN + "testWithdrawals: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
			} else {
				System.out.println(TestUtils.TEXT_COLOR_RED + "testWithdrawals: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
			}
		} catch (Exception e) {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testWithdrawals: TC1 FAILED with exception: " + e.getMessage() + TestUtils.TEXT_COLOR_RESET);
		}
	}
		
		// NEW Improvement
		public static void testOverdraftPrevention() {
			// 1-Setup phase
			Vector<Transaction> testTransactions = new Vector<>();
			String testAccount = "5495-1234";
			
			try {
				
				testTransactions.add(AccountController.addTransaction(testAccount, 50.00, testTransactions));
				
				// 2-Exercise phase
				AccountController.addTransaction(testAccount, -60.00, testTransactions);
				
				
				System.out.println(TestUtils.TEXT_COLOR_RED + "testOverdraftPrevention: TC1 FAILED (Overdraft exception was not thrown)" + TestUtils.TEXT_COLOR_RESET);
				
			} catch (Exception e) {
				// 3-Verify phase
				if (e.getMessage().contains("Insufficient funds")) {
					System.out.println(TestUtils.TEXT_COLOR_GREEN + "testOverdraftPrevention: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
				} else {
					System.out.println(TestUtils.TEXT_COLOR_RED + "testOverdraftPrevention: TC1 FAILED (Threw an exception, but for the wrong reason)" + TestUtils.TEXT_COLOR_RESET);
				}
			}
		}
			
			public static void testCloseAccountWithNonZeroBalance() {
				Vector<Account> testAccounts = new Vector<>();
				testAccounts.add(new Account("5495-1234", "mike@gmail.com", "Standard", java.util.Calendar.getInstance().getTime()));
				
				Vector<Transaction> testTransactions = new Vector<>();
				
				try {
					
					testTransactions.add(AccountController.addTransaction("5495-1234", 10.0, testTransactions));
					
					
					AccountController.closeAccount("5495-1234", testAccounts, testTransactions);
					
					
					System.out.println(TestUtils.TEXT_COLOR_RED + "testCloseAccountWithNonZeroBalance: TC1 FAILED (Allowed closing with non-zero balance)" + TestUtils.TEXT_COLOR_RESET);
				} catch (Exception e) {
					
					if (e.getMessage().contains("Balance must be exactly £0.00")) {
						System.out.println(TestUtils.TEXT_COLOR_GREEN + "testCloseAccountWithNonZeroBalance: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
					} else {
						System.out.println(TestUtils.TEXT_COLOR_RED + "testCloseAccountWithNonZeroBalance: TC1 FAILED (Wrong exception message)" + TestUtils.TEXT_COLOR_RESET);
					}
				}
			}

			public static void testCloseAccountSuccess() {
				Vector<Account> testAccounts = new Vector<>();
				testAccounts.add(new Account("5495-6789", "mike@gmail.com", "Saving", java.util.Calendar.getInstance().getTime()));
				
				Vector<Transaction> testTransactions = new Vector<>(); 
				
				try {
				
					boolean result = AccountController.closeAccount("5495-6789", testAccounts, testTransactions);
	
					if (result && testAccounts.isEmpty()) {
						System.out.println(TestUtils.TEXT_COLOR_GREEN + "testCloseAccountSuccess: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
					} else {
						System.out.println(TestUtils.TEXT_COLOR_RED + "testCloseAccountSuccess: TC1 FAILED (Account not removed)" + TestUtils.TEXT_COLOR_RESET);
					}
				} catch (Exception e) {
					System.out.println(TestUtils.TEXT_COLOR_RED + "testCloseAccountSuccess: TC1 FAILED with exception: " + e.getMessage() + TestUtils.TEXT_COLOR_RESET);
				}
	}
}
