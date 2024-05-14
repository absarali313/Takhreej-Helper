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
public class LemmatizerProxyDAOTest {
    
  
    /**
     * Test of getLemmatizedWord method, of class LemmatizerProxyDAO.
     */
    @Test
    public void testGetLemmatizedWord_NullInput() throws Exception {
        System.out.println("getLemmatizedWord");
        String textToLemmatize = "";
        LemmatizerProxyDAO instance = new LemmatizerProxyDAO();
        String result = instance.getLemmatizedWord(textToLemmatize);
        assertEquals("",result);
       
    }
      @Test
    public void testGetLemmatizedWord_lemmatizedWords() throws Exception {
        System.out.println("getLemmatizedWord");
        String textToLemmatize = "  رضي ه  ,  :  غزوت مع النبي  خمس عشرة   .";
        LemmatizerProxyDAO instance = new LemmatizerProxyDAO();
        String result = instance.getLemmatizedWord(textToLemmatize);
        assertNotNull(result);
       
    }
    
}
