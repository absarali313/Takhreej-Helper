// LoginDAO.java
package DataAccessLayer;

import TransferObjects.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO implements ILoginDAO {
	
    public User getUserByEmail(String email){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish a database connection (replace with your database connection logic)
            connection = DBhandler.getInstance().getConnection();

            // SQL query to retrieve user data by email
            String query = "SELECT * FROM users WHERE email = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if the user exists
            if (resultSet.next()) {
                // Retrieve user data from the result set
                String retrievedName = resultSet.getString("name");
                String retrievedEmail = resultSet.getString("email");
                String retrievedPhoneNo = resultSet.getString("phone no");
                String retrievedPassword = resultSet.getString("password");


                // Create a User object with the retrieved data
                User user = new User(retrievedName, retrievedEmail, retrievedPhoneNo, retrievedPassword);
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
