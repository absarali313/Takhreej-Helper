// LoginService.java
package BusinessLogicLayer;

import DataAccessLayer.ILoginDAO;
import TransferObjects.User;

public class LoginService implements ILoginService {
    private ILoginDAO loginDAO;

    public LoginService(ILoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    public boolean loginUser(String username, String password, String recaptchaResponse) {
        // Validate the recaptchaResponse using Google Recaptcha API (if implemented)

        User user = loginDAO.getUserByName(username);

        if (user != null && validatePassword(password, user.getPassword())) {
            return true;
        }

        return false;
    }

    private boolean validatePassword(String inputPassword, String hashedPassword) {
        PasswordHasher hasher = new PasswordHasher();

        // Check if the provided inputPassword matches the hashedPassword
        return hasher.checkPassword(inputPassword, hashedPassword);
    }

}
