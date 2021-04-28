package com.aa.awesomecareer.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.aa.awesomecareer.model.CompanyModel;
import com.aa.awesomecareer.model.IndustryModel;
import com.aa.awesomecareer.service.CompanyService;
import com.aa.awesomecareer.service.IndustryService;

@Controller
public class CompanyController {
	@Autowired
	MessageSource messageSource;

	@Autowired
	@Qualifier("companyService")
	CompanyService companyService;
	
	@Autowired
	@Qualifier("industryService")
	IndustryService industryService;
	
	@GetMapping(value = "/company/register")
	public String showCompanyRegister(Model model) {
		CompanyModel companyModel = new CompanyModel();
		model.addAttribute("companyModel", companyModel);
		return "company/form1";
	}
	
	@PostMapping(value = "/company")
	public String creatCompany(@ModelAttribute("company") @Validated CompanyModel companyModel, Model model
			) throws Exception {
		companyService.creatCompany(companyModel);
		model.addAttribute("companyModel", companyModel);
		return "company/dashboard";
	}
	
	@GetMapping(value = "/company/{id}")
	public String overviewCompany(@PathVariable("id") Integer id, Model model) throws Exception {
		CompanyModel companyModel = companyService.findCompanyById(id);
		model.addAttribute("companyModel", companyModel);
		return "company/dashboard";
	}
	
	@GetMapping(value = "/company/{id}/edit")
	public String showFormEditCompany(@PathVariable("id") Integer id, Model model) throws Exception {
		CompanyModel companyModel = companyService.findCompanyById(id);
		model.addAttribute("companyModel", companyModel);
		
		List<IndustryModel> industrys = industryService.finAll();
		model.addAttribute("industrys", industrys);
		
		return "company/edit";
	}
	
	@PostMapping(value = "/company/{id}/edit")
	public String updateCompany(@PathVariable("id") Integer id, Model model,
			@ModelAttribute CompanyModel companyModel, HttpServletRequest request) throws Exception {
		companyService.updateCompany(companyModel);
		return "company/dashboard";
	}
}
