package com.aa.awesomecareer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobsController {
	
	@GetMapping(value="/jobs")
	public String showJobForm(Model model) {
		return "jobs/form";
	}

}
