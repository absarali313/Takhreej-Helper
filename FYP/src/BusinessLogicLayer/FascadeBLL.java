package BusinessLogicLayer;

import DataAccessLayer.FascadeDAO;
import TransferObject.Research;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public class FascadeBLL implements IFascadeBLL {
    IResearchBO researchBO;

    public FascadeBLL() {
        this.researchBO = new ResearchBO(new FascadeDAO());
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
    
}
