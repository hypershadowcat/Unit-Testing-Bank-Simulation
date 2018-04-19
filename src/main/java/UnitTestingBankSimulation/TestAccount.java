package UnitTestingBankSimulation;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

// Written by Juliet Mercado & Craig Anderson

public class TestAccount {

	Bank testBank;
	Customer testCustomer;
	SavingsAccount testAccount;
	
	final String bankName = "testBank";
	final String lastName = "Mercado";
	final String firstName = "Juliet";
	final double testBalance = 234.56;
	final String description = "testDescription";
	
	@Before
	public void init() {
		// Makes Bank object
		testBank = new Bank(bankName);
		// Makes Customer object
		testCustomer = new Customer(testBank, lastName, firstName);
		// Creates Saving Account object
		testAccount = new SavingsAccount(testCustomer, testBalance, description);
	}
	
	@Test
	public void testAccount() {
		// Tests that account exists
		assertNotNull(testAccount);
		// Verifies there is a description
		assertEquals(testAccount.getAccountDescription(), description);
		// Test that balance exists
		assertNotNull(testBalance);
	}
	
	@Test
	public void testCustomer() {
		// Tests that customer exists
		assertNotNull(testCustomer);
		// Verifies there is a last name
		assertEquals(testCustomer.getLastName(), lastName);
		// Verifies there is a first name
		assertEquals(testCustomer.getFirstName(), firstName);
	}
	
	@Test
	public void testDeposit() {
		// Temp Var to make deposit
		double newBalance = testBalance + 267.91;
		// make deposit
		testAccount.deposit(267.91);
		// Checks that deposit was done correctly
		assertTrue(testAccount.getBalance() == newBalance);
	}
	
	@Test
	public void testWithdraw() {
		// Temp Var to make withdraw
		double newBalance = testBalance - 167.91;
		// make withdraw
		testAccount.withdraw(167.91);
		// Checks that with was done correctly
		assertTrue(testAccount.getBalance() == newBalance);
	}
	
	@Test
	public void testTransfer(){
		// Create new import account to transfer balance
		SavingsAccount importAccount = new SavingsAccount(testCustomer, testBalance, description);
		// make withdraw from first account
		double newBalance = testBalance - 50.00;
		// make deposit to second account
		double newBalance2 = testBalance + 50.00;
		// Make transfer
		Account.transfer(testAccount, importAccount, 50.00);
		// Checks that transfer was done correctly
		assertTrue(testAccount.getBalance() == newBalance);
		assertTrue(importAccount.getBalance() == newBalance2);
	}
}