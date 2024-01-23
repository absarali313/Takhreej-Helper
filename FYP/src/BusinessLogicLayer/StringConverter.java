/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogicLayer;

import java.util.*;

/**
 *
 * @author ch-sa
 */
public class StringConverter {
    
     public ArrayList<String> convert(String inputString) {
        // Check if the input string is not null or empty
        if (inputString != null && !inputString.isEmpty()) {
            // Split the string using comma as the delimiter
            String[] stringArray = inputString.split(",");

            // Convert the array to an ArrayList
            List<String> stringList = Arrays.asList(stringArray);

            // Return the ArrayList
            return new ArrayList<String>(stringList);
        } else {
            // Return an empty ArrayList if the input string is empty or null
            return new ArrayList<String>();
        }
    }
    
}
