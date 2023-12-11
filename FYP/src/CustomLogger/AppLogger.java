package CustomLogger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppLogger {
    private static Logger logger = LogManager.getLogger(AppLogger.class.getName());

    public Logger getLogger() {
        return logger;
    }
    public void classChange(String name) {
    	logger = LogManager.getLogger(name);
    	
    }
}
