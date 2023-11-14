package TransferObjects;

public class User {
	private String name;
	private String email;
	private String phone;
	private String password;
	private boolean rememberMe;
    private String rememberMeToken;
	
	public User(String name, String email, String phone, String password, boolean rememberMe, String rememberMeToken) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.rememberMe = rememberMe;
        this.rememberMeToken = rememberMeToken;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRememberMe() {
	    return rememberMe;
    }
	public void setisRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	 public String getRememberMeToken() {
	    return rememberMeToken;
    }
	 public void setRememberMeToken(String rememberMeToken) {
		this.rememberMeToken = rememberMeToken;
		}
}
