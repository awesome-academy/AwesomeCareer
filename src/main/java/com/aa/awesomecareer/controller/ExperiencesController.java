package com.aa.awesomecareer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aa.awesomecareer.model.ExperienceModel;
import com.aa.awesomecareer.model.MonthModel;
import com.aa.awesomecareer.model.YearModel;
import com.aa.awesomecareer.repository.ExperienceRepository;
import com.aa.awesomecareer.service.ExperienceService;

@Controller
public class ExperiencesController {
	
	@Autowired 
	ExperienceService experienceService;
	
	@ModelAttribute("years")
	List<YearModel> getYears(){
		List<YearModel> years = new ArrayList<YearModel>();
		for(int i=1971; i<2022;i++) {
			YearModel yi = new YearModel(i-1971,"i");
			years.add(yi);
		}
		return years;
	}
	
	@ModelAttribute("months")
	List<MonthModel> getMonths(){
		String[] arr = { "January", "February", "March", "April","May",
				"June","July","August","September","October","November","December" };
		List<MonthModel> months = new ArrayList<MonthModel>();
		MonthModel m1= new MonthModel(1,"January");
		MonthModel m2= new MonthModel(2,"February");
		MonthModel m3= new MonthModel(3,"March");
		MonthModel m4= new MonthModel(4,"April");
		MonthModel m5= new MonthModel(5,"May");
		MonthModel m6= new MonthModel(6,"June");
		MonthModel m7= new MonthModel(7,"July");
		MonthModel m8= new MonthModel(8,"August");
		MonthModel m9= new MonthModel(9,"September");
		MonthModel m10= new MonthModel(10,"October");
		MonthModel m11= new MonthModel(11,"November");
		MonthModel m12= new MonthModel(12,"December");
		months.add(m1);
		months.add(m2);
		months.add(m3);
		months.add(m4);
		months.add(m5);
		months.add(m6);
		months.add(m7);
		months.add(m8);
		months.add(m9);
		months.add(m10);
		months.add(m11);
		months.add(m12);
		
		return months;
	}
	
	@GetMapping(value="/user/{id}/experience")
	public String showExperience(Model model) {
		ExperienceModel experienceModel = new ExperienceModel();
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
