// IRememberMeManager.java
package DataAccessLayer;

import TransferObjects.User;

public interface IRememberMeManager {
	
    boolean isUserRemembered(String email);

    void rememberUser(User user);

    User getUserIfRemembered(String email);
}
