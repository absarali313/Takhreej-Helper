// ILoginDAO.java
package DataAccessLayer;

import CustomException.AuthenticationException;
import TransferObjects.User;

public interface ILoginDAO {
	User getUserByEmail(String name);
	boolean rememberUserCredentials(String name, String password, boolean remember) throws AuthenticationException;
    boolean autoLogin() throws AuthenticationException;
	void resetPassword(String email, String newPassword);
	
}
