// LoginService.java
package BusinessLogicLayer;

import DataAccessLayer.ILoginDAO;
import TransferObjects.User;

public class LoginService implements ILoginService {
    private ILoginDAO loginDAO;

    public LoginService(ILoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    public boolean login(String email, String password, boolean rememberMe) {
        // Validate the recaptchaResponse using Google Recaptcha API (if implemented)

        User user = loginDAO.getUserByEmail(email);

        if (user != null && validatePassword(password, user.getPassword())) {
            return true;
        }

        return false;
    }

    private boolean validatePassword(String inputPassword, String hashedPassword) {
        IPasswordHasher hasher = new PasswordHasher();

        // Check if the provided inputPassword matches the hashedPassword
        return hasher.checkPassword(inputPassword, hashedPassword);
    }

}
