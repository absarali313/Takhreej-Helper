package BusinessLogicLayer;

/**
 *
 * @author Absar Ali
 */
public interface IFilterBO {

    boolean createFilter(int researchId, int orderNo, String expression,String type);

    boolean deleteFilter(int id);

    boolean updateFilterExpression(int id,int orderNo, String expression);
    
}
