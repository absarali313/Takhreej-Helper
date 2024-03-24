package BusinessLogicLayer;

import CustomException.NoHadithFoundException;
import DataAccessLayer.FascadeDAO;
import DataAccessLayer.IFascadeDAO;
import TransferObject.Hadith;
import TransferObject.Research;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
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

            if (research.getFilters().get(i).getType().equals("Pattern")) {
                hadithIds.addAll(searchHadithsByPattern(research, i));
            } else if (research.getFilters().get(i).getType().equals("Lemma")) {
                hadithIds.addAll(searchHadithsByLemma(research, i));
            }
        }
        hadithIds = keepAtLeastXTimesElements(hadithIds, filterIndex + 1);

        try {
            hadiths = fascadeDAO.getHadiths(hadithIds);
        } catch (NoHadithFoundException ex) {
            Logger.getLogger("No hadith found");
        }
        
        return hadiths;
    }

    public ArrayList<Integer> searchHadithsByPattern(Research research, int filterIndex) {
        ArrayList<Hadith> hadiths = new ArrayList<Hadith>();
        ArrayList<Integer> hadithIdsRegex = new ArrayList<Integer>();

        String expression;
        FilterConverterBO converter = new FilterConverterBO(new FascadeDAO());
        ArrayList<String> filterArray = fascadeBLL.convert(research.getFilters().get(filterIndex).getExpression());
        expression = converter.convertToFilter(filterArray);
        System.out.println(expression);
        hadithIdsRegex.addAll(fascadeDAO.getFilteredHadithIds(expression));

        ArrayList<Integer> hadithIds = hadithIdsRegex;

        return hadithIds;
    }

    public ArrayList<Integer> searchHadithsByLemma(Research research, int filterIndex) {
       
        ArrayList<Integer> hadithIdsRegex = new ArrayList<Integer>();

        String expression;
        FilterConverterBO converter = new FilterConverterBO(new FascadeDAO());
        ArrayList<String> filterArray = fascadeBLL.convert(research.getFilters().get(filterIndex).getExpression());
        expression = converter.converLemmaToFilter(filterArray);
        System.out.println(expression);
        hadithIdsRegex.addAll(fascadeDAO.getFilteredRootsHadithIds(expression));

        ArrayList<Integer> hadithIds = hadithIdsRegex;

        return hadithIds;
    }

    public static ArrayList<Integer> keepAtLeastXTimesElements(ArrayList<Integer> arrayList, int x) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Count occurrences of each element
        for (Integer element : arrayList) {
            countMap.put(element, countMap.getOrDefault(element, 0) + 1);
        }
        System.out.print("Before " + countMap.size());

        // Traverse the HashMap and add elements occurring at least x times to the result ArrayList
        for (Integer element : countMap.keySet()) {
            if (countMap.get(element) == x) {
                result.add(element);
            }
        }
        System.out.print("After : " + result.size());
        return result;
    }

    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        // Create a set to store unique elements
        Set<Integer> unionSet = new HashSet<>();

        // Add all elements from the first list to the set
        unionSet.addAll(list1);

        // Add all elements from the second list to the set
        unionSet.addAll(list2);

        // Create a new list to store the union of elements
        ArrayList<Integer> unionList = new ArrayList<>(unionSet);

        return unionList;
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
