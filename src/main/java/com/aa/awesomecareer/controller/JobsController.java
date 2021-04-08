package com.aa.awesomecareer.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aa.awesomecareer.model.JobModel;
import com.aa.awesomecareer.model.TypeModel;
import com.aa.awesomecareer.service.FieldService;
import com.aa.awesomecareer.service.JobService;
import com.aa.awesomecareer.service.TypeService;
import com.aa.awesomecareer.service.impl.CloundinaryService;
import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;

@Controller
public class JobsController {

	@Autowired
	TypeService typeService;
	
	@Autowired
	FieldService fieldService;
	
	@Autowired
	JobService jobService;
	
	@Autowired
    private CloundinaryService cloudinaryService;
	
	@GetMapping(value="/jobs")
	public String showJobForm(Model model) {
		JobModel jobModel = new JobModel();
		model.addAttribute("jobModel", jobModel);
		model.addAttribute("typeModels", typeService.findAll());
		model.addAttribute("fieldModels", fieldService.findAll());
		
		return "jobs/form";
	}
	
	@PostMapping (value="/jobs")
	public String saveJobForm(@ModelAttribute("jobModel") JobModel jobModel,@RequestParam("image") MultipartFile image,
			Model model,HttpServletRequest request,RedirectAttributes redirectAttributes) {
		if (image.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

		Cloudinary cloudinary = new Cloudinary();
		String url = cloudinaryService.uploadFile(image);
		jobModel.setUserId(1);
		jobService.saveJobModel(jobModel,url);
		return "redirect:jobs/all";
     }
	
	@GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
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
	
	@GetMapping(value="/uploadform/{id}")
	public String showCvForm(@PathVariable("id") Integer id,Model model) {
		JobModel jobModel = new JobModel();
		jobModel.setId(id);
		model.addAttribute("jobModel", jobModel);
		return "jobs/cvform";
	}
	
}
