package tests;


import model.Transaction;
import java.util.*;

public class TransactionTest {

	public static void main(String[] args) {
		testTransactionConstructor();
		testTransactionSetters();

	}
	
	public static void testTransactionConstructor() {
        String testAccountNumber = "1234";
        double testAmount = 100.00;
        Date testDate = new Date();

        
        Transaction testTrans = new Transaction(testAccountNumber, testAmount, testDate);

        String test_case_name = "TC1-getAccount_number";
        
        if (testTrans.getAccount_number().equals(testAccountNumber)) {
            utils.TestUtils.printTestPassed(test_case_name);
        } else {
        	utils.TestUtils.printTestFailed(test_case_name);
        }
        
        test_case_name = "TC2-getTransaction_amount";

        if (testTrans.getTransaction_amount() == testAmount) {
        	utils.TestUtils.printTestPassed(test_case_name);
        } else {
        	utils.TestUtils.printTestFailed(test_case_name);
        }
        
        test_case_name = "TC3-getTransaction_Date";

        if (testTrans.getTransaction_date().equals(testDate)) {
        	utils.TestUtils.printTestPassed(test_case_name);
        } else {
        	utils.TestUtils.printTestFailed(test_case_name);
        }

       
    }
	
	public static void testTransactionSetters() {
	    Transaction testTransaction = new Transaction("0", 0.0, new Date());
	    
	    String test_account_number = "1234";
	    double test_transaction_amount = 100.00;
	    Date test_transaction_date = new java.util.GregorianCalendar(2026, java.util.Calendar.FEBRUARY, 8).getTime();

	    testTransaction.setAccount_number(test_account_number);
	    testTransaction.setTransaction_amount(test_transaction_amount);
	    testTransaction.setTransaction_date(test_transaction_date);
	    
	    System.out.println("Starting the assertions of the test method: testTransactionSetters");
	    
	    String test_case_name = "TC5-setAccount_number / getAccount_number";
	    if (testTransaction.getAccount_number().equals(test_account_number)) {
	        utils.TestUtils.printTestPassed(test_case_name);
	    } else {
	        utils.TestUtils.printTestFailed(test_case_name);
	    }
	    
	    test_case_name = "TC6-setTransaction_amount / getTransaction_amount";
	    if (testTransaction.getTransaction_amount() == test_transaction_amount) {
	        utils.TestUtils.printTestPassed(test_case_name);
	    } else {
	        utils.TestUtils.printTestFailed(test_case_name);
	    }
	    
	    test_case_name = "TC7-setTransaction_date / getTransaction_date";
	    if (testTransaction.getTransaction_date().equals(test_transaction_date)) {
	        utils.TestUtils.printTestPassed(test_case_name);
	    } else {
	        utils.TestUtils.printTestFailed(test_case_name);
	    }
	}

	

}
