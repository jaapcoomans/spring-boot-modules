package nl.jaapcoomans.demo.springbootmodules.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Value("${security.jwt.token.expire-length:3600000}")
	private long jwtValidityMillis;

	@Bean
	public JwtTokenProvider jwtTokenProvider() {
		return new JwtTokenProvider(this.jwtValidityMillis, userDetailsService());
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailService();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic().disable()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers("/auth/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	private JwtFilter jwtFilter() {
		return new JwtFilter(jwtTokenProvider());
	}
}
