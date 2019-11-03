import javax.mail.*;

public class CustomAuthenticator extends Authenticator {
	private String username;
	private String password;

	public CustomAuthenticator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}

}
