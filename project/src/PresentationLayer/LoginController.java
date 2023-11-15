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
    	
    	IRememberMeManager rememberMeManager = new RememberMeManager();
        // Initialize the Data Access layer
        ILoginDAO loginDAO = new LoginDAO(rememberMeManager);

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

    private String generateCaptcha(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < length; i++) {
            captcha.append(characters.charAt((int) (Math.random() * characters.length())));
        }
        return captcha.toString();
    }

    private boolean verifyCaptcha(String generatedCaptcha, String userInput) {
        return generatedCaptcha.equals(userInput);
    }
    
    public void loginUserFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Your Email: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Do you want to be remembered? (yes/no): ");
        String rememberChoice = scanner.nextLine().toLowerCase();

        boolean rememberMe = rememberChoice.equals("yes");

        // Generate and display the CAPTCHA
        String generatedCaptcha = generateCaptcha(6);
        System.out.println("CAPTCHA: " + generatedCaptcha);

        // Prompt the user to enter the CAPTCHA
        System.out.print("Enter the CAPTCHA: ");
        String captchaInput = scanner.nextLine();

        // Verify the CAPTCHA
        if (!verifyCaptcha(generatedCaptcha, captchaInput)) {
            System.out.println("CAPTCHA verification failed. Login aborted.");
            return;
        }
        // Delegate login to the Business Logic layer
        boolean isAuthenticated = loginService.login(username, password, rememberMe);

        if (isAuthenticated) {
            System.out.println("User " + username + " Login successfully!");
        } else {
            System.out.println("Invalid credentials. Login failed.");
        }
    }
}