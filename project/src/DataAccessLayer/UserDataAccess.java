package DataAccessLayer;

import java.util.List;
import java.util.Map;

// Data Access layer interface
public interface UserDataAccess {
    void saveUser(String name, String email, String password, String phoneNumber);
    List<Map<String, String>> getAllUsers();
}
