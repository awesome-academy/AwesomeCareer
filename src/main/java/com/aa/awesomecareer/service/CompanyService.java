package com.aa.awesomecareer.service;

import com.aa.awesomecareer.model.CompanyModel;

public interface CompanyService {
	
	public CompanyModel creatCompany(CompanyModel companyModel) throws Exception;
	
	public CompanyModel findCompanyById(Integer id) throws Exception;
	
	public CompanyModel updateCompany(CompanyModel companyModel) throws Exception;

}
