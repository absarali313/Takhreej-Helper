package BusinessLogicLayer;

import CustomException.ResearchAlreadyExistsException;
import DataAccessLayer.IFascadeDAO;

/**
 *
 * @author Absar Ali
 */
public class FilterBO implements IFilterBO {

    IFascadeDAO fascadeDAO;

    public FilterBO(IFascadeDAO fascade) {
        fascadeDAO = fascade;
    }

    @Override
    public boolean createFilter(int researchId, int orderNo, String expression,String type) {
        try {
            if (fascadeDAO.insertFilter(researchId,orderNo,expression, type)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean updateFilterExpression(int id,int orderNo, String expression) {
        try {
            if (fascadeDAO.updateFilter(id,orderNo, expression)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean deleteFilter(int id) {
        try {
            if (fascadeDAO.deleteFilter(id)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
    
}
