package TransferObject;

import java.util.ArrayList;

/**
 *
 * @author Absar Ali
 */
public class Research {
    private int researchId;
    private String name;
    private ArrayList<Integer> searchBaseLine;
    private ArrayList<Filter> filters;
    
    public Research(int researchId, String name, ArrayList<Integer> searchBaseLine,ArrayList<Filter> filters) {
        this.researchId = researchId;
        this.name = name;
        this.searchBaseLine = searchBaseLine;
        this.filters = filters;
    }
    public Research(int researchId, String name,ArrayList<Filter> filters) {
        this.researchId = researchId;
        this.name = name;
        this.searchBaseLine = null;
        this.filters = filters;
    }
    
    

    public ArrayList<Filter> getFilters() {
        return filters;
    }

    public void setFilters(ArrayList<Filter> filters) {
        this.filters = filters;
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

    public ArrayList<Integer> getSearchBaseLine() {
        return searchBaseLine;
    }

    public void setSearchBaseLine(ArrayList<Integer> searchBaseLine) {
        this.searchBaseLine = searchBaseLine;
    }
    
    
}
