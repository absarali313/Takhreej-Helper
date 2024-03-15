package BusinessLogicLayer;

import CustomException.NoHadithFoundException;
import DataAccessLayer.IFascadeDAO;
import TransferObject.Hadith;
import TransferObject.Research;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Absar Ali
 */
public class SearchBO implements ISearchBO {

    private IFascadeDAO fascadeDAO;
    private IFascadeBLL fascadeBLL;

    public SearchBO(IFascadeDAO fascadeDAO, IFascadeBLL fascadeBLL) {
        this.fascadeDAO = fascadeDAO;
        this.fascadeBLL = fascadeBLL;
    }

    @Override
    public ArrayList<Hadith> searchHadiths(Research research, int filterIndex) {
        ArrayList<Hadith> hadiths = new ArrayList<Hadith>();
        ArrayList<Integer> hadithIds = new ArrayList<Integer>();
        for (int i = 0; i <= filterIndex; i++) {
            String expression;
            FilterConverterBO converter = new FilterConverterBO();
            ArrayList<String> filterArray = fascadeBLL.convert(research.getFilters().get(i).getExpression());
            expression = converter.convert(filterArray);
            System.out.println(expression);
            hadithIds.addAll(fascadeDAO.getFilteredHadithIds(expression));
        }
        System.out.println(countOccurrences(hadithIds,85));
         System.out.println(countOccurrences(hadithIds,61));
        hadithIds = keepAtLeastXTimesElements(hadithIds,filterIndex+1);
        try {
            hadiths = fascadeDAO.getHadiths(hadithIds);
        } catch (NoHadithFoundException ex) {
            Logger.getLogger("No hadith found");
        }
        return hadiths;
    }
public static ArrayList<Integer> keepAtLeastXTimesElements(ArrayList<Integer> arrayList, int x) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
       
        // Count occurrences of each element
        for (Integer element : arrayList) {
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }
        
        // Traverse the HashMap and add elements occurring at least x times to the result ArrayList
        
        for (Integer element : countMap.keySet()) {
            if (countMap.get(element) >= x) {
                result.add(element);
            }
        }
        System.out.println(countMap.get(85));
        System.out.println(countMap.get(61));
        return result;
    }

 public static int countOccurrences(ArrayList<Integer> arrayList, int elementToCount) {
        int count = 0;
        for (Integer element : arrayList) {
            if (element.equals(elementToCount)) {
                count++;
            }
        }
        return count;
    }

//    public ArrayList<Hadith> filterHadith(ArrayList<String> expressionList) {
//        ArrayConverterBO converter = new ArrayConverterBO();
//        String expression = converter.ArrayToString(expressionList);
//        
//        return null;
//    }
}
