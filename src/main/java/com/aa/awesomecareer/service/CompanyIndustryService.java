package com.aa.awesomecareer.service;

import java.util.List;

import com.aa.awesomecareer.model.CompanyIndustryModel;

public interface CompanyIndustryService {
	
	public List<CompanyIndustryModel> findIndustryIdByCompanyId(Integer companyId) throws Exception;

}
