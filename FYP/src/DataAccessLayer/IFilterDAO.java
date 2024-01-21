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

    boolean insertFilter(int researchId, int orderNo, String filter);

    boolean updateFilter(int id,int orderNo, String filter);
    
}
