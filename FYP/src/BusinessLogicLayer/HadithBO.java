/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogicLayer;

import CustomException.NoHadithFoundException;
import DataAccessLayer.FascadeDAO;
import DataAccessLayer.IFascadeDAO;
import TransferObject.Hadith;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public class HadithBO implements IHadithBO {

    private IFascadeDAO fascadeDAO;

    public HadithBO(IFascadeDAO fascade) {
        this.fascadeDAO =  fascade;
    }

    @Override
    public ArrayList<Hadith> getAllHadiths(ArrayList<Integer> serials) {
        ArrayList<Hadith> list = new ArrayList<>();
        try {
            list = fascadeDAO.getHadiths(serials);
        } catch(NoHadithFoundException e){
            return list;
        }
        return list;
    }
    
    
}
