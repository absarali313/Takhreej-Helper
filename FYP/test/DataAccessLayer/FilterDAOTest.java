/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DataAccessLayer;

import TransferObject.Filter;
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
public class FilterDAOTest {

       public FilterDAOTest() {
    }
    /**
     * Test of insertFilter method, of class FilterDAO.
     */
     @Test
    public void testInsertFilter_Success() {
        FilterDAO instance = new FilterDAO();
        int researchId = 2;
        int orderNo = 0;
         String expression = "زكاAND ة? OR صوم";
        String searchType = "Pattern";
        assertTrue(instance.insertFilter(researchId, orderNo, expression, searchType));
        boolean deleteFilter = instance.deleteFilter(2,0);
        assertTrue(deleteFilter);
        
    }
    
@Test
public void testInsertFilter_InvalidResearchId_SQLException() {
    FilterDAO instance = new FilterDAO();
    int researchId = -1; 
    int orderNo = 0;
    String expression = "زكاAND ة? OR صوم";
   String searchType = "Pattern";
    assertFalse(instance.insertFilter(researchId, orderNo, expression, searchType));
}
    
    /**
     * Test of updateFilter method, of class FilterDAO.
     */
 
    @Test
    public void testUpdateFilter_successfull_updation(){

        FilterDAO instance = new FilterDAO();
        boolean insertResult = instance.insertFilter(2,0,"(ال)?صلاة OR (آل)?صلآة","pattern");
        assertTrue(insertResult);
        boolean updateResult = instance.updateFilter(2, 0, "test");
        assertTrue(updateResult);
        boolean deleteFilter = instance.deleteFilter(2,0);
        assertTrue(deleteFilter);
    }
   
     @Test
    public void testUpdateFilter_NoRowsUpdated() {
        FilterDAO instance = new FilterDAO();
        boolean insertResult = instance.insertFilter(2,0,"(ال)?صلاة OR (آل)?صلآة","pattern");
        assertTrue(insertResult);
        boolean updatedResult = instance.updateFilter(-1, -1, "test");
        assertFalse(updatedResult); // Expecting false because no rows were updated

    }
   
    @Test
    public void testUpdateFilter_type_successfull_updation(){

        FilterDAO instance = new FilterDAO();
        boolean insertResult = instance.insertFilter(3,1,"صلآة","pattern");
        assertTrue(insertResult);
        boolean isupdated = instance.updateFilterType(3, 1, "lemma");
        assertTrue(isupdated);
        boolean deleteFilter = instance.deleteFilter(3,1);
        assertTrue(deleteFilter);
    }
    @Test
    public void testDeleteFilter_NotFound() {
 
        FilterDAO instance = new FilterDAO();
        boolean insertResult = instance.insertFilter(4,2,"صلآة","pattern");
        assertTrue(insertResult);
        boolean expResult = false;
        boolean result = instance.deleteFilter(4,2);
        assertNotEquals(expResult, result);
    }
   @Test
   public void deleteFilter_Found() {
    // Insert a filter into the database
    FilterDAO filterDAO = new FilterDAO();
    filterDAO.insertFilter(3, 0, "صوم", "زكاة");
    boolean isDeleted = filterDAO.deleteFilter(3,0);
    assertTrue(isDeleted);
}
   
   @Test
    public void testGetFilters_SuccessfulRetrieval() {

        FilterDAO instance = new FilterDAO();
        instance.insertFilter(5, 1, "غزو", "lemma");
        ArrayList<Filter> filters = instance.getFilters(5);
        // Assert: Ensure that the list of filters is not empty
        assertFalse(filters.isEmpty());
         boolean isDeleted = instance.deleteFilter(5,1);
         assertTrue(isDeleted);
        
    }
    
     @Test
    public void testGetFilters_Unsuccesful_Retrieval() {
        FilterDAO instance = new FilterDAO();
        instance.insertFilter(4, 1, "غزو", "lemma");
        ArrayList<Filter> filters = instance.getFilters(0);
        // Assert: Ensure that the list of filters is not empty
        assertTrue(filters.isEmpty());
         boolean isDeleted = instance.deleteFilter(4,1);
         assertTrue(isDeleted);
    }
    
}
