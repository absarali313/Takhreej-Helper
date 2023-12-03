// LoginService.java
package BusinessLogicLayer;

import DataAccessLayer.ILoginDAO;
import DataAccessLayer.LoginDAO;
import TransferObjects.User;

public class LoginService implements ILoginService {
    private ILoginDAO loginDAO;

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public boolean login(String email, String password) {
       

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

	@Override
	public boolean rememberMe(String name, String password, boolean remember) {
		 // Call DAO to handle remember me functionality
        return loginDAO.rememberUserCredentials(name, password, remember);
	}

	@Override
	public boolean autoLogin() {
		// Call DAO to handle auto-login functionality
        return loginDAO.autoLogin();
	}

}
