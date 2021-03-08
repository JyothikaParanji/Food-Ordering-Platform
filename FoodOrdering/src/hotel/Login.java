package hotel;

public class Login {
	
	private int loginId;
	public int getLoginId() {
		return loginId;
	}
	public Login() {}
	
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String userName;
	private String password;
	
	
	@Override
	public String toString() {
		return "Login [loginId=" + this.loginId + ", userName=" + this.userName + ", password=" + this.password + "]";
	}
	
}