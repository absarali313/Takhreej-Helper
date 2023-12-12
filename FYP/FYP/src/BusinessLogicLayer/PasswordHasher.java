package BusinessLogicLayer;

import org.mindrot.jbcrypt.BCrypt;

// Hashing utility class
public class PasswordHasher implements IPasswordHasher {

    @Override
    public String hashPassword(String password) {
        // Generate a salt with cost factor 10 and hash the password
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }

    @Override
    public boolean checkPassword(String candidatePassword, String hashedPassword) {
        // Use the same salt generation logic to check the password
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }
}
