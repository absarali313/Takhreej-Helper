/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DataAccessLayer;

import java.util.ArrayList;
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
public class SearchDAOTest {
    
    public SearchDAOTest() {
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
     * Test of getFilteredHadithIds method, of class SearchDAO.
     */
   @Test
    public void testGetFilteredHadithIds_NoResults() {
        String expression = "زكا لا ANDة OR صوم";
        SearchDAO instance = new SearchDAO();
        ArrayList<Integer> result = instance.getFilteredHadithIds(expression);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
@Test
    public void testGetFilteredHadithIds_ResultsFound() {
     
        String expression = "(ال)?صلاة OR (آل)?صلآة";
        SearchDAO instance = new SearchDAO();
        ArrayList<Integer> result = instance.getFilteredHadithIds(expression);
        assertTrue(result.isEmpty());
    }
    
       @Test
    public void testGetFilteredHadithIds_SQLException() {
        String expression = "صلاة OR (آل)?صلآة";
        SearchDAO instance = new SearchDAO();
        ArrayList<Integer> result = instance.getFilteredHadithIds(null);
        assertTrue(result.isEmpty());
    }
    /**
     * Test of getFilteredLemmaHadithIds method, of class SearchDAO.
     */
   @Test
public void testGetFilteredLemmaHadithIds_NoResults() {
    String expression ="ابصارتر";
    SearchDAO instance = new SearchDAO();
    ArrayList<Integer> result = instance.getFilteredLemmaHadithIds(expression);
    assertTrue(result.isEmpty());
}

@Test
public void testGetFilteredLemmaHadithIds_ResultsFound() {
    String expression = "آباء";
    SearchDAO instance = new SearchDAO();
    ArrayList<Integer> result = instance.getFilteredLemmaHadithIds(expression);
    assertFalse(result.isEmpty());
}

    /**
     * Test of getFilteredRootHadithIds method, of class SearchDAO.
     */
    @Test
    public void testGetFilteredRootHadithIds_EmptyResult() {
        String expression = "منال";
        SearchDAO instance = new SearchDAO();
        ArrayList<Integer> result = instance.getFilteredRootHadithIds(expression);
        assertTrue(result.isEmpty());
    }
      @Test
   
    public void testGetFilteredRootHadithIds_NonEmptyResult() {
        String expression = "فقم";
        SearchDAO instance = new SearchDAO();
        ArrayList<Integer> result = instance.getFilteredRootHadithIds(expression);
        assertFalse(result.isEmpty());
    }

    /**
     * Test of getdHadithIdsByTopic method, of class SearchDAO.
     */
@Test
public void testGetdHadithIdsByTopic_NoResults() {
   
    String expression = "منال";
    SearchDAO instance = new SearchDAO();
    ArrayList<Integer> result = instance.getdHadithIdsByTopic(expression);
    assertTrue(result.isEmpty());
}
    @Test
public void testGetdHadithIdsByTopic_ResultsFound() {
    // Provide an expression that matches existing data in the database
    String expression = "رسول";
    SearchDAO instance = new SearchDAO();
    ArrayList<Integer> result = instance.getdHadithIdsByTopic(expression);
    assertTrue(!result.isEmpty());
}
}
