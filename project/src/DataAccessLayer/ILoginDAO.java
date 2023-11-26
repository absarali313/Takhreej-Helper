// ILoginDAO.java
package DataAccessLayer;

import TransferObjects.User;

public interface ILoginDAO {
	User getUserByEmail(String name);
	boolean rememberUserCredentials(String name, String password, boolean remember);
    boolean autoLogin();
}
