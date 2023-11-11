package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.InputStream;
import java.util.Properties;

public class DBhandler {
  private static DBhandler instance;
  private Connection con;
  String url;
  String user;
  String password;
  private static final String CONFIG_FILE = "config.properties";
  
  private DBhandler() throws SQLException {
    try {
      Properties properties = loadProperties();
      url = properties.getProperty("database.url");
      password = properties.getProperty("database.password");
      user = properties.getProperty("database.user");
      System.out.println(user);
      this.con = DriverManager.getConnection(url, user, password);
    } catch (Exception ex) {
      System.out.println("Something is wrong with the DB connection String : " + ex.getMessage());
    }
  }
  public Connection getConnection() {
    return con;
  }
  public static DBhandler getInstance() throws SQLException {
    if (instance == null) {
      instance = new DBhandler();
    } else if (instance.getConnection().isClosed()) {
      instance = new DBhandler();
    }
    return instance;
  }
  
  public static Properties loadProperties() {
      Properties properties = new Properties();

      try (InputStream input = DBhandler.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
          if (input == null) {
              System.out.println("Sorry, unable to find " + CONFIG_FILE);
              return properties;
          }

          // Load a properties file from the class path
          properties.load(input);

      } catch (Exception e) {
          e.printStackTrace();
      }

      return properties;
  }
  
}