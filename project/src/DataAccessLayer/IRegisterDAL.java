package DataAccessLayer;

import TransferObjects.User;

public interface IRegisterDAL {
	 public Boolean insertUser(User user);

	public boolean isEmailRegistered(String email);
}
