package com.aa.awesomecareer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aa.awesomecareer.model.ExperienceModel;
import com.aa.awesomecareer.service.ExperienceService;
import com.aa.awesomecareer.util.CommonUtil;

@Controller
public class ExperiencesController {
	
	@Autowired 
	ExperienceService experienceService;
	
	@Autowired
	CommonUtil common;
	
	@GetMapping(value="/user/{id}/experience")
	public String showExperience(Model model) {
		ExperienceModel experienceModel = new ExperienceModel();
		List<Integer> years = common.yearList();
		List<String> months = common.monthList();
		model.addAttribute("years", years);
		model.addAttribute("months", months);
		model.addAttribute("experienceModel",experienceModel);
		
		return "experiences/form";
	}
	
	@PostMapping(value="/user/{id}/experience")
	public String addExperience(@PathVariable("id") int userId, @ModelAttribute ExperienceModel experienceModel, Model model) {
		experienceModel.setUserId(userId);
		ExperienceModel newExperienceModel = experienceService.save(experienceModel);
		
		model.addAttribute("newExperienceModel", newExperienceModel);
		
		return "experiences/show";
	}

}
