/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import CustomException.ResearchAlreadyExistsException;
import CustomLogger.Log;
import TransferObject.Filter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public class FilterDAO implements IFilterDAO {

    @Override
    public boolean insertFilter(int researchId, int orderNo, String expression) {

        String query = "INSERT INTO filter(researchId,orderNo,expression) Values(?,?,?) ";
        try (java.sql.PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, researchId);
            preparedStatement.setInt(2, orderNo);
            preparedStatement.setString(3, expression);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Log.getLogger().error("Error in creating new research", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateFilter(int id, int orderNo, String filter) {

        String query = "UPDATE filter SET expression = ?, orderNo = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, filter);
            preparedStatement.setInt(2, orderNo);
            preparedStatement.setInt(3, id);
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

    public ArrayList<Filter> getFilters(int researchId) {
        ArrayList<Filter> filters = new ArrayList<Filter>();

        String query = "SELECT * FROM filter where researchId = ?";

        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, researchId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int orderNo = resultSet.getInt("orderNo");
                    String expression = resultSet.getString("expression");
                    filters.add(new Filter(id, orderNo, expression));
                }
            }

            if (filters.isEmpty()) {
                Log.getLogger().info("No filter found in the database.");
            }

        } catch (SQLException e) {
            Log.getLogger().error("Error in retrieving filter", e.getMessage());
        } catch (Exception e) {
            Log.getLogger().error("Error while getting filter from the database: " + e.getMessage());
        }

        return filters;
    }

}
