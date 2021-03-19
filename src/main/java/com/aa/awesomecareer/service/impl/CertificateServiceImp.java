package com.aa.awesomecareer.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.entity.Certificate;
import com.aa.awesomecareer.model.CertificateModel;
import com.aa.awesomecareer.repository.CertificateRepository;
import com.aa.awesomecareer.service.CertificateService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
@Qualifier("certificateService")
public class CertificateServiceImp implements CertificateService {
	private static final Logger logger = LoggerFactory.getLogger(CertificateServiceImp.class);
	
	@Autowired
	private CertificateRepository certificateRepository;
	
	public CertificateServiceImp() {
	}
	
	public CertificateModel saveCertificate(CertificateModel certificateModel) {
		logger.info("Save certificate to the database");
		try {
			Certificate condition = new Certificate();
			condition.setUserId(2);
			condition.setTitle(certificateModel.getTitle());
			condition.setIssuedTime(certificateModel.getIssuedTime());
			Certificate certificate = certificateRepository.save(condition);
			certificateModel = new CertificateModel();
			BeanUtils.copyProperties(certificate, certificateModel);
			return certificateModel;
		}
		catch (Exception e) {
			logger.error("An error occurred while save certificate to the database", e);
		}
		return null;
	}
}
