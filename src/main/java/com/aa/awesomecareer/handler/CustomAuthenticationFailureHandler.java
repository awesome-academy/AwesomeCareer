package com.aa.awesomecareer.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component("authenticationFailureHandler")
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException{
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String error = exception.getMessage();
		
		System.out.println("A failed login attempt with email and password: " + email + "and"+ password + 
				"Reason: " + error);
		
		String redirectUrl = request.getContextPath() + "/login?error";
		response.sendRedirect(redirectUrl);
	}

}
