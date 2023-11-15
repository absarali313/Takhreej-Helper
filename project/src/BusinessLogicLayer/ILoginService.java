// ILoginService.java
package BusinessLogicLayer;

public interface ILoginService {
    boolean login(String username, String password, boolean rememberMe);
}
