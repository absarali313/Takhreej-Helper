/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessLayer;

import java.io.IOException;

/**
 *
 * @author ch-sa
 */
public interface ILemmatizerDAO {

    String getLemmatizedWord(String textToLemmatize) throws IOException;
    
}
