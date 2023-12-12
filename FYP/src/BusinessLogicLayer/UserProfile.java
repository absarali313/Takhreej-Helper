
package BusinessLogicLayer;

import CustomException.ProfileUpdateException;
import DataAccessLayer.IUserProfileDAL;
import DataAccessLayer.UserProfileDAL;
import TransferObjects.User;

public class UserProfile {
    private IUserProfileDAL userProfileDAL;

    public UserProfile() {
        this.userProfileDAL = new UserProfileDAL();
    }

    public User getUserProfile(String email) {
        return userProfileDAL.getUserProfile(email);
    }

    public boolean updateUserProfile(String email, String newName, String newPhoneNumber) throws ProfileUpdateException {
        try {
            if (isValidUser(newName, email, newPhoneNumber)) {
                userProfileDAL.updateUserProfile(email, newName, newPhoneNumber);
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
