package com.aa.awesomecareer.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aa.awesomecareer.model.ExperienceModel;
import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.service.ExperienceService;

@Controller
public class ExperiencesController {
	
	@Autowired 
	ExperienceService experienceService;
	
	@GetMapping(value="/experience")
	public String showExperience(Model model) {
		ExperienceModel experienceModel = new ExperienceModel();
		model.addAttribute("experienceModel",experienceModel);
	
		return "experiences/_form";
	}
	
	@PostMapping(value="/experience")
	public String addExperience(@ModelAttribute ExperienceModel experienceModel,
			BindingResult bindingResult, Model model) throws ParseException {
		experienceModel.setUserId(1);
		experienceService.save(experienceModel);
		List<ExperienceModel> experienceModels = experienceService.findAllById(1);
		model.addAttribute("experienceModels", experienceModels);
		
		return "experiences/index::copy";
	}
	
	@GetMapping(value="/experience/{id}/edit")
	public String showFormOld(@PathVariable("id") Integer id,Model model) {
		
		ExperienceModel experienceModel = experienceService.findById(id);
		model.addAttribute("experienceModel", experienceModel);
		System.out.println("Kiem tra id cua experience "+ experienceModel.getId());
		
		return "experiences/_form";
	}
	
	@DeleteMapping(value="/experience/{id}/delete")
	public String deleteExperience(@PathVariable("id") Integer id,Model model) {
		
		experienceService.delete(id);
		 List<ExperienceModel> experienceModels = experienceService.findAllById(1);
	     model.addAttribute("experienceModels", experienceModels);
	     
		return "experiences/index::copy";
	}

}
