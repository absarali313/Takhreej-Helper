/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DataAccessLayer;

import CustomException.ResearchAlreadyExistsException;
import TransferObject.Filter;
import TransferObject.Research;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Saqib
 */
public class FilterDAOTest {

    public FilterDAOTest() {
    }

    @BeforeEach
    public void removeResearch() {
        ResearchDAO researchDAO = new ResearchDAO(new FilterDAO());
        Research research = researchDAO.getResearchByName("research_test_filter");
        researchDAO.deleteResearch(research.getResearchId());
    }

    /**
     * Test of insertFilter method, of class FilterDAO.
     */
    @Test
    public void testInsertFilter_Success() throws ResearchAlreadyExistsException {
        FilterDAO instance = new FilterDAO();
        ResearchDAO researchDAO = new ResearchDAO(instance);
      
        Research research = null;
        try {
            researchDAO.insertResearch("research_test_filter");

        } catch (Exception e) {
            researchDAO.deleteResearch(researchDAO.getResearchByName("research_test_filter").getResearchId());
            researchDAO.insertResearch("research_test_filter");
        }
        research = researchDAO.getResearchByName("research_test_filter");
        int orderNo = 0;
        String expression = "صوم";
        String searchType = "Pattern";
        assertTrue(instance.insertFilter(research.getResearchId(), orderNo, expression, searchType));
        Filter filter = instance.getFilters(research.getResearchId()).get(orderNo);
        instance.deleteFilter(research.getResearchId(), filter.getId());
        researchDAO.deleteResearch(research.getResearchId());

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
    public void testUpdateFilter_successfull_updation() {

         FilterDAO instance = new FilterDAO();
        ResearchDAO researchDAO = new ResearchDAO(instance);
        try {
            researchDAO.insertResearch("research_test_filter");
        } catch (Exception e) {
           
        }
        Research research = researchDAO.getResearchByName("research_test_filter");
        instance.insertFilter(research.getResearchId(), 0, "abc", "Pattern");
        Filter filter = instance.getFilters(research.getResearchId()).get(0);
        boolean updateResult = instance.updateFilter(research.getResearchId(), filter.getId(), "test");
        assertTrue(!updateResult);
         instance.deleteFilter(research.getResearchId(), filter.getId());
        researchDAO.deleteResearch(research.getResearchId());
        
    }

    @Test
    public void testUpdateFilter_NoRowsUpdated() {
      FilterDAO instance = new FilterDAO();
        ResearchDAO researchDAO = new ResearchDAO(instance);
        try {
            researchDAO.insertResearch("research_test_filter");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Research research = researchDAO.getResearchByName("research_test_filter");
        instance.insertFilter(research.getResearchId(), 0, "abc", "Pattern");
        Filter filter = instance.getFilters(research.getResearchId()).get(0);
        boolean updatedResult = instance.updateFilter(research.getResearchId(),-1 , "test");
        assertFalse(updatedResult); // Expecting false because no rows were updated

    }

    @Test
    public void testUpdateFilter_type_successfull_updation() {

        FilterDAO instance = new FilterDAO();
        ResearchDAO researchDAO = new ResearchDAO(instance);
        try {
            researchDAO.insertResearch("research_test_filter");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Research research = researchDAO.getResearchByName("research_test_filter");
        instance.insertFilter(research.getResearchId(), 0, "صلآة", "pattern");
        Filter filter = instance.getFilters(research.getResearchId()).get(0);
        boolean isupdated = instance.updateFilter(research.getResearchId(), 0, "test");
        assertTrue(isupdated);

        researchDAO.deleteResearch(research.getResearchId());
        instance.deleteFilter(research.getResearchId(), filter.getId());
    }

    @Test
    public void testDeleteFilter_NotFound() {

        FilterDAO instance = new FilterDAO();
        ResearchDAO researchDAO = new ResearchDAO(instance);
        try {
            researchDAO.insertResearch("research_test_filter");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Research research = researchDAO.getResearchByName("research_test_filter");

        boolean expResult = false;
        boolean result = instance.deleteFilter(research.getResearchId(), 2);
        assertEquals(expResult, result);
    }

    @Test
    public void deleteFilter_Found() {
       
       
        FilterDAO filterDAO = new FilterDAO();
        ResearchDAO researchDAO = new ResearchDAO(filterDAO);
        try {
            researchDAO.insertResearch("research_test_filter");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Research research = researchDAO.getResearchByName("research_test_filter");

        filterDAO.insertFilter(research.getResearchId(), 0, "صوم", "زكاة");
        boolean isDeleted = filterDAO.deleteFilter(research.getResearchId(), 0);
        assertTrue(isDeleted);
        researchDAO.deleteResearch(research.getResearchId());
    }

    @Test
    public void testGetFilters_SuccessfulRetrieval() {

        FilterDAO instance = new FilterDAO();
        ResearchDAO researchDAO = new ResearchDAO(instance);
        try {
            researchDAO.insertResearch("research_test_filter");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Research research = researchDAO.getResearchByName("research_test_filter");

        instance.insertFilter(research.getResearchId(), 0, "غزو", "lemma");
        ArrayList<Filter> filters = instance.getFilters(research.getResearchId());
        // Assert: Ensure that the list of filters is not empty
        assertFalse(filters.isEmpty());
        
        researchDAO.deleteResearch(research.getResearchId());

    }

    @Test
    public void testGetFilters_Unsuccesful_Retrieval() {
       
        FilterDAO instance = new FilterDAO();
        ResearchDAO researchDAO = new ResearchDAO(instance);
        try {
            researchDAO.insertResearch("research_test_filter");
        } catch (Exception e) {
           
            
        }
        Research research = researchDAO.getResearchByName("research_test_filter");

        instance.insertFilter(research.getResearchId(), 0, "غزو", "lemma");
        ArrayList<Filter> filters = instance.getFilters(research.getResearchId());
        for(Filter filter : filters)
            instance.deleteFilter(research.getResearchId(), filter.getId());
        // Assert: Ensure that the list of filters is not empty
        assertTrue(instance.getFilters(research.getResearchId()+1).isEmpty());
        //instance.deleteFilter(research.getResearchId(), 0);
        researchDAO.deleteResearch(research.getResearchId());
    }

}
