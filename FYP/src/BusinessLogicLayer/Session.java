package BusinessLogicLayer;

import TransferObjects.User;

/**
 *
 * @author ch-sa
 */
public class Session {
    public static User loggedUser;
    
    public Session(User user){
        Session.loggedUser  = user;
    }
    
    public static User getSession(){
        return loggedUser;
    }
    public static void setSession(User user){
       Session.loggedUser = user;
    }
}
