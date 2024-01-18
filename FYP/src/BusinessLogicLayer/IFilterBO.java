package BusinessLogicLayer;

/**
 *
 * @author Absar Ali
 */
public interface IFilterBO {

    boolean createFilter(String expression);

    boolean deleteFilter(int id);

    boolean updateFilterExpression(int id, String expression);
    
}
