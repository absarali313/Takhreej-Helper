package DataAccessLayer;

import CustomException.DataAccessException;
import TransferObjects.User;

public interface IUserProfileDAL {
    User getUserProfile(String email) throws DataAccessException;
    boolean updateUserProfile(User updatedUser) throws DataAccessException;
}
