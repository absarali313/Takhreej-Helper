/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BusinessLogicLayer;

import DataAccessLayer.FascadeDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TranslatorBOTest {
    
  
    /**
     * Test of getTranslationToEnglish method, of class TranslatorBO.
     */
    @Test
    public void testGetTranslationToEnglish_NullInput() {
        System.out.println("getTranslationToEnglish");
        String matn = "";
        TranslatorBO instance = new TranslatorBO(new FascadeDAO());
        String expResult = null;
        String result = instance.getTranslationToEnglish(matn);
        assertEquals(expResult, result);
      
    }
    
     @Test
    public void testGetTranslationToEnglish_ValidInput() {
        System.out.println("getTranslationToEnglish");
        String matn = "  رضي ه  ,  :  غزوت مع النبي  خمس عشرة   .";
        TranslatorBO instance = new TranslatorBO(new FascadeDAO());
        
        String result = instance.getTranslationToEnglish(matn);
        assertNotNull(result);
      
    }
    
}
