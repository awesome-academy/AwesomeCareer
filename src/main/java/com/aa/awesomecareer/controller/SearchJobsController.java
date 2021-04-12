package com.aa.awesomecareer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aa.awesomecareer.service.JobService;
import com.aa.awesomecareer.model.JobModel;

@RestController
public class SearchJobsController {
	
	@Autowired
	JobService jobService;
	
	@GetMapping(value="/search", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public List<JobModel> showSearch(@RequestParam String term, Model model, final RedirectAttributes redirectAttributes,
			HttpServletRequest request) throws Exception {
		List<JobModel> jobModels = jobService.findAllJobSearch(term);
		System.out.println("Da chay den day chua");
		return jobModels;
	}

}
