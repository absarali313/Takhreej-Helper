package BusinessLogicLayer;

import DataAccessLayer.FascadeDAO;
import TransferObject.Hadith;
import TransferObject.Research;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public class FascadeBLL implements IFascadeBLL {

    ISmartSearchBO smartSearchBO;
    ISearchBO searchBO;
    IResearchBO researchBO;
    IHadithBO hadithBO;
    IFilterBO filterBO;
    IStringConverter stringConverter;
    FascadeDAO fascadeDAO = new FascadeDAO();
    public FascadeBLL() {
        this.researchBO = new ResearchBO(fascadeDAO);
        this.hadithBO = new HadithBO(fascadeDAO);
        this.filterBO = new FilterBO(fascadeDAO);
        this.stringConverter = new StringConverter();
        this.searchBO = new SearchBO(fascadeDAO, this);
        this.smartSearchBO = new SmartSearchBO(fascadeDAO);
    }

    @Override
    public boolean createResearch(String name) {
        return researchBO.createResearch(name);
    }

    @Override
    public boolean deleteResearch(int id) {
        return researchBO.deleteResearch(id);
    }

    @Override
    public boolean updateResearchName(int id, String name) {
        return researchBO.updateResearchName(id, name);
    }

    @Override
    public ArrayList<Research> getAllResearches() {
        return researchBO.getAllResearches();
    }

    @Override
    public Research getResearch(String name) {
        return researchBO.getResearch(name);
    }

    @Override
    public ArrayList<Hadith> getAllHadiths(ArrayList<Integer> serials) {
        return hadithBO.getAllHadiths(serials);
    }

    @Override
    public boolean createFilter(int researchId, int orderNo, String expression) {
        return filterBO.createFilter(researchId, orderNo, expression);
    }

    @Override
    public boolean deleteFilter(int id) {
        return filterBO.deleteFilter(id);
    }

    @Override
    public boolean updateFilterExpression(int id, int orderNo, String expression) {
        return filterBO.updateFilterExpression(id, orderNo, expression);
    }

    @Override
    public ArrayList<String> convert(String inputString) {
        return stringConverter.convert(inputString);
    }

    @Override
    public ArrayList<Hadith> searchHadiths(Research research, int filterIndex) {
        return searchBO.searchHadiths(research, filterIndex);
    }

    @Override
    public ArrayList<String> getTopics(String matn) {
        return smartSearchBO.getTopics(matn);
    }

    @Override
    public ArrayList<Hadith> Search(String matn) {
      return smartSearchBO.Search(matn);
    }

}
