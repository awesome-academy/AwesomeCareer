package com.aa.awesomecareer.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.aa.awesomecareer.service.UserService;




@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("userService")
    private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userDetailsService);
		auth.setPasswordEncoder(passwordEncoder);
		return auth;
	}
	
	@Override
	protected void configure (AuthenticationManagerBuilder auth)  throws Exception{
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Autowired
	@Qualifier("authenticationSuccessHandler")
    private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	@Qualifier("authenticationFailureHandler")
    private AuthenticationFailureHandler authenticationFailureHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
	        .antMatchers("/resources/**").permitAll()
	        .antMatchers("/images/**").permitAll()
	        .antMatchers("/webjars/**").permitAll()
	        .antMatchers("/home").permitAll()
	        .antMatchers("/login").permitAll()
	        .antMatchers("/signup").permitAll()
	        .antMatchers(HttpMethod.POST, "/users").permitAll()
	        .antMatchers("/error").permitAll()
	        .antMatchers("/access_denied").permitAll()
	        .antMatchers("/admin/**").hasAuthority("ADMIN")
	        .antMatchers(HttpMethod.GET, "/users").hasAnyAuthority("USER","ADMIN")
	        .anyRequest().permitAll();
		http.formLogin()
			.loginPage("/login").failureUrl("/login?error=true&code=0")
			.usernameParameter("email").passwordParameter("password")
			.successHandler(authenticationSuccessHandler)
			.failureHandler(authenticationFailureHandler)
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/")
			.permitAll();
		http.logout()
			.invalidateHttpSession(false)
			.clearAuthentication(true)
			.deleteCookies("JSESSIONID")
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        .logoutSuccessUrl("/login?logout")
	        .permitAll();
		http.rememberMe()
		    .rememberMeParameter("remember-me")
		    .tokenValiditySeconds(24 * 60 * 60)
		    .useSecureCookie(true)
            .tokenRepository(userService)
            .userDetailsService(userService);
		
	}
}
