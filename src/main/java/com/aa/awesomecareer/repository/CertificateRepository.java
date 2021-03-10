package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Certificate;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

}
