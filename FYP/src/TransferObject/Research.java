package TransferObject;

import java.util.ArrayList;

/**
 *
 * @author Absar Ali
 */
public class Research {
    private int researchId;
    private String name;
    private ArrayList<Hadith> searchBaseLine;
    
    public Research(int researchId, String name, ArrayList<Hadith> searchBaseLine) {
        this.researchId = researchId;
        this.name = name;
        this.searchBaseLine = searchBaseLine;
    }

    public int getResearchId() {
        return researchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Hadith> getSearchBaseLine() {
        return searchBaseLine;
    }

    public void setSearchBaseLine(ArrayList<Hadith> searchBaseLine) {
        this.searchBaseLine = searchBaseLine;
    }
    
    
}
