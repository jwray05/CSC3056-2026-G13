package tests;

import app.SimpleBankingApp;
import utils.TestUtils;

public class SimpleBankingAppTest {

    
	// system under test (SUT):
	//static SimpleBankingApp mainApp = new SimpleBankingApp ();

	// this test method (test case) verifies if the data load feature of the class (unit or component) 
	// under test (UUT) works properly
	public static void testLoadData() {
		// Reminder: the classical Four-Phase test pattern (Setup-Exercise-Verify-Teardown
		// http://xunitpatterns.com/Four%20Phase%20Test.html 
		
		// 1-Setup phase: none
		
		// 2-Exercise phase
		SimpleBankingApp.loadUserData();

		// 3-Verify phase
		// we see in the load function of the UUT that we have loaded 3 users, so let's verify that
		if (SimpleBankingApp.users.size() == 3)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadUserData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadUserData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);

		// The above only verification is basic (simple, weak) 
		// To do STRONGER verification, we would need more assertions for user names and account balances, etc.
		
		SimpleBankingApp.loadAccountData();
		if (SimpleBankingApp.accounts.size() == 4)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadAccountData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadAccountData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		// 4-Teardown phase: if our goal was to only test the load, as Teardown (mainApp.accounts)
		// we would have deleted the loaded deleted from memory (variables users, and accounts), but we want
		// to use those data in the other tests, thus, we do not do any Teardown in this test case
	}
	
	// this test method (test case) verifies if the Deposit feature works properly
	public static void testDeposits() {
		// 1-Setup phase
		double balanceBefore = SimpleBankingApp.getBalance("5495-1234"); 
		double depositAmount = 50.21;
		
		// 2-Exercise phase
		SimpleBankingApp.addTransaction("5495-1234", depositAmount);
		double balanceAfter = SimpleBankingApp.getBalance("5495-1234");
		
		// 3-verify
		assert balanceBefore + depositAmount == balanceAfter;
		if (balanceBefore + depositAmount == balanceAfter)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testDeposits: TC1 passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED XXX: balanceBefore + depositAmount != balanceAfter");
			System.out.format("testDeposits: balanceBefore = %.2f ; depositAmount = %.2f ; balanceAfter = %.2f %s\n", 
					balanceBefore , depositAmount , balanceAfter, TestUtils.TEXT_COLOR_RESET);
		}
		
		// 4-tear-down: put the system state back in where it was
		// read more about the tear-down phase of test cases: http://xunitpatterns.com/Four%20Phase%20Test.html
		SimpleBankingApp.addTransaction("5495-1234", -depositAmount);
	}

	 
		// this test method (test case) verifies if the Withdraw feature works properly
		public static void testWithdrawals() {
			// 1-Setup phase
			String prefix = "5495";
			String hyphen = "-";
			String suffix = "1234";
			String testAccount = new String(prefix.concat(hyphen).concat(suffix));
			Double balanceBeforeObj = Double.valueOf(SimpleBankingApp.getBalance(testAccount));
			double balanceBefore = balanceBeforeObj.doubleValue();
			double withdrawalAmount = 0.00; 
			withdrawalAmount = withdrawalAmount + 50.00;
			withdrawalAmount = withdrawalAmount + 0.21;
			
			// 2-Exercise phase
			double amountToDeduct = withdrawalAmount * -1.0;
			SimpleBankingApp.addTransaction(testAccount, amountToDeduct);
			Double balanceAfterObj = Double.valueOf(SimpleBankingApp.getBalance(testAccount));
			double balanceAfter = balanceAfterObj.doubleValue();
			
			// 3-Verify phase
			double expectedBalance = balanceBefore - withdrawalAmount;
			boolean isMatch = false;
			if (Double.compare(expectedBalance, balanceAfter) == 0) {
				isMatch = true;
			}
			
			assert isMatch == true;
			
			if (isMatch == true) {
				String successMsg = "testWithdrawals: TC1 passed";
				System.out.println(TestUtils.TEXT_COLOR_GREEN + successMsg + TestUtils.TEXT_COLOR_RESET);
			} else {
				String failMsg = "testWithdrawals: TC1 FAILED XXX: balanceBefore - withdrawalAmount != balanceAfter";
				System.out.println(TestUtils.TEXT_COLOR_RED + failMsg);
				String errorDetails = String.format("testWithdrawals: balanceBefore = %.2f ; withdrawalAmount = %.2f ; balanceAfter = %.2f %s\n", 
						balanceBefore, withdrawalAmount, balanceAfter, TestUtils.TEXT_COLOR_RESET);
				System.out.print(errorDetails);
			}
			
			// 4-Teardown phase
			double restoreAmount = amountToDeduct * -1.0;
			SimpleBankingApp.addTransaction(testAccount, restoreAmount);
		
	}
	
	
	public static void main(String[] args) {
		// we need to call our test cases (methods)
		testLoadData();
		testDeposits();
		// testWithdrawals(); -- uncomment this call, when you have developed the test method (test case)
	}

}
