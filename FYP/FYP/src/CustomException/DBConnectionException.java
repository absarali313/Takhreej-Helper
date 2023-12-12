package CustomException;

import java.sql.SQLException;

public class DBConnectionException extends SQLException {
    public DBConnectionException(String message) {
        super(message);
    }

    public DBConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}