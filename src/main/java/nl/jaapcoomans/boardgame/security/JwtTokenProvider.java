package nl.jaapcoomans.boardgame.security;

import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtTokenProvider {
	private final Key signingKey;
	private final long validityInMilliseconds;
	private UserDetailsService userDetailsService;

	public JwtTokenProvider(long validityMilliSeconds, UserDetailsService userDetailsService) {
		this.validityInMilliseconds = validityMilliSeconds;
		this.userDetailsService = userDetailsService;
		this.signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	}

	public String createToken(String username, List<String> roles) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("roles", roles);
		Date now = Date.from(Instant.now());
		Date validity = new Date(now.getTime() + validityInMilliseconds);
		return Jwts.builder()
			.setClaims(claims)
			.setIssuedAt(now)
			.setExpiration(validity)
			.signWith(signingKey)
			.compact();
	}

	String resolveToken(final HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}

	boolean validateToken(final String token) {
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);
			if (claims.getBody().getExpiration().before(Date.from(Instant.now()))) {
				return false;
			}
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			throw new RuntimeException("Expired or invalid JWT token");
		}
	}

	Authentication getAuthentication(final String token) {
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsernameFromToken(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	private String getUsernameFromToken(final String token) {
		return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody().getSubject();
	}
}
