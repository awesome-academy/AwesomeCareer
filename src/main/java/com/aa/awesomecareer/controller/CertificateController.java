package com.aa.awesomecareer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aa.awesomecareer.model.CertificateModel;
import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.service.CertificateService;

@Controller

public class CertificateController {
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	@Qualifier("certificateService")
	CertificateService certificateService;
	
	@GetMapping(value = "/certificate")
	public String showCertificate(Model model) {
		CertificateModel certificateModel = new CertificateModel();
		model.addAttribute("certificateModel", certificateModel);
		return "users/certificate/_certificate";
	}
	
	@PostMapping(value = "/certificate")
	public String saveCertificate(@ModelAttribute("user") @Validated CertificateModel certificateModel, Model model,
			HttpServletResponse response) throws Exception {
		certificateService.saveCertificate(certificateModel);
		return "users/certificate/_index::copy";
	}
	
	@GetMapping(value = "/certificate/{id}/edit")
	public String showFormUpdate(@PathVariable("id") Integer id, Model model) {
		CertificateModel certificateModel = certificateService.finCertificateById(id);
		model.addAttribute("certificateModel", certificateModel);
		//System.out.println("id cua certificate la " + certificateModel.getId());
		return "users/certificate/_edit::edit";
	}
	
	@DeleteMapping(value = "/certificate/{id}/delete")
	public String delete(@PathVariable Integer id, Model model, HttpServletRequest request) throws Exception {
		certificateService.deleteCertificate(id);
		System.out.println("delete thanh cong certificate id " + id);
		List<CertificateModel> certificateModels = certificateService.findCertificateByUserId(3);
		model.addAttribute("certificateModels", certificateModels);
		return "users/certificate/_index::copy";
	}
	
	@PutMapping(value = "/certificate/{id}/edit")
	public String updateCertificate(@PathVariable("id") Integer id, @ModelAttribute CertificateModel certificateModel, 
			Model model, HttpServletResponse response) throws Exception {
		System.out.println("sua certificate co id = " + id);
		certificateService.updateCertificate(certificateModel);
		return "users/certificate/_index::copy";		
	}

}
