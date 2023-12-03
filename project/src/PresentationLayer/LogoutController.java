// ConsoleLogoutController.java
package PresentationLayer;

import BusinessLogicLayer.ILogoutService;
import BusinessLogicLayer.LogoutService;

public class LogoutController {
    private LogoutService logoutService;

    public LogoutController(LogoutService logoutService) {
        this.logoutService = logoutService;
    }

    public void logoutUser() {
        logoutService.logout();
        System.out.println("User logged out successfully!");
      //  String redirectToLogin = logoutService.redirectToLogin();
        // System.out.println("Redirecting to: " + redirectToLogin);
    }
}
