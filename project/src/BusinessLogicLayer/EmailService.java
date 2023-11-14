package BusinessLogicLayer;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Random;

public class EmailService {
	  private String lastGeneratedVerificationCode;

	    public String generateVerificationCode() {
	        // Generate a random 6-digit verification code
	        Random random = new Random();
	        int verificationCode = 100000 + random.nextInt(900000);
	        lastGeneratedVerificationCode = String.valueOf(verificationCode);
	        return lastGeneratedVerificationCode;
	    }

    public boolean sendVerificationEmail(String recipientEmail) {
        String senderEmail = "manalq2023@outlook.com";
        String senderPassword = "MAnal@12345";
        String subject = "Verification Code for Registration";
        String verificationCode = generateVerificationCode();
        String message = "Your verification code is: " + verificationCode;

        Properties props = new Properties();
        // Disable SSL/TLS certificate validation
        props.put("mail.smtp.ssl.trust", "*");

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com"); // Outlook SMTP server
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, senderPassword);
                    }
                });

        try {
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(senderEmail));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            Transport.send(mimeMessage);

            System.out.println("Verification email sent successfully");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean verifyCode(String userEnteredCode) {
        // Compare the stored code with the user-entered code
        return lastGeneratedVerificationCode != null && lastGeneratedVerificationCode.equals(userEnteredCode);
    }
}
