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
}