package com.aa.awesomecareer.service;

import java.util.List;

import com.aa.awesomecareer.model.CertificateModel;

public interface CertificateService {
	
public CertificateModel saveCertificate(CertificateModel certificateModel) throws Exception;
	
	public void deleteCertificate(Integer id) throws Exception;
	
	public List<CertificateModel> findCertificateByUserId(Integer userId);
	
	public CertificateModel finCertificateById(Integer id);
	
	public CertificateModel updateCertificate(CertificateModel certificateModel);
	
}