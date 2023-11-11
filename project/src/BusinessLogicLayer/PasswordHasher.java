package BusinessLogicLayer;

import org.mindrot.jbcrypt.BCrypt;

// Hashing utility class
public class PasswordHasher {
    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean checkPassword(String candidatePassword, String hashedPassword) {
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }
}
