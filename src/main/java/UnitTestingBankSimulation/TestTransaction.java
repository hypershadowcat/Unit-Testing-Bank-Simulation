package UnitTestingBankSimulation;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class TestTransaction {
	
	Bank testBank;
	Customer testCustomer;
	SavingsAccount testSavings;
	Transaction testTransaction;
	final String bankName = "Test Name";
	final String lastName = "Anderson";
	final String firstName = "Craig";
	final double initialBalance = 800.23;
	final double rate = 2.1;
	final String description = "Test Description";
	
	final int id;
    final LocalDateTime timestamp;
    final TransactionType type;
    final double amount;
    final String description;
	
	@Before
	public void init() {
		// Creates Bank object
		testBank = new Bank(bankName);
		// Creates Customer object
		testCustomer = new Customer(testBank, lastName, firstName);
		// Creates Saving Account object
		testSavings = new SavingsAccount(testCustomer, initialBalance, description);
		// Creates Transaction object
		testTransaction = new Transaction();
		
	}

}
