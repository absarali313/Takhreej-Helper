/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BusinessLogicLayer;

import DataAccessLayer.FascadeDAO;
import DataAccessLayer.IFascadeDAO;
import TransferObject.Hadith;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SmartSearchBOTest {

    IFascadeDAO fascadeDAO = new FascadeDAO();

    /**
     * Test of getTopics method, of class SmartSearchBO.
     */
    @Test
    public void testGetTopics_NoInput() {
        System.out.println("getTopics");
        String matn = "";
        SmartSearchBO instance = new SmartSearchBO(fascadeDAO);
        ArrayList<String> expResult = null;
        ArrayList<String> result = new ArrayList<String>();
        assertTrue(result.isEmpty());

    }

    @Test
    public void testGetTopics_TopicsReturned() {
        System.out.println("getTopics");
        String matn = "  رضي ه  ,  :  غزوت مع النبي  خمس عشرة   .";
        SmartSearchBO instance = new SmartSearchBO(fascadeDAO);

        ArrayList<String> result = instance.getTopics(matn);
        assertFalse(result.isEmpty());

    }

    /**
     * Test of Search method, of class SmartSearchBO.
     */
    @Test
    public void testSearch_NoInput() {
        System.out.println("Search");
        String matn = "";
        SmartSearchBO instance = new SmartSearchBO(fascadeDAO);
        ArrayList<Hadith> result = null;
        try {
            instance.Search(matn);
        } catch (Exception e) {
            result = new ArrayList<Hadith>();
        }

        assertTrue(result.isEmpty());
    }

    @Test
    public void testSearch_ReturnHadith() {
        System.out.println("Search");
        String matn = "  رضي ه  ,  :  غزوت مع النبي  خمس عشرة   .";
        SmartSearchBO instance = new SmartSearchBO(fascadeDAO);
        ArrayList<Hadith> result = instance.Search(matn);
        assertFalse(result.isEmpty());

    }

}
