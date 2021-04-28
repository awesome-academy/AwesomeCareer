package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.entity.CompanyIndustry;
import com.aa.awesomecareer.model.CompanyIndustryModel;
import com.aa.awesomecareer.repository.CompanyIndustryRepository;
import com.aa.awesomecareer.repository.CompanyIndustryRepositoryCustom;
import com.aa.awesomecareer.service.CompanyIndustryService;

@Service
@Qualifier("companyIndustryService")
public class CompanyIndustryServiceImp implements CompanyIndustryService {
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyIndustryServiceImp.class);
	
	@Autowired
	@Qualifier("companyIndustryRepository")
	private CompanyIndustryRepository companyIndustryRepository;
		
	public CompanyIndustryServiceImp() {
	}
	
	@Override
	public List<CompanyIndustryModel> findIndustryIdByCompanyId(Integer companyId) throws Exception {
		logger.info("Tim kiem industryId theo companyId trong co so du lieu");
		try {
			List<CompanyIndustry> industrys = companyIndustryRepository.findIndustryIdByCompanyId(companyId);
			List<CompanyIndustryModel> industryModels = new ArrayList<CompanyIndustryModel>();
			for (CompanyIndustry ids : industrys) {
				CompanyIndustryModel companyIndustryModel = new CompanyIndustryModel();
				BeanUtils.copyProperties(ids, companyIndustryModel);
				industryModels.add(companyIndustryModel);
			}
			return industryModels;
		} catch (Exception e) {
			logger.error("An error occurred while fetching the user details from the database", e);
			return null;
		}
	}

}
