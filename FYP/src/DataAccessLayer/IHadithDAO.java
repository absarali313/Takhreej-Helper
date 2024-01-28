/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessLayer;

import CustomException.NoHadithFoundException;
import TransferObject.Hadith;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public interface IHadithDAO {

    ArrayList<Integer> getAllHadithIds();

    Hadith getHadithById(int index);

    ArrayList<Hadith> getHadiths(ArrayList<Integer> serials) throws NoHadithFoundException;
    
}
