// ILoginService.java
package BusinessLogicLayer;

public interface ILoginService {
    boolean login(String name, String password);
    boolean rememberMe(String name, String password, boolean remember);
    boolean autoLogin();
}
