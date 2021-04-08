package com.aa.awesomecareer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aa.awesomecareer.model.JobModel;
import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.service.ApplicationService;
import com.aa.awesomecareer.service.JobService;
import com.aa.awesomecareer.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	JobService jobService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ApplicationService applicationService;
	
	@GetMapping( value="/admin/{id}")
	public String showAdmin(@PathVariable("id") Integer id,Model model) {
		List<JobModel> jobModels = jobService.findJobByUserId(id);
		model.addAttribute("jobModels", jobModels);
		return "admin/show";
	}
	
	@GetMapping(value="/admin/{id}/applicant")
	public String showApplicantOfJob(@PathVariable("id") Integer jobId, Model model) {
		
		List<UserModel> userModels = applicationService.findByJobId(jobId);
		model.addAttribute("userModels", userModels);
		
		return "admin/_applicant";
	}

}
