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
    IResearchBO researchBO;
    IHadithBO hadithBO;
    
    public FascadeBLL() {
        this.researchBO = new ResearchBO(new FascadeDAO());
        this.hadithBO = new HadithBO(new FascadeDAO());
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
    public Research getResearch(String name){
        return researchBO.getResearch(name);
    }

    @Override
    public ArrayList<Hadith> getAllHadiths(ArrayList<Integer> serials) {
        return hadithBO.getAllHadiths(serials);
    }
    
}
