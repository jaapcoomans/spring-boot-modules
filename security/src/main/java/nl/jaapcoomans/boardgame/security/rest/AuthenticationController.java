package nl.jaapcoomans.boardgame.security.rest;

import static org.springframework.http.ResponseEntity.ok;

import java.util.Collections;

import nl.jaapcoomans.boardgame.security.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	private AuthenticationManager authenticationManager;
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	public AuthenticationController(final AuthenticationManager authenticationManager, final JwtTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@PostMapping("/login")
	public ResponseEntity<UserInfo> login(@RequestBody LoginCommand loginCommand) {
		try {
			String username = loginCommand.getUsername();
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginCommand.getPassword()));
			String token = this.jwtTokenProvider.createToken(username, Collections.emptyList());

			return ResponseEntity.ok(new UserInfo(username, token));
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid username/password supplied");
		}
	}

}
