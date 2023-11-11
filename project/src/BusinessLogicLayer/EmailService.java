package BusinessLogicLayer;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailService {

    public Boolean sendEmail(String recipientEmail, String subject, String message) {
        String senderEmail ="ENTER OUTLOOK EMAIL HERE";
        String senderPassword = "PASSWORD";
    	Properties props = new Properties();
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

            System.out.println("Email sent successfully");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

  
}
