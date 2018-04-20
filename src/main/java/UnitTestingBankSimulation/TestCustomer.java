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
    
    @Test
    public void testYtdFees() {
    	final double ytdFees = 145.00;
    	
    	double testFees = testCustomer.ytdFees();
    	
    	assertEquals(testFees, ytdFees, 0.0006);
    }
    
    @Test
    public void testYtdInterest() {
    	final double ytdInterest = 0.06;
    	
    	double testInterest = testCustomer.ytdInterest();
    	
    	assertEquals(testInterest, ytdInterest, 0.0006);
    }
    
    @Test
    public void testAddSavingsAccount() {
    	final double testInitBal = 1000;
    	final String testDesc = "Joeblow's Savings";
    	
    	testCustomer.addSavingsAccount(testInitBal, testDesc);
    	
    	assertEquals(testCustomer.getSavingsAccount(), testInitBal, 0.0006); // getSavingsAccount method added to adequately test this function.
    }
    
    @Test
    public void testRemoveAccount() {
    	final String testAccountID = "0001";
    	
    	assertEquals(testCustomer.getCustomerAccounts(), testAccountID);
    }
    
}