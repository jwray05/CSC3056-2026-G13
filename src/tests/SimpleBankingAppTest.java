package tests;

public class SimpleBankingAppTest {

	public static void main(String[] args) {
		
		System.out.println("--- Running User Tests ---");
		UserControllerTest.testLoadUserData();
		UserControllerTest.testRegisterUserInvalidEmail();
		UserControllerTest.testRegisterUserValidEmail();
		
		System.out.println("\n--- Running Account Tests ---");
		AccountControllerTest.testLoadAccountData();
		AccountControllerTest.testDeposits();
		AccountControllerTest.testWithdrawals(); 
		AccountControllerTest.testOverdraftPrevention();
		AccountControllerTest.testCloseAccountWithNonZeroBalance();
        AccountControllerTest.testCloseAccountSuccess();
		
		System.out.println("\nAll test suites completed.");
	}
}