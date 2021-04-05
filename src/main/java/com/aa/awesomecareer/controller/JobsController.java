package com.aa.awesomecareer.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aa.awesomecareer.model.JobModel;
import com.aa.awesomecareer.model.TypeModel;
import com.aa.awesomecareer.service.JobService;
import com.aa.awesomecareer.service.FieldService;
import com.aa.awesomecareer.service.TypeService;

@Controller
public class JobsController {
	@Autowired
	TypeService typeService;
	
	@Autowired
	FieldService fieldService;
	
	@Autowired
	JobService jobService;
	
	@GetMapping(value="/jobs")
	public String showJobForm(Model model) {
		JobModel jobModel = new JobModel();
		model.addAttribute("jobModel", jobModel);
		model.addAttribute("typeModels", typeService.findAll());
		model.addAttribute("fieldModels", fieldService.findAll());
		return "jobs/form";
	}
	
	@PostMapping (value="/jobs")
	public String saveJobForm(@ModelAttribute("jobModel") JobModel jobModel, 
			Model model,HttpServletRequest request) {
		System.out.println("Xem typeIds naof "+ jobModel.getTypeIds());
		for(Integer i :jobModel.getTypeIds() ) {
			System.out.println(i);
		}
		jobService.saveJobModel(jobModel);
		return "redirect:jobs/all";
     }
	
	@GetMapping(value="/jobs/all")
	public String showJob(Model model) {
	
	List<JobModel> jobModels = jobService.findAllJob();
    model.addAttribute("jobModels", jobModels);
    return "jobs/show";
		
	}

	
	@GetMapping(value="/jobs/{id}")
	public String showJobDetail(@PathVariable("id") Integer id,Model model) {
		JobModel jobModel = jobService.showJobDetail(id);
		model.addAttribute("jobModel",jobModel);
		List<TypeModel> typeModels = jobModel.getTypeModels();
		model.addAttribute("typeModels",typeModels);
		return "jobs/detail";	
	}
}
