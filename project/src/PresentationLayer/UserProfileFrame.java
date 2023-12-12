package PresentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BusinessLogicLayer.IUserProfileService;
import BusinessLogicLayer.UserProfileService;
import CustomException.DataAccessException;
import TransferObjects.User;

public class UserProfileFrame extends JPanel {
    private IUserProfileService userProfileService;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JTextField passwordTextField;

    public UserProfileFrame(String userEmail) {
        userProfileService = new UserProfileService();
        setLayout(new GridLayout(5, 2));

        // Initialize text fields with user profile data
        try {
            User userProfile = userProfileService.getUserProfile(userEmail);

            if (userProfile != null) {
                nameTextField = new JTextField(userProfile.getName());
                emailTextField = new JTextField(userProfile.getEmail());
                phoneTextField = new JTextField(userProfile.getPhone());
                passwordTextField = new JTextField(userProfile.getPassword());

                add(new JLabel("Name:"));
                add(nameTextField);
                add(new JLabel("Email:"));
                add(emailTextField);
                add(new JLabel("Phone:"));
                add(phoneTextField);
                add(new JLabel("Password:"));
                add(passwordTextField);

                JButton editProfileButton = new JButton("Edit Profile");
                add(editProfileButton);

                // Add ActionListener for the Edit Profile button
                editProfileButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        openEditProfileDialog(userEmail);
                    }
                });
            } else {
                // Handle the case where user profile data is not available
                JOptionPane.showMessageDialog(this, "Error loading user profile data");
            }
        } catch (DataAccessException e) {
            // Handle data access exception
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading user profile data: " + e.getMessage());
        }
    }

    private void openEditProfileDialog(String userEmail) {
        // Open the Edit Profile dialog
        EditProfileDialog editProfileDialog = new EditProfileDialog((JFrame) SwingUtilities.getWindowAncestor(this), userEmail);
        editProfileDialog.setSize(400, 300);
        editProfileDialog.setLocationRelativeTo(null);

        // Add a WindowListener to refresh the user profile panel when the EditProfileDialog is closed
        editProfileDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                refreshUserProfile(userEmail);
            }
        });

        editProfileDialog.setVisible(true);
    }

    private void refreshUserProfile(String userEmail) {
        // Update user profile panel after editing
        try {
            User updatedUserProfile = userProfileService.getUserProfile(userEmail);

            if (updatedUserProfile != null) {
                nameTextField.setText(updatedUserProfile.getName());
                emailTextField.setText(updatedUserProfile.getEmail());
                phoneTextField.setText(updatedUserProfile.getPhone());
                passwordTextField.setText(updatedUserProfile.getPassword());
            } else {
                // Handle the case where updated user profile data is not available
                JOptionPane.showMessageDialog(this, "Error loading updated user profile data");
            }
        } catch (DataAccessException e) {
            // Handle data access exception
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading updated user profile data: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Create a frame
        JFrame frame = new JFrame("User Profile Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an instance of UserProfileFrame
        UserProfileFrame userProfileFrame = new UserProfileFrame("user@example.com");

        // Add UserProfileFrame to the frame
        frame.getContentPane().add(userProfileFrame);

        // Pack and set frame visibility
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}