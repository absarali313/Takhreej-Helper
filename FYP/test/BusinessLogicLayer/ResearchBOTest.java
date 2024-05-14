/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BusinessLogicLayer;

import CustomException.NoResearchFoundException;
import CustomException.ResearchAlreadyExistsException;
import DataAccessLayer.FascadeDAO;
import DataAccessLayer.IFascadeDAO;
import TransferObject.Research;
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
public class ResearchBOTest {

    /**
     * Test of createResearch method, of class ResearchBO.
     */
   @Test
    public void testCreateResearch_Success() {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        ResearchBO instance = new ResearchBO(fascadeDAO);
        String name = "Hajj And Pbuh";
        boolean result = instance.createResearch(name);
        Research researchTest = instance.getResearch(name);
      
        assertTrue(result);
        instance.deleteResearch(researchTest.getResearchId());
    }

 @Test
    public void testCreateResearch_ResearchAlreadyExistsException() throws ResearchAlreadyExistsException {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        ResearchBO instance = new ResearchBO(fascadeDAO);
        String Name = "Namaz and Pbuh ";
        // Create the research initially
        boolean initialResult = instance.createResearch(Name);
        boolean result = instance.createResearch(Name);
        Research researchTest = instance.getResearch(Name);
        assertFalse(result); // Assert that creation fails as expected
        instance.deleteResearch(researchTest.getResearchId());
    }
     @Test
    public void testUpdateResearchName_Success() {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        ResearchBO instance = new ResearchBO(fascadeDAO);
        String researchName = "ZAKAT and PBUH ";
        String updatedName = "Update";
        boolean createResult = instance.createResearch(researchName);
        assertTrue(createResult); // Ensure research creation succeeds
        Research researchTest = instance.getResearch(researchName);
        boolean updateResult = instance.updateResearchName(researchTest.getResearchId(), updatedName);
        assertTrue(updateResult);
        instance.deleteResearch(researchTest.getResearchId());
    }
   
    @Test
    public void testUpdateResearchName_Failure() {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        ResearchBO instance = new ResearchBO(fascadeDAO);
        String researchName = "ZAKAT AND HAJJ";
        String updatedName = "Updated Research";
        boolean createResult = instance.createResearch(researchName);
        Research researchTest = instance.getResearch(researchName);
        boolean updateResult = instance.updateResearchName(0, updatedName);
        assertFalse(updateResult);
        instance.deleteResearch(researchTest.getResearchId());
    }

      @Test
    public void testDeleteResearch_Success() {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        ResearchBO instance = new ResearchBO(fascadeDAO);
        String researchName = "ISLAM";
        boolean createResult = instance.createResearch(researchName);
        Research researchTest = instance.getResearch(researchName);
        instance.deleteResearch(researchTest.getResearchId());
    }
     @Test
    public void testDeleteResearch_Failure() {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        ResearchBO instance = new ResearchBO(fascadeDAO);
        String researchName = "ISLAM";
        boolean createResult = instance.createResearch(researchName);
        Research researchTest = instance.getResearch(researchName);
        instance.deleteResearch(0);
    }
    
    /**
     * Test of deleteResearch method, of class ResearchBO.
     */
    @Test
    public void testGetAllResearches_ResearchesExist() {
       
        IFascadeDAO fascadeDAO = new FascadeDAO(); // Instantiate the concrete implementation
        ResearchBO instance = new ResearchBO(fascadeDAO);
        ArrayList<Research> result = instance.getAllResearches();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
@Test
    public void testGetAllResearches_NoResearchesExist()  {
        // Arrange
        IFascadeDAO fascadeDAO = new FascadeDAO() {
            @Override
            public ArrayList<Research> getAllResearch() throws NoResearchFoundException {
                throw new NoResearchFoundException("No researches found");
            }
        };
        ResearchBO instance = new ResearchBO(fascadeDAO);
       // Attempt to get all researches
        ArrayList<Research> result = instance.getAllResearches();
        //Verify that an empty list is returned
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
    
}
