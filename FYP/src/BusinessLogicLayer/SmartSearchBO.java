/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogicLayer;

import CustomException.NoHadithFoundException;
import DataAccessLayer.IFascadeDAO;
import TransferObject.Hadith;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ch-sa
 */
public class SmartSearchBO implements ISmartSearchBO {
    IFascadeDAO fascadeDAO;
    public SmartSearchBO(IFascadeDAO fascadeDAO){
        this.fascadeDAO = fascadeDAO;
    }
    @Override
    public ArrayList<String> getTopics(String matn){
        ArrayList<String> topics = new ArrayList<String>();
        for(String topic : fascadeDAO.predictTopic(matn).split(",")){
            topics.add(topic);
            System.out.println(topic);
        }
        return topics;
    }
    public ArrayList<Hadith> Search(String matn){
        ArrayList<Hadith> hadiths = new ArrayList<Hadith>();
        ArrayList<String> topics = getTopics(matn);
        FilterConverterBO converter = new FilterConverterBO(fascadeDAO);
        String expression = converter.converTopicsToFilter(topics);
        ArrayList<Integer> hadithIds = fascadeDAO.getdHadithIdsByTopic(expression);
        try {
            hadiths = fascadeDAO.getHadiths(hadithIds);
        } catch (NoHadithFoundException ex) {
            Logger.getLogger("Exception in finding hadith in smart search : " + ex.getMessage());
        }
        return hadiths;
    }
    
}
