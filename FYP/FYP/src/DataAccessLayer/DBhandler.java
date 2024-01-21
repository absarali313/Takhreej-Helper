package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.InputStream;
import java.util.Properties;
import CustomLogger.AppLogger;
import CustomException.DBConnectionException;

public class DBhandler implements IDBhandler {

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the CONFIG_FILE
     */
    public static String getCONFIG_FILE() {
        return CONFIG_FILE;
    }

    /**
     * @param aCONFIG_FILE the CONFIG_FILE to set
     */
    public static void setCONFIG_FILE(String aCONFIG_FILE) {
        CONFIG_FILE = aCONFIG_FILE;
    }
  private static final AppLogger logger = new AppLogger(); // Use the logger instance from AppLogger
  private static DBhandler instance;
  private Connection con;
  String url;
  private String user;
  private String password;
  private static String CONFIG_FILE = "config.properties";
  
  private DBhandler() throws DBConnectionException {
    try {
      Properties properties = loadProperties();
      url = properties.getProperty("database.url");
      password = properties.getProperty("database.password");
      user = properties.getProperty("database.user");
      Class.forName("com.mysql.jdbc.Driver");
      this.con = DriverManager.getConnection(url, user, password);
    } catch (Exception ex) {
    	logger.getLogger().error("Error establishing database connection: {}", ex.getMessage());
    	throw new DBConnectionException("Error establishing database connection: " + ex.getMessage(), ex);
    }
  }
    @Override
  public Connection getConnection() {
    return getCon();
  }
  public static DBhandler getInstance() throws DBConnectionException {
    if (instance == null) {
      instance = new DBhandler();
    } else
		try {
			if (instance.getConnection().isClosed()) {
			  instance = new DBhandler();
			}
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 logger.getLogger().error("Error checking database connection status: {}", e.getMessage());
			 throw new DBConnectionException("Error checking database connection status: " + e.getMessage(), e);
		}
    return instance;
  }
  
  public static Properties loadProperties() {
      Properties properties = new Properties();

      try (InputStream input = DBhandler.class.getClassLoader().getResourceAsStream(getCONFIG_FILE())) {
          if (input == null) {
        	  logger.getLogger().error("Sorry, unable to find {}", getCONFIG_FILE());
              return properties;
          }

          // Load a properties file from the class path
          properties.load(input);

      } catch (Exception e) {
    	  logger.getLogger().error("Error loading properties: {}", e.getMessage());
          e.printStackTrace(); // Log the stack trace to console for now
      }

      return properties;
  }
  
}