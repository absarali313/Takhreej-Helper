// ILoginDAO.java
package DataAccessLayer;

import TransferObjects.User;

public interface ILoginDAO {
    User getUserByUsername(String username);
}
