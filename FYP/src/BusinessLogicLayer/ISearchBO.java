/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BusinessLogicLayer;

import TransferObject.Hadith;
import TransferObject.Research;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public interface ISearchBO {

    ArrayList<Hadith> searchHadiths(Research research, int filterIndex);
    //ArrayList<Hadith> searchHadithsByPattern(Research research, int filterIndex);
    
}
