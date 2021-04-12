package com.aa.awesomecareer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aa.awesomecareer.model.JobModel;
import com.aa.awesomecareer.service.JobService;
import com.aa.awesomecareer.service.UserService;

@Controller
public class EmailController {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	JobService jobService;
	
	@Autowired
	UserService userService;
	
	@PostMapping (value="/sendEmail/{id}")
	public String sendEmail (@PathVariable("id") Integer id, Model model) {
		
		JobModel jobModel =jobService.showJobDetail(id);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(jobModel.getCompanyEmail());
		msg.setText("I'm interested open job of company");
		
		javaMailSender.send(msg);
		
		return "result";
	}

}
