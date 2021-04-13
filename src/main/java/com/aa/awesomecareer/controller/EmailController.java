package com.aa.awesomecareer.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.aa.awesomecareer.model.JobModel;
import com.aa.awesomecareer.model.MailModel;
import com.aa.awesomecareer.service.ApplicationService;
import com.aa.awesomecareer.service.EmailSenderService;
import com.aa.awesomecareer.service.JobService;
import com.aa.awesomecareer.service.UserService;


@Controller
public class EmailController {
	
	@Autowired
	EmailSenderService senderService;
	
	@Autowired
	JobService jobService;
	
	@Autowired
	ApplicationService applicationService;
	
	@Autowired
	UserService userService;
	
	@Autowired
    private SpringTemplateEngine templateEngine;
	
	@PostMapping (value="/sendEmail/{id}")
	public String sendEmail (@PathVariable("id") Integer id, Model model) {
		JobModel jobModel =jobService.showJobDetail(id);
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("name", "John Michel!");
		properties.put("location", "Sri Lanka");
		properties.put("sign", "Java Developer");

        MailModel mailModel= new MailModel("testforcode2021@gmail.com",jobModel.getCompanyEmail(),
        		"This is sample email with spring boot and thymeleaf",
        		new MailModel.HtmlTemplate("admin/emailletter", properties));
		try {
			senderService.sendEmail(mailModel);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "jobs/result";
	}

}
	
