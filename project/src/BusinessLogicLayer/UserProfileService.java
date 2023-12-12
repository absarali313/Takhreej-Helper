package BusinessLogicLayer;

import CustomException.DataAccessException;
import DataAccessLayer.IUserProfileDAL;
import DataAccessLayer.UserProfileDAL;
import TransferObjects.User;

public class UserProfileService implements IUserProfileService {
    private IUserProfileDAL userProfileDAL;

    public UserProfileService() {
        this.userProfileDAL = new UserProfileDAL();
    }

    @Override
    public User getUserProfile(String email) throws DataAccessException {
        return userProfileDAL.getUserProfile(email);
    }

    @Override
    public boolean updateUserProfile(User updatedUser) throws DataAccessException {
        return userProfileDAL.updateUserProfile(updatedUser);
    }
}
