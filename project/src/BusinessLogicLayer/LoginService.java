// LoginService.java
package BusinessLogicLayer;

import CustomException.AuthenticationException;
import CustomException.EmailServiceException;
import DataAccessLayer.ILoginDAO;
import DataAccessLayer.LoginDAO;
import TransferObjects.User;

public class LoginService implements ILoginService {
    private ILoginDAO loginDAO;

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public boolean login(String email, String password) throws AuthenticationException {
       

        User user = loginDAO.getUserByEmail(email);

        if (user != null && validatePassword(password, user.getPassword())) {
            return true;
        }

     // If authentication fails, throw the custom exception
        throw new AuthenticationException("Authentication failed for user: " + email);
    
    }

    private boolean validatePassword(String inputPassword, String hashedPassword) {
        IPasswordHasher hasher = new PasswordHasher();

        // Check if the provided inputPassword matches the hashedPassword
        return hasher.checkPassword(inputPassword, hashedPassword);
    }

	@Override
	public boolean rememberMe(String name, String password, boolean remember) throws AuthenticationException {
		 // Call DAO to handle remember me functionality
        return loginDAO.rememberUserCredentials(name, password, remember);
	}

	@Override
	public boolean autoLogin() throws AuthenticationException {
		// Call DAO to handle auto-login functionality
        return loginDAO.autoLogin();
	}

	 public void resetPassword(String email, String newPassword, String storedOtp, String userEnteredCode) throws EmailServiceException {
	        // Check if both codes match using the verifyCode method
	        if (verifyCode(userEnteredCode, storedOtp)) {
	            // Call the reset password method in LoginDAO
	            loginDAO.resetPassword(email, newPassword);
	            System.out.println("Password reset successfully for email: " + email);
	        } else {
	            throw new EmailServiceException("Invalid verification code. Password reset failed.");
	        }
	    }

	    private boolean verifyCode(String userEnteredCode, String storedOtp) {
	        return storedOtp != null && storedOtp.equals(userEnteredCode);
	    }
}
