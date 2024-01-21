package DataAccessLayer;

import CustomException.ResearchAlreadyExistsException;
import CustomLogger.Log;
import TransferObject.Hadith;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Absar Ali
 */
public class ResearchDAO implements IResearchDAO {

    @Override
    public boolean insertResearch(String name) throws ResearchAlreadyExistsException{
        if(researchExists(name))
            throw new ResearchAlreadyExistsException("Research with this name already exists ");
        String query = "INSERT INTO RESEARCH(name) Values(?) ";
        try (java.sql.PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            Log.getLogger().error("Error in creating new research", e.getMessage());
            return false;
        }
    }

    private boolean researchExists(String name) {
        String query = "SELECT COUNT(*) FROM research WHERE name = ?";
        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
             Log.getLogger().error("Error in finding research with this name.", e.getMessage());
        }
        return false; // Default to false in case of errors
    }
    @Override
    public boolean updateResearch(int id, String newName) {
        
        String query = "UPDATE RESEARCH SET name = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, newName);
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
    public boolean deleteResearch(int id) {
        
        String query = "DELETE FROM research WHERE id = ?";
        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return true;  // Update successful
            } else {
                Log.getLogger().info("No rows were deleted. Research with id: " + id + " not found.");
                return false;
            }
        } catch (SQLException e) {
            Log.getLogger().error("Error in deleting research", e.getMessage());
            return false;
        }
    }
   


}
