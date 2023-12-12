// LogoutService.java
package BusinessLogicLayer;

//import java.awt.event.ActionEvent;
import java.io.File;

public class LogoutService implements ILogoutService {

    private static final String REMEMBER_ME_FILE = "rememberMe.dat";

    @Override
    public void logout() {
        File rememberMeFile = new File(REMEMBER_ME_FILE);
        if (rememberMeFile.exists()) {
            rememberMeFile.delete();
        }
    }

    @Override
    public String redirectToLogin() {
        return "/login";
    }
    
   /* public void actionPerformed(ActionEvent e) {
    	this.setVisible(false);
    	String operation = e.getActionCommand();
    	switch(operation)
    	{
    	case ""
    	{
    		redirectToLogin();
    		
    		break;
    	}
    	}
    }

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}*/
}
