package DataAccessLayer;

import CustomException.DataAccessException;
import TransferObjects.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProfileDAL implements IUserProfileDAL {

    @Override
    public User getUserProfile(String email) throws DataAccessException {
        try (Connection connection = DBhandler.getInstance().getConnection()) {
            String query = "SELECT * FROM users WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String retrievedEmail = resultSet.getString("email");
                        String phone = resultSet.getString("phoneNumber");
                        String password = resultSet.getString("password");

                        return new User(name, retrievedEmail, password, phone);
                    }
                }
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error retrieving user profile: " + e.getMessage(), e);
        }

        return null; // Return null if the user is not found
    }

    @Override
    public boolean updateUserProfile(User updatedUser) throws DataAccessException {
        try (Connection connection = DBhandler.getInstance().getConnection()) {
            String query = "UPDATE users SET name = ?, phoneNumber = ?, password = ? WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, updatedUser.getName());
                preparedStatement.setString(2, updatedUser.getPhone());
                preparedStatement.setString(3, updatedUser.getPassword());
                preparedStatement.setString(4, updatedUser.getEmail());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error updating user profile: " + e.getMessage(), e);
        }
    }
}
