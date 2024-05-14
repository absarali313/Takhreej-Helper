/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DataAccessLayer;

import CustomException.NoHadithFoundException;
import TransferObject.Book;
import TransferObject.Hadith;
import TransferObject.Narrator;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 *
 * @author Saqib
 */
public class HadithDAOTest {
    
    public HadithDAOTest() {
    }

   @Test
    public void testGetHadithById_ValidHadithFound() {
        // Prepare test data
        int index = 1; // Assuming an existing Hadith index
        BookDAO bookDAO = new BookDAO();    
        NarratorsDAO narratorsDAO = new NarratorsDAO(); 
        HadithDAO instance = new HadithDAO(bookDAO, narratorsDAO);
        Hadith result = instance.getHadithById(index);
        assertNotNull(result);
    }

    @Test
    public void testGetHadithById_NoHadithFound() {
        // Prepare test data
        int index = 0; // Assuming a non-existing Hadith index
        BookDAO bookDAO = new BookDAO(); 
        NarratorsDAO narratorsDAO = new NarratorsDAO(); 
        HadithDAO instance = new HadithDAO(bookDAO, narratorsDAO);
        Hadith result = instance.getHadithById(index);
        assertNull(result);
    }
     @Test
    public void testGetHadithById_SQLExceptionOccurs() {
        // Prepare test data
        int index = -1; // Assuming an index that may cause an SQLException
        BookDAO bookDAO = new BookDAO(); 
        NarratorsDAO narratorsDAO = new NarratorsDAO(); 
        HadithDAO instance = new HadithDAO(bookDAO, narratorsDAO);
        Hadith result = instance.getHadithById(index);
        assertNull(result);
    }
    /**
     * Test of getAllHadithIds method, of class HadithDAO.
     */
   @Test
    public void testGetAllHadithIds_HadithIdsFound() {
        BookDAO bookDAO = new BookDAO(); 
        NarratorsDAO narratorsDAO = new NarratorsDAO();
        HadithDAO instance = new HadithDAO(bookDAO,narratorsDAO); 
        ArrayList<Integer> result = instance.getAllHadithIds();
        assertFalse(result.isEmpty());
    }
    
    //no hadiths found
    //gethadiths
    
}
