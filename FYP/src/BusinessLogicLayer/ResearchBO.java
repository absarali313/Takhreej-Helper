package BusinessLogicLayer;

import CustomException.NoResearchFoundException;
import CustomException.ResearchAlreadyExistsException;
import CustomLogger.Log;
import DataAccessLayer.FascadeDAO;
import DataAccessLayer.IFascadeDAO;
import TransferObject.Research;
import java.util.ArrayList;

/**
 *
 * @author Absar Ali
 */
public class ResearchBO implements IResearchBO {

    IFascadeDAO fascadeDAO;

    public ResearchBO(IFascadeDAO fascade) {
        this.fascadeDAO = fascade;
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
    public boolean updateResearchName(int id, String name) {
        try {
            if (fascadeDAO.updateResearch(id, name)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean deleteResearch(int id) {
        try {
            if (fascadeDAO.deleteResearch(id)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public ArrayList<Research> getAllResearches() {
        ArrayList<Research> researches = new ArrayList<Research>();
        try {
            researches = fascadeDAO.getAllResearch();
        } catch (NoResearchFoundException e) {
            Log.getLogger().info("No Research found in the database.");
        }
        return researches;
    }
    @Override
    public Research getResearch(String name){
        Research research = null;
         try {
            research = fascadeDAO.getResearchByName(name);
        } catch (Exception e) {
            Log.getLogger().info("No Research found in the database.");
            return research;
        }
        return research;
    }

}
