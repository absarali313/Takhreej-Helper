package BusinessLogicLayer;

import DataAccessLayer.IRegisterDAL;
import DataAccessLayer.RegisterDAL;
import TransferObjects.User;

public class RegistrationService {
    private IRegisterDAL registerDAL;

    public RegistrationService() {
        this.registerDAL = new RegisterDAL();
    }

    public boolean registerUser(String name, String email, String password, String phoneNumber, String verificationCode) {
        if (!isEmailRegistered(email)&& isValidUser(name, email,password,phoneNumber) && isValidVerificationCode(verificationCode)) {
            PasswordHasher hasher = new PasswordHasher();
            String hashedPassword = hasher.hashPassword(password);
            User user = new User(name, email,hashedPassword ,phoneNumber);
            registerDAL.insertUser(user);
            System.out.println("User " + name + " registered successfully!");
            return true;
        } else {
            System.out.println("Invalid user information or verification code. Registration failed.");
            return false;
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
    public boolean validateFields(String name, String email, String phone, String password, String confirmPassword) {
        return !name.trim().isEmpty() && !email.trim().isEmpty() && !phone.trim().isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty() && confirmPass(password,confirmPassword);
    }
	public boolean confirmPass(String pass, String confirmPass) {
		if(pass.equals(confirmPass))
			return true;
		return false;
	}
}
