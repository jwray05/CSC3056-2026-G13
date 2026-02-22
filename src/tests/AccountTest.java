package tests;

import model.Account;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AccountTest {

	public static void main(String[] args) {
		
		
		testAccountSetters();
		testAccountConstruction();
		
	}


	public static void testAccountConstruction() {
		
		String test_account_number = "1234";
		String test_username_of_account_holder = "mike";
		String test_account_type = "Saving";
		Date test_account_opening_date = new java.util.GregorianCalendar(2026, java.util.Calendar.FEBRUARY, 18).getTime();
		
		Account testAccount = new Account(test_account_number,test_username_of_account_holder,test_account_type, test_account_opening_date);
		
		//3-Verify (Assert)
		System.out.println("Starting the assertions of the test method: testUserConstructor");
		
		String test_case_name = "TC1-getAccount_number";
		
		if(testAccount.getAccount_number().equals(test_account_number)) {
			utils.TestUtils.printTestPassed(test_case_name);
		}else {
			utils.TestUtils.printTestFailed(test_case_name);
		}
		
		test_case_name = "TC2-getUsername_of_account_holder";
		
		if(testAccount.getUsername_of_account_holder().equals(test_username_of_account_holder)) {
			utils.TestUtils.printTestPassed(test_case_name);
		}else {
			utils.TestUtils.printTestFailed(test_case_name);
		}
		
		test_case_name = "TC3-getAccount_type";
		
		if(testAccount.getAccount_type().equals(test_account_type)) {
			utils.TestUtils.printTestPassed(test_case_name);
		}else {
			utils.TestUtils.printTestFailed(test_case_name);
		}

		test_case_name = "TC4-getAccount_opening_date";
		
		if(testAccount.getAccount_opening_date().equals(test_account_opening_date)) {
			utils.TestUtils.printTestPassed(test_case_name);
		}else {
			utils.TestUtils.printTestFailed(test_case_name);
		}
	}
	
	public static void testAccountSetters() {
		Account testAccount = new Account("0","temporary","Standard",new java.util.GregorianCalendar(2026, java.util.Calendar.FEBRUARY, 1).getTime());
		
		String test_account_number = "1234";
	    String test_username_of_account_holder = "michael";
	    String test_account_type = "Saving";
	    Date test_account_opening_date = new java.util.GregorianCalendar(2026, java.util.Calendar.FEBRUARY, 8).getTime();

	   
	    testAccount.setAccount_number(test_account_number);
	    testAccount.setUsername_of_account_holder(test_username_of_account_holder);
	    testAccount.setAccount_type(test_account_type);
	    testAccount.setAccount_opening_date(test_account_opening_date);
	    
	    
	    System.out.println("Starting the assertions of the test method: testAccountSetters");
	    
	    String test_case_name = "TC1-setAccount_number / getAccount_number";
	    if(testAccount.getAccount_number().equals(test_account_number)) {
	        utils.TestUtils.printTestPassed(test_case_name);
	    }else {
	        utils.TestUtils.printTestFailed(test_case_name);
	    }
	    
	    test_case_name = "TC2-setUsername_of_account_holder / getUsername_of_account_holder";
	    if(testAccount.getUsername_of_account_holder().equals(test_username_of_account_holder)) {
	    	utils.TestUtils.printTestPassed(test_case_name);
	    }else {
	        utils.TestUtils.printTestFailed(test_case_name);
	    }
	    
	    test_case_name = "TC3-setAccount_type / getAccount_type";
	    if(testAccount.getAccount_type().equals(test_account_type)) {
	        utils.TestUtils.printTestPassed(test_case_name);
	    }else {
	       utils.TestUtils.printTestFailed(test_case_name);
	    }

	    test_case_name = "TC4-setAccount_opening_date / getAccount_opening_date";
	    if(testAccount.getAccount_opening_date().equals(test_account_opening_date)) {
	        utils.TestUtils.printTestPassed(test_case_name);
	    }else {
	        utils.TestUtils.printTestFailed(test_case_name);
	    }
	    
	}
}

