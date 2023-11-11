package DataAccessLayer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

// Data Access and Domain layer
public class DBhandler implements UserDataAccess {
    private static final String DATABASE_PROPERTIES = "config.properties";

    private String DATABASE_URL;
    private String DATABASE_USER;
    private String DATABASE_PASSWORD;

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
        loadDatabaseProperties();
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

    private void loadDatabaseProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(DATABASE_PROPERTIES)) {
            Properties properties = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find " + DATABASE_PROPERTIES);
                return;
            }

            // Load a properties file from class path, inside static method
            properties.load(input);

            // Get property values
            DATABASE_URL = properties.getProperty("database.url");
            DATABASE_USER = properties.getProperty("database.user");
            DATABASE_PASSWORD = properties.getProperty("database.password");

        } catch (IOException ex) {
            ex.printStackTrace();
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
