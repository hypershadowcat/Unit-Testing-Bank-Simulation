package UnitTestingBankSimulation;

import static org.junit.Assert.*;
import java.util.List;
import java.util.SortedSet;
import org.junit.*;

// Written by Ihor Panchenko, 2018
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

	// Test for Bank constructor
	@Test
	public void testBank() {
		// Asserts that the object isn't null. If it is an AssertionError is thrown
		assertNotNull(testBank); // when bank object exists -- true
		
		// Asserts that two objects are equal
		assertEquals(testBank.getNAME(), bankName); // when bank name is correct -- true
	}

	// Test for getAllAccounts method
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
	
	// Test for addCustomer method
	@Test
	public void testAddCustomer() {
		assertNotNull(testCustomer_1); // when testCustomer_1 returned by the method -- true
	}

	// Test for getCustomer method
	@Test
	public void testGetCustomer() {
		Customer customer = testBank.getCustomer(testCustomer_1);
		assertNotNull(customer); // when customer object exists -- true
		assertEquals(customer.getLastName(), lastName); // when last name is correct -- true
		assertEquals(customer.getFirstName(), firstName); // when last name is correct -- true
	}
	
	// Test for getAllCustomers method
	@Test
	public void testGetAllCustomers() {
		// Creates the customer set
		SortedSet<Customer> customerSortedSet = testBank.getAllCustomers();
		assertNotNull(customerSortedSet);
		assertEquals(customerSortedSet.first().getLastName(), lastName);
		assertEquals(customerSortedSet.first().getFirstName(), firstName);
	}

	// Test for getCustometList method
	@Test
	public void testGetCustomerList() {
		assertNotNull(customerList);
		
		if (customerList != null) {
			// Checks customer's last and first names in the list
			for (int i = 0; i < customerList.size(); i++) {
				Customer customer = customerList.get(i);
				assertEquals(customer.getLastName(), lastName); // when last name is correct -- true
				assertEquals(customer.getFirstName(), firstName); // when first name is correct -- true
			}
		}
	}

	// Test for removeCustomer method
	@Test
	public void testRemoveCustomer() {
		assertEquals(2, customerList.size()); // checks if list has 2 customers
		testBank.removeCustomer(testCustomer_2); // removes the customer
		assertEquals(1, customerList.size()); // checks if list has only 1 customers
	}
}
