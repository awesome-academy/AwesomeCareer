package com.aa.awesomecareer.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.service.EmailSenderService;
import com.aa.awesomecareer.service.UserService;
import com.aa.awesomecareer.util.Utility;

import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailSenderService emailSenderService;
	
	@GetMapping("/forgot_password")
	public String showForgotPasswordForm () {
		return "users/forgot_password_form";
	}
	
	@PostMapping("/forgot_password")
	public String processForgotPassword(@RequestParam("email") String email,HttpServletRequest request, Model model) {
		String token = RandomString.make(25);
		
		userService.updateResetPasswordToken(token, email);
		String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" +token;
		System.out.println("Xem link reset password nao" +resetPasswordLink);
		try {
			emailSenderService.sendEmailWithLink(email, resetPasswordLink);
			model.addAttribute("message", "Email sent successfully");
		} catch (EntityNotFoundException ex) {
			model.addAttribute("error",ex.getMessage());
		} catch (UnsupportedEncodingException | MessagingException e) {
			model.addAttribute("error","Error while sending email");
		}
		return "users/forgot_password_form";
	}
	
	@GetMapping("/reset_password")
	public String showResetPasswordForm(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		UserModel userModel = userService.findUserByPasswordForgotToken(token);
		System.out.println("Xem gia tri token truyen vao chua "+ token);
		System.out.println("xem cos usermodel reset password khong nao"+userModel.id);
		model.addAttribute("token", token);
		if(userModel==null) {
			model.addAttribute("message", "Invalid Token");
			return "message";
		}
		return "users/reset_password_form";
	}
	
	@PostMapping ("/reset_password")
	public String processResetPassword(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		String newPassword = request.getParameter("password");
		
		UserModel userModel = userService.findUserByPasswordForgotToken(token);
		
		if(userModel == null) {
			model.addAttribute("message", "Invalid Token");
			return "message";
		}else {
			userService.updateNewPassword(token, newPassword);
			model.addAttribute("message", "You have successfully changed your password");
		}
		return "users/_login";
	}
	

}
