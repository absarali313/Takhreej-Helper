package TransferObject;

/**
 *
 * @author Absar Ali
 */
public class Filter {
    private int id;
    private int orderNo;
    private String type;
    private String expression;
    
    public Filter(int id, int orderNo, String expression,String type) {
        this.id = id;
        this.orderNo = orderNo;
        this.type = type;
        this.expression = expression;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
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
    
    
    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    
    
}
