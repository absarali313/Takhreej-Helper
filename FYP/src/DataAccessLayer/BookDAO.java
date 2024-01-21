package DataAccessLayer;

import CustomLogger.Log;
import TransferObject.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public class BookDAO implements IBookDAO {

    @Override
    public Book getBook(int id) {
        String query = "SELECT * FROM book WHERE id = ?";
        Book book = null;

        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Retrieve data from the result set and construct a Hadith object
                    int bookId = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    book = new Book(id, name);
                    

                } else {
                    Log.getLogger().info("No Book found with serial: " + id);
                }
            } catch (Exception e) {
                Log.getLogger().info("Error while getting book from database : " + e.getMessage());
            }
        } catch (SQLException e) {
            Log.getLogger().error("Error in retrieving book", e.getMessage());
        }

        // Return the Hadith object (or null if not found)
        return book;
    }

}
