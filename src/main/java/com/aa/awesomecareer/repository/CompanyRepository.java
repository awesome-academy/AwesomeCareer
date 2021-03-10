package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
