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
public class TopicGeneratorTest {
    
    public TopicGeneratorTest() {
    }
    

    /**
     * Test of predictTopic method, of class TopicGenerator.
     */
    @Test
    public void testPredictTopic() {
        System.out.println("predictTopic");
        String hadith = "";
        TopicGenerator instance = new TopicGenerator();
        String expResult = "";
        String result = instance.predictTopic(hadith);
        assertNull(result);
      
    }
    
     @Test
    public void testPredictTopic_predictTopics() {
        System.out.println("predictTopic");
        String hadith = "  رضي ه  ,  :  غزوت مع النبي  خمس عشرة   .";
        TopicGenerator instance = new TopicGenerator();
    
        String result = instance.predictTopic(hadith);
        assertNotNull(result);
      
    }
    
}
