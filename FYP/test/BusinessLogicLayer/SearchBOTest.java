/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BusinessLogicLayer;

import TransferObject.Hadith;
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
public class SearchBOTest {
    
    public SearchBOTest() {
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
     * Test of searchHadiths method, of class SearchBO.
     */
    @Test
    public void testSearchHadiths() {
        System.out.println("searchHadiths");
        Research research = null;
        int filterIndex = 0;
        SearchBO instance = null;
        ArrayList<Hadith> expResult = null;
        ArrayList<Hadith> result = instance.searchHadiths(research, filterIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchHadithsByPattern method, of class SearchBO.
     */
    @Test
    public void testSearchHadithsByPattern() {
        System.out.println("searchHadithsByPattern");
        Research research = null;
        int filterIndex = 0;
        SearchBO instance = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.searchHadithsByPattern(research, filterIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchHadithsByToken method, of class SearchBO.
     */
    @Test
    public void testSearchHadithsByToken() {
        System.out.println("searchHadithsByToken");
        Research research = null;
        int filterIndex = 0;
        SearchBO instance = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.searchHadithsByToken(research, filterIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchHadithsByLemma method, of class SearchBO.
     */
    @Test
    public void testSearchHadithsByLemma() {
        System.out.println("searchHadithsByLemma");
        Research research = null;
        int filterIndex = 0;
        SearchBO instance = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.searchHadithsByLemma(research, filterIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchHadithsByRoots method, of class SearchBO.
     */
    @Test
    public void testSearchHadithsByRoots() {
        System.out.println("searchHadithsByRoots");
        Research research = null;
        int filterIndex = 0;
        SearchBO instance = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.searchHadithsByRoots(research, filterIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keepAtLeastXTimesElements method, of class SearchBO.
     */
    @Test
    public void testKeepAtLeastXTimesElements() {
        System.out.println("keepAtLeastXTimesElements");
        ArrayList<Integer> arrayList = null;
        int x = 0;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = SearchBO.keepAtLeastXTimesElements(arrayList, x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of union method, of class SearchBO.
     */
    @Test
    public void testUnion() {
        System.out.println("union");
        ArrayList<Integer> list1 = null;
        ArrayList<Integer> list2 = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = SearchBO.union(list1, list2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countOccurrences method, of class SearchBO.
     */
    @Test
    public void testCountOccurrences() {
        System.out.println("countOccurrences");
        ArrayList<Integer> arrayList = null;
        int elementToCount = 0;
        int expResult = 0;
        int result = SearchBO.countOccurrences(arrayList, elementToCount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
