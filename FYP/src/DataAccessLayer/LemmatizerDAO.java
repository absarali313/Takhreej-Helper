/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import java.io.IOException;

/**
 *
 * @author ch-sa
 */
public class LemmatizerDAO implements ILemmatizerDAO {

    LemmatizerProxyDAO lemma = new LemmatizerProxyDAO();
    @Override
    public String getLemmatizedWord(String textToLemmatize) throws IOException {
       return  lemma.getLemmatizedWord(textToLemmatize);
    }
    
}
