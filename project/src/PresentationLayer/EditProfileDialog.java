package PresentationLayer;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BusinessLogicLayer.IUserProfileService;
import BusinessLogicLayer.UserProfileService;

public class EditProfileDialog extends JDialog {
    private IUserProfileService userProfileService;

    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JTextField passwordTextField;

    public EditProfileDialog(JFrame parent, String userEmail) {
        super(parent, "Edit Profile", true);
        userProfileService = new UserProfileService();

        // Assuming you have JTextField components for editing user information
        nameTextField = new JTextField();
        emailTextField = new JTextField();
        phoneTextField = new JTextField();
        passwordTextField = new JTextField();

        // Set up your UI to allow editing of user profile information
        setLayout(new GridLayout(5, 2));
        add(new JLabel("New Name:"));
        add(nameTextField);
        add(new JLabel("New Email:"));
        add(emailTextField);
        add(new JLabel("New Phone:"));
        add(phoneTextField);
        add(new JLabel("New Password:"));
        add(passwordTextField);
        add(new JLabel("")); // Placeholder label for spacing
        add(new JLabel(""));

        JButton updateButton = new JButton("Update Profile");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve updated profile information from the UI components
                String newName = nameTextField.getText();
                String newEmail = emailTextField.getText();
                String newPhone = phoneTextField.getText();
                String newPassword = passwordTextField.getText();

                // Update the user profile
                try {
                    boolean updateSuccessful = userProfileService.updateProfile(userEmail, newName, newEmail, newPassword, newPhone);
                    if (updateSuccessful) {
                        JOptionPane.showMessageDialog(EditProfileDialog.this, "Profile updated successfully");
                        // Close the dialog if the update is successful
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(EditProfileDialog.this, "Failed to update profile");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(EditProfileDialog.this, "Error updating profile: " + ex.getMessage());
                }
            }
        });

        add(updateButton);

        pack();
        setLocationRelativeTo(null);
    }
}
