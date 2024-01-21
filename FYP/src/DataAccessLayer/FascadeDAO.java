package DataAccessLayer;

import CustomException.ResearchAlreadyExistsException;
import TransferObject.Book;
import TransferObject.Filter;
import TransferObject.Hadith;
import TransferObject.Narrator;
import TransferObject.Research;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public class FascadeDAO implements IFascadeDAO {

    IResearchDAO researchDAO;
    IFilterDAO filterDAO;
    INarratorsDAO narratorsDAO;
    IBookDAO bookDAO;
    IHadithDAO hadithDAO;

    public FascadeDAO() {
        researchDAO = new ResearchDAO(new FilterDAO());
        filterDAO = new FilterDAO();
        narratorsDAO = new NarratorsDAO();
        bookDAO = new BookDAO();
        hadithDAO = new HadithDAO(new BookDAO(), new NarratorsDAO());
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
    public Research getResearchById(int id) {
        return researchDAO.getResearchById(id);
    }

    @Override
    public ArrayList<Research> getAllResearch() {
        return researchDAO.getAllResearch();
    }

    @Override
    public boolean insertFilter(int researchId, int orderNo, String expression) {
        return filterDAO.insertFilter(researchId, orderNo, expression);
    }

    @Override
    public boolean updateFilter(int id, int orderNo, String filter) {
        return filterDAO.updateFilter(id, orderNo, filter);
    }

    @Override
    public boolean deleteFilter(int id) {
        return filterDAO.deleteFilter(id);
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
    public ArrayList<Hadith> getHadiths(ArrayList<Integer> serials) {
        return hadithDAO.getHadiths(serials);
    }

}