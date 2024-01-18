package DataAccessLayer;

import CustomException.ResearchAlreadyExistsException;

/**
 *
 * @author ch-sa
 */
public class FascadeDAO implements IFascadedao {
    IResearchDAO researchDAO;
    IFilterDAO filterDAO;
    public FascadeDAO(){
        researchDAO = new ResearchDAO();
        filterDAO = new FilterDAO();
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
    public boolean insertFilter(String expression) {
       return filterDAO.insertFilter(expression);
    }

    @Override
    public boolean updateFilter(int id, String filter) {
       return filterDAO.updateFilter(id, filter);
    }

    @Override
    public boolean deleteFilter(int id) {
       return filterDAO.deleteFilter(id);
    }
    
}
