package BusinessLogicLayer;

import CustomException.DataAccessException;
import TransferObjects.User;

public interface IUserProfileService {
    User getUserProfile(String email) throws DataAccessException;
    boolean updateUserProfile(User updatedUser) throws DataAccessException;
	boolean updateProfile(String userEmail, String newName, String newEmail, String newPassword, String newPhone);
}
