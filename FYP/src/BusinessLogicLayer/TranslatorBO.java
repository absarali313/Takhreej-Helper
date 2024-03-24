/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogicLayer;

import DataAccessLayer.IFascadeDAO;

/**
 *
 * @author ch-sa
 */
public class TranslatorBO implements ITranslatorBO {
    IFascadeDAO fascadeDAO;
    
    public TranslatorBO(IFascadeDAO fascadeDAO){
        this.fascadeDAO = fascadeDAO;
    }
    
    @Override
    public String getTranslationToEnglish(String matn){
        return fascadeDAO.translateHadith(matn);
    }
}
