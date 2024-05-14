/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DataAccessLayer;

import CustomException.ResearchAlreadyExistsException;
import TransferObject.Filter;
import TransferObject.Research;
import com.mysql.jdbc.PreparedStatement;
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
public class ResearchDAOTest {
    
 
    /**
     * Test of insertResearch method, of class ResearchDAO.
     * @throws CustomException.ResearchAlreadyExistsException
     */
     @Test
    public void testInsertResearch_AlreadyResearchDoesNotExist_SuccessfulInsertion() throws ResearchAlreadyExistsException {
        ResearchDAO researchDAO = new ResearchDAO(new FilterDAO());
        String newResearchName = "Namaz And zakat Research";
        boolean result = researchDAO.insertResearch(newResearchName);
        assertTrue(result);
    }

    @Test 
    public void testInsertResearch_ResearchAlreadyExists() {
        ResearchDAO researchDAO = new ResearchDAO(new FilterDAO());
        String existingResearchName = "namaz";
     try {
            researchDAO.insertResearch(existingResearchName);
            fail("Expected ResearchAlreadyExistsException was not thrown");
        } catch (ResearchAlreadyExistsException e) {
            // Pass: ResearchAlreadyExistsException was thrown
        }
    }

    /**
     * Test of insertResearch method, of class ResearchDAO.
     * @throws CustomException.ResearchAlreadyExistsException  
     */
    @Test
    public void testUpdateResearch_SuccessfulUpdation() throws ResearchAlreadyExistsException {
     
      
        ResearchDAO researchDAO = new ResearchDAO(new FilterDAO()); // Instantiate ResearchDAO with a FilterDAO instance
        boolean insertResult = researchDAO.insertResearch("Akhiratsss", new Filter(0,0,"test","Pattern"));
        Research researchTest = researchDAO.getResearchByName("Akhiratsss");
        boolean updated =  researchDAO.updateResearch(researchTest.getResearchId(),"Zakat");
        assertTrue(updated);
        researchDAO.deleteResearch(researchTest.getResearchId());
}
    @Test
    public void testUpdateResearch_NoRowsUpdated() throws ResearchAlreadyExistsException {
        // Arrange
        ResearchDAO researchDAO = new ResearchDAO(new FilterDAO()); 
        // Insert dummy data into the database and get the researchId
        boolean researchId = researchDAO.insertResearch("roza", new Filter(0, 0, "test", "Pattern"));
        // Attempt to update a non-existent research record
        boolean result = researchDAO.updateResearch(-1, "roza");
        assertFalse(result); // Expecting false because no rows were updated
    }     
  
    @Test
    public void testUpdateResearch_SQLException_NullFilterDAO() {
        
       
        ResearchDAO researchDAO = new ResearchDAO(new FilterDAO()); // Instantiate ResearchDAO with a null FilterDAO instance

        boolean result = researchDAO.updateResearch(0,null);
        assertFalse(result);
    }
    
    /**
     * Test of deleteResearch method, of class ResearchDAO.
     * @throws CustomException.ResearchAlreadyExistsException
     */
 @Test
    public void testDeleteResearch_SuccessfulDeletion() throws ResearchAlreadyExistsException {
     
        ResearchDAO researchDAO = new ResearchDAO(new FilterDAO()); // Instantiate ResearchDAO with a FilterDAO instance
        boolean insertResult = researchDAO.insertResearch("NAMAZ AND HAJJ ", new Filter(0,0,"test","Pattern"));
        Research researchTest = researchDAO.getResearchByName("NAMAZ AND HAJJ ");
        boolean isdeleted =  researchDAO.deleteResearch(researchTest.getResearchId());
        assertTrue(isdeleted);
    }
    @Test
    public void testDeleteResearch_NoRowsDeleted() {
        //non existent id 
        int id = 1;
        ResearchDAO researchDAO = new ResearchDAO(new FilterDAO()); // Instantiate ResearchDAO with a FilterDAO instance
        boolean deleteResult = researchDAO.deleteResearch(id);
        assertFalse(deleteResult);
    }
    
    @Test
    public void testGetResearchByName_Found() throws ResearchAlreadyExistsException {
        ResearchDAO researchDAO = new ResearchDAO(new FilterDAO()); // Instantiate ResearchDAO with a FilterDAO instance
        boolean insertResult = researchDAO.insertResearch("Akhiratsss", new Filter(0,0,"test","Pattern"));
        //retrive from data base
        Research research = researchDAO.getResearchByName("Akhiratsss");
        assertNotNull(research); // Expecting the research object to be not null
    }
    
  //   @Test
    //public void testGetResearchByName_Not_Found() throws ResearchAlreadyExistsException {
      //  ResearchDAO researchDAO = new ResearchDAO(new FilterDAO()); // Instantiate ResearchDAO with a FilterDAO instance
       // boolean insertResult = researchDAO.insertResearch("Qayamat", new Filter(0,0,"test","Pattern"));
        //Research research = researchDAO.getResearchByName("HAJJ");
        //assertNull(research); 
   // }
    
 

    /**
     * Test of getResearchByName method, of class ResearchDAO.
     */
  
    /**
     * Test of getAllResearch method, of class ResearchDAO.
     */
 @Test
    public void testGetAllResearch_ResearchFound() throws Exception {
        // Arrange
        ResearchDAO instance = new ResearchDAO(new FilterDAO());
        // Insert sample research data into the database or data source
        instance.insertResearch("Research 1", new Filter(0,0, "test","pattern"));
        ArrayList<Research> result = instance.getAllResearch();
        assertTrue(!result.isEmpty()); // Expecting at least one research record
    }
@Test
    public void testGetAllResearch_NO_ResearchFound() throws Exception {
        // Arrange
        ResearchDAO instance = new ResearchDAO(new FilterDAO());
        // Insert sample research data into the database or data source
        instance.insertResearch("Researches", new Filter(0,0, "test","pattern"));
        ArrayList<Research> result = instance.getAllResearch();
        assert(result.isEmpty()); // Expecting at least one research record
    }
   
}