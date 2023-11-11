package DataAccessLayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Data Access and Domain layer
public class DBhandler implements UserDataAccess {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/FYP";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    static {
        try {
            // Load the JDBC driver explicitly
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading JDBC driver");
        }
    }

    public DBhandler() {
        // Ensure the static block is executed
        System.out.println("JDBC driver loaded successfully.");

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD)) {
            String createUserTableQuery = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "email VARCHAR(255) NOT NULL,"
                    + "password VARCHAR(255) NOT NULL,"
                    + "phoneNumber VARCHAR(20) NOT NULL)";
            
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createUserTableQuery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String email, String password, String phoneNumber) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD)) {
            String insertUserQuery = "INSERT INTO users (name, email, password, phoneNumber) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, phoneNumber);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Map<String, String>> getAllUsers() {
        List<Map<String, String>> users = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD)) {
            String getAllUsersQuery = "SELECT * FROM users";
            
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(getAllUsersQuery);
                
                while (resultSet.next()) {
                    Map<String, String> user = new HashMap<>();
                    user.put("name", resultSet.getString("name"));
                    user.put("email", resultSet.getString("email"));
                    user.put("password", resultSet.getString("password"));
                    user.put("phoneNumber", resultSet.getString("phoneNumber"));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
