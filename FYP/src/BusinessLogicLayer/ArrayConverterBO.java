/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogicLayer;

import TransferObject.Narrator;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public class ArrayConverterBO implements IConverterBO{

    public ArrayConverterBO() {
    }

    public String convert(ArrayList<String> list) {
        // Check if the list is not empty
        if (list != null && !list.isEmpty()) {
            return String.join(" ", list);
        } else {
            // Return an empty string if the list is empty or null
            return "";
        }
    }
    public String convertNarratorsListToString(ArrayList<Narrator> list){
         if (list != null && !list.isEmpty()) {
             ArrayList<String> narrators = new ArrayList<String>();
             for(Narrator narrator : list){
                 narrators.add(narrator.getName());
             }
            return String.join(", ", narrators);
        } else {
            // Return an empty string if the list is empty or null
            return "NO SANAD";
        }
    }

}
