/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import CustomException.ResearchAlreadyExistsException;
import CustomLogger.Log;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ch-sa
 */
public class FilterDAO implements IFilterDAO {
    
    
    
    @Override
    public boolean insertFilter(String expression){
        
        String query = "INSERT INTO filter(expression) Values(?) ";
        try (java.sql.PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, expression);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Log.getLogger().error("Error in creating new research", e.getMessage());
            return false;
        }
    }
    
    
    @Override
     public boolean updateFilter(int id, String filter) {
        
        String query = "UPDATE filter SET expression = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, filter);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return true;  // Update successful
            } else {
                Log.getLogger().info("No rows were updated. Research with id: " + id + " not found.");
                return false;
            }
        } catch (SQLException e) {
            Log.getLogger().error("Error in updating research", e.getMessage());
            return false;
        }
    }

    @Override
     public boolean deleteFilter(int id) {
        
        String query = "DELETE FROM filter WHERE id = ?";
        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return true;  // Update successful
            } else {
                Log.getLogger().info("No rows were deleted. Filter with id: " + id + " not found.");
                return false;
            }
        } catch (SQLException e) {
            Log.getLogger().error("Error in deleting Filter", e.getMessage());
            return false;
        }
    }
}
