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
        String query = "SELECT * FROM narrator as n join sanad as s on s.narratorId = n.id  WHERE s.hadithId = ?";
        ArrayList<Narrator> narrators = new ArrayList<Narrator>();

        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Retrieve data from the result set and construct a Hadith object
                    int narratorId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Narrator narrator = new Narrator(id, name);
                    narrators.add(narrator);

                }
            } catch (Exception e) {
                Log.getLogger().info("Error while getting narrator from database : " + e.getMessage());
            }
        } catch (SQLException e) {
            Log.getLogger().error("Error in retrieving narrator", e.getMessage());
        }
        if (narrators.isEmpty()) {
            Log.getLogger().info("No Narrator found with serial: " + id);
        }
        // Return the Hadith object (or null if not found)
        return narrators;
    }
}
