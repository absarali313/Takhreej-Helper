/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessLayer;

import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public interface ISearchDAO {

    ArrayList<Integer> getFilteredHadithIds(String expression);
    
}
