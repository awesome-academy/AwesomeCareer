package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>, EducationRepositoryCustom {

}
