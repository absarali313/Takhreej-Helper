/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessLayer;

import CustomException.ResearchAlreadyExistsException;
import TransferObject.Filter;
import TransferObject.Research;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public interface IResearchDAO {

    boolean insertResearch(String name) throws ResearchAlreadyExistsException;

    boolean updateResearch(int id, String newName);
    
    boolean deleteResearch(int id);
    
    boolean insertResearch(String name,Filter filter) throws ResearchAlreadyExistsException;
    
    ArrayList<Integer> getResearchBaselineIds(int researchId);
    
    public Research getResearchById(int id);
    
    ArrayList<Research> getAllResearch();
    
    
}
