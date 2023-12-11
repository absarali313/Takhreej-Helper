package CustomException;

import javax.swing.JOptionPane;

public class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
       
    }
}