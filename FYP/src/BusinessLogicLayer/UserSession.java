package BusinessLogicLayer;

import TransferObject.User;

/**
 *
 * @author ch-sa
 */
public class UserSession {
    public static User loggedUser;
    
    public UserSession(User user){
        UserSession.loggedUser  = user;
    }
    
    public static User getSession(){
        return loggedUser;
    }
    public static void setSession(User user){
       UserSession.loggedUser = user;
    }
}
