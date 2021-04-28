package com.aa.awesomecareer.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aa.awesomecareer.entity.CompanyIndustry;
import com.aa.awesomecareer.repository.CompanyIndustryRepositoryCustom;
import com.aa.awesomecareer.service.impl.CompanyIndustryServiceImp;

public class CompanyIndustryRepositoryCustomImpl implements CompanyIndustryRepositoryCustom {
	
	private static Logger log = LoggerFactory.getLogger(CompanyIndustryServiceImp.class);
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<CompanyIndustry> findIndustryIdByCompanyId(Integer companyId) {
		log.info("Tim industryId theo companyId trong co so du lieu");
		try {
			TypedQuery<CompanyIndustry> query = entityManager.createQuery("FROM CompanyIndustry industry WHERE industry.companyId = :companyId", CompanyIndustry.class);
			query.setParameter("companyId", companyId);
			return query.getResultList();
		} catch (Exception e) {
			log.error("da xay ra loi khi tim kiem industryId theo companyId trong co so du lieu", e);
			return null;
		}
	}


}
