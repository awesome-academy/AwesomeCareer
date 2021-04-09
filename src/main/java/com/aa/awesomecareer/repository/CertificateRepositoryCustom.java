package com.aa.awesomecareer.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.awesomecareer.entity.Certificate;

public interface CertificateRepositoryCustom extends JpaRepository<Certificate, Integer> {
	
	public List<Certificate> findCertificateByUserId(Integer userId);

}
