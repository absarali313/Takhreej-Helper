/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DataAccessLayer;

/**
 *
 * @author ch-sa
 */
public interface IFilterDAO {

    boolean deleteFilter(int id);

    boolean insertFilter(String expression);

    boolean updateFilter(int id, String filter);
    
}
