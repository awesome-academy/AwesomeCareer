package com.aa.awesomecareer.controller;

import java.io.IOException;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aa.awesomecareer.model.EducationModel;
import com.aa.awesomecareer.model.ExperienceModel;
import com.aa.awesomecareer.model.SkillModel;
import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.service.EducationService;
import com.aa.awesomecareer.service.ExperienceService;
import com.aa.awesomecareer.service.SkillService;
import com.aa.awesomecareer.service.UserService;
import com.aa.awesomecareer.util.CommonUtil;

@Controller
//@EnableWebMvc
public class UsersController {
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	MessageSource messageSource;

	@Autowired
	ExperienceService experienceService;

	@Autowired
	SkillService skillService;
	
	@Autowired
	EducationService educationService;
	
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

	@GetMapping(value = { "/signup" })
	public String add(Locale locale, Model model) {
		List<String> occupations = CommonUtil.occupationList();
		model.addAttribute("occupations", occupations);
		List<String> countries = CommonUtil.countryList();
		model.addAttribute("countries", countries);
		model.addAttribute("user", new UserModel());
		return "users/_add";
	}

	@PostMapping(value = "/users")
	public String create(@ModelAttribute("userModel") @Validated UserModel userModel, BindingResult bindingResult,
			Model model, final RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {
		if (bindingResult.hasErrors()) {
			logger.info("Returning register.jsp page, validate failed");
			return "users/_add";
		}
		userService.addUser(userModel);
		// Add message to flash scope
		return "redirect: " + request.getContextPath() + "/user/" + userModel.getId();
	}

	@GetMapping(value = "/user/{id}")
	public String show(@PathVariable Integer id, Model model) {
		UserModel userModel = userService.findUserById(id);
		model.addAttribute("userModel", userModel);

		List<ExperienceModel> experienceModels = experienceService.findAllById(1);
		model.addAttribute("experienceModels", experienceModels);

		List<SkillModel> skillModels = skillService.findAll();
		model.addAttribute("skillModels", skillModels);
		
		List<EducationModel> educationModels = educationService.findAllByUserId(1);
		model.addAttribute("educationModels", educationModels);

		return "users/show";

	}

}
