/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogicLayer;

import CustomException.ResearchAlreadyExistsException;
import DataAccessLayer.IFascadeDAO;
import TransferObject.Filter;
import TransferObject.Research;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ch-sa
 */
public class MergeResearchBO implements IMergerResearch {
    
    IFascadeDAO fascadeDAO;
    
    public MergeResearchBO(IFascadeDAO fascade){
        fascadeDAO = fascade;
    }
    
    @Override
    public boolean mergeResearches(String name,Research research1, Research research2) {
        if (research1 == null && research2 == null) {
            return false;
        } 

       
        ArrayList<Filter> mergedFilters = mergeFilters(research1.getFilters(), research2.getFilters());
        
        try {
            fascadeDAO.insertResearch(name);
        } catch (ResearchAlreadyExistsException ex) {
            Logger.getLogger(MergeResearchBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        Research research = fascadeDAO.getResearchByName(name);
        int count = 0;
        for(Filter filter : mergedFilters){
            fascadeDAO.insertFilter(research.getResearchId(), count, filter.getExpression(), filter.getType());
            count++;
        }
        return true;
    }

    private static ArrayList<Filter> mergeFilters(ArrayList<Filter> filters1, ArrayList<Filter> filters2) {
        ArrayList<Filter> mergedFilters = new ArrayList<>();

        if (filters1 != null) {
            mergedFilters.addAll(filters1);
        }
        if (filters2 != null) {
            mergedFilters.addAll(filters2);
        }

        return mergedFilters;
    }
    
    
}
