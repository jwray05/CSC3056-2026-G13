package tests;

public class SimpleBankingAppTest {

	public static void main(String[] args) {
		
		System.out.println("--- Running User Tests ---");
		UserControllerTest.testLoadUserData();
		
		System.out.println("\n--- Running Account Tests ---");
		AccountControllerTest.testLoadAccountData();
		AccountControllerTest.testDeposits();
		AccountControllerTest.testWithdrawals(); 
		
		System.out.println("\nAll test suites completed.");
	}
}