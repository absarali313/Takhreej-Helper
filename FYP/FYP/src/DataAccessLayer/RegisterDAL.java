package DataAccessLayer;
import java.sql.PreparedStatement;
import CustomLogger.AppLogger;
import java.sql.ResultSet;
import java.sql.SQLException;
import TransferObjects.User;

public class RegisterDAL implements IRegisterDAL {

    /**
     * @return the logger
     */
    public static AppLogger getLogger() {
        return logger;
    }

    /**
     * @param aLogger the logger to set
     */
    public static void setLogger(AppLogger aLogger) {
        logger = aLogger;
    }
	private static AppLogger logger = new AppLogger(); // Use the logger instance from AppLogger
	
	public boolean isEmailRegistered(String email) {
        String checkEmailQuery = "SELECT * FROM users WHERE email = ? ";

        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(checkEmailQuery)) {
            preparedStatement.setString(1,email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Returns true if there are rows, indicating email is registered
            }
        } catch (SQLException e) {
        	getLogger().getLogger().error("Error checking if email is registered: {}", e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
	 public Boolean insertUser(User user) {
		  if (isEmailRegistered(user.getEmail())) {
			  getLogger().getLogger().error("Error: Email is already registered");
	            return false;
	        }
		 String insertUserQuery = "INSERT INTO users (name, email, password, phoneNumber) VALUES (?, ?, ?, ?)";

	     	try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(insertUserQuery)) {
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPassword());
	            preparedStatement.setString(4, user.getPhone());
	            preparedStatement.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	        	getLogger().getLogger().error("Error inserting user: {}", e.getMessage());
	            e.printStackTrace();
	            return false;
	        }
	    }
	
}