package BusinessLogicLayer;
import CustomLogger.AppLogger;
import CustomException.RegisterationException;
import DataAccessLayer.IRegisterDAL;
import DataAccessLayer.RegisterDAL;
import TransferObject.User;

public class RegistrationService {
	private static final AppLogger logger = new AppLogger(); // Use the logger instance from AppLogger
    private IRegisterDAL registerDAL;

    public RegistrationService() {
        this.registerDAL = new RegisterDAL();
    }

    public boolean registerUser(String name, String email, String password, String phoneNumber, String verificationCode) throws RegisterationException {
        try {
            if(isEmailRegistered(email))
                throw new RegisterationException("User already Exists");
        	if (!isEmailRegistered(email)&& isValidUser(name, email,password,phoneNumber) && isValidVerificationCode(verificationCode)) {
                    
                    PasswordHasher hasher = new PasswordHasher();
                    String hashedPassword = hasher.hashPassword(password);
                    User user = new User(name, email,hashedPassword ,phoneNumber);
                    registerDAL.insertUser(user);
                    logger.getLogger().info("User {} registered successfully!", name);
                    return true;
                 }
                else {
            throw new RegisterationException("Invalid user information or verification code. Registration failed.");
                }
        }catch (Exception e) {
        		logger.getLogger().error("Error during registration: {}", e.getMessage());
                throw new RegisterationException("Error during registration: " + e.getMessage());
            }
        }
    

    public boolean isEmailRegistered(String email) {
       
        return registerDAL.isEmailRegistered(email);
    }
     public void userAlreadyExists(String email) throws RegisterationException {
       
        throw new RegisterationException("User already Exists");
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
    public boolean validateFields(String name, String email, String phone, String password, String confirmPassword) throws RegisterationException {
        try {
            if (!name.trim().isEmpty() && !email.trim().isEmpty() && !phone.trim().isEmpty() && !password.isEmpty()
                    && !confirmPassword.isEmpty() && confirmPass(password, confirmPassword)) {
                return true;
            } else {
                throw new RegisterationException("Invalid input fields. Registration failed.");
            }
        } catch (Exception e) {
        	logger.getLogger().error("Error validating input fields: {}", e.getMessage());
                throw new RegisterationException("Password doesn't match: " + e.getMessage());
        }
    }

	public boolean confirmPass(String pass, String confirmPass) {
		if(pass.equals(confirmPass))
			return true;
		return false;
	}
}
