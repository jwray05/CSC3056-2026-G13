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
		// 1-Setup phase: Create an empty transaction list for testing
		Vector<Transaction> testTransactions = new Vector<>();
		String testAccount = "5495-1234";
		double balanceBefore = AccountController.getBalance(testAccount, testTransactions); 
		double depositAmount = 50.21;
		
		// 2-Exercise phase: Add a transaction to our test list
		testTransactions.add(AccountController.addTransaction(testAccount, depositAmount));
		double balanceAfter = AccountController.getBalance(testAccount, testTransactions);
		
		// 3-Verify
		assert balanceBefore + depositAmount == balanceAfter;
		if (balanceBefore + depositAmount == balanceAfter) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testDeposits: TC1 passed"+ TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED");
		}
	}

	public static void testWithdrawals() {
		// 1-Setup phase
		Vector<Transaction> testTransactions = new Vector<>();
		String testAccount = "5495-1234";
		double balanceBefore = AccountController.getBalance(testAccount, testTransactions); 
		double withdrawalAmount = 50.21; 
		
		// 2-Exercise phase (Negative amount for withdrawal)
		testTransactions.add(AccountController.addTransaction(testAccount, -withdrawalAmount));
		double balanceAfter = AccountController.getBalance(testAccount, testTransactions);
		
		// 3-Verify phase
		assert balanceBefore - withdrawalAmount == balanceAfter;
		if (balanceBefore - withdrawalAmount == balanceAfter) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testWithdrawals: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testWithdrawals: TC1 FAILED");
		}
	}
}
