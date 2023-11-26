// LoginController.java
package PresentationLayer;

import BusinessLogicLayer.ILoginService;
import BusinessLogicLayer.LoginService;
import DataAccessLayer.ILoginDAO;
import DataAccessLayer.IRememberMeManager;
import DataAccessLayer.LoginDAO;
import DataAccessLayer.RememberMeManager;

import java.util.Scanner;

public class LoginController {
    public static void main(String[] args) {
    	
        // Initialize the Data Access layer
        ILoginDAO loginDAO = new LoginDAO();

        // Initialize the Business Logic layer
        ILoginService loginService = new LoginService(loginDAO);

        // Initialize the Presentation layer
        ConsoleLoginController loginController = new ConsoleLoginController(loginService);

        // Example: Login a user using the Presentation layer
        loginController.loginUserFromInput();
    }
}

// Presentation layer (Console)
class ConsoleLoginController {
    private ILoginService loginService;

    public ConsoleLoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    
    public void loginUserFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Your Email: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        
        // Delegate login to the Business Logic layer
        boolean isAuthenticated = loginService.login(username, password);

        if (isAuthenticated) {
            System.out.println("User " + username + " Login successfully!");
        } else {
            System.out.println("Invalid credentials. Login failed.");
        }
    }
}