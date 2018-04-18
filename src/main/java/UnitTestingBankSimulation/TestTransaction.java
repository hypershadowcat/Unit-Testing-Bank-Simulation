package UnitTestingBankSimulation;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class TestTransaction {

	Transaction testTransaction;
	final double amount = 234.23;
	final String description = "Fuck You";

	@Test
	public void init() {

		// Creates Transaction object
		testTransaction = new Transaction(TransactionType.DEPOSIT, amount, description);
		// Checks that to make sure there is a transaction
		assertNotNull(testTransaction);
		// Checks there is a value in amount
		assertNotNull(amount);
		// Checking with actual description
		assertEquals(testTransaction.getDescription(), description);

	}

}
