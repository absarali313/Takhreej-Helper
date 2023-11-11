package BusinessLogicLayer;

import java.util.List;
import java.util.Map;
import DataAccessLayer.IRegisterDAL;

// Business Logic layer
public class RegistrationService {
    private IRegisterDAL registerDAL;

    public RegistrationService(IRegisterDAL registerDAL) {
        this.registerDAL = registerDAL;
    }

    public void registerUser(String name, String email, String password, String phoneNumber) {
        if (isValidUser(name, email, password, phoneNumber)) {
            PasswordHasher hasher = new PasswordHasher();
            String hashedPassword = hasher.hashPassword(password); // Hash the password
            registerDAL.insertUser(name, email, hashedPassword, phoneNumber);
            System.out.println("User " + name + " registered successfully!");
        } else {
            System.out.println("Invalid user information. Registration failed.");
        }
    }

   // Add your getter code yourself Manal

    private boolean isValidUser(String name, String email, String password, String phoneNumber) {
        // Add your validation logic here
        return name != null && !name.isEmpty() && email != null && !email.isEmpty()
                && password != null && !password.isEmpty() && phoneNumber != null && !phoneNumber.isEmpty();
    }
}
