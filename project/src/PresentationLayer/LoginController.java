// LoginController.java
package PresentationLayer;

import BusinessLogicLayer.ILoginService;
import BusinessLogicLayer.ILogoutService;
import BusinessLogicLayer.LoginService;
import BusinessLogicLayer.LogoutService;
import DataAccessLayer.ILoginDAO;
import DataAccessLayer.LoginDAO;

import java.util.Scanner;

public class LoginController {
    public static void main(String[] args) {
        // Initialize the Data Access layer
        ILoginDAO loginDAO = new LoginDAO();

        // Initialize the Business Logic layer
        ILoginService loginService = new LoginService(loginDAO);
        LogoutService logoutService = new LogoutService();

        
        if(loginService.autoLogin())
        {
        	System.out.println("User Login successfully!");
        	ConsoleLogoutController logoutController = new ConsoleLogoutController(logoutService);
        	logoutController.logoutUserFromInput();
        	
        }
        else
        {
        	 // Initialize the Presentation layer
            ConsoleLoginController loginController = new ConsoleLoginController(loginService);
            // Example: Login a user using the Presentation layer
            loginController.loginUserFromInput();
        }
       
    }
}

// Presentation layer (Console)
class ConsoleLoginController {
    private ILoginService loginService;
    private LogoutController logout;

    public ConsoleLoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    public void loginUserFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Your Email: ");
        String name = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Do you want to be remembered? (yes/no): ");
        String rememberChoice = scanner.nextLine().toLowerCase();

        boolean rememberMe = rememberChoice.equals("yes");
        boolean isAuthenticated = loginService.login(name,password);
        // Delegate login to the Business Logic layer
        if(rememberMe && isAuthenticated)
        {
        	loginService.rememberMe(name, password, rememberMe);
        }
       
        if (isAuthenticated) {
            System.out.println("User " + name + " Login successfully!");
        } else {
            System.out.println("Invalid credentials. Login failed.");
        }
        
    }
}


class ConsoleLogoutController {
	LogoutController logout;
    public ConsoleLogoutController(LogoutService logoutService) {
    	logout = new LogoutController(logoutService);
    }

    public void logoutUserFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to logout? (yes/no): ");
        String rememberChoice = scanner.nextLine().toLowerCase();

        boolean logoutInput = rememberChoice.equals("yes");
        // Delegate login to the Business Logic layer
        if(logoutInput)
        {
        	logout.logoutUser();
        }
    }
}
