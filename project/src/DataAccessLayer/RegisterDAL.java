package DataAccessLayer;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAL implements IRegisterDAL {
	 public Boolean insertUser(String name, String email, String password, String phoneNumber) {
	        
		 String insertUserQuery = "INSERT INTO users (name, email, password, phoneNumber) VALUES (?, ?, ?, ?)";

	     	try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(insertUserQuery)) {
	            preparedStatement.setString(1, name);
	            preparedStatement.setString(2, email);
	            preparedStatement.setString(3, password);
	            preparedStatement.setString(4, phoneNumber);
	            preparedStatement.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}