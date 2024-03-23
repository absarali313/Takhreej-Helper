/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogicLayer;

import DataAccessLayer.FascadeDAO;
import DataAccessLayer.IFascadeDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ch-sa
 */
public class FilterConverterBO implements IConverterBO {

    IFascadeDAO fascadeDAO;

    public FilterConverterBO(IFascadeDAO fascade) {
        fascadeDAO = fascade;
    }

    @Override
    public String convertToFilter(ArrayList<String> list) {
        String expression = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("(") || list.get(i).equals(")")) {
                expression += list.get(i) + " ";
            } else if (!list.get(i).equals("AND") && !list.get(i).equals("OR")) {
                if (!list.get(i).startsWith("!")) {
                    expression += "matn REGEXP '" + list.get(i) + "' ";
                } else {
                    expression += "matn NOT REGEXP '" + list.get(i).replace("!", "") + "' ";
                }

            } else {
                expression += list.get(i) + " ";

            }
        }
        return expression;
    }

    public String converLemmaToFilter(ArrayList<String> list) {
        String expression = "";
        for (int i = 0; i < list.size(); i++) {
            try {
                list.set(i, fascadeDAO.getLemmatizedWord(list.get(i)));
            } catch (IOException ex) {
                Logger.getLogger(FilterConverterBO.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!list.get(i).equals("")) {
                if (list.get(i).equals("(") || list.get(i).equals(")")) {
                    expression += list.get(i) + " ";

                } else if (!list.get(i).equals("AND") && !list.get(i).equals("OR")) {
                    if (!list.get(i).startsWith("!")) {
                        expression += "root REGEXP '" + list.get(i) + "' ";
                    } else {
                        expression += "root NOT REGEXP  '" + list.get(i).replace("!", "") + "' ";
                    }

                } else {
                    expression += list.get(i) + " ";
                }
            }
        }
        return expression;
    }

    private String getLemma(String textToLemmatize) throws IOException {
        return fascadeDAO.getLemmatizedWord(textToLemmatize);
    }

}
