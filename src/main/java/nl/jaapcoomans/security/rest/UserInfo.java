package nl.jaapcoomans.security.rest;

public class UserInfo {
	private final String username;
	private final String token;

	public UserInfo(final String username, final String token) {
		this.username = username;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public String getToken() {
		return token;
	}
}
