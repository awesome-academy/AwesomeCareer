package com.aa.awesomecareer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aa.awesomecareer.repository.JobElasticRepository;
import com.aa.awesomecareer.model.JobElasticModel;

@RestController
public class ElasticSearchController {
	
	@Autowired
	JobElasticRepository jobElasticRepository;
	
	@GetMapping (value="/search/text")
	public List<JobElasticModel> searchJobTitle(@RequestParam ("term") String term, Model model){
		System.out.println("Vao controller elastic search chua");
     return jobElasticRepository.findByJobTitle(term) ;
	}
	
	

}
