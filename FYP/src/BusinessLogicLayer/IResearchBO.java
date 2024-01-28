/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicLayer;

import TransferObject.Research;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public interface IResearchBO {

    boolean createResearch(String name);

    boolean deleteResearch(int id);

    boolean updateResearchName(int id, String name);
    
    ArrayList<Research> getAllResearches();
    
}
