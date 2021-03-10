package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aa.awesomecareer.entity.JobType;

public interface JobTypeRepository extends JpaRepository<JobType, Integer> {

}
