package BusinessLogicLayer;
import CustomLogger.AppLogger;
import CustomException.RegisterationException;
import DataAccessLayer.IRegisterDAL;
import DataAccessLayer.RegisterDAL;
import TransferObjects.User;

public class RegistrationService implements IRegistrationService {
	private static AppLogger logger = new AppLogger(); // Use the logger instance from AppLogger
    private IRegisterDAL registerDAL;

    public RegistrationService() {
        this.registerDAL = new RegisterDAL();
    }

    @Override
    public boolean registerUser(String name, String email, String password, String phoneNumber, String verificationCode) throws RegisterationException {
        try {
            if(isEmailRegistered(email))
                throw new RegisterationException("User already Exists");
        	if (!isEmailRegistered(email)&& isValidUser(name, email,password,phoneNumber) && isValidVerificationCode(verificationCode)) {
                    
                    IPasswordHasher hasher = new PasswordHasher();
                    String hashedPassword = hasher.hashPassword(password);
                    User user = new User(name, email,hashedPassword ,phoneNumber);
                    getRegisterDAL().insertUser(user);
                    getLogger().getLogger().info("User {} registered successfully!", name);
                    return true;
                 }
                else {
            throw new RegisterationException("Invalid user information or verification code. Registration failed.");
                }
        }catch (Exception e) {
        		getLogger().getLogger().error("Error during registration: {}", e.getMessage());
                throw new RegisterationException("Error during registration: " + e.getMessage());
            }
        }
    

    @Override
    public boolean isEmailRegistered(String email) {
       
        return getRegisterDAL().isEmailRegistered(email);
    }
    @Override
     public void userAlreadyExists(String email) throws RegisterationException {
       
        throw new RegisterationException("User already Exists");
    }
    @Override
    public boolean isValidVerificationCode(String verificationCode) {
        // Check if the verification code is not null
        return verificationCode != null;
    }


    private boolean isValidUser(String name, String email, String phoneNumber, String password) {
        // Add your validation logic here
        return name != null && !name.isEmpty() && email != null && !email.isEmpty()
                && password != null && !password.isEmpty() && phoneNumber != null && !phoneNumber.isEmpty();
    }
    @Override
    public boolean validateFields(String name, String email, String phone, String password, String confirmPassword) throws RegisterationException {
        try {
            if (!name.trim().isEmpty() && !email.trim().isEmpty() && !phone.trim().isEmpty() && !password.isEmpty()
                    && !confirmPassword.isEmpty() && confirmPass(password, confirmPassword)) {
                return true;
            } else {
                throw new RegisterationException("Invalid input fields. Registration failed.");
            }
        } catch (Exception e) {
        	getLogger().getLogger().error("Error validating input fields: {}", e.getMessage());
            throw new RegisterationException("Error validating input fields: " + e.getMessage());
        }
    }

    @Override
	public boolean confirmPass(String pass, String confirmPass) {
		if(pass.equals(confirmPass))
			return true;
		return false;
	}

    /**
     * @return the logger
     */
    public static AppLogger getLogger() {
        return logger;
    }

    /**
     * @param aLogger the logger to set
     */
    public static void setLogger(AppLogger aLogger) {
        logger = aLogger;
    }

    /**
     * @return the registerDAL
     */
    public IRegisterDAL getRegisterDAL() {
        return registerDAL;
    }

    /**
     * @param registerDAL the registerDAL to set
     */
    public void setRegisterDAL(IRegisterDAL registerDAL) {
        this.registerDAL = registerDAL;
    }
}
