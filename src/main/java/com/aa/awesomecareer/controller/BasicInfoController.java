package com.aa.awesomecareer.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.service.UserService;
import com.aa.awesomecareer.util.CommonUtil;

@Controller
public class BasicInfoController {
	private static final Logger logger = LoggerFactory.getLogger(BasicInfoController.class);
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	@Qualifier("userService")
	UserService userService;
		
	@GetMapping(value = "/basic/edit")
	public String showBasicInfo(Model model) {
		List<String> genders = CommonUtil.genderList();
		model.addAttribute("genders", genders);
		
		List<String> relationships = CommonUtil.relationshipList();
		model.addAttribute("relationships", relationships);
		
		UserModel userModel = userService.findUser(3);
		model.addAttribute("userModel", userModel);
		
		return "users/basicinfo/_basicInfo";
	}
	
	@PutMapping(value = "/users/{id}/edit")
	public String update(@PathVariable("id") Integer id, @ModelAttribute UserModel userModel, Locale locale, 
			Model model, HttpServletRequest request) throws Exception {
		userService.saveInfo(userModel);
		System.out.println("sua thong tin user co id = " + id);
		return "users/basicinfo/_index::copy";
	}

}
