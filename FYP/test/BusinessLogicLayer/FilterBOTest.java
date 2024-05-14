/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BusinessLogicLayer;

import DataAccessLayer.FascadeDAO;
import DataAccessLayer.IFascadeDAO;
import TransferObject.Research;
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
    public void testCreateFilter_Success() {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        FilterBO instance = new FilterBO(fascadeDAO);
        String researchName = "Test Research";
        String filterExpression = "غزوAND?";
        String filterType = "Pattern";
        ResearchBO researchBO = new ResearchBO(fascadeDAO);
        researchBO.createResearch(researchName);
        Research researchTest = researchBO.getResearch(researchName);
        // Act: Attempt to create a filter
        boolean result = instance.createFilter(researchTest.getResearchId(), 1, filterExpression, filterType);
        // Assert: Verify that the filter creation succeeds
        assertTrue(result);
        instance.deleteFilter(researchTest.getResearchId(), 1);
       
    }
    @Test
    public void testCreateFilter_Failure() {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        FilterBO instance = new FilterBO(fascadeDAO);
        String researchName = "Test Research";
        String filterExpression = "غزو";
        String filterType = "Pattern";
        ResearchBO researchBO = new ResearchBO(fascadeDAO);
        researchBO.createResearch(researchName);
       // Research researchTest = researchBO.getResearch(researchName);
        // Act: Attempt to create a filter
        boolean result = instance.createFilter(-1, 1, filterExpression, filterType);
        // Assert: Verify that the filter creation succeeds
        assertFalse(result);
    }
    /**
     * Test of updateFilterExpression method, of class FilterBO.
     */
      @Test
    public void testUpdateFilterExpression_Success() {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        FilterBO instance = new FilterBO(fascadeDAO);
        String researchName = "checking";
        String filterExpression = "Filter Expression";
        String newExpression = "New Filter Expression";
        String filterType = "Type";
        ResearchBO researchBO = new ResearchBO(fascadeDAO);
        researchBO.createResearch(researchName);
        Research researchTest = researchBO.getResearch(researchName);
        instance.createFilter(researchTest.getResearchId(),1, filterExpression, filterType);
        boolean result = instance.updateFilterExpression(researchTest.getResearchId(),1, newExpression);
        // Assert: Verify that the filter expression is updated successfully
        assertTrue(result);
        researchBO.deleteResearch(researchTest.getResearchId());
        instance.deleteFilter(researchTest.getResearchId(), 1);
    }
         @Test
    public void testUpdateFilterExpression_Failure() {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        FilterBO instance = new FilterBO(fascadeDAO);
        String researchName = "checking";
        String filterExpression = "Filter Expression";
        String newExpression = "New Filter Expression";
        String filterType = "Type";
        ResearchBO researchBO = new ResearchBO(fascadeDAO);
        researchBO.createResearch(researchName);
        Research researchTest = researchBO.getResearch(researchName);
        instance.createFilter(researchTest.getResearchId(),1, filterExpression, filterType);
        boolean result = instance.updateFilterExpression(-1,1, newExpression);
        // Assert: Verify that the filter expression is updated successfully
        assertFalse(result);
    }
       @Test
    public void testDeleteFilterExpression_Success() {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        FilterBO instance = new FilterBO(fascadeDAO);
        String researchName = "Namaz new research";
        String filterExpression = "زكا ةزكاة ?";
        String filterType = "Type";
        ResearchBO researchBO = new ResearchBO(fascadeDAO);
        researchBO.createResearch(researchName);
        Research researchTest = researchBO.getResearch(researchName);
        instance.createFilter(researchTest.getResearchId(),1, filterExpression, filterType);
        boolean result = instance.deleteFilter(researchTest.getResearchId(), 1);
        assertTrue(result);
        researchBO.deleteResearch(researchTest.getResearchId());
        
    }
        @Test
    public void testDeleteFilterExpression_Failure() {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        FilterBO instance = new FilterBO(fascadeDAO);
        String researchName = "Namaz new research";
        String filterExpression = "زكا ةزكاة ?";
        String filterType = "Type";
        ResearchBO researchBO = new ResearchBO(fascadeDAO);
        researchBO.createResearch(researchName);
        Research researchTest = researchBO.getResearch(researchName);
        instance.createFilter(researchTest.getResearchId(),1, filterExpression, filterType);
        boolean result = instance.deleteFilter(-1, 1);
        assertFalse(result);
        researchBO.deleteResearch(researchTest.getResearchId());
        
    }

    
}