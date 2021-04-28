package com.aa.awesomecareer.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.CompanyIndustry;

@Repository
public interface CompanyIndustryRepositoryCustom {
		
	public List<CompanyIndustry> findIndustryIdByCompanyId(Integer companyId);

}
