package CustomLogger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    public static Logger logger = LogManager.getLogger(Logger.class.getName());

    public static Logger getLogger() {
        return logger;
    }
    public static void classChange(String name) {
    	logger = LogManager.getLogger(name);
    }
}
