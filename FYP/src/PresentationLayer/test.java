/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PresentationLayer;

import BusinessLogicLayer.FascadeBLL;
import BusinessLogicLayer.IFascadeBLL;
import TransferObject.Hadith;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public class test {
    
    
    public static void main(String[] args){
        
        
        IFascadeBLL fascadeBLL = new FascadeBLL();
        String matn = "إن جبريل عليه السلام لم يزال يوصيني بالجار حتى ظننت أنه سيورثه.";
        ArrayList<Hadith> hadiths = fascadeBLL.Search(matn);
        for(Hadith hadith : hadiths){
            System.out.println(hadith.getMatn());
        }
        System.out.println(hadiths.size());
    }
}
