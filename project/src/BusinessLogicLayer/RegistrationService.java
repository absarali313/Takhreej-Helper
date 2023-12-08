package BusinessLogicLayer;

import CustomException.RegisterationException;
import DataAccessLayer.IRegisterDAL;
import DataAccessLayer.RegisterDAL;
import TransferObjects.User;

public class RegistrationService {
    private IRegisterDAL registerDAL;

    public RegistrationService() {
        this.registerDAL = new RegisterDAL();
    }

    public boolean registerUser(String name, String email, String password, String phoneNumber, String verificationCode) throws RegisterationException {
        try {
        	if (!isEmailRegistered(email)&& isValidUser(name, email,password,phoneNumber) && isValidVerificationCode(verificationCode)) {
            PasswordHasher hasher = new PasswordHasher();
            String hashedPassword = hasher.hashPassword(password);
            User user = new User(name, email,hashedPassword ,phoneNumber);
            registerDAL.insertUser(user);
            System.out.println("User " + name + " registered successfully!");
            return true;
        } else {
        	throw new RegisterationException("Invalid user information or verification code. Registration failed.");
        	}
        	}
        	catch (Exception e) {
                throw new RegisterationException("Error during registration: " + e.getMessage());
            }
        }
    

    public boolean isEmailRegistered(String email) {
        return registerDAL.isEmailRegistered(email);
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
            throw new RegisterationException("Error validating input fields: " + e.getMessage());
        }
    }

	public boolean confirmPass(String pass, String confirmPass) {
		if(pass.equals(confirmPass))
			return true;
		return false;
	}
}
