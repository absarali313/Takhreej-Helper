/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessLayer;

import TransferObject.Filter;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public interface IFilterDAO {

    boolean deleteFilter(int id,int orderNum);

    boolean insertFilter(int researchId, int orderNo, String filter, String type);

    boolean updateFilter(int id, int orderNo, String filter);

    boolean updateFilterType(int id, int orderNo, String type);

    public ArrayList<Filter> getFilters(int researchId);

}
