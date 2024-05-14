/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BusinessLogicLayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ch-sa
 */
public class RegistrationServiceTest {

    public RegistrationServiceTest() {
    }

    /**
     * Test of registerUser method, of class RegistrationService.
     */
    @Test
    public void testRegisterUser() throws Exception {
        System.out.println("registerUser");
        String name = "";
        String email = "";
        String password = "";
        String phoneNumber = "";
        String verificationCode = "";
        RegistrationService instance = new RegistrationService();
        boolean expResult = false;
        boolean result = true;
        try {
            result = instance.registerUser(name, email, password, phoneNumber, verificationCode);
        } catch (Exception e) {
            result = false;
        }
        assertEquals(expResult, result);

    }

    /**
     * Test of isEmailRegistered method, of class RegistrationService.
     */
    @Test
    public void testIsEmailRegistered() {
        System.out.println("isEmailRegistered");
        String email = "absar@gmail.com";
        RegistrationService instance = new RegistrationService();
        boolean expResult = false;
        boolean result = instance.isEmailRegistered(email);
        assertEquals(expResult, result);

    }

}
