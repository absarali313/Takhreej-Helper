// ILoginService.java
package BusinessLogicLayer;

public interface ILoginService {
    boolean loginUser(String username, String password, String recaptchaResponse);
}
