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
 * @author Saqib
 */
public class FilterBOTest {
    
    public FilterBOTest() {
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
     * Test of createFilter method, of class FilterBO.
     */
    @Test
    public void testCreateFilter() {
        System.out.println("createFilter");
        int researchId = 0;
        int orderNo = 0;
        String expression = "";
        String type = "";
        FilterBO instance = null;
        boolean expResult = false;
        boolean result = instance.createFilter(researchId, orderNo, expression, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFilterExpression method, of class FilterBO.
     */
    @Test
    public void testUpdateFilterExpression() {
        System.out.println("updateFilterExpression");
        int id = 0;
        int orderNo = 0;
        String expression = "";
        FilterBO instance = null;
        boolean expResult = false;
        boolean result = instance.updateFilterExpression(id, orderNo, expression);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateFilterType method, of class FilterBO.
     */
    @Test
    public void testUpdateFilterType() {
        System.out.println("updateFilterType");
        int id = 0;
        int orderNo = 0;
        String type = "";
        FilterBO instance = null;
        boolean expResult = false;
        boolean result = instance.updateFilterType(id, orderNo, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFilter method, of class FilterBO.
     */
    @Test
    public void testDeleteFilter() {
        System.out.println("deleteFilter");
        int id = 0;
        int orderNum = 0;
        FilterBO instance = null;
        boolean expResult = false;
        boolean result = instance.deleteFilter(id, orderNum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
