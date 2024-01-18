package BusinessLogicLayer;

import CustomException.ResearchAlreadyExistsException;
import DataAccessLayer.FascadeDAO;
import DataAccessLayer.IFascadedao;

/**
 *
 * @author Absar Ali
 */
public class ResearchBO implements IResearchBO {

    IFascadedao fascadeDAO;

    public ResearchBO(IFascadedao fascade) {
        fascadeDAO = fascade;
    }

    @Override
    public boolean createResearch(String name) {
        try {
            if (fascadeDAO.insertResearch(name)) {
                return true;
            }
        } catch (ResearchAlreadyExistsException e) {
            return false;
        }
        return false;
    }
    
    @Override
    public boolean updateResearchName(int id, String name){
         try {
            if (fascadeDAO.updateResearch(id,name)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
    @Override
     public boolean deleteResearch(int id){
         try {
            if (fascadeDAO.deleteResearch(id)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}
