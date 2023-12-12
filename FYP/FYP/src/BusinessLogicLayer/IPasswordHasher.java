package BusinessLogicLayer;

public interface IPasswordHasher {

	String hashPassword(String password);

	boolean checkPassword(String candidatePassword, String hashedPassword);

}