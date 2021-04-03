package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.awesomecareer.entity.JobTypeName;

public interface JobTypeRepository extends JpaRepository<JobTypeName, Integer> {

}
