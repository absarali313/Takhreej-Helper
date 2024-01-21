package TransferObject;

import java.util.ArrayList;

/**
 *
 * @author Absar Ali
 */
public class Hadith {
    private int index;
    private int id;
    private String matn;
    private String bookName;
    private ArrayList<Narrator> Narrators;
    
    
    public Hadith(int index,int id, String matn, String bookName, ArrayList<Narrator> Narrators) {
        this.index = index;
        this.id = id;
        this.matn = matn;
        this.bookName = bookName;
        this.Narrators = Narrators;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getMatn() {
        return matn;
    }

    public void setMatn(String matn) {
        this.matn = matn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public ArrayList<Narrator> getNarrators() {
        return Narrators;
    }

    public void setNarrators(ArrayList<Narrator> Narrators) {
        this.Narrators = Narrators;
    }
    
    
    
}
