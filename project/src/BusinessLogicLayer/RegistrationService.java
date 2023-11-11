package BusinessLogicLayer;

import java.util.List;
import java.util.Map;

import DataAccessLayer.UserDataAccess;

// Business Logic layer
public class RegistrationService {
    private UserDataAccess userDataAccess;

    public RegistrationService(UserDataAccess userDataAccess) {
        this.userDataAccess = userDataAccess;
    }

    public void registerUser(String name, String email, String password, String phoneNumber) {
        if (isValidUser(name, email, password, phoneNumber)) {
            // Additional business logic can be added here
            // For example, sending a confirmation email, performing additional checks, etc.
            String hashedPassword = PasswordHasher.hashPassword(password); // Hash the password
            userDataAccess.saveUser(name, email, hashedPassword, phoneNumber);
            System.out.println("User " + name + " registered successfully!");
        } else {
            System.out.println("Invalid user information. Registration failed.");
        }
    }

    public List<Map<String, String>> getAllUsers() {
        return userDataAccess.getAllUsers();
    }

    private boolean isValidUser(String name, String email, String password, String phoneNumber) {
        // Add your validation logic here
        return name != null && !name.isEmpty() && email != null && !email.isEmpty()
                && password != null && !password.isEmpty() && phoneNumber != null && !phoneNumber.isEmpty();
    }
}
