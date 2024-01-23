package BusinessLogicLayer;

import DataAccessLayer.IFascadeDAO;
import TransferObject.Hadith;
import TransferObject.Research;
import java.util.ArrayList;

/**
 *
 * @author Absar Ali
 */
public class SearchBO extends ResearchBO {

    public SearchBO(IFascadeDAO fascade) {
        super(fascade);
    }

//    public ArrayList<Hadith> filterHadith(ArrayList<String> expressionList) {
//        ArrayConverterBO converter = new ArrayConverterBO();
//        String expression = converter.ArrayToString(expressionList);
//        
//        return null;
//    }

}
