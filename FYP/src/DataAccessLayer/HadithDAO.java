package DataAccessLayer;

import CustomException.NoHadithFoundException;
import CustomLogger.Log;
import TransferObject.Hadith;
import TransferObject.Narrator;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Manal Saqib
 */
public class HadithDAO implements IHadithDAO {

    private BookDAO bookDAO;
    private NarratorsDAO narratorsDAO;

    public HadithDAO(BookDAO bookDAO, NarratorsDAO narratorsDAO) {
        this.bookDAO = bookDAO;
        this.narratorsDAO = narratorsDAO;
    }

    @Override
    public Hadith getHadithById(int index) {
        String query = "SELECT * FROM hadith WHERE serial = ?";
        Hadith hadith = null;

        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, index);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Retrieve data from the result set and construct a Hadith object
                    int serial = resultSet.getInt("serial");
                    int bookId = resultSet.getInt("bookId");
                    int hadithId = resultSet.getInt("hadithId");
                    String matn = resultSet.getString("matn");
                    hadith = initHadith(bookId, serial, hadithId, matn);

                } else {
                    Log.getLogger().info("No Hadith found with serial: " + index);
                }
            } catch (Exception e) {
                Log.getLogger().info("Error while getting hadith from database : " + e.getMessage());
            }
        } catch (SQLException e) {
            Log.getLogger().error("Error in retrieving Hadith" + e.getMessage());
        }

        // Return the Hadith object (or null if not found)
        return hadith;
    }

    @Override
    public ArrayList<Integer> getAllHadithIds() {
        ArrayList<Integer> hadiths = new ArrayList<>();

        String query = "SELECT serial FROM hadith";

        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int serial = resultSet.getInt("serial");

                hadiths.add(serial);
            }

            if (hadiths.isEmpty()) {
                Log.getLogger().info("No Hadith found in the database.");
            }

        } catch (SQLException e) {
            Log.getLogger().error("Error in retrieving Hadithjj" + e.getMessage());
        } catch (Exception e) {
            Log.getLogger().error("Error while getting hadith from database: " + e.getMessage());
        }

        return hadiths;
    }

    @Override
    public ArrayList<Hadith> getHadiths(ArrayList<Integer> serials) throws NoHadithFoundException {
        ArrayList<Hadith> hadiths = new ArrayList<Hadith>();
        for (int serial : serials) {
            hadiths.add(getHadithById(serial));
        }
        if (hadiths.isEmpty()) {
            Log.getLogger().info("No Hadith Found in the database");
            throw new NoHadithFoundException("No Hadith Found");
        }

        return hadiths;
    }

    private Hadith initHadith(int bookId, int serial, int hadithId, String matn) {
        Hadith hadith;
        String bookName = bookDAO.getBook(bookId).getName();
        ArrayList<Narrator> narrators = new ArrayList<Narrator>();
        narrators = narratorsDAO.getNarrator(serial);
        hadith = new Hadith(serial, hadithId, matn, bookName, narrators);
        return hadith;
    }
}
