/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DataAccessLayer;

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
public class TranslatorDAOTest {
   
    /**
     * Test of translateHadith method, of class TranslatorDAO.
     */
    @Test
    public void testTranslateHadith() {
        System.out.println("translateHadith");
        String hadith = "";
        TranslatorDAO instance = new TranslatorDAO();
        String expResult = "";
        String result = instance.translateHadith(hadith);
        assertNull(result);
       
    }
    
     @Test
    public void testTranslateHadith_translated() {
        System.out.println("translateHadith");
        String hadith = "  رضي ه  ,  :  غزوت مع النبي  خمس عشرة   .";
        TranslatorDAO instance = new TranslatorDAO();
        String result = instance.translateHadith(hadith);
        assertNotNull(result);
       
    }
    
}
