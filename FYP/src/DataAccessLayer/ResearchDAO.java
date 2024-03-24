package DataAccessLayer;

import CustomException.NoResearchFoundException;
import CustomException.ResearchAlreadyExistsException;
import CustomLogger.Log;
import TransferObject.Filter;
import TransferObject.Hadith;
import TransferObject.Research;
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

    private FilterDAO filterDAO;

    public ResearchDAO(FilterDAO filterDAO) {
        this.filterDAO = filterDAO;
    }

    @Override
    public boolean insertResearch(String name) throws ResearchAlreadyExistsException {
        if (researchExists(name)) {
            throw new ResearchAlreadyExistsException("Research with this name already exists ");
        }
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

    @Override
    public boolean insertResearch(String name, Filter filter) throws ResearchAlreadyExistsException {
        if (researchExists(name)) {
            throw new ResearchAlreadyExistsException("Research with this name already exists ");
        }
        String query = "INSERT INTO RESEARCH(name) Values(?) ";
        try (java.sql.PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            if (filterDAO.insertFilter(filter.getId(), filter.getOrderNo(), filter.getExpression(),filter.getType())) {
                return true;
            } else {
                return false;
            }
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

    @Override
    public ArrayList<Integer> getResearchBaselineIds(int researchId) {
        ArrayList<Integer> hadithSerials = new ArrayList<>();

        String query = "SELECT hadithid FROM researchbaseline WHERE researchid = ?";
        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, researchId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Retrieve data from the result set and construct a Hadith object
                    int serial = resultSet.getInt("hadithid");
                    hadithSerials.add(serial);
                }

            } catch (Exception e) {
                Log.getLogger().info("There is no pre-staged hadiths for this research" + e.getMessage());
            }
        } catch (SQLException e) {
            Log.getLogger().error("Error in retrieving Hadith", e.getMessage());
        }
        if (hadithSerials.isEmpty()) {
            HadithDAO hadithDAO = new HadithDAO(new BookDAO(), new NarratorsDAO());
            hadithSerials = hadithDAO.getAllHadithIds();
        }
        return hadithSerials;
    }

    @Override
    public Research getResearchByName(String name) {
        String query = "SELECT * FROM research WHERE name = ?";
        Research research = null;

        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Retrieve data from the result set and construct a Hadith object
                    int id = resultSet.getInt("id");
                    ArrayList<Filter> filters = filterDAO.getFilters(id);
                    ArrayList<Integer> baseLine = getResearchBaselineIds(id);
                    research = new Research(id, name, baseLine, filters);

                } else {
                    Log.getLogger().info("No research found with name : " + name);
                }
            } catch (Exception e) {
                Log.getLogger().info("Error while getting research from database : " + e.getMessage());
            }
        } catch (SQLException e) {
            Log.getLogger().error("Error in retrieving research", e.getMessage());
        }

        // Return the Hadith object (or null if not found)
        return research;
    }

    @Override
    public ArrayList<Research> getAllResearch() throws NoResearchFoundException {
        ArrayList<Research> researches = new ArrayList<Research>();

        String query = "SELECT * FROM research";

        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                ArrayList<Filter> filters = filterDAO.getFilters(id);
                ArrayList<Integer> baseLine = getResearchBaselineIds(id);
                researches.add(new Research(id, name, baseLine, filters));
            }

            if (researches.isEmpty()) {

                throw new NoResearchFoundException("No Research Found");
            }

        } catch (SQLException e) {
            Log.getLogger().error("Error in retrieving Hadith", e.getMessage());
        } catch (Exception e) {
            Log.getLogger().error("Error while getting hadith from database: " + e.getMessage());
        }

        return researches;
    }
}
