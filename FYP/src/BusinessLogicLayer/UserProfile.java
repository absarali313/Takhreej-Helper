package BusinessLogicLayer;

import CustomException.DBConnectionException;
import CustomException.ProfileUpdateException;
import DataAccessLayer.IUserProfileDAL;
import DataAccessLayer.UserProfileDAL;
import TransferObject.User;
import java.sql.SQLException;

public class UserProfile {
    private UserProfileDAL userProfileDAL;

    public UserProfile() throws DBConnectionException {
        this.userProfileDAL = new UserProfileDAL();
    }

    public User getUserProfile(String email) throws SQLException {
        return userProfileDAL.getUserProfile(email);
    }

    public boolean updateUserProfile(String newName, String newPhoneNumber) throws ProfileUpdateException {
        try {
            if (isValidUser(newName, UserSession.getSession().getEmail(), newPhoneNumber)) {
                userProfileDAL.updateUserProfile(UserSession.getSession().getEmail(), newName, newPhoneNumber);
                System.out.println("User profile updated successfully!");
                return true;
            } else {
                throw new ProfileUpdateException("Invalid user information. Profile update failed.");
            }
        } catch (Exception e) {
            throw new ProfileUpdateException("Error during profile update: " + e.getMessage());
        }
    }

    private boolean isValidUser(String name, String email, String phoneNumber) {
        return name != null && !name.isEmpty() && email != null && !email.isEmpty()
                && phoneNumber != null && !phoneNumber.isEmpty();
    }
}
