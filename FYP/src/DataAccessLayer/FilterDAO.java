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
    public boolean insertFilter(int researchId, int orderNo, String expression, String searchType) {

        String query = "INSERT INTO filter(researchId,orderNo,expression,type) Values(?,?,?,?) ";
        try (java.sql.PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, researchId);
            preparedStatement.setInt(2, orderNo);
            preparedStatement.setString(3, expression);
            preparedStatement.setString(4, searchType);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Log.getLogger().error("Error in creating new filter", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateFilter(int reseachId, int orderNo, String filter) {

        String query = "UPDATE filter SET expression = ? WHERE researchId = ? AND orderNo = ?";
        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, filter);

            preparedStatement.setInt(2, reseachId);
            preparedStatement.setInt(3, orderNo);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Upadting");
                return true;  // Update successful
            } else {
                System.out.println("Failed");
                Log.getLogger().info("No rows were updated. filter with id: " + reseachId + " not found.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Failed");
            Log.getLogger().error("Error in updating filter", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateFilterType(int reseachId, int orderNo, String type) {

        String query = "UPDATE filter SET type = ? WHERE researchId = ? AND orderNo = ?";
        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {

            preparedStatement.setInt(2, reseachId);
            preparedStatement.setInt(3, orderNo);
            preparedStatement.setString(1, type);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Upadting");
                return true;  // Update successful
            } else {
                System.out.println("Failed");
                Log.getLogger().info("No rows were updated. filter with id: " + reseachId + " not found.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Failed");
            Log.getLogger().error("Error in updating filter", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteFilter(int researchId) {

        String query = "DELETE FROM filter WHERE researchId = ?";
        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, researchId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return true;  // Update successful
            } else {
                Log.getLogger().info("No rows were deleted. Filter with research id: " + researchId + " not found.");
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
                    String type = resultSet.getString("type");
                    System.out.println(type + " " + expression);
                    filters.add(new Filter(id, orderNo, expression, type));
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
