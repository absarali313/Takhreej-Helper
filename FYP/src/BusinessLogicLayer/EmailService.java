package BusinessLogicLayer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import CustomLogger.Log;
import CustomException.EmailServiceException;
import java.util.Random;

public class EmailService {

    private String lastGeneratedVerificationCode;
    private String senderEmail;
    private String senderPassword;

    public EmailService() {
        // Load email properties from a file
        loadEmailProperties();
    }

    private void loadEmailProperties() {
        Log.getLogger().info("Calling loadEmailProperties Function");
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("email.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            senderEmail = prop.getProperty("sender.email");
            senderPassword = prop.getProperty("sender.password");
            System.out.println(senderEmail);

        } catch (IOException ex) {
            Log.getLogger().error("Error loading email properties", ex);
            throw new RuntimeException("Error loading email properties");
        }
    }

    // Existing code for generating verification code
    public String generateVerificationCode() {
        Log.getLogger().info("Calling generateVerificationCode Function");
        Random random = new Random();
        int verificationCode = 100000 + random.nextInt(900000);
        lastGeneratedVerificationCode = String.valueOf(verificationCode);
        return lastGeneratedVerificationCode;
    }

    // Generic method to send an email with a verification code
    private boolean sendEmail(String recipientEmail, String subject, String message) throws EmailServiceException {
        Log.getLogger().info("Calling sendEmail Function");

        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(senderEmail));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            mimeMessage.setSubject(subject); // Set the subject of the email
            mimeMessage.setText(message);   // Set the content of the email

            Transport.send(mimeMessage);

            Log.getLogger().info("Email sent successfully to {}", recipientEmail);
            return true;

        } catch (MessagingException e) {
            Log.getLogger().error("Error sending email", e);
            throw new EmailServiceException("Error sending email: " + e.getMessage());
        }
    }

    // Method for sending verification code for user registration
    public boolean sendVerificationEmail(String recipientEmail) throws EmailServiceException {
        Log.getLogger().info("Calling sendVerificationEmail Function");
        String subject = "Verification Code for Registration";
        String verificationCode = generateVerificationCode();
        String message = "Your verification code is: " + verificationCode;

        return sendEmail(recipientEmail, subject, message);
    }

    // Method for sending random OTP for forgot password
    public String sendForgotPasswordOTP(String recipientEmail) throws EmailServiceException {
        Log.getLogger().info("Calling sendForgotPasswordOTP Function");
        String subject = "Forgot Password OTP";
        String otp = generateVerificationCode();
        String message = "Your OTP for resetting the password is: " + otp;

        // Save the generated OTP before sending the email
        String storedOTP = otp;

        if (sendEmail(recipientEmail, subject, message)) {
            Log.getLogger().info("Forgot Password OTP sent successfully");
            return storedOTP; // Return the stored OTP if the email is sent successfully
        } else {
            Log.getLogger().error("Error sending Forgot Password OTP");
            return null; // Return null or handle the case where the email sending fails
        }
    }

    public boolean verifyCode(String userEnteredCode) {
        Log.getLogger().info("Calling verifyCode Function");
        return lastGeneratedVerificationCode != null && lastGeneratedVerificationCode.equals(userEnteredCode);
    }
}
