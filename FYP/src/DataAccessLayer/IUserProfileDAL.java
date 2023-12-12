package DataAccessLayer;

import TransferObject.User;

import java.sql.SQLException;

public interface IUserProfileDAL {
    void updateUserProfile(String email, String newName, String newPhoneNumber);

    User getUserProfile(String email) throws SQLException;
}
