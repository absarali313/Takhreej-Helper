package DataAccessLayer;

import TransferObject.User;

public interface IRegisterDAL {
	 public Boolean insertUser(User user);

	public boolean isEmailRegistered(String email);
}
