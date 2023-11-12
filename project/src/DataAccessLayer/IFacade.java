// ILoginFacade.java
package DataAccessLayer;

public interface IFacade extends ILoginDAO {

    boolean authenticateUser(String username, String password, String recaptchaResponse);
}
