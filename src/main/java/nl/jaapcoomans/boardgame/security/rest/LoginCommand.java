package nl.jaapcoomans.boardgame.security.rest;

public class LoginCommand {
	private String username;
	private String password;

	public LoginCommand(final String username, final String password) {
		this.username = username;
		this.password = password;
	}

	String getUsername() {
		return username;
	}

	String getPassword() {
		return password;
	}
}
