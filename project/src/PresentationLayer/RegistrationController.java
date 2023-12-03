package PresentationLayer;

import BusinessLogicLayer.EmailService;
import BusinessLogicLayer.RegistrationService;
import DataAccessLayer.IRegisterDAL;
import DataAccessLayer.RegisterDAL;

import java.util.Scanner;

public class RegistrationController {
    public static void main(String[] args) {
        // Initialize the Data Access layer
        EmailService email = new EmailService();
        IRegisterDAL register = new RegisterDAL();

        // Initialize the Business Logic layer
        RegistrationService registrationService = new RegistrationService();

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

        // Prompt user to enter their name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Initialize a flag to control the email entry loop
        boolean isEmailEntered = false;
        String email = "";

        // Loop until a valid email is entered
        while (!isEmailEntered) {
            // Prompt user to enter their email
            System.out.print("Enter your email: ");
            email = scanner.nextLine();

            // Check if the email is already registered
            if (registrationService.isEmailRegistered(email)) {
                System.out.println("Error: Email is already registered. Please enter a different email.");
            } else {
                isEmailEntered = true;
            }
        }

        // Continue with the rest of the registration process
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