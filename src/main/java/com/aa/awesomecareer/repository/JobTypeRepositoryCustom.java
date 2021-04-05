package com.aa.awesomecareer.repository;

import java.util.List;

import com.aa.awesomecareer.entity.JobType;

public interface JobTypeRepositoryCustom {
	List<JobType> findByJobId(Integer id);
}
