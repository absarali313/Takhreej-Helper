package BusinessLogicLayer;

import DataAccessLayer.IRegisterDAL;
import TransferObjects.User;

public class RegistrationService {
    private IRegisterDAL registerDAL;

    public RegistrationService(IRegisterDAL registerDAL) {
        this.registerDAL = registerDAL;
    }

    public boolean registerUser(String name, String email, String password, String phoneNumber, String verificationCode) {
        if (isValidUser(name, email,password,phoneNumber) && isValidVerificationCode(verificationCode)) {
            PasswordHasher hasher = new PasswordHasher();
            String hashedPassword = hasher.hashPassword(password);
            User user = new User(name, email,hashedPassword ,phoneNumber);
            registerDAL.insertUser(user);
            System.out.println("User " + name + " registered successfully!");
            return true;
        } else {
            System.out.println("Invalid user information or verification code. Registration failed.");
            return false;
        }
    }
    

    public boolean isValidVerificationCode(String verificationCode) {
        // Check if the verification code is not null
        return verificationCode != null;
    }


    private boolean isValidUser(String name, String email, String phoneNumber, String password) {
        // Add your validation logic here
        return name != null && !name.isEmpty() && email != null && !email.isEmpty()
                && password != null && !password.isEmpty() && phoneNumber != null && !phoneNumber.isEmpty();
    }
}
