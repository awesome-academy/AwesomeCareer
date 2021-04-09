package com.aa.awesomecareer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aa.awesomecareer.model.EducationModel;
import com.aa.awesomecareer.service.EducationService;

@Controller
public class EducationsCotroller {

	@Autowired
	EducationService educationService;

	@GetMapping(value = "/education")
	public String showEducationForm(Model model) {
		EducationModel educationModel = new EducationModel();
		model.addAttribute("educationModel", educationModel);
		return "educations/form";
	}

	@PostMapping(value = "/education")
	public String saveEducation(@ModelAttribute EducationModel educationModel, Model model) {
		educationModel.setUserId(1);
		educationService.saveEducation(educationModel);
		List<EducationModel> educationModels = educationService.findAllByUserId(1);
		model.addAttribute("educationModels", educationModels);
		return "educations/index::copy";
	}

	@GetMapping(value = "/education/{id}/edit")
	public String showEditForm(@PathVariable Integer id, Model model) {
		EducationModel educationModel = educationService.findById(id);
		System.out.println("gia tri id cua education edit la +" + educationModel.getDescription());
		model.addAttribute("educationModel", educationModel);
		return "educations/form";
	}

	@DeleteMapping(value = "/education/{id}/delete")
	public String deleteEducation(@PathVariable("id") Integer id, Model model) {
		educationService.deleteEducationById(id);
		List<EducationModel> educationModels = educationService.findAllByUserId(1);
		model.addAttribute("educationModels", educationModels);
		return "educations/index::copy";
	}
}
