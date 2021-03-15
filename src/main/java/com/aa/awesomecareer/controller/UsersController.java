package com.aa.awesomecareer.controller;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.service.UserService;

@Controller
//@EnableWebMvc
public class UsersController {
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	MessageSource messageSource;

	@Autowired
	@Qualifier("userService")
	UserService userService;

	@GetMapping(value = "/users")
	public String index(@RequestParam(name = "page", required = false) Optional<Integer> page, Locale locale,
			Model model, HttpServletRequest request) {
		List<UserModel> users = userService.findAll();
		model.addAttribute("users", users);
		return "users/index";
	}

	@GetMapping(value = "/users/{email}")
	public String show(@PathVariable String email, Model model) {
		UserModel userModel = userService.findByEmail(email);
		model.addAttribute("user", userModel);

		return "users/show";
	}
	
	@GetMapping(value = { "/users/add", "/signup" })
	public String add(Locale locale, Model model) {
		model.addAttribute("user", new UserModel());
		return "users/add";
	}
	
//	@PostMapping(value = "/users")
//	public String create(@ModelAttribute("user") @Validated UserModel userModel, BindingResult bindingResult,
//			Model model, final RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {
//		if (bindingResult.hasErrors()) {
//			logger.info("Returning register.jsp page, validate failed");
//			return "users/add";
//		}
//		userService.addUser(userModel);
//		// Add message to flash scope
//		return "redirect: " + request.getContextPath() + "/home";
//	}

}
