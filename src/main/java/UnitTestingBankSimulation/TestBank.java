package UnitTestingBankSimulation;

import static org.junit.Assert.*;
import java.util.List;
import java.util.SortedSet;
import org.junit.*;

public class TestBank {

	Bank testBank;
	final String bankName = "Test Name";
	final String lastName = "Panchenko";
	final String firstName = "Ihor";
	String testCustomer_1, testCustomer_2;
	
	// Creates similar objects for tests which execute before the tests are run
	@Before
	public void init() {
		// Creates Bank object
		testBank = new Bank(bankName);
		
		// Adds two customers
		testCustomer_1 = testBank.addCustomer(lastName, firstName);
		testCustomer_2 = testBank.addCustomer(lastName, firstName);
	}

	// Bank constructor test
	@Test
	public void testBank() {
		// Asserts that the object isn't null. If it is an AssertionError is thrown
		assertNotNull(testBank); // when bank object exists -- true
		
		// Asserts that two objects are equal
		assertEquals(testBank.getNAME(), bankName); // when bank name is correct -- true
	}


}
