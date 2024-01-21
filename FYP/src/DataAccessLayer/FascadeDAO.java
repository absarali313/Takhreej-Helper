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
    public boolean insertFilter(int researchId, int orderNo, String expression) {
       return filterDAO.insertFilter(researchId,orderNo,expression);
    }

    @Override
    public boolean updateFilter(int id, int orderNo, String filter) {
       return filterDAO.updateFilter(id,orderNo, filter);
    }

    @Override
    public boolean deleteFilter(int id) {
       return filterDAO.deleteFilter(id);
    }
    
}
