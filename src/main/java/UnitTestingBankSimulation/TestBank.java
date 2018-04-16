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
	// Creates the customer list
	List<Customer> customerList = testBank.getCustomer(lastName, firstName);
	
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

	// Method getAllAccounts test
	@Test
	public void testGetAllAccounts() {
		final double accountBalance = 741.95;
		final String description = "Test description";
		// Creates the account in the set
		Account testAccount = new SavingsAccount(testBank.getCustomer(testCustomer_1),
				accountBalance, description);
		
		// Creates the accounts set
		SortedSet<Account> accountsSet = testBank.getAllAccounts();
		assertNotNull(accountsSet); // when Set exists -- true
		
		// Asserts that the first (lowest) element currently in this set and customer are equal
		assertEquals(accountsSet.first().getCustomerId(), testCustomer_1); // when 1st customerID is correct -- true
		assertEquals(accountsSet.first().getAccountDescription(), description); // when 1st description is correct -- true
		assertTrue(accountsSet.first().getBalance() == accountBalance); // when 1st balance is correct -- true
	}
	
	// Method addCustomer test
	@Test
	public void testAddCustomer() {
		assertNotNull(testCustomer_1); // when testCustomer_1 returned by the method -- true
	}

	// Method getCustomer test
	@Test
	public void testGetCustomer() {
		Customer customer = testBank.getCustomer(testCustomer_1);
		assertNotNull(customer); // when customer object exists -- true
		assertEquals(customer.getLastName(), lastName); // when last name is correct -- true
		assertEquals(customer.getFirstName(), firstName); // when last name is correct -- true
	}
	
	// Method getAllCustomers test
	@Test
	public void testGetAllCustomers() {
		// Creates the customer set
		SortedSet<Customer> customerSortedSet = testBank.getAllCustomers();
		assertNotNull(customerSortedSet);
		assertEquals(customerSortedSet.first().getLastName(), lastName);
		assertEquals(customerSortedSet.first().getFirstName(), firstName);
	}

	
}
