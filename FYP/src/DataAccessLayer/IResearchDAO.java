/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessLayer;

import CustomException.ResearchAlreadyExistsException;

/**
 *
 * @author ch-sa
 */
public interface IResearchDAO {

    boolean insertResearch(String name) throws ResearchAlreadyExistsException;

    boolean updateResearch(int id, String newName);
    
    boolean deleteResearch(int id);
    
}
