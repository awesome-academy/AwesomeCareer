package com.aa.awesomecareer.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aa.awesomecareer.model.JobModel;
import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.service.UserService;
import com.aa.awesomecareer.service.impl.CloundinaryService;
import com.aa.awesomecareer.util.CommonUtil;
import com.cloudinary.Cloudinary;

@Controller
public class BasicInfoController {
	private static final Logger logger = LoggerFactory.getLogger(BasicInfoController.class);
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired
    private CloundinaryService cloudinaryService;
		
	@GetMapping(value = "/basic/edit")
	public String showBasicInfo(Model model) {
		List<String> genders = CommonUtil.genderList();
		model.addAttribute("genders", genders);
		
		List<String> relationships = CommonUtil.relationshipList();
		model.addAttribute("relationships", relationships);
		
		UserModel userModel = userService.findUser(3);
		model.addAttribute("userModel", userModel);
		
		return "users/basicinfo/_basicInfo";
	}
	
	@PutMapping(value = "/users/{id}/edit")
	public String update(@PathVariable("id") Integer id, @ModelAttribute UserModel userModel, Locale locale, 
			Model model, HttpServletRequest request) throws Exception {
		userService.saveInfo(userModel);
		System.out.println("sua thong tin user co id = " + id);
		return "users/basicinfo/_index::copy";
	}
	
	@GetMapping(value="/imageuser/update")
	public String showUpdateImage(Model model) {
		System.out.println("cap nhat anh cua user");
		UserModel userModel = userService.findUser(3);
		model.addAttribute("userModel", userModel);
		return "users/form";
	}
	
	@GetMapping("/uploadImage")
    public String uploadImage() {
        return "uploadImage";
    }

	@PostMapping(value="/imageuser")
	public String saveJobForm(@ModelAttribute("userModel") UserModel userModel, @RequestParam("image") MultipartFile image,
			Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (image.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadImage";
        }

		Cloudinary cloudinary = new Cloudinary();
		String url = cloudinaryService.uploadFile(image);
		System.out.println("cap nhat anh da toi day");
				
		userService.updateImage(userModel, url);
		return "redirect:user/3";
     }
}
