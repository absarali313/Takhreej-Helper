// ILoginService.java
package BusinessLogicLayer;

import CustomException.AuthenticationException;

public interface ILoginService {
    boolean login(String name, String password) throws AuthenticationException;
    boolean rememberMe(String name, String password, boolean remember) throws AuthenticationException;
    boolean autoLogin() throws AuthenticationException;
}
