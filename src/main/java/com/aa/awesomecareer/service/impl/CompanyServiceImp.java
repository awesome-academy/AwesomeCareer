package com.aa.awesomecareer.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aa.awesomecareer.entity.Company;
import com.aa.awesomecareer.entity.CompanyIndustry;
import com.aa.awesomecareer.entity.SkillUser;
import com.aa.awesomecareer.entity.User;
import com.aa.awesomecareer.model.CompanyModel;
import com.aa.awesomecareer.model.UserModel;
import com.aa.awesomecareer.repository.CompanyIndustryRepository;
import com.aa.awesomecareer.repository.CompanyIndustryRepositoryCustom;
import com.aa.awesomecareer.repository.CompanyRepository;
import com.aa.awesomecareer.service.CompanyService;


@Service
@Qualifier("companyService")
public class CompanyServiceImp implements CompanyService {
	private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImp.class);
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CompanyIndustryRepository companyIndustryRepo;
				
	public CompanyServiceImp() {
	}
	
	public CompanyModel creatCompany(CompanyModel companyModel) throws Exception {
		logger.info("Creat company to the database");
		try {
			Company company = new Company();
			company.setName(companyModel.getName());
			company.setAddress(companyModel.getAddress());
			company.setFoundedBy(companyModel.getFoundedBy());
			company.setFoundedTime(companyModel.getFoundedTime());
			company.setWebsite(companyModel.getWebsite());
			companyRepository.save(company);
			return companyModel;
		}
		catch (Exception e) {
			logger.error("An error occurred while creat company to the database", e);
		}
		return null;
	}
	
	@Override
	@Transactional
	public CompanyModel findCompanyById(Integer id) throws Exception {
		try {
			logger.info("Finding company from database by id");
			Optional<Company> company = companyRepository.findById(id);
			CompanyModel companyModel = new CompanyModel();
			BeanUtils.copyProperties(company.get(), companyModel);
			return companyModel;
		}
		catch (Exception e) {
			logger.error("An error occurred while find company to the database", e);
		}
		return null;
	}
	
	@Override
	@Transactional
	public CompanyModel updateCompany(CompanyModel companyModel) throws Exception {
		try {
			logger.info("update company info in the database");
			Optional<Company> company = companyRepository.findById(companyModel.getId());
			Company company1 = company.get();
			company1.setName(companyModel.getName());
			company1.setAddress(companyModel.getAddress());
			company1.setFoundedTime(companyModel.getFoundedTime());
			company1.setWebsite(companyModel.getWebsite());
			
			List<Integer> ids = companyModel.getIndustryIds();
			List<CompanyIndustry> companyIndustrys = companyIndustryRepo.findIndustryIdByCompanyId(companyModel.getId());
			for (CompanyIndustry companyIndustry : companyIndustrys) {
				companyIndustryRepo.deleteById(companyIndustry.getId());
			}
			
			System.out.println("da update company va delete industry theo company, bat dau update industry");
			
			for (Integer id : ids) {
			   System.out.println("Id cua industry la " + ids);
			   CompanyIndustry companyIndustry1 = new CompanyIndustry();
			   companyIndustry1.setCompanyId(companyModel.getId());
			   companyIndustry1.setIndustryId(id);
			   companyIndustryRepo.save(companyIndustry1);
			}
		}
		catch (Exception e) {
			logger.error("An error occurred while update company to the database", e);
		}
		return null;
	}

}
