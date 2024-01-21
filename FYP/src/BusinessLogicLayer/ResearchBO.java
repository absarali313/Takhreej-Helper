package BusinessLogicLayer;

import CustomException.ResearchAlreadyExistsException;
import DataAccessLayer.FascadeDAO;
import DataAccessLayer.IFascadeDAO;

/**
 *
 * @author Absar Ali
 */
public class ResearchBO implements IResearchBO {

    IFascadeDAO fascadeDAO;

    public ResearchBO(IFascadeDAO fascade) {
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
