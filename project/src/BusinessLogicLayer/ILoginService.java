// ILoginService.java
package BusinessLogicLayer;

import CustomException.AuthenticationException;
import CustomException.EmailServiceException;

public interface ILoginService {
    boolean login(String name, String password) throws AuthenticationException;
    boolean rememberMe(String name, String password, boolean remember) throws AuthenticationException;
    boolean autoLogin() throws AuthenticationException;
	//void resetPassword(String name, String string, String storedOTP, String userEnteredCode) throws EmailServiceException;
}
