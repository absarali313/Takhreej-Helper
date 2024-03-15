package BusinessLogicLayer;

import CustomException.NoHadithFoundException;
import DataAccessLayer.IFascadeDAO;
import TransferObject.Hadith;
import TransferObject.Research;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Absar Ali
 */
public class SearchBO implements ISearchBO {

    private IFascadeDAO fascadeDAO;
    private IFascadeBLL fascadeBLL;
    public SearchBO(IFascadeDAO fascadeDAO,IFascadeBLL fascadeBLL) {
        this.fascadeDAO = fascadeDAO;
        this.fascadeBLL = fascadeBLL;
    }

    @Override
    public ArrayList<Hadith> searchHadiths(Research research, int filterIndex){
        ArrayList<Hadith> hadiths = new ArrayList<Hadith>();
        ArrayList<Integer> hadithIds = new ArrayList<Integer>();
        String expression;
        FilterConverterBO converter = new FilterConverterBO();
        ArrayList<String> filterArray = fascadeBLL.convert(research.getFilters().get(filterIndex).getExpression());
        
        expression = converter.convert(filterArray);
        System.out.println(expression);
        hadithIds = fascadeDAO.getFilteredHadithIds(expression);
        try {
            hadiths = fascadeDAO.getHadiths(hadithIds);
        } catch (NoHadithFoundException ex) {
            Logger.getLogger("No hadith found");
        }
        return hadiths;
    }
    
//    public ArrayList<Hadith> filterHadith(ArrayList<String> expressionList) {
//        ArrayConverterBO converter = new ArrayConverterBO();
//        String expression = converter.ArrayToString(expressionList);
//        
//        return null;
//    }

}
