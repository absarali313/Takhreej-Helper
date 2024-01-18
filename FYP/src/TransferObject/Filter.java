package TransferObject;

import java.util.ArrayList;

/**
 *
 * @author Absar Ali
 */
public class Filter {
    private int id;
    private String expression;
    
     public Filter() {
        this.expression = "";
    }

    public Filter(int id) {
        this.id = id;
        this.expression = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public Filter(String expression, int id) {
        this.expression = expression;
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
    
    
    
    
}
