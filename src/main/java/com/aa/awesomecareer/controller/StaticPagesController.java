package com.aa.awesomecareer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticPagesController {

	private static final Logger logger = LoggerFactory.getLogger(StaticPagesController.class);

	@GetMapping(value = "/access_denied")
	public String accessDenied() {
		logger.info("Access denied");
		return "access_denied";
	}
	
	@GetMapping(value = "/error")
	public String error() {
		logger.info("Error");
		return "error";
	}

}
