
package DataAccessLayer;

import BusinessLogicLayer.ILoginService;
import TransferObjects.User;

public class Facade implements IFacade {
    private ILoginService loginService;

    public Facade(ILoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public boolean authenticateUser(String username, String password, String recaptchaResponse) {
        return loginService.loginUser(username, password, recaptchaResponse);
    }

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRememberMeToken(String name, String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getRememberMeToken(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
