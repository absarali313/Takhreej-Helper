// LoginService.java
package BusinessLogicLayer;
import CustomLogger.AppLogger;
import CustomException.AuthenticationException;
import CustomException.EmailServiceException;
import DataAccessLayer.ILoginDAO;
import DataAccessLayer.LoginDAO;
import TransferObjects.User;
import java.io.File;


public class LoginService implements ILoginService {

    /**
     * @return the loginDAO
     */
    public ILoginDAO getLoginDAO() {
        return loginDAO;
    }

    /**
     * @param loginDAO the loginDAO to set
     */
    public void setLoginDAO(ILoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
	private static AppLogger logger = new AppLogger(); // Use the logger instance from AppLogger
        private static final String REMEMBER_ME_FILE = "rememberMe.dat";

	static {
	logger.classChange(LoginService.class.getName());
	}
    private ILoginDAO loginDAO;

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public boolean login(String email, String password) throws AuthenticationException {
       

        User user = getLoginDAO().getUserByEmail(email);

        if (user != null && validatePassword(password, user.getPassword())) {
            UserSession.setSession(user);
            return true;
        }
       
        else{
     // If authentication fails, throw the custom exception
        logger.getLogger().error("Authentication failed for user: {}", email);
        throw new AuthenticationException("Exception - Authentication failed for user: " + email);
        }
    }

    private boolean validatePassword(String inputPassword, String hashedPassword) {
        IPasswordHasher hasher = new PasswordHasher();

        // Check if the provided inputPassword matches the hashedPassword
        return hasher.checkPassword(inputPassword, hashedPassword);
    }

	@Override
	public boolean rememberMe(String name, String password, boolean remember) throws AuthenticationException {
		 // Call DAO to handle remember me functionality
        return getLoginDAO().rememberUserCredentials(name, password, remember);
	}

	@Override
	public boolean autoLogin() throws AuthenticationException {
		// Call DAO to handle auto-login functionality
        return getLoginDAO().autoLogin();
	}

	 public void resetPassword(String email, String newPassword, String storedOtp, String userEnteredCode) throws EmailServiceException {
	        // Check if both codes match using the verifyCode method
	        if (verifyCode(userEnteredCode, storedOtp)) {
	            // Call the reset password method in LoginDAO
	            getLoginDAO().resetPassword(email, newPassword);
	            logger.getLogger().info("Password reset successfully for email: {}", email);
	        } else {
	        	logger.getLogger().error("Invalid verification code. Password reset failed for email: {}", email);
	            throw new EmailServiceException("Invalid verification code. Password reset failed.");
	        }
	    }
        
         public void logout() {
            File rememberMeFile = new File(REMEMBER_ME_FILE);
            if (rememberMeFile.exists()) {
             rememberMeFile.delete();
        }
    }

	    private boolean verifyCode(String userEnteredCode, String storedOtp) {
	        return storedOtp != null && storedOtp.equals(userEnteredCode);
	    }
}

