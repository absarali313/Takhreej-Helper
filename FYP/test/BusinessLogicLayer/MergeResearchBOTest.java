/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BusinessLogicLayer;

import DataAccessLayer.FascadeDAO;
import TransferObject.Filter;
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
 * @author ch-sa
 */
public class MergeResearchBOTest {

    /**
     * Test of mergeResearches method, of class MergeResearchBO.
     */
    @Test
    public void testMergeResearches_null() {

        String name = "";
        Research research1 = null;
        Research research2 = null;
        MergeResearchBO instance = null;
        boolean expResult = false;
        boolean result = true;
        try {
            instance.mergeResearches(name, research1, research2);
        } catch (Exception e) {
            result = false;
        }
        assertEquals(expResult, result);

    }
    @Test
     public void testMergeResearches_Merged() {

        String name = "";
        Research research1 = new Research(1,"a", new ArrayList<Filter>());
        Research research2 = new Research(1,"b", new ArrayList<Filter>());
        MergeResearchBO instance = new MergeResearchBO(new FascadeDAO());
        boolean expResult = true;
        boolean result = true;
        try {
            instance.mergeResearches(name, research1, research2);
        } catch (Exception e) {
            result = false;
        }
        assertEquals(expResult, result);

    }

}
