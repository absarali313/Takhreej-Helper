package CustomException;

import javax.swing.JOptionPane;

public class ProfileUpdateException extends Exception {
    public ProfileUpdateException(String message) {
        super(message);
       
    }
}