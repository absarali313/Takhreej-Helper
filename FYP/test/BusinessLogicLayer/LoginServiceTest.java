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
public class LoginServiceTest {

    /**
     * Test of login method, of class LoginService.
     */
    @Test
    public void testLogin_UserExists() throws Exception {
        System.out.println("login");
        String email = "absar0306@gmail.com";
        String password = "absar123";
        LoginService instance = new LoginService();
        boolean expResult = true;
        boolean result = instance.login(email, password);
        assertEquals(expResult, result);

    }

    @Test
    public void testLogin_UserNotExists() throws Exception {
        System.out.println("login");
        String email = "amna@gmail.com";
        String password = "absar123";
        LoginService instance = new LoginService();
        boolean expResult = false;
        boolean result = true;
        try {
            instance.login(email, password);
        } catch (Exception e) {
            result = false;
        }
        assertEquals(expResult, result);

    }

}
