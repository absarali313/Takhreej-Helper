// LoginDAO.java
package DataAccessLayer;

import TransferObjects.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import CustomException.AuthenticationException;

public class LoginDAO implements ILoginDAO {
	 
    private static final String REMEMBER_ME_FILE = "rememberMe.dat";

	public LoginDAO() {
		}

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
                String retrievedPhoneNo = resultSet.getString("phoneNumber");
                String retrievedPassword = resultSet.getString("password");


                // Create a User object with the retrieved data
                User user = new User(retrievedName, retrievedEmail, retrievedPassword,retrievedPhoneNo);
                
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

	@Override
    public boolean rememberUserCredentials(String name, String password, boolean remember) throws AuthenticationException {
		User user = new User();
		user = getUserByEmail(name);
		if(user != null)
		{
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(REMEMBER_ME_FILE))) {
	            // Create a map to store hashed credentials
	            Map<String, String> credentialsMap = new HashMap<>();
	            // For simplicity, we are using plain text here; in a real scenario, you'd hash the password
	            credentialsMap.put("username", name);
	            credentialsMap.put("password", password);
	            // Write the map to the file
	            oos.writeObject(credentialsMap);
	            return true;
	        } catch (IOException e) {
	        	 // Catch the custom exception and handle it
	            throw new AuthenticationException("Error saving credentials for user: " + name);
	        }			
		}
		else
		{
			return false;
		}
    }

    @Override
    public boolean autoLogin() throws AuthenticationException {
        File file = new File(REMEMBER_ME_FILE);

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(REMEMBER_ME_FILE))) {
                // Read the map from the file
                Map<String, String> credentialsMap = (HashMap<String, String>) ois.readObject();

                String storedName = credentialsMap.get("username");
                String storedPassword = credentialsMap.get("password");
                
                return true;
             /* Retrieve the user from the database based on the stored username
                User user = getUserByEmail(storedName);

                if (user != null && storedPassword.equals(user.getPassword())) {
                    // Auto-login successful
                    return true;
                } else {
                    // Credentials don't match or user not found
                    throw new AuthenticationException("Auto-login failed: Invalid credentials");
                }*/
            } catch (IOException | ClassNotFoundException e) {
                // Catch the custom exception and handle it
                throw new AuthenticationException("Error reading auto-login credentials");
            }
        }

        return false;
    }
 // Inside the LoginDAO class

    public void resetPassword(String email, String newPassword) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish a database connection (replace with your database connection logic)
            connection = DBhandler.getInstance().getConnection();

            // SQL query to update the user's password
            String query = "UPDATE users SET password = ? WHERE email = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, email);

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Password reset successfully for email: " + email);
            } else {
                System.out.println("User not found. Password reset failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources (statement and connection)
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

   
}


