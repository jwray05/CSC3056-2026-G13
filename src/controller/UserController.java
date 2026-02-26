package controller;

import java.util.Vector;
import model.User;

public class UserController {
	
	/**
	 * Loads the initial user data for the application.
	 * In a real deployment, this would read from a database or file.
	 * * @return A Vector containing the loaded User objects.
	 */
	public static Vector<User> loadUserData() {
		Vector<User> users = new Vector<User>();
		
		// structure of each record: username (email address), password, first_name, last_name, mobile_number
		User aUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
		users.add(aUser);
		
		aUser = new User("james.cameron@gmail.com", "angel", "James", "Cameron",  "07777654321");
		users.add(aUser);
		
		aUser = new User("julia.roberts@gmail.com", "change_me",   "Julia", "roberts",   "07770123456");
		users.add(aUser); 
		
		return users;
	}
	
	public static User registerUser(String email, String password, String firstName, String lastName, String mobileNumber) {
		
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,6}$";
		
		if (!email.matches(emailRegex)) {
			throw new IllegalArgumentException("Registration Failed: Username must be a valid email address.");
		}
		
		return new User(email, password, firstName, lastName, mobileNumber);
	}
	
}