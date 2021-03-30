package com.aa.awesomecareer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.service.UserService;

@Controller
public class SkillsController {
	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@PostMapping(value = "/user/{id}/skill")
	public String addSkill(@PathVariable("id") Integer id, @ModelAttribute UserModel userModel, Model model,
			HttpServletRequest request) {
		userModel.setId(1);
		userService.saveSkill(userModel);
		return "redirect: " + request.getContextPath() + "/user/" + userModel.getId();
	}


}
