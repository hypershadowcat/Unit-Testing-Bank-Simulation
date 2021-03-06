package UnitTestingBankSimulation;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/// Written by Juliet Mercado & Craig Anderson

public class TestSavingsAccount {

	Bank testBank;
	Customer testCustomer;
	SavingsAccount testSavings;
	final String bankName = "Test Name";
	final String lastName = "Anderson";
	final String firstName = "Craig";
	final double initialBalance = 800.23;
	final double rate = 2.1;
	final String description = "Test Description";

	@Before
	public void init() {
		// Creates Bank object
		testBank = new Bank(bankName);
		// Creates Customer object
		testCustomer = new Customer(testBank, lastName, firstName);
		// Creates Saving Account object
		testSavings = new SavingsAccount(testCustomer, initialBalance, description);
	}

	@Test
	public void testSavingsAccount() {
		// Tests there is a saving account
		assertNotNull(testSavings);
		// Check descriptions
		assertEquals(testSavings.getAccountDescription(), description);
		// Checks initial balance
		assertNotNull(initialBalance);
	}

	@Test
	public void testAddInterest() {
		testSavings.addInterestTransaction(rate);
		assertNotNull(rate);
	}
}
