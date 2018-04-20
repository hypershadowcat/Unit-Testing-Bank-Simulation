package UnitTestingBankSimulation;

import static org.junit.Assert.*;
import org.junit.*;

// Written by Zachary Willis, Team Spirit Bomb, 2018

public class TestCustomer {
	
    Customer testCustomer;
    final Bank testBank = new Bank("testBank");
    final String testLastName = "Bobob";
    final String testFirstName = "Jojo";
    
    // Set up clean slate for all tests
    @Before
    public void init() {
    	// Create customer object
    	testCustomer = new Customer(testBank, testLastName, testFirstName);
    }
    
    @Test
    public void testCustomerCreated() {
    	assertNotNull(testCustomer); // Ensures the customer object exists.
    	
    	assertEquals(testCustomer.getBank(), testBank); // Ensures the bank name of customer object is correct bank for test.
    }
    
    
    
}