package com.aa.awesomecareer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aa.awesomecareer.entity.Certificate;
import com.aa.awesomecareer.model.CertificateModel;
import com.aa.awesomecareer.repository.CertificateRepository;
import com.aa.awesomecareer.repository.CertificateRepositoryCustom;
import com.aa.awesomecareer.service.CertificateService;

@Service
@Qualifier("certificateService")
public class CertificateServiceImp implements CertificateService {
	private static final Logger logger = LoggerFactory.getLogger(CertificateServiceImp.class);
	
	@Autowired
	private CertificateRepository certificateRepository;
	
	@Autowired
	private CertificateRepositoryCustom certificateRepositoryCustom;
		
	public CertificateServiceImp() {
	}
	
	@Transactional
	public CertificateModel saveCertificate(CertificateModel certificateModel) throws Exception {
		logger.info("Save certificate to the database");
		try {
			Certificate certificate = new Certificate();
			certificate.setTitle(certificateModel.getTitle());
			certificate.setIssuedTime(certificateModel.getIssuedTime());
			certificate.setUserId(3);
			certificateRepository.save(certificate);
			return certificateModel;
		}
		catch (Exception e) {
			logger.error("An error occurred while save certificate to the database", e);
		}
		return null;
	}
	
	@Override
	public List<CertificateModel> findCertificateByUserId(Integer userId) {
		logger.info("Tim kiem certificate theo userId trong co so du lieu");
		try {
			List<Certificate> certificates = certificateRepositoryCustom.findCertificateByUserId(userId);
			List<CertificateModel> certificateModels = new ArrayList<CertificateModel>();
			for (Certificate certificate : certificates) {
				CertificateModel certificateModel = new CertificateModel();
				BeanUtils.copyProperties(certificate, certificateModel);
				certificateModels.add(certificateModel);
			}
			return certificateModels;
		} catch (Exception e) {
			logger.error("An error occurred while fetching the user details from the database", e);
			return null;
		}
	}
	
	@Override
	public void deleteCertificate(Integer id) throws Exception {
		logger.info("Delete certificate to the database");
		try {
			certificateRepository.deleteById(id);
		}
		catch (Exception e) {
			logger.error("An error occurred while delete certificate to the database", e);
		}
	}
	
	public CertificateModel finCertificateById(Integer id) {
		logger.info("Finding certificate from database by id");
		Optional<Certificate> certificate = certificateRepository.findById(id);
		CertificateModel certificateModel = new CertificateModel();
		BeanUtils.copyProperties(certificate.get(), certificateModel);
		return certificateModel;
	}
	
	public CertificateModel updateCertificate(CertificateModel certificateModel) {
		logger.info("Update certificate by id in the database");
		Optional<Certificate> updateCertificate = certificateRepository.findById(certificateModel.getId());
		Certificate certificate = updateCertificate.get();
		certificate.setTitle(certificateModel.getTitle());
		certificate.setIssuedTime(certificateModel.getIssuedTime());
		certificate.setUserId(3);
		Certificate certificate1 = certificateRepository.save(certificate);
		certificateModel = new CertificateModel();
		BeanUtils.copyProperties(certificate1, certificateModel);
		return certificateModel;
	}
}