// LoginDAO.java
package DataAccessLayer;

import TransferObjects.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO implements ILoginDAO {
    @Override
    public User getUserByUsername(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish a database connection (replace with your database connection logic)
            connection = DBhandler.getInstance().getConnection();

            // SQL query to retrieve user data by username
            String query = "SELECT * FROM users WHERE username = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if the user exists
            if (resultSet.next()) {
                // Retrieve user data from the result set
                String retrievedUsername = resultSet.getString("username");
                String retrievedPassword = resultSet.getString("password");
               

                // Create a User object with the retrieved data
                User user = new User();
                user.setUsername(retrievedUsername);
                user.setPassword(retrievedPassword);
                // Set other fields

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources (result set, statement, and connection)
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null; // Return null if the user is not found or an error occurs
    }
}
