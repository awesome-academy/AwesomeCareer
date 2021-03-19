package com.aa.awesomecareer.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aa.awesomecareer.model.CertificateModel;
import com.aa.awesomecareer.service.CertificateService;

@Controller

public class CertificateController {
	private static final Logger logger = LoggerFactory.getLogger(CertificateController.class);
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	@Qualifier("certificateService")
	CertificateService certificateService;
	
	@PostMapping(value = "/users/{id}/certificate")
	public String create(Model model, HttpServletRequest request) throws Exception {
		//CertificateModel certificateModel = certificateService.saveCertificate(certificateModel);
		return "redirect: " + request.getContextPath() + "/home";
	}

}
