package PresentationLayer;

import BusinessLogicLayer.EmailService;
import BusinessLogicLayer.RegistrationService;
import DataAccessLayer.IRegisterDAL;
import DataAccessLayer.RegisterDAL;

import java.util.Scanner;

public class RegsitrationController {
    public static void main(String[] args) {
        // Initialize the Data Access layer
        EmailService email = new EmailService();

        IRegisterDAL register = new RegisterDAL();

        // Initialize the Business Logic layer
        RegistrationService registrationService = new RegistrationService(register);

        // Initialize the Presentation layer
        ConsoleRegistrationController registrationController = new ConsoleRegistrationController(registrationService, email);

        // Example: Register a user using the Presentation layer
        registrationController.registerUserFromInput();
    }
}

class ConsoleRegistrationController {
    private RegistrationService registrationService;
    private EmailService emailService;

    public ConsoleRegistrationController(RegistrationService registrationService, EmailService emailService) {
        this.registrationService = registrationService;
        this.emailService = emailService;
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

        // Send verification email
        boolean verificationCodeSent = emailService.sendVerificationEmail(email);

        if (verificationCodeSent) {
            boolean isVerificationCodeCorrect = false;

            // Enter the verification code with a loop for re-entry if incorrect
            while (!isVerificationCodeCorrect) {
                System.out.print("Enter the verification code: ");
                String userVerificationCode = scanner.nextLine();

                // Verify the entered code
                if (emailService.verifyCode(userVerificationCode)) {
                    isVerificationCodeCorrect = true;
                    // Delegate registration to the Business Logic layer with the verification code
                    registrationService.registerUser(name, email, password, phoneNumber, userVerificationCode);
                } else {
                    System.out.println("Incorrect verification code. Please try again.");
                }
            }
        } else {
            System.out.println("Error sending verification email. Registration aborted.");
        }

        // Close the scanner
        scanner.close();
    }
}
