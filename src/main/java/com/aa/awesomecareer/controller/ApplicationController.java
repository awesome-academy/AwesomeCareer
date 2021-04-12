package com.aa.awesomecareer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aa.awesomecareer.model.ApplicationModel;
import com.aa.awesomecareer.model.JobModel;
import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.service.ApplicationService;
import com.aa.awesomecareer.service.impl.CloundinaryService;
import com.cloudinary.Cloudinary;

@Controller
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	@Autowired
	CloundinaryService cloundinaryService;
	
	@PostMapping(value="/jobs/{id}/savecv")
	public String saveCv (@PathVariable ("id") Integer jobId,@RequestParam("csv") MultipartFile file,Model model,
			HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.out.println("Xem da vao controller chua");
		if(!applicationService.existApplication(2, jobId)) {
		   if(file.isEmpty()) {
			   redirectAttributes.addFlashAttribute("message", "Please select a file to upload");  
			   return "redirect:uploadStatus";		   
			   }
		   
		   ApplicationModel applicationModel = new ApplicationModel();
		  Cloudinary cloundinary = new Cloudinary();
		  String fileUrl = cloundinaryService.uploadFile(file);
		  applicationModel.setUserId(2);
		  applicationModel.setFileUrl(fileUrl);
		  applicationModel.setJobId(jobId);
		  ApplicationModel applicationModelSave = applicationService.saveApplicationModel(applicationModel);
		  model.addAttribute("applicationModel",applicationModelSave);
		 
		  return "jobs/success";
	}
		return null;
	}
	
	@GetMapping (value="/jobs/applicant")
	public String listApplicant (Model model){
		List<ApplicationModel> applicationModels = applicationService.findAllApplicant();
	    model.addAttribute("applicationModels", applicationModels);
	
		return "admin/_applicant";
	}
}
