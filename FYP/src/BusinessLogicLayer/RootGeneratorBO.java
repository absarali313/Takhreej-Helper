/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogicLayer;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author ch-sa
 */
public class RootGeneratorBO {
    
    public ArrayList<String> getRoots(String matn){
        ArrayList<String> roots = new ArrayList<String>();
        ArrayList<String> hadithRoots = new ArrayList<String>();
        matn = removeDiacriticsAndPunctuations(matn);
        for (String word : matn.split(" ")){
            roots.addAll(net.oujda_nlp_team.AlKhalil2Analyzer.getInstance().processToken(word).getAllRoots());
        }
        
        return roots;
    }
    
    public String removeDiacriticsAndPunctuations(String text) {
    // Remove diacritics
    String normalizedText = Normalizer.normalize(text, Normalizer.Form.NFD); 
    String withoutDiacritics = normalizedText.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

    // Remove punctuations
    String withoutPunctuations = withoutDiacritics.replaceAll("\\p{Punct}+", "");

    return withoutPunctuations;
}
    
}
