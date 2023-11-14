package BusinessLogicLayer;

import org.mindrot.jbcrypt.BCrypt;

// Hashing utility class
public class PasswordHasher implements IPasswordHasher {
    @Override
	public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
	public boolean checkPassword(String candidatePassword, String hashedPassword) {
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }
}
