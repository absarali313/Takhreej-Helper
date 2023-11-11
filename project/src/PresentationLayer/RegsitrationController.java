package PresentationLayer;

import BusinessLogicLayer.RegistrationService;
import DataAccessLayer.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Presentation layer
public class RegsitrationController {
    public static void main(String[] args) {
        // Initialize the Data Access layer
    	IRegisterDAL register = new RegisterDAL();

        // Initialize the Business Logic layer
        RegistrationService registrationService = new RegistrationService(register);

        // Initialize the Presentation layer
        ConsoleRegistrationController registrationController = new ConsoleRegistrationController(registrationService);

        // Example: Register a user using the Presentation layer
        registrationController.registerUserFromInput();


    }
}

// Presentation layer (Console)
class ConsoleRegistrationController {
    private RegistrationService registrationService;

    public ConsoleRegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public void registerUserFromInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        // Delegate registration to the Business Logic layer
        registrationService.registerUser(name, email, password, phoneNumber);
    }
}
