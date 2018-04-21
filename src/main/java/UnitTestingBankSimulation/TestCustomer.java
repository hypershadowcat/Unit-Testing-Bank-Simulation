package UnitTestingBankSimulation;

import static org.junit.Assert.*;
import org.junit.*;

// Written by Zachary Willis, Team Spirit Bomb, 2018

public class TestCustomer {
	
    Customer testCustomer;
    SavingsAccount testAccount;
    final Bank testBank = new Bank("testBank");
    final String testLastName = "Bobob";
    final String testFirstName = "Jojo";
    final String testDesc = "Joeblow's Savings";
    final double testInitBal = 1000;
    
    // Set up clean slate for all tests
    @Before
    public void init() {
    	// Create customer object
    	testCustomer = new Customer(testBank, testLastName, testFirstName);
    	testAccount = testCustomer.addSavingsAccount(testInitBal, testDesc);
    }
    
    @Test
    public void testCustomerCreated() {
    	assertNotNull(testCustomer); // Ensures the customer object exists.
    	
    	assertEquals(testCustomer.getBank(), testBank); // Ensures the bank name of customer object is correct bank for test.
    	assertEquals(testCustomer.getLastName(), testLastName);
    	assertEquals(testCustomer.getFirstName(), testFirstName);
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
    	assertNotNull(testAccount);
    	assertEquals(testAccount.getAccountDescription(), testDesc); // Ensures description is accurate
    	assertEquals(testCustomer.getSavingsAccount(), testInitBal, 0.0006); // getSavingsAccount method added to adequately test this function.
    }
    
    @Test
    public void testRemoveAccount() {
		String testAccountID = "001";
		testCustomer.getAccount(testAccountID);
    	testCustomer.removeAccount(testAccountID);
    	
    	assertNull(testAccountID); // Ensures the account was removed and the object doesn't exist.
    }
    
}