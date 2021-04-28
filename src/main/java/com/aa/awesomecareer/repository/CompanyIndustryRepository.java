package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.CompanyIndustry;


@Repository
public interface CompanyIndustryRepository extends JpaRepository<CompanyIndustry, Integer>, CompanyIndustryRepositoryCustom {

}
