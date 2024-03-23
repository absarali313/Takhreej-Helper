/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicLayer;

import TransferObject.Hadith;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public interface ISmartSearchBO {

    ArrayList<String> getTopics(String matn);
    ArrayList<Hadith> Search(String matn);
    
}
