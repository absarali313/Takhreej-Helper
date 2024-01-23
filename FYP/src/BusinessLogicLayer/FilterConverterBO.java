/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogicLayer;

import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public class FilterConverterBO implements IConverterBO {

    @Override
    public String convert(ArrayList<String> list) {
        String expression = "";
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                if (!list.get(i).startsWith("!")) {
                    expression = "LIKE %" + list.get(i) + "% ";
                } else {
                    expression = "NOT LIKE %" + list.get(i) + "% ";
                }

            } else {
                expression = list.get(i) + " ";
            }
        }
        return expression;
    }

}
