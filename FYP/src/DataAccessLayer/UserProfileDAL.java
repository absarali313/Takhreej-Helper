package DataAccessLayer;

import TransferObject.User;
import CustomException.DBConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserProfileDAL implements IUserProfileDAL {

   // Assuming you have a database connection stored somewhere
    private Connection connection;

    // Constructor that initializes the connection
    public UserProfileDAL() throws DBConnectionException {
        try {
            this.connection = DBhandler.getInstance().getConnection();
        } catch (DBConnectionException e) {
            // Handle or rethrow the exception, depending on your application's error-handling strategy
            e.printStackTrace();
            throw new DBConnectionException("Error establishing database connection: " + e.getMessage(), e);
        }
    }
    // This is a placeholder method to simulate updating the user profile in a database
    @Override
    public void updateUserProfile(String email, String newName, String newPhoneNumber) {
        // Actual database update logic goes here
        try {
            String updateQuery = "UPDATE user_profiles SET name=?, phone=? WHERE email=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, newName);
                preparedStatement.setString(2, newPhoneNumber);
                preparedStatement.setString(3, email);

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's error-handling strategy
        }
    }

    // This is a placeholder method to simulate retrieving user profile from a database
    @Override
    public User getUserProfile(String email) throws SQLException {
        String query = "SELECT * FROM user_profiles WHERE email=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Retrieve user data from the result set
                    String retrievedName = resultSet.getString("name");
                    String retrievedPhoneNo = resultSet.getString("phone");

                    // Create a User object with the retrieved data
                    return new User(retrievedName, retrievedPhoneNo);
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error retrieving user profile: " + e.getMessage(), e);
        }

        return null; // Return null if the user is not found
    }
}
