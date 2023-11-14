// ILoginDAO.java
package DataAccessLayer;

import TransferObjects.User;

public interface ILoginDAO {
	User getUserByName(String name);

    void saveRememberMeToken(String name, String token);

    String getRememberMeToken(String name);
}
