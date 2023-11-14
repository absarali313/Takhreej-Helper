package DataAccessLayer;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import TransferObjects.User;
import java.util.List;
public class RegisterDAL implements IRegisterDAL {
	 public Boolean insertUser(User user) {
	        
		 String insertUserQuery = "INSERT INTO users (name, email, password, phoneNumber) VALUES (?, ?, ?, ?)";

	     	try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(insertUserQuery)) {
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPassword());
	            preparedStatement.setString(4, user.getPhone());
	            preparedStatement.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	
}