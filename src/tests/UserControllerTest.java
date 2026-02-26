package tests;

import java.util.Vector;
import controller.UserController;
import model.User;
import utils.TestUtils;

public class UserControllerTest {

	public static void testLoadUserData() {
		// 1-Setup & 2-Exercise phase
		Vector<User> testUsers = UserController.loadUserData();

		// 3-Verify phase
		if (testUsers.size() == 3) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadUserData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadUserData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
		}
	}
	
	public static void testRegisterUserInvalidEmail() {
		try {
			
			controller.UserController.registerUser("mike", "pass", "Mike", "Smith", "07771234567");
			
			
			System.out.println(utils.TestUtils.TEXT_COLOR_RED + "testRegisterUserInvalidEmail: TC1 FAILED (Allowed invalid email)" + utils.TestUtils.TEXT_COLOR_RESET);
		} catch (IllegalArgumentException e) {
		
			if (e.getMessage().contains("Username must be a valid email address")) {
				System.out.println(utils.TestUtils.TEXT_COLOR_GREEN + "testRegisterUserInvalidEmail: TC1 passed" + utils.TestUtils.TEXT_COLOR_RESET);
			} else {
				System.out.println(utils.TestUtils.TEXT_COLOR_RED + "testRegisterUserInvalidEmail: TC1 FAILED (Wrong exception message)" + utils.TestUtils.TEXT_COLOR_RESET);
			}
		}
	}
	
	public static void testRegisterUserValidEmail() {
		try {
			
			model.User newUser = controller.UserController.registerUser("mike@gmail.com", "pass", "Mike", "Smith", "07771234567");
			
			
			if (newUser != null && newUser.getUsername().equals("mike@gmail.com")) {
				System.out.println(utils.TestUtils.TEXT_COLOR_GREEN + "testRegisterUserValidEmail: TC1 passed" + utils.TestUtils.TEXT_COLOR_RESET);
			} else {
				System.out.println(utils.TestUtils.TEXT_COLOR_RED + "testRegisterUserValidEmail: TC1 FAILED" + utils.TestUtils.TEXT_COLOR_RESET);
			}
		} catch (Exception e) {
			System.out.println(utils.TestUtils.TEXT_COLOR_RED + "testRegisterUserValidEmail: TC1 FAILED with exception: " + e.getMessage() + utils.TestUtils.TEXT_COLOR_RESET);
		}
	}
}