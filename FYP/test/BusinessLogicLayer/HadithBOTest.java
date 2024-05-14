/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BusinessLogicLayer;

import DataAccessLayer.FascadeDAO;
import TransferObject.Hadith;
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
public class HadithBOTest {
    
 

    /**
     * Test of getAllHadiths method, of class HadithBO.
     */
    @Test
    public void testGetAllHadiths_NoInputGiven() {
        System.out.println("getAllHadiths");
        ArrayList<Integer> serials = new ArrayList<Integer>();
        HadithBO instance = new HadithBO(new FascadeDAO());
        ArrayList<Hadith> expResult = new ArrayList<Hadith>();
        ArrayList<Hadith> result = instance.getAllHadiths(serials);
        assertEquals(expResult, result);
       
    }
     @Test
    public void testGetAllHadiths_HadithIdGiven() {
        System.out.println("getAllHadiths");
        ArrayList<Integer> serials = new ArrayList<Integer>();
        serials.add(1);
        HadithBO instance = new HadithBO(new FascadeDAO());
     
        ArrayList<Hadith> result = instance.getAllHadiths(serials);
        assertFalse(result.isEmpty());
       
    }
    
}
