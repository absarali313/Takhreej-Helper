/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DataAccessLayer;

import TransferObject.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Saqib
 */
public class RegisterDALTest {
    
    public RegisterDALTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isEmailRegistered method, of class RegisterDAL.
     */
 

    @Test
    public void testInsertUser_EmailAlreadyRegistered() {
        // Prepare test data
        User user = new User("manalsaqib", "manalsaqib3@gmail.com", "password", "1234567890");
        RegisterDAL instance = new RegisterDAL();
        // Perform the test
        boolean result = instance.insertUser(user);
        // Verify the result
        assertFalse(result); // Expecting false as the email is already registered
    }
  @Test
    public void testInsertUser_SuccessfulInsertion() {
  
        String newEmail = "f2000234@cfd.nu.edu.pk"; 
        User user = new User("Dummy User", newEmail, "password", "1234567890");
        RegisterDAL instance = new RegisterDAL();
        // Ensure the email is not already registered
        assertFalse(instance.isEmailRegistered(newEmail));
        boolean result = instance.insertUser(user);
        assertTrue(result); // Expecting true as the insertion was successful
    }
    /**
     * Test of insertUser method, of class RegisterDAL.
     */
    @Test
    public void testInsertUser_SQLException() {
        // Prepare test data
        User user = new User(null, null, null,null);
        RegisterDAL instance = new RegisterDAL();
        boolean result = instance.insertUser(user);
        assertFalse(result); // Expecting false as an SQLException occurred
    }
    
}
