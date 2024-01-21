package DataAccessLayer;

import CustomLogger.Log;
import TransferObject.Hadith;
import TransferObject.Narrator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Manal Saqid
 */
public class NarratorsDAO implements INarratorsDAO {

    @Override
    public ArrayList<Narrator> getNarrator(int id) {
        String query = "SELECT * FROM narrator WHERE id = ?";
        ArrayList<Narrator> narrators = new ArrayList<Narrator>();

        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Retrieve data from the result set and construct a Hadith object
                    int narratorId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Narrator narrator = new Narrator(id,name);
                    narrators.add(narrator);

                } else {
                    Log.getLogger().info("No Narrator found with serial: " + id);
                }
            } catch (Exception e) {
                Log.getLogger().info("Error while getting narrator from database : " + e.getMessage());
            }
        } catch (SQLException e) {
            Log.getLogger().error("Error in retrieving narrator", e.getMessage());
        }

        // Return the Hadith object (or null if not found)
        return narrators;
    }
}
