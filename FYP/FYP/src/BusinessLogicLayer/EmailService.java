package BusinessLogicLayer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import CustomLogger.AppLogger;
import CustomException.EmailServiceException;
import java.util.Random;

public class EmailService implements IEmailService {
	private static final AppLogger logger = new AppLogger(); // Use the logger instance from AppLogger
	
    private String lastGeneratedVerificationCode;
    private String senderEmail;
    private String senderPassword;

    public EmailService() {
        // Load email properties from a file
        loadEmailProperties();
    }

    private void loadEmailProperties() {
    	logger.getLogger().info("Calling loadEmailProperties Function");
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("email.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            setSenderEmail(prop.getProperty("sender.email"));
            setSenderPassword(prop.getProperty("sender.password"));
            System.out.println(getSenderEmail());

        } catch (IOException ex) {
        	 logger.getLogger().error("Error loading email properties", ex);
            throw new RuntimeException("Error loading email properties");
        }
    }

    // Existing code for generating verification code
    @Override
    public String generateVerificationCode() {
    	logger.getLogger().info("Calling generateVerificationCode Function");
        Random random = new Random();
        int verificationCode = 100000 + random.nextInt(900000);
        setLastGeneratedVerificationCode(String.valueOf(verificationCode));
        return getLastGeneratedVerificationCode();
    }

    // Generic method to send an email with a verification code
private boolean sendEmail(String recipientEmail, String subject, String message) throws EmailServiceException {
    logger.getLogger().info("Calling sendEmail Function");
    
    Properties props = new Properties();
    props.put("mail.smtp.ssl.trust", "*");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.office365.com");
    props.put("mail.smtp.port", "587");
    
    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(getSenderEmail(), getSenderPassword());
        }
    });

    try {
        Message mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(getSenderEmail()));
        mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        mimeMessage.setSubject(subject); // Set the subject of the email
        mimeMessage.setText(message);   // Set the content of the email

        Transport.send(mimeMessage);

        logger.getLogger().info("Email sent successfully to {}", recipientEmail);
        return true;

    } catch (MessagingException e) {
        logger.getLogger().error("Error sending email", e);
        throw new EmailServiceException("Error sending email: " + e.getMessage());
    }
}


    // Method for sending verification code for user registration
    @Override
    public boolean sendVerificationEmail(String recipientEmail) throws EmailServiceException {
    	logger.getLogger().info("Calling sendVerificationEmail Function");
        String subject = "Verification Code for Registration";
        String verificationCode = generateVerificationCode();
        String message = "Your verification code is: " + verificationCode;

        return sendEmail(recipientEmail,subject,message);
    }

    // Method for sending random OTP for forgot password
    @Override
    public String sendForgotPasswordOTP(String recipientEmail) throws EmailServiceException {
    	logger.getLogger().info("Calling sendForgotPasswordOTP Function");
        String subject = "Forgot Password OTP";
        String otp = generateVerificationCode();
        String message = "Your OTP for resetting the password is: " + otp;

        // Save the generated OTP before sending the email
        String storedOTP = otp;

        if (sendEmail(recipientEmail,subject,message)) {
        	 logger.getLogger().info("Forgot Password OTP sent successfully");
            return storedOTP; // Return the stored OTP if the email is sent successfully
        } else {
        	 logger.getLogger().error("Error sending Forgot Password OTP");
            return null; // Return null or handle the case where the email sending fails
        }
    }

    @Override
    public boolean verifyCode(String userEnteredCode) {
    	logger.getLogger().info("Calling verifyCode Function");
        return getLastGeneratedVerificationCode() != null && getLastGeneratedVerificationCode().equals(userEnteredCode);
    }

    /**
     * @return the lastGeneratedVerificationCode
     */
    public String getLastGeneratedVerificationCode() {
        return lastGeneratedVerificationCode;
    }

    /**
     * @param lastGeneratedVerificationCode the lastGeneratedVerificationCode to set
     */
    public void setLastGeneratedVerificationCode(String lastGeneratedVerificationCode) {
        this.lastGeneratedVerificationCode = lastGeneratedVerificationCode;
    }

    /**
     * @return the senderEmail
     */
    public String getSenderEmail() {
        return senderEmail;
    }

    /**
     * @param senderEmail the senderEmail to set
     */
    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    /**
     * @return the senderPassword
     */
    public String getSenderPassword() {
        return senderPassword;
    }

    /**
     * @param senderPassword the senderPassword to set
     */
    public void setSenderPassword(String senderPassword) {
        this.senderPassword = senderPassword;
    }
}
