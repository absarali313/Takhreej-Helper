/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DataAccessLayer;

import TransferObject.Narrator;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
//mport static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author Saqib
 */
public class NarratorsDAOTest {
    
    public NarratorsDAOTest() {
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
     * Test of getNarrator method, of class NarratorsDAO.
     */
    @Test
    public void testGetNarrator_IdNonZero_NarratorFound() {
        // Test case for an existing ID
        int id = 2; // Assuming an existing ID
        NarratorsDAO instance = new NarratorsDAO();
        // Call the method to be tested
        ArrayList<Narrator> result = instance.getNarrator(id);
        assertFalse(result.isEmpty()); 
    }
      @Test
    public void testGetNarrator_IdNonZero_NoNarratorFound() {
        int id = 9999;
        NarratorsDAO instance = new NarratorsDAO();
        ArrayList<Narrator> result = instance.getNarrator(id);
        assertTrue(result.isEmpty()); // Expecting an empty list because no narrator found
    }

    @Test
     public void testGetNarrator_SQLException() {
  
        NarratorsDAO instance = new NarratorsDAO();
        ArrayList<Narrator> result = instance.getNarrator(-1);
        assertTrue(result.isEmpty()); // Expecting an empty list because no narrator found
    }
}
