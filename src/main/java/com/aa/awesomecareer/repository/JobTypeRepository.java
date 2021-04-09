package com.aa.awesomecareer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aa.awesomecareer.entity.JobType;


@Repository
public interface JobTypeRepository extends JpaRepository<JobType, Integer>,JobTypeRepositoryCustom {

}
