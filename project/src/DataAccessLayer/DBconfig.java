package DataAccessLayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBconfig {
    private static final String CONFIG_FILE_PATH = "config.properties";
    private Properties properties;

    public DBconfig() {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDatabaseUrl() {
        String databaseUrl = properties.getProperty("database.url");
        if (databaseUrl == null) {
            throw new RuntimeException("Database URL not found in config.properties");
        }
        return databaseUrl;
    }

    public String getDatabaseUser() {
        return properties.getProperty("database.user", "root");
    }

    public String getDatabasePassword() {
        return properties.getProperty("database.password", "");
    }
}
