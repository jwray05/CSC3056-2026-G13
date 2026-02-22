package tests;


import model.User;
import utils.TestUtils;

public class UserTest {

	public static void main(String[] args) {
		
		testUserConstruction();
		
	}
	




public static void testUserConstruction() {
	/*
	User testUser = new User("mike", "my_password", "Mike", "Smith", "07771234567");
	
	System.out.println(testUser);
	*/
	
	//automated testing
	//1-Setup
	String test_username = "mike";
	String test_password = "my_password";
	String test_first_name = "Mike";
	String test_last_name = "Smith";
	String test_mobile_number = "07771234567";
	
	//2-Exercise, run the object under test (constructor)
	User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);
	
	//3-Verify (Assert)
	System.out.println("Starting the assertions of the test method: testUserConstructor");
	
	String test_case_name = "TC1-getUsername";
	
	if(testUser.getUsername().equals(test_username)) {
		utils.TestUtils.printTestPassed(test_case_name);
	}else {
		utils.TestUtils.printTestFailed(test_case_name);
	}
	
	test_case_name = "TC2-getPassword";
	
	if(testUser.getPassword().equals(test_password)) {
		utils.TestUtils.printTestPassed(test_case_name);
	}else {
		utils.TestUtils.printTestFailed(test_case_name);
	}
	
	test_case_name = "TC3-getFirstName";
	
	if(testUser.getFirst_name().equals(test_first_name)) {
		utils.TestUtils.printTestPassed(test_case_name);
	}else {
		utils.TestUtils.printTestFailed(test_case_name);
	}
	
	test_case_name = "TC4-getLastName";
	
	if(testUser.getLast_name().equals(test_last_name)) {
		utils.TestUtils.printTestPassed(test_case_name);
	}else {
		utils.TestUtils.printTestFailed(test_case_name);
	}
	
	test_case_name = "TC5-getMobileNumber";
	
	if(testUser.getMobile_number().equals(test_mobile_number)) {
		utils.TestUtils.printTestPassed(test_case_name);
	}else {
		utils.TestUtils.printTestFailed(test_case_name);
	}
	
	
	assert testUser.getUsername().equals(test_username):"TC1 Failed, Username mismatch";
	assert testUser.getPassword().equals(test_password):"TC2 Failed, Password mismatch";
	assert testUser.getFirst_name().equals(test_first_name):"TC3 Failed, First Name mismatch";
	assert testUser.getLast_name().equals(test_last_name):"TC4 Failed, Last Name mismatch";
	assert testUser.getMobile_number().equals(test_mobile_number):"TC5 Failed, Mobile Number mismatch";
	
	//assert(1==2);
	System.out.println("All java assertions in the test suite passed (none failed.)");
	
	
	/*
	if(testUser.getUsername() == test_username)
		System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed"+ TestUtils.TEXT_COLOR_RESET);
	else
		System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-Failed"+ TestUtils.TEXT_COLOR_RESET);
	
	
	if(testUser.getPassword() == test_password)
		System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword-Passed"+ TestUtils.TEXT_COLOR_RESET);
	else
		System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getPassword-Failed"+ TestUtils.TEXT_COLOR_RESET);
	
	
	if(testUser.getFirst_name() == test_first_name)
		System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getFirstName-Passed"+ TestUtils.TEXT_COLOR_RESET);
	else
		System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getFirstName-Failed"+ TestUtils.TEXT_COLOR_RESET);
	
	
	if(testUser.getLast_name() == test_last_name)
		System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getLastName-Passed"+ TestUtils.TEXT_COLOR_RESET);
	else
		System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getLastName-Failed"+ TestUtils.TEXT_COLOR_RESET);
	
	
	if(testUser.getMobile_number() == test_mobile_number)
		System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC5-getMobileNumber-Passed"+ TestUtils.TEXT_COLOR_RESET);
	else
		System.out.println(TestUtils.TEXT_COLOR_RED + "TC5-getMobileNumber-Failed"+ TestUtils.TEXT_COLOR_RESET);
}*/
	
}	

}
