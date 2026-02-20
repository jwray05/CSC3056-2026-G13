package tests;

import model.Account;

public class AccountTest {

	public static void main(String[] args) {
		Account testAccount = new Account("1234","mike","Saving",new java.util.GregorianCalendar(2026, java.util.Calendar.FEBRUARY, 18).getTime());

		System.out.println(testAccount);
	}

}
