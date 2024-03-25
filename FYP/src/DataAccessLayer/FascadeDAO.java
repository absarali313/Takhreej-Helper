package DataAccessLayer;

import CustomException.NoHadithFoundException;
import CustomException.NoResearchFoundException;
import CustomException.ResearchAlreadyExistsException;
import TransferObject.Book;
import TransferObject.Filter;
import TransferObject.Hadith;
import TransferObject.Narrator;
import TransferObject.Research;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public class FascadeDAO implements IFascadeDAO {

    ITopicGenerator topicGenerator;
    IResearchDAO researchDAO;
    IFilterDAO filterDAO;
    INarratorsDAO narratorsDAO;
    IBookDAO bookDAO;
    IHadithDAO hadithDAO;
    ISearchDAO searchDAO;
    ILemmatizerDAO lemmatizerDAO;
    ITranslatorDAO translatorDAO;

    public FascadeDAO() {
        searchDAO = new SearchDAO();
        researchDAO = new ResearchDAO(new FilterDAO());
        filterDAO = new FilterDAO();
        narratorsDAO = new NarratorsDAO();
        bookDAO = new BookDAO();
        hadithDAO = new HadithDAO(new BookDAO(), new NarratorsDAO());
        lemmatizerDAO = new LemmatizerDAO();
        topicGenerator = new TopicGenerator();
        translatorDAO = new TranslatorDAO();
        
    }

    @Override
    public boolean insertResearch(String name) throws ResearchAlreadyExistsException {
        return researchDAO.insertResearch(name);
    }

    @Override
    public boolean updateResearch(int id, String newName) {
        return researchDAO.updateResearch(id, newName);
    }

    @Override
    public boolean deleteResearch(int id) {
        return researchDAO.deleteResearch(id);
    }

    @Override
    public boolean insertResearch(String name, Filter filter) throws ResearchAlreadyExistsException {
        return researchDAO.insertResearch(name, filter);
    }

    @Override
    public ArrayList<Integer> getResearchBaselineIds(int researchId) {
        return researchDAO.getResearchBaselineIds(researchId);
    }

    @Override
    public Research getResearchByName(String name) {
        return researchDAO.getResearchByName(name);
    }

    @Override
    public ArrayList<Research> getAllResearch() throws NoResearchFoundException {
        return researchDAO.getAllResearch();
    }

    @Override
    public boolean insertFilter(int researchId, int orderNo, String expression,String type) {
        return filterDAO.insertFilter(researchId, orderNo, expression,type);
    }

    @Override
    public boolean updateFilter(int id, int orderNo, String filter) {
        return filterDAO.updateFilter(id, orderNo, filter);
    }
    @Override
    public boolean updateFilterType(int id, int orderNo, String type) {
        return filterDAO.updateFilterType(id, orderNo, type);
    }

    @Override
    public boolean deleteFilter(int id, int orderNum) {
        return filterDAO.deleteFilter(id,orderNum);
    }

    @Override
    public ArrayList<Filter> getFilters(int researchId) {
        return filterDAO.getFilters(researchId);
    }

    @Override
    public ArrayList<Narrator> getNarrator(int id) {
        return narratorsDAO.getNarrator(id);
    }

    @Override
    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Override
    public ArrayList<Integer> getAllHadithIds() {
        return hadithDAO.getAllHadithIds();
    }

    @Override
    public Hadith getHadithById(int index) {
        return hadithDAO.getHadithById(index);
    }

    @Override
    public ArrayList<Hadith> getHadiths(ArrayList<Integer> serials) throws NoHadithFoundException {
        return hadithDAO.getHadiths(serials);
    }

    @Override
    public ArrayList<Integer> getFilteredHadithIds(String expression) {
        return searchDAO.getFilteredHadithIds(expression);
    }

    @Override
    public ArrayList<Integer> getFilteredLemmaHadithIds(String expression) {
        return searchDAO.getFilteredLemmaHadithIds(expression);
    }
    
    @Override
    public ArrayList<Integer> getFilteredRootHadithIds(String expression){
        return searchDAO.getFilteredRootHadithIds(expression);
    }

    @Override
    public String getLemmatizedWord(String textToLemmatize) throws IOException {
        return lemmatizerDAO.getLemmatizedWord(textToLemmatize);
    }

    @Override
    public String predictTopic(String matn) {
        return topicGenerator.predictTopic(matn);
    }

    @Override
    public ArrayList<Integer> getdHadithIdsByTopic(String expression) {
        return searchDAO.getdHadithIdsByTopic(expression);
    }
    
    @Override
    public String translateHadith(String matn){
        return translatorDAO.translateHadith(matn);
    }

}
